type Nullable<T> = T | null | undefined
declare const __doNotImplementIt: unique symbol
type __doNotImplementIt = typeof __doNotImplementIt
export namespace ccev.dsl.core {
    interface Code {
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ccev.dsl.core {
    interface EvidenceDTO {
        readonly identifier: string;
        readonly isConformantTo: any/* kotlin.collections.List<string> */;
        readonly supportsValue: any/* kotlin.collections.List<string> */;
        readonly supportsConcept: any/* kotlin.collections.List<string> */;
        readonly supportsRequirement: any/* kotlin.collections.List<string> */;
        readonly validityPeriod: Nullable<ccev.dsl.core.PeriodOfTime>;
        readonly name: string;
        readonly file: Nullable<string>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ccev.dsl.core {
    interface EvidenceTypeList {
        readonly description: string;
        readonly identifier: string;
        readonly name: string;
        readonly specifiesEvidenceType: any/* kotlin.collections.List<ccev.dsl.core.EvidenceType> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface EvidenceType {
        readonly identifier: string;
        readonly name: string;
        readonly evidenceTypeClassification: ccev.dsl.core.Code;
        readonly validityPeriodConstraint: Nullable<ccev.dsl.core.PeriodOfTime>;
        readonly issuingPlace: Nullable<ccev.dsl.core.CoreLocationLocation>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class CoreLocationLocation {
        constructor();
    }
    class PeriodOfTime {
        constructor(duration: Nullable<string>, endTime: Nullable<number>, startTime: Nullable<number>);
    }
}
export namespace ccev.dsl.core {
    interface InformationConcept {
        readonly identifier: string;
        readonly name: string;
        readonly unit: ccev.dsl.core.CUnitDTO;
        readonly type: ccev.dsl.core.Code;
        readonly description: string;
        readonly expressionOfExpectedValue: Nullable<string>;
        readonly dependsOn: any/* kotlin.collections.List<string> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ccev.dsl.core {
    interface SupportedValueDTO {
        readonly identifier: string;
        readonly value: Nullable<string>;
        readonly query: Nullable<string>;
        readonly providesValueFor: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ccev.dsl.core {
    interface CUnitDTO {
        readonly identifier: string;
        readonly name: string;
        readonly description: string;
        readonly notation: Nullable<string>;
        readonly type: any/* ccev.dsl.core.CUnitType */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export as namespace cccev_cccev_dsl_core;