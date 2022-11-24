# Welcome to CCCEV-CEE

### Request score computation

Each InformationConcept has its own score. The total score of a request is the average score of all its
InformationConcepts.

**Computation rules per field**

- Score value goes from 0 to 100 included
- A field with an auto-computed value does not have a score
- Having no value blocks the score to 0, no matter if some other conditions are verified
- Having a value gives +50 score
- The rest is computed according to the provided evidences for the field (from 0 to 50 included)
    - Each EvidenceTypeList has its own score
    - The final score corresponds to the highest amongst the EvidenceTypeLists
    - The score of an ETL is `(totalEvidenceTypes / numberOfFulfilledEvidenceTypes) * 50`

## Domain

![Drag Racing](cccev.jpg)

TODO Add model definition

* Evidence
* EvidenceType
* EvidenceTypeList
* Requirement
* InformationConcept
* SupportedValue

### InformationConcept

```kotlin
object VolumeProduitFini: InformationConceptBase(
    identifier = "volumeProduitFini",
    name = "Volume",
    description = "Volume",
    unit = CubicMeter,
    type = Destinataire.ProduitFini
)
```

## Figma
https://www.figma.com/file/kQXSWDiA0N5mLa8qt583m2/Untitled?node-id=4%3A380

## Api
* Run api
`./gradlew :api-gateway:bootRun -x test`

* Goto Swagger documentation
`http://localhost:8083/swagger-ui.html`