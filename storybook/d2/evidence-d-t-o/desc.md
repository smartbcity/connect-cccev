

## Evidence

Type: `EvidenceDTO`

Proof that a Requirement is met.



The class Evidence provides the means to support responses to Criteria or to a concrete Information Requirement or to an Information Concept inside an Information Requirement. The proof described by an Evidence can 1 verify a claim (i.e. is it true that John is 25, yes/no), 2 prove a condition (i.e. is John 18+, yes/no), or 3 simply provide data (i.e. the age of a person, namely 25). The proof can be given through documents or extracts of base registries, independently from its structure, format or medium used to exchange it: a pdf document, a video, a recording, etc.

  
<article>

***file*** `String?` 

Proof of evidence

</article>
<article>

***identifier*** [`EvidenceId`](#evidenceid) 

</article>
<article>

***isConformantTo*** [`List<EvidenceTypeId>`](#evidencetypeid) 

Evidence Type that specifies characteristics of the Evidence.

</article>
<article>

***name*** `String` 

Name of the Evidence

</article>
<article>

***supportsConcept*** `List<InformationConceptId>` 

Information Concept providing facts found/inferred from the Evidence.

</article>
<article>

***supportsRequirement*** [`List<RequirementId>`](#requirementid) 

Requirement for which the Evidence provides proof.

</article>
<article>

***supportsValue*** `List<SupportedValueId>` 

Supported Value that the Evidence contains.

</article>
<article>

***validityPeriod*** `PeriodOfTime?` 

Period of Time during which the Evidence holds true or has force.

</article>

