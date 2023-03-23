package cccev.f2.request.api.service

import cccev.commons.utils.contentByteArray
import cccev.commons.utils.toUploadCommand
import cccev.f2.request.domain.command.RequestAddEvidenceCommandDTOBase
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestAddEvidenceCommand
import cccev.s2.request.domain.command.RequestAddRequirementsCommand
import cccev.s2.request.domain.command.RequestAddValuesCommand
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import cccev.s2.request.domain.command.RequestCreateCommand
import cccev.s2.request.domain.command.RequestCreatedEvent
import cccev.s2.request.domain.command.RequestRemoveEvidenceCommand
import cccev.s2.request.domain.command.RequestRemoveRequirementsCommand
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import cccev.s2.request.domain.model.RequestId
import cccev.s2.request.domain.utils.RequestFsPath
import city.smartb.fs.s2.file.client.FileClient
import city.smartb.fs.s2.file.domain.features.command.FileUploadedEvent
import city.smartb.fs.s2.file.domain.model.FilePath
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service

@Service
class RequestF2AggregateService(
    private val fileClient: FileClient,
    private val requestAggregateService: RequestAggregateService
) {
    suspend fun create(command: RequestCreateCommand): RequestCreatedEvent {
        return requestAggregateService.create(command)
    }

    suspend fun addRequirements(command: RequestAddRequirementsCommand): RequestAddedRequirementsEvent {
        return requestAggregateService.addRequirements(command)
    }

    suspend fun removeRequirements(command: RequestRemoveRequirementsCommand): RequestRemovedRequirementsEvent {
        return requestAggregateService.removeRequirements(command)
    }

    suspend fun addValues(command: RequestAddValuesCommand): RequestAddedValuesEvent {
        return requestAggregateService.addValues(command)
    }

    suspend fun addEvidence(command: RequestAddEvidenceCommandDTOBase, file: FilePart?): RequestAddedEvidenceEvent {
        val filePath = file?.upload(command.id, RequestFsPath.DIR_EVIDENCE)?.path
        return RequestAddEvidenceCommand(
            id = command.id,
            name = command.name,
            file = filePath,
            url = command.url,
            isConformantTo = command.isConformantTo
        ).let { requestAggregateService.addEvidence(it) }
    }

    suspend fun removeEvidence(command: RequestRemoveEvidenceCommand): RequestRemovedEvidenceEvent {
        return requestAggregateService.removeEvidence(command)
    }

    private suspend fun FilePart.upload(requestId: RequestId, directory: String): FileUploadedEvent {
        val path = FilePath(
            objectType = RequestFsPath.OBJECT_TYPE,
            objectId = requestId,
            directory = directory,
            name = filename()
        )
        return fileClient.fileUpload(path.toUploadCommand(), contentByteArray())
    }
}
