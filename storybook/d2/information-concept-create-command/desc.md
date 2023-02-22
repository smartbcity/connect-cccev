

### Command

Type: `InformationConceptCreateCommand`  
<article>

***dependsOn*** [`List<InformationConceptId>`](#informationconceptid) 

A list of information concepts the one depends on for auto-computation, if applicable.

</article>
<article>

***description*** `String` 

The description of the information concept.

</article>
<article>

***expressionOfExpectedValue*** `String?` 

Expression to evaluate in order to auto-compute the SupportedValue associated with the information concept, if applicable. <br /> For now, the expression will be evaluated using a Kotlin engine. <br /> The expression may contain other known information concepts, identified by their id. They must be declared in the `dependsOn` field.

</article>
<article>

***name*** `String` 

The name of the information concept.

</article>
<article>

***unitId*** `DataUnitId` 

The data unit used for the information concept.

</article>

