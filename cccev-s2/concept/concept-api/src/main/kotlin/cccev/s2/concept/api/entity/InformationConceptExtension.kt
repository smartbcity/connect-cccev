package cccev.s2.concept.api.entity

import cccev.s2.concept.domain.model.InformationConcept

fun InformationConceptEntity.toInformationConcept() = InformationConcept(
    id = id,
    name = name,
    unitId = unitId,
    description = description,
    expressionOfExpectedValue = expressionOfExpectedValue,
    dependsOn = dependsOn
)
