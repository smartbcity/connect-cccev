package cccev.projection.api.entity

object Relation {
    const val DEPENDS_ON = "DEPENDS_ON"
    const val FULFILLS = "FULFILLS"
    const val HAS_CONCEPT = "HAS_CONCEPT"
    const val HAS_EVIDENCE_TYPE_LIST = "HAS_EVIDENCE_TYPE_LIST"
    const val HAS_REQUIREMENT = "HAS_REQUIREMENT"
    const val HAS_UNIT = "HAS_UNIT"
    const val IS_DERIVED_FROM = "IS_DERIVED_FROM"
    const val SPECIFIES_EVIDENCE_TYPE = "SPECIFIES_EVIDENCE_TYPE"
    const val PROVIDES_EVIDENCE = "PROVIDES_EVIDENCE"
    const val PROVIDES_VALUE = "PROVIDES_VALUE"
    const val PROVIDES_VALUE_FOR = "PROVIDES_VALUE_FOR"
    const val SUPPORTS_CONCEPT = "SUPPORTS_CONCEPT"

    object Requirement {
        const val CONDITION_ENABLING = "CONDITION_ENABLING"
        const val CONDITION_VALIDATION = "CONDITION_VALIDATION"
    }
}
