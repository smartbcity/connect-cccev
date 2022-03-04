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
export namespace f2.dsl.cqrs {
    interface Command extends f2.dsl.cqrs.Message {
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs {
    interface Event extends f2.dsl.cqrs.Message {
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs {
    interface Message {
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs {
    interface Query extends f2.dsl.cqrs.Message {
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs.error {
    interface ErrorDTO<PAYLOAD> {
        readonly severity: f2.dsl.cqrs.error.ErrorSeverity;
        readonly type: string;
        readonly description: string;
        readonly date: string;
        readonly payload: PAYLOAD;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Error<PAYLOAD> implements f2.dsl.cqrs.error.ErrorDTO<PAYLOAD> {
        constructor(type: string, description: string, date: string, payload: PAYLOAD, severity: f2.dsl.cqrs.error.ErrorSeverity);
        get type(): string;
        get description(): string;
        get date(): string;
        get payload(): PAYLOAD;
        get severity(): f2.dsl.cqrs.error.ErrorSeverity;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class ErrorSeverity {
        constructor(severity: string);
        get severity(): string;
    }
    class ErrorSeverityWarning extends f2.dsl.cqrs.error.ErrorSeverity {
        constructor();
    }
    class AlertSeverityError extends f2.dsl.cqrs.error.ErrorSeverity {
        constructor();
    }
}
export namespace f2.dsl.cqrs.exception {
    class F2Exception /* extends kotlin.Exception */ {
        constructor(id: string, error: f2.dsl.cqrs.error.ErrorDTO<any /*UnknownType **/>);
        get id(): string;
        get error(): f2.dsl.cqrs.error.ErrorDTO<any /*UnknownType **/>;
    }
}
export namespace f2.dsl.cqrs.page {
    interface PageDTO<OBJECT> {
        readonly total: number;
        readonly items: any/* kotlin.collections.List<OBJECT> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Page<OBJECT> implements f2.dsl.cqrs.page.PageDTO<OBJECT> {
        constructor(total: number, items: any/* kotlin.collections.List<OBJECT> */);
        get total(): number;
        get items(): any/* kotlin.collections.List<OBJECT> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs.page {
    interface PageQueryDTO extends f2.dsl.cqrs.Query {
        readonly pagination: Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface PageQueryResultDTO<OBJECT> extends f2.dsl.cqrs.Event, f2.dsl.cqrs.page.PageDTO<OBJECT> {
        readonly total: number;
        readonly items: any/* kotlin.collections.List<OBJECT> */;
        readonly pagination: Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class PageQuery implements f2.dsl.cqrs.page.PageQueryDTO {
        constructor(pagination: Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>);
        get pagination(): Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class PageQueryResult<OBJECT> implements f2.dsl.cqrs.page.PageQueryResultDTO<OBJECT> {
        constructor(pagination: Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>, total: number, items: any/* kotlin.collections.List<OBJECT> */);
        get pagination(): Nullable<f2.dsl.cqrs.page.OffsetPaginationDTO>;
        get total(): number;
        get items(): any/* kotlin.collections.List<OBJECT> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.cqrs.page {
    interface Pagination {
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface OffsetPaginationDTO {
        readonly offset: number;
        readonly limit: number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class OffsetPagination implements f2.dsl.cqrs.page.OffsetPaginationDTO, f2.dsl.cqrs.page.Pagination {
        constructor(offset: number, limit: number);
        get offset(): number;
        get limit(): number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface PagePaginationDTO {
        readonly page: Nullable<number>;
        readonly size: Nullable<number>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class PagePagination implements f2.dsl.cqrs.page.PagePaginationDTO, f2.dsl.cqrs.page.Pagination {
        constructor(page: Nullable<number>, size: Nullable<number>);
        get page(): Nullable<number>;
        get size(): Nullable<number>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace f2.dsl.fnc {
    interface F2Function<T, R> {
        invoke(cmd: T): any/* kotlin.js.Promise<R> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface F2Supplier<R> {
        invoke(): any/* kotlin.js.Promise<Array<R>> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface F2Consumer<T> {
        invoke(cmd: T): any/* kotlin.js.Promise<void> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl {
    interface SsmChaincodeQueries {
        ssmGetAdminFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetAdminQuery, ssm.chaincode.dsl.query.SsmGetAdminResult>;
        ssmGetQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetQuery, ssm.chaincode.dsl.query.SsmGetResult>;
        ssmGetSessionLogsQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetSessionLogsQuery, ssm.chaincode.dsl.query.SsmGetSessionLogsQueryResult>;
        ssmGetSessionQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetSessionQuery, ssm.chaincode.dsl.query.SsmGetSessionResult>;
        ssmGetTransactionQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetTransactionQuery, ssm.chaincode.dsl.query.SsmGetTransactionQueryResult>;
        ssmGetUserFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmGetUserQuery, ssm.chaincode.dsl.query.SsmGetUserResult>;
        ssmListAdminQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmListAdminQuery, ssm.chaincode.dsl.query.SsmListAdminResult>;
        ssmListSessionQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmListSessionQuery, ssm.chaincode.dsl.query.SsmListSessionResult>;
        ssmListSsmQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmListSsmQuery, ssm.chaincode.dsl.query.SsmListSsmResult>;
        ssmListUserQueryFunction(): f2.dsl.fnc.F2Function<ssm.chaincode.dsl.query.SsmListUserQuery, ssm.chaincode.dsl.query.SsmListUserResult>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl {
    interface SsmQueryDTO extends f2.dsl.cqrs.Query {
        readonly chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface SsmItemResultDTO<T> extends f2.dsl.cqrs.Event {
        readonly item: Nullable<T>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface SsmItemsResultDTO<T> extends f2.dsl.cqrs.Event {
        readonly items: Array<T>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.blockchain {
    interface BlockDTO {
        readonly blockId: string;
        readonly previousHash: Int8Array;
        readonly dataHash: Int8Array;
        readonly transactions: any/* kotlin.collections.List<ssm.chaincode.dsl.blockchain.TransactionDTO> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Block implements ssm.chaincode.dsl.blockchain.BlockDTO {
        constructor(blockId: string, previousHash: Int8Array, dataHash: Int8Array, transactions: any/* kotlin.collections.List<ssm.chaincode.dsl.blockchain.Transaction> */);
        get blockId(): string;
        get previousHash(): Int8Array;
        get dataHash(): Int8Array;
        get transactions(): any/* kotlin.collections.List<ssm.chaincode.dsl.blockchain.Transaction> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.blockchain {
    abstract class EnvelopeType {
        private constructor();
        static get TRANSACTION_ENVELOPE(): ssm.chaincode.dsl.blockchain.EnvelopeType & {
            get name(): "TRANSACTION_ENVELOPE";
            get ordinal(): 0;
        };
        static get ENVELOPE(): ssm.chaincode.dsl.blockchain.EnvelopeType & {
            get name(): "ENVELOPE";
            get ordinal(): 1;
        };
        static values(): Array<ssm.chaincode.dsl.blockchain.EnvelopeType>;
        static valueOf(value: string): ssm.chaincode.dsl.blockchain.EnvelopeType;
        get name(): "TRANSACTION_ENVELOPE" | "ENVELOPE";
        get ordinal(): 0 | 1;
    }
}
export namespace ssm.chaincode.dsl.blockchain {
    interface IdentitiesInfoDTO {
        readonly id: string;
        readonly mspid: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class IdentitiesInfo implements ssm.chaincode.dsl.blockchain.IdentitiesInfoDTO {
        constructor(id: string, mspid: string);
        get id(): string;
        get mspid(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.blockchain {
    interface TransactionDTO {
        readonly transactionId: string;
        readonly blockId: string;
        readonly timestamp: any/* kotlin.Long */;
        readonly isValid: boolean;
        readonly channelId: string;
        readonly creator: ssm.chaincode.dsl.blockchain.IdentitiesInfoDTO;
        readonly nonce: Int8Array;
        readonly type: ssm.chaincode.dsl.blockchain.EnvelopeType;
        readonly validationCode: number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Transaction implements ssm.chaincode.dsl.blockchain.TransactionDTO {
        constructor(transactionId: string, blockId: string, timestamp: any/* kotlin.Long */, isValid: boolean, channelId: string, creator: ssm.chaincode.dsl.blockchain.IdentitiesInfo, nonce: Int8Array, type: ssm.chaincode.dsl.blockchain.EnvelopeType, validationCode: number);
        get transactionId(): string;
        get blockId(): string;
        get timestamp(): any/* kotlin.Long */;
        get isValid(): boolean;
        get channelId(): string;
        get creator(): ssm.chaincode.dsl.blockchain.IdentitiesInfo;
        get nonce(): Int8Array;
        get type(): ssm.chaincode.dsl.blockchain.EnvelopeType;
        get validationCode(): number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.config {
    interface SsmChaincodePropertiesDTO {
        readonly url: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class ChaincodeSsmConfig implements ssm.chaincode.dsl.config.SsmChaincodePropertiesDTO {
        constructor(url: string);
        get url(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmAgentDTO {
        readonly name: string;
        readonly pub: Int8Array;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmAgent implements ssm.chaincode.dsl.model.SsmAgentDTO {
        constructor(name: string, pub: Int8Array);
        get name(): string;
        get pub(): Int8Array;
        equals(other: Nullable<any>): boolean;
        hashCode(): number;
        static get Companion(): {
        };
        component1(): string;
        component2(): Int8Array;
        copy(name: string, pub: Int8Array): ssm.chaincode.dsl.model.Agent;
        toString(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface ChaincodeDTO {
        readonly id: string;
        readonly channelId: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Chaincode implements ssm.chaincode.dsl.model.ChaincodeDTO {
        constructor(id: string, channelId: string);
        get id(): string;
        get channelId(): string;
        component1(): string;
        component2(): string;
        copy(id: string, channelId: string): ssm.chaincode.dsl.model.Chaincode;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmDTO {
        readonly name: string;
        readonly transitions: any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmTransitionDTO> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Ssm implements ssm.chaincode.dsl.model.SsmDTO {
        constructor(name: string, transitions: any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmTransition> */);
        get name(): string;
        get transitions(): any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmTransition> */;
        component1(): string;
        component2(): any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmTransition> */;
        copy(name: string, transitions: any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmTransition> */): ssm.chaincode.dsl.model.Ssm;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmContextDTO extends ssm.chaincode.dsl.model.WithPrivate {
        readonly session: string;
        readonly public: string;
        readonly iteration: number;
        readonly private: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmContext implements ssm.chaincode.dsl.model.SsmContextDTO {
        constructor(session: string, _public: string, iteration: number, _private: any/* Nullable<kotlin.collections.Map<string, string>> */);
        get session(): string;
        get public(): string;
        get iteration(): number;
        get private(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        component1(): string;
        component2(): string;
        component3(): number;
        component4(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        copy(session: string, _public: string, iteration: number, _private: any/* Nullable<kotlin.collections.Map<string, string>> */): ssm.chaincode.dsl.model.SsmContext;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmGrantDTO {
        readonly user: string;
        readonly iteration: number;
        readonly credits: any/* kotlin.collections.Map<string, ssm.chaincode.dsl.model.CreditDTO> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGrant {
        constructor(user: string, iteration: number, credits: any/* kotlin.collections.Map<string, ssm.chaincode.dsl.model.Credit> */);
        get user(): string;
        get iteration(): number;
        get credits(): any/* kotlin.collections.Map<string, ssm.chaincode.dsl.model.Credit> */;
        component1(): string;
        component2(): number;
        component3(): any/* kotlin.collections.Map<string, ssm.chaincode.dsl.model.Credit> */;
        copy(user: string, iteration: number, credits: any/* kotlin.collections.Map<string, ssm.chaincode.dsl.model.Credit> */): ssm.chaincode.dsl.model.SsmGrant;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
    }
    interface CreditDTO {
        readonly amount: number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class Credit implements ssm.chaincode.dsl.model.CreditDTO {
        constructor(amount: number);
        get amount(): number;
        component1(): number;
        copy(amount: number): ssm.chaincode.dsl.model.Credit;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmSessionDTO extends ssm.chaincode.dsl.model.WithPrivate {
        readonly ssm: Nullable<string>;
        readonly session: string;
        readonly roles: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly public: Nullable<any>;
        readonly private: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmSession implements ssm.chaincode.dsl.model.SsmSessionDTO {
        constructor(ssm: string, session: string, roles: any/* kotlin.collections.Map<string, string> */, _public: string, _private: any/* Nullable<kotlin.collections.Map<string, string>> */);
        get ssm(): string;
        get session(): string;
        get roles(): any/* kotlin.collections.Map<string, string> */;
        get public(): string;
        get private(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmSessionStateDTO extends ssm.chaincode.dsl.model.SsmSessionDTO, ssm.chaincode.dsl.model.WithPrivate {
        readonly ssm: Nullable<string>;
        readonly session: string;
        readonly roles: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly public: Nullable<any>;
        readonly private: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly origin: Nullable<ssm.chaincode.dsl.model.SsmTransitionDTO>;
        readonly current: number;
        readonly iteration: number;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmSessionState implements ssm.chaincode.dsl.model.SsmSessionStateDTO {
        constructor(ssm: Nullable<string>, session: string, roles: any/* Nullable<kotlin.collections.Map<string, string>> */, _public: Nullable<any>, _private: any/* Nullable<kotlin.collections.Map<string, string>> */, origin: Nullable<ssm.chaincode.dsl.model.SsmTransition>, current: number, iteration: number);
        get ssm(): Nullable<string>;
        get session(): string;
        get roles(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        get public(): Nullable<any>;
        get private(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        get origin(): Nullable<ssm.chaincode.dsl.model.SsmTransition>;
        get current(): number;
        get iteration(): number;
        component1(): Nullable<string>;
        component2(): string;
        component3(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        component4(): Nullable<any>;
        component5(): any/* Nullable<kotlin.collections.Map<string, string>> */;
        component6(): Nullable<ssm.chaincode.dsl.model.SsmTransition>;
        component7(): number;
        component8(): number;
        copy(ssm: Nullable<string>, session: string, roles: any/* Nullable<kotlin.collections.Map<string, string>> */, _public: Nullable<any>, _private: any/* Nullable<kotlin.collections.Map<string, string>> */, origin: Nullable<ssm.chaincode.dsl.model.SsmTransition>, current: number, iteration: number): ssm.chaincode.dsl.model.SsmSessionState;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmSessionStateLogDTO {
        readonly txId: string;
        readonly state: ssm.chaincode.dsl.model.SsmSessionStateDTO;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmSessionStateLog implements ssm.chaincode.dsl.model.SsmSessionStateLogDTO {
        constructor(txId: string, state: ssm.chaincode.dsl.model.SsmSessionState);
        get txId(): string;
        get state(): ssm.chaincode.dsl.model.SsmSessionState;
        component1(): string;
        component2(): ssm.chaincode.dsl.model.SsmSessionState;
        copy(txId: string, state: ssm.chaincode.dsl.model.SsmSessionState): ssm.chaincode.dsl.model.SsmSessionStateLog;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface SsmTransitionDTO {
        readonly from: number;
        readonly to: number;
        readonly role: string;
        readonly action: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmTransition implements ssm.chaincode.dsl.model.SsmTransitionDTO {
        constructor(from: number, to: number, role: string, action: string);
        get from(): number;
        get to(): number;
        get role(): string;
        get action(): string;
        component1(): number;
        component2(): number;
        component3(): string;
        component4(): string;
        copy(from: number, to: number, role: string, action: string): ssm.chaincode.dsl.model.SsmTransition;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model {
    interface WithPrivate {
        readonly private: any/* Nullable<kotlin.collections.Map<string, string>> */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model.uri {
    interface ChaincodeUriDTO {
        readonly uri: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class ChaincodeUri implements ssm.chaincode.dsl.model.uri.ChaincodeUriDTO {
        constructor(uri: string);
        get uri(): string;
        static get Companion(): {
            get PARTS(): number;
            get PREFIX(): string;
        };
        get channelId(): string;
        get chaincodeId(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.model.uri {
    interface SsmUriDTO {
        readonly uri: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmUri implements ssm.chaincode.dsl.model.uri.SsmUriDTO {
        constructor(uri: string);
        get uri(): string;
        static get Companion(): {
            get PARTS(): number;
            get PREFIX(): string;
        };
        get channelId(): string;
        get chaincodeId(): string;
        get ssmName(): string;
        get ssmVersion(): string;
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        component1(): string;
        copy(uri: string): ssm.chaincode.dsl.model.uri.SsmUri;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetAdminQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, name: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get name(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetAdminResult implements ssm.chaincode.dsl.SsmItemResultDTO<ssm.chaincode.dsl.model.Agent> {
        constructor(item: Nullable<ssm.chaincode.dsl.model.Agent>);
        get item(): Nullable<ssm.chaincode.dsl.model.Agent>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, name: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get name(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetResult implements ssm.chaincode.dsl.SsmItemResultDTO<ssm.chaincode.dsl.model.Ssm> {
        constructor(item: Nullable<ssm.chaincode.dsl.model.Ssm>);
        get item(): Nullable<ssm.chaincode.dsl.model.Ssm>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetSessionLogsQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, ssmName: string, sessionName: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get ssmName(): string;
        get sessionName(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetSessionLogsQueryResult {
        constructor(ssmName: string, sessionName: string, logs: any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmSessionStateLog> */);
        get ssmName(): string;
        get sessionName(): string;
        get logs(): any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmSessionStateLog> */;
        component1(): string;
        component2(): string;
        component3(): any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmSessionStateLog> */;
        copy(ssmName: string, sessionName: string, logs: any/* kotlin.collections.List<ssm.chaincode.dsl.model.SsmSessionStateLog> */): ssm.chaincode.dsl.query.SsmGetSessionLogsQueryResult;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetSessionQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, sessionName: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get sessionName(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetSessionResult implements ssm.chaincode.dsl.SsmItemResultDTO<ssm.chaincode.dsl.model.SsmSessionState> {
        constructor(item: Nullable<ssm.chaincode.dsl.model.SsmSessionState>);
        get item(): Nullable<ssm.chaincode.dsl.model.SsmSessionState>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetTransactionQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, id: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get id(): string;
        component1(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        component2(): string;
        copy(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, id: string): ssm.chaincode.dsl.query.SsmGetTransactionQuery;
        toString(): string;
        hashCode(): number;
        equals(other: Nullable<any>): boolean;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetTransactionQueryResult implements ssm.chaincode.dsl.SsmItemResultDTO<ssm.chaincode.dsl.blockchain.Transaction> {
        constructor(item: Nullable<ssm.chaincode.dsl.blockchain.Transaction>);
        get item(): Nullable<ssm.chaincode.dsl.blockchain.Transaction>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmGetUserQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri, name: string);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        get name(): string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmGetUserResult implements ssm.chaincode.dsl.SsmItemResultDTO<ssm.chaincode.dsl.model.Agent> {
        constructor(item: Nullable<ssm.chaincode.dsl.model.Agent>);
        get item(): Nullable<ssm.chaincode.dsl.model.Agent>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmListAdminQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmListAdminResult implements ssm.chaincode.dsl.SsmItemsResultDTO<string> {
        constructor(items: Array<string>);
        get items(): Array<string>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmListSessionQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmListSessionResult implements ssm.chaincode.dsl.SsmItemsResultDTO<string> {
        constructor(items: Array<string>);
        get items(): Array<string>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmListSsmQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmListSsmResult implements ssm.chaincode.dsl.SsmItemsResultDTO<string> {
        constructor(items: Array<string>);
        get items(): Array<string>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace ssm.chaincode.dsl.query {
    class SsmListUserQuery implements ssm.chaincode.dsl.SsmQueryDTO {
        constructor(chaincodeUri: ssm.chaincode.dsl.model.uri.ChaincodeUri);
        get chaincodeUri(): ssm.chaincode.dsl.model.uri.ChaincodeUri;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class SsmListUserResult implements ssm.chaincode.dsl.SsmItemsResultDTO<string> {
        constructor(items: Array<string>);
        get items(): Array<string>;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace s2.dsl.automate {
    class S2Automate /* implements s2.dsl.automate.Automate */ {
        constructor(name: string, transitions: Array<s2.dsl.automate.S2Transition>, subMachines: Array<s2.dsl.automate.S2SubMachine>);
        get name(): string;
        get transitions(): Array<s2.dsl.automate.S2Transition>;
        get subMachines(): Array<s2.dsl.automate.S2SubMachine>;
    }
}
export namespace s2.dsl.automate {
    interface S2InitCommand extends f2.dsl.cqrs.Command {
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface S2Command<ID> extends f2.dsl.cqrs.Command, s2.dsl.automate.WithId<ID> {
        readonly id: ID;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace s2.dsl.automate {
    class S2ErrorBase implements s2.dsl.automate.S2Error {
        constructor(severity: f2.dsl.cqrs.error.ErrorSeverity, type: string, description: string, date: string, payload: any/* kotlin.collections.Map<string, string> */);
        get severity(): f2.dsl.cqrs.error.ErrorSeverity;
        get type(): string;
        get description(): string;
        get date(): string;
        get payload(): any/* kotlin.collections.Map<string, string> */;
        toString(): string;
    }
}
export namespace s2.dsl.automate {
    interface S2Event<STATE, ID> extends f2.dsl.cqrs.Event, s2.dsl.automate.WithId<ID> {
        readonly id: ID;
        readonly type: STATE;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class S2EventSuccess<STATE, COMMAND, ID> implements f2.dsl.cqrs.Event {
        constructor(id: ID, type: COMMAND, from: STATE, to: STATE);
        get id(): ID;
        get type(): COMMAND;
        get from(): STATE;
        get to(): STATE;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    class S2EventError<STATE, COMMAND, ID> implements f2.dsl.cqrs.Event {
        constructor(id: ID, type: COMMAND, from: STATE, to: STATE, error: s2.dsl.automate.S2Error);
        get id(): ID;
        get type(): COMMAND;
        get from(): STATE;
        get to(): STATE;
        get error(): s2.dsl.automate.S2Error;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace s2.dsl.automate {
    class S2SubMachine {
        constructor(automate: s2.dsl.automate.S2Automate, startsOn: any/* kotlin.collections.List<any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */> */, endsOn: any/* kotlin.collections.List<any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */> */, autostart: boolean, blocking: boolean, singleton: boolean);
        get automate(): s2.dsl.automate.S2Automate;
        get startsOn(): any/* kotlin.collections.List<any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */> */;
        get endsOn(): any/* kotlin.collections.List<any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */> */;
        get autostart(): boolean;
        get blocking(): boolean;
        get singleton(): boolean;
    }
}
export namespace s2.dsl.automate {
    class S2InitTransition {
        constructor(to: s2.dsl.automate.S2State, role: s2.dsl.automate.S2Role, command: any/* kotlin.reflect.KClass<s2.dsl.automate.S2InitCommand> */);
        get to(): s2.dsl.automate.S2State;
        get role(): s2.dsl.automate.S2Role;
        get command(): any/* kotlin.reflect.KClass<s2.dsl.automate.S2InitCommand> */;
    }
    class S2Transition {
        constructor(from: Nullable<s2.dsl.automate.S2State>, to: s2.dsl.automate.S2State, role: s2.dsl.automate.S2Role, msg: any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */);
        get from(): Nullable<s2.dsl.automate.S2State>;
        get to(): s2.dsl.automate.S2State;
        get role(): s2.dsl.automate.S2Role;
        get msg(): any/* kotlin.reflect.KClass<f2.dsl.cqrs.Message> */;
    }
    class S2TransitionCommand {
        constructor(name: string, attributes: Array<s2.dsl.automate.S2TransitionCommandAttribute>);
        get name(): string;
        get attributes(): Array<s2.dsl.automate.S2TransitionCommandAttribute>;
    }
    class S2TransitionCommandAttribute {
        constructor(name: string, type: string, optional: boolean);
        get name(): string;
        get type(): string;
        get optional(): boolean;
    }
}
export namespace s2.dsl.automate.builder {
    function s2(exec: (p0: any/* s2.dsl.automate.builder.S2AutomateBuilder */) => void): s2.dsl.automate.S2Automate;
}
export namespace s2.dsl.automate {
    interface S2Error {
        readonly severity: f2.dsl.cqrs.error.ErrorSeverity;
        readonly type: string;
        readonly description: string;
        readonly date: string;
        readonly payload: any/* kotlin.collections.Map<string, string> */;
    }
}
export namespace s2.dsl.automate {
    interface S2Role {
    }
}
export namespace s2.dsl.automate {
    interface S2State {
        readonly position: number;
    }
}
export namespace s2.dsl.automate {
    interface MessageWithId<ID> {
        readonly id: ID;
    }
}
export namespace cccev.s2.request.domain {
    interface RequestEvent extends s2.dsl.automate.S2Event<any/* cccev.s2.request.domain.RequestState */, string> {
        readonly id: string;
        readonly type: any/* cccev.s2.request.domain.RequestState */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestCommand extends s2.dsl.automate.S2Command<string> {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestAuditCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestAuditedEventDTO extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Audited */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestEvidenceAddCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly evidence: ccev.dsl.core.EvidenceDTO;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestEvidenceAddedEventDTO extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Created */;
        readonly evidenceId: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestEvidenceRemoveCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly evidenceTypeId: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestEvidenceRemovedEventDTO extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Created */;
        readonly evidenceTypeId: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestInitCommandDTO extends s2.dsl.automate.S2InitCommand {
        readonly id: string;
        readonly frameworkId: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestInitializedEventDTO {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestRefuseCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestRefusedEventDto extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Created */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestSendCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestSentEventDto extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Sent */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestSignCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestSignedEventDto extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Signed */;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export namespace cccev.s2.request.domain.features.command {
    interface RequestSupportedValueAddCommandDTO extends cccev.s2.request.domain.RequestCommand {
        readonly id: string;
        readonly supportedValue: ccev.dsl.core.SupportedValueDTO;
        readonly __doNotUseIt: __doNotImplementIt;
    }
    interface RequestSupportedValueAddedEventDto extends cccev.s2.request.domain.RequestEvent {
        readonly id: string;
        readonly type: any/* typeof cccev.s2.request.domain.RequestState.Created */;
        readonly providesValueFor: string;
        readonly __doNotUseIt: __doNotImplementIt;
    }
}
export as namespace cccev_request_domain;