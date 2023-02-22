package cccev.core.dsl.axess

import cccev.core.dsl.Code
import cccev.core.dsl.informationRequirement

object ProtocolStep {
    object Preparation: Code
    object Validation: Code
    object Certification: Code
}


val ProtocolPreparation = informationRequirement {
    identifier = "ProtocolPreparation"
    name = "Protocol Preparation"
    type = ProtocolStep.Preparation
}


val ProtocolValidation = informationRequirement {
    identifier = "ProtocolValidation"
    name = "Protocol Validation"
    type = ProtocolStep.Validation
}

val ProtocolCertification = informationRequirement {
    identifier = "ProtocolCertification"
    name = "Protocol Certification"
    type = ProtocolStep.Certification
}
