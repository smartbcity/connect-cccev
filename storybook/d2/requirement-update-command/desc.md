

### Command

Type: `RequirementUpdateCommand`  
<article>

***description*** `String?` 

Description of the requirement. <br/> If the requirement is a constraint, this field must contain an expression returning a boolean. For now, this expression will be evaluated using a Kotlin engine. <br /> The expression may contain known information concepts, identified by their id. They must be declared in the `hasConcept` field.

</article>
<article>

***hasConcept*** [`List<InformationConceptId>`](/docs/core-information-concept--page#informationconceptid) 

Concepts used by the requirement

</article>
<article>

***hasEvidenceTypeList*** [`List<EvidenceTypeListId>`](/docs/model--page#evidencetypelistid) 

Evidences that must be provided for the requirement to be validated. <br/> This list represents an OR-relation, i.e. only one of the specified evidence lists has to be fully provided.

</article>
<article>

***hasRequirement*** [`List<RequirementId>`](#requirementid) 

Sub-requirements that must be fulfilled for the requirement to be validated.

</article>
<article>

***id*** [`RequirementId`](#requirementid) 

Identifier of the requirement to update.

</article>
<article>

***name*** `String?` 

Name of the requirement.

</article>

