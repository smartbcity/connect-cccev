package cccev.f2.certification.api.service

import cccev.commons.utils.contentByteArray
import cccev.commons.utils.toUploadCommand
import cccev.f2.certification.domain.command.CertificationAddEvidenceCommandDTOBase
import cccev.s2.certification.api.CertificationAggregateService
import cccev.s2.certification.domain.command.CertificationAddEvidenceCommand
import cccev.s2.certification.domain.command.CertificationAddRequirementsCommand
import cccev.s2.certification.domain.command.CertificationAddValuesCommand
import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import cccev.s2.certification.domain.command.CertificationCreateCommand
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommand
import cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommand
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.certification.domain.utils.CertificationFsPath
import city.smartb.fs.s2.file.client.FileClient
import city.smartb.fs.s2.file.domain.features.command.FileUploadedEvent
import city.smartb.fs.s2.file.domain.model.FilePath
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service

@Service
class CertificationF2AggregateService(
    private val fileClient: FileClient,
    private val certificationAggregateService: CertificationAggregateService
) {
    suspend fun create(command: CertificationCreateCommand): CertificationCreatedEvent {
        return certificationAggregateService.create(command)
    }

    suspend fun addRequirements(command: CertificationAddRequirementsCommand): CertificationAddedRequirementsEvent {
        return certificationAggregateService.addRequirements(command)
    }

    suspend fun removeRequirements(command: CertificationRemoveRequirementsCommand): CertificationRemovedRequirementsEvent {
        return certificationAggregateService.removeRequirements(command)
    }

    suspend fun addValues(command: CertificationAddValuesCommand): CertificationAddedValuesEvent {
        return certificationAggregateService.addValues(command)
    }

    suspend fun addEvidence(command: CertificationAddEvidenceCommandDTOBase, file: FilePart?): CertificationAddedEvidenceEvent {
        val filePath = file?.upload(command.id, CertificationFsPath.DIR_EVIDENCE, command.metadata)?.path
        return CertificationAddEvidenceCommand(
            id = command.id,
            name = command.name,
            file = filePath,
            url = command.url,
            isConformantTo = command.isConformantTo
        ).let { certificationAggregateService.addEvidence(it) }
    }

    suspend fun removeEvidence(command: CertificationRemoveEvidenceCommand): CertificationRemovedEvidenceEvent {
        return certificationAggregateService.removeEvidence(command)
    }

    private suspend fun FilePart.upload(
        certificationId: CertificationId,
        directory: String,
        metadata: Map<String, String>?
    ): FileUploadedEvent {
        val path = FilePath(
            objectType = CertificationFsPath.OBJECT_TYPE,
            objectId = certificationId,
            directory = directory,
            name = filename(),
        )
        return fileClient.fileUpload(path.toUploadCommand(metadata ?: emptyMap()), contentByteArray())
    }
}
