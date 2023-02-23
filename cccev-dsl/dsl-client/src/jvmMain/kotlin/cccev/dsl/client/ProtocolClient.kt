package cccev.dsl.client

import cccev.dsl.client.example.LocalConsultationProtocolPreparationRequirements
import cccev.dsl.model.EvidenceTypeList
import cccev.dsl.model.InformationConcept
import cccev.dsl.model.Requirement
import cccev.f2.requirement.domain.command.InformationRequirementCreateCommandDTOBase
import cccev.f2.requirement.domain.command.RequirementCreateCommandDTOBase
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementKind
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    val client = CCCEVClient("http://localhost:8083/api")
    val requirementClient = client.requirementClient()
    LocalConsultationProtocolPreparationRequirements.asFlow().flatMapMerge { requirement ->
        buildList {
            requirement.let(::add)
            requirement.hasRequirement?.let(::addAll)
            requirement.isRequirementOf?.let(::addAll)
            requirement.hasQualifiedRelation?.let(::addAll)
        }.asFlow()
    }.map { requirement ->
        RequirementCreateCommandDTOBase(
            name = requirement.name,
            description = requirement.description,
            hasConcept = emptyList(),
            hasEvidenceTypeList = emptyList(),
            hasRequirement = requirement.hasRequirement?.mapNotNull { it.identifier } ?: emptyList(),
            isRequirementOf = requirement.isRequirementOf?.mapNotNull { it.identifier },
            hasQualifiedRelation = requirement.hasQualifiedRelation?.mapNotNull { it.identifier },
            kind = RequirementKind.INFORMATION.name
        )
    }.let { flow ->
        requirementClient.requirementCreate().invoke(flow)
    }.collect()
}
