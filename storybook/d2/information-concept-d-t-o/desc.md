

## InformationConceptDTO



See [cccev.s2.concept.domain.model.InformationConcept](/docs/core-information-concept--page#informationconcept)

  
<article>

***dependsOn*** [`List<InformationConceptId>`](/docs/core-information-concept--page#informationconceptid) 

A list of information concepts this one depends on for auto-computation, if applicable.

</article>
<article>

***description*** `String` 

The description of this information concept.

</article>
<article>

***expressionOfExpectedValue*** `String?` 

Expression to evaluate in order to auto-compute the SupportedValue associated with this information concept, if applicable. <br /> For now, the expression will be evaluated using a Kotlin engine. <br /> The expression may contain other known information concepts, identified by their id. They must be declared in the `dependsOn` field.

</article>
<article>

***id*** [`InformationConceptId`](/docs/core-information-concept--page#informationconceptid) 

Unique identifier of this information concept.

</article>
<article>

***name*** `String` 

The name of this information concept.

</article>
<article>

***unit*** [`DataUnitDTO`](/docs/dataunitdto--page#dataunitdto) 

The data unit used for this information concept.

</article>

