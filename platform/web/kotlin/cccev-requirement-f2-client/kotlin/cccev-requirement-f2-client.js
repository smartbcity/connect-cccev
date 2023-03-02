(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './ktor-ktor-utils-js-ir.js', './cccev-requirement-f2-domain.js', './kotlin-kotlin-stdlib-js-ir.js', './f2-f2-client-core.js', './cccev-requirement-domain.js', './f2-f2-dsl-function.js', './f2-f2-client-ktor.js', './kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js', './cccev-dsl-model.js', './f2-f2-dsl-cqrs.js', './ssm-ssm-chaincode-dsl.js', './s2-s2-automate-dsl.js', './s2-s2-event-sourcing-dsl.js', './cccev-request-domain.js', './cccev-evidence-f2-domain.js', './cccev-unit-domain.js', './cccev-unit-f2-domain.js', './cccev-concept-domain.js', './cccev-concept-f2-domain.js', './cccev-evidence-type-domain.js', './cccev-evidence-type-f2-domain.js', './f2-f2-client-ktor-http.js', './f2-f2-client-ktor-rsocket.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./ktor-ktor-utils-js-ir.js'), require('./cccev-requirement-f2-domain.js'), require('./kotlin-kotlin-stdlib-js-ir.js'), require('./f2-f2-client-core.js'), require('./cccev-requirement-domain.js'), require('./f2-f2-dsl-function.js'), require('./f2-f2-client-ktor.js'), require('./kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js'), require('./cccev-dsl-model.js'), require('./f2-f2-dsl-cqrs.js'), require('./ssm-ssm-chaincode-dsl.js'), require('./s2-s2-automate-dsl.js'), require('./s2-s2-event-sourcing-dsl.js'), require('./cccev-request-domain.js'), require('./cccev-evidence-f2-domain.js'), require('./cccev-unit-domain.js'), require('./cccev-unit-f2-domain.js'), require('./cccev-concept-domain.js'), require('./cccev-concept-f2-domain.js'), require('./cccev-evidence-type-domain.js'), require('./cccev-evidence-type-f2-domain.js'), require('./f2-f2-client-ktor-http.js'), require('./f2-f2-client-ktor-rsocket.js'));
  else {
    if (typeof this['ktor-ktor-utils-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'ktor-ktor-utils-js-ir' was not found. Please, check whether 'ktor-ktor-utils-js-ir' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-requirement-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-requirement-f2-domain' was not found. Please, check whether 'cccev-requirement-f2-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-client-core'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-client-core' was not found. Please, check whether 'f2-f2-client-core' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-requirement-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-requirement-domain' was not found. Please, check whether 'cccev-requirement-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-dsl-function'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-dsl-function' was not found. Please, check whether 'f2-f2-dsl-function' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-client-ktor'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-client-ktor' was not found. Please, check whether 'f2-f2-client-ktor' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' was not found. Please, check whether 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-dsl-model'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-dsl-model' was not found. Please, check whether 'cccev-dsl-model' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-dsl-cqrs'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-dsl-cqrs' was not found. Please, check whether 'f2-f2-dsl-cqrs' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['ssm-ssm-chaincode-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'ssm-ssm-chaincode-dsl' was not found. Please, check whether 'ssm-ssm-chaincode-dsl' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['s2-s2-automate-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 's2-s2-automate-dsl' was not found. Please, check whether 's2-s2-automate-dsl' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['s2-s2-event-sourcing-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 's2-s2-event-sourcing-dsl' was not found. Please, check whether 's2-s2-event-sourcing-dsl' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-request-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-request-domain' was not found. Please, check whether 'cccev-request-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-evidence-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-evidence-f2-domain' was not found. Please, check whether 'cccev-evidence-f2-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-unit-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-unit-domain' was not found. Please, check whether 'cccev-unit-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-unit-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-unit-f2-domain' was not found. Please, check whether 'cccev-unit-f2-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-concept-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-concept-domain' was not found. Please, check whether 'cccev-concept-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-concept-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-concept-f2-domain' was not found. Please, check whether 'cccev-concept-f2-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-evidence-type-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-evidence-type-domain' was not found. Please, check whether 'cccev-evidence-type-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['cccev-evidence-type-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'cccev-evidence-type-f2-domain' was not found. Please, check whether 'cccev-evidence-type-f2-domain' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-client-ktor-http'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-client-ktor-http' was not found. Please, check whether 'f2-f2-client-ktor-http' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    if (typeof this['f2-f2-client-ktor-rsocket'] === 'undefined') {
      throw new Error("Error loading module 'cccev-requirement-f2-client'. Its dependency 'f2-f2-client-ktor-rsocket' was not found. Please, check whether 'f2-f2-client-ktor-rsocket' is loaded prior to 'cccev-requirement-f2-client'.");
    }
    root['cccev-requirement-f2-client'] = factory(typeof this['cccev-requirement-f2-client'] === 'undefined' ? {} : this['cccev-requirement-f2-client'], this['ktor-ktor-utils-js-ir'], this['cccev-requirement-f2-domain'], this['kotlin-kotlin-stdlib-js-ir'], this['f2-f2-client-core'], this['cccev-requirement-domain'], this['f2-f2-dsl-function'], this['f2-f2-client-ktor'], this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir'], this['cccev-dsl-model'], this['f2-f2-dsl-cqrs'], this['ssm-ssm-chaincode-dsl'], this['s2-s2-automate-dsl'], this['s2-s2-event-sourcing-dsl'], this['cccev-request-domain'], this['cccev-evidence-f2-domain'], this['cccev-unit-domain'], this['cccev-unit-f2-domain'], this['cccev-concept-domain'], this['cccev-concept-f2-domain'], this['cccev-evidence-type-domain'], this['cccev-evidence-type-f2-domain'], this['f2-f2-client-ktor-http'], this['f2-f2-client-ktor-rsocket']);
  }
}(this, function (_, kotlin_io_ktor_ktor_utils, kotlin_city_smartb_cccev_requirement_f2_domain, kotlin_kotlin, kotlin_city_smartb_f2_f2_client_core, kotlin_city_smartb_cccev_requirement_domain, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_f2_f2_client_ktor, kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core, kotlin_city_smartb_cccev_dsl_model, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_s2_s2_event_sourcing_dsl, kotlin_city_smartb_cccev_request_domain, kotlin_city_smartb_cccev_evidence_f2_domain, kotlin_city_smartb_cccev_unit_domain, kotlin_city_smartb_cccev_unit_f2_domain, kotlin_city_smartb_cccev_concept_domain, kotlin_city_smartb_cccev_concept_f2_domain, kotlin_city_smartb_cccev_evidence_type_domain, kotlin_city_smartb_cccev_evidence_type_f2_domain, kotlin_city_smartb_f2_f2_client_ktor_http, kotlin_city_smartb_f2_f2_client_ktor_rsocket) {
  'use strict';
  //region block: imports
  var JsType_getInstance = kotlin_io_ktor_ktor_utils.$_$.d;
  var RequirementGetQueryDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.i;
  var getKClass = kotlin_kotlin.$_$.f;
  var arrayOf = kotlin_kotlin.$_$.rd;
  var createKType = kotlin_kotlin.$_$.c;
  var Unit_getInstance = kotlin_kotlin.$_$.h5;
  var typeInfoImpl = kotlin_io_ktor_ktor_utils.$_$.n;
  var List = kotlin_kotlin.$_$.o5;
  var createInvariantKTypeProjection = kotlin_kotlin.$_$.a;
  var F2ClientType_HTTP_getInstance = kotlin_city_smartb_f2_f2_client_core.$_$.a;
  var RequirementGetResultDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.j;
  var GetRequirementQuery = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.h;
  var GetRequirementQueryResult = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.g;
  var GetRequirementListQuery = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.f;
  var GetRequirementListQueryResult = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.e;
  var ConstraintCreateCommandDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.a;
  var RequirementCreatedEvent = kotlin_city_smartb_cccev_requirement_domain.$_$.b;
  var CriterionCreateCommandDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.b;
  var InformationRequirementCreateCommandDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.c;
  var RequirementCreateCommandDTOBase = kotlin_city_smartb_cccev_requirement_f2_domain.$_$.d;
  var RequirementUpdateCommand = kotlin_city_smartb_cccev_requirement_domain.$_$.d;
  var RequirementUpdatedEvent = kotlin_city_smartb_cccev_requirement_domain.$_$.f;
  var classMeta = kotlin_kotlin.$_$.k9;
  var setMetadataFor = kotlin_kotlin.$_$.ma;
  var f2SupplierSingle = kotlin_city_smartb_f2_f2_dsl_function.$_$.d;
  var CoroutineImpl = kotlin_kotlin.$_$.z8;
  var F2ClientBuilder_getInstance = kotlin_city_smartb_f2_f2_client_ktor.$_$.b;
  var get = kotlin_city_smartb_f2_f2_client_ktor.$_$.a;
  var await_0 = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.f;
  var get_COROUTINE_SUSPENDED = kotlin_kotlin.$_$.l8;
  //endregion
  //region block: pre-declaration
  setMetadataFor(RequirementClient, 'RequirementClient', classMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(requirementClient$slambda, 'requirementClient$slambda', classMeta, CoroutineImpl, undefined, undefined, undefined, [0]);
  //endregion
  function RequirementClient$requirementGet$ref($boundThis) {
    var l = function () {
      return $boundThis.v6k();
    };
    l.callableName = 'requirementGet';
    return l;
  }
  function RequirementClient$getRequirement$ref($boundThis) {
    var l = function () {
      return $boundThis.w6k();
    };
    l.callableName = 'getRequirement';
    return l;
  }
  function RequirementClient$getRequirements$ref($boundThis) {
    var l = function () {
      return $boundThis.x6k();
    };
    l.callableName = 'getRequirements';
    return l;
  }
  function RequirementClient$constraintCreate$ref($boundThis) {
    var l = function () {
      return $boundThis.y6k();
    };
    l.callableName = 'constraintCreate';
    return l;
  }
  function RequirementClient$criterionCreate$ref($boundThis) {
    var l = function () {
      return $boundThis.z6k();
    };
    l.callableName = 'criterionCreate';
    return l;
  }
  function RequirementClient$informationRequirementCreate$ref($boundThis) {
    var l = function () {
      return $boundThis.a6l();
    };
    l.callableName = 'informationRequirementCreate';
    return l;
  }
  function RequirementClient$requirementCreate$ref($boundThis) {
    var l = function () {
      return $boundThis.b6l();
    };
    l.callableName = 'requirementCreate';
    return l;
  }
  function RequirementClient$requirementUpdate$ref($boundThis) {
    var l = function () {
      return $boundThis.c6l();
    };
    l.callableName = 'requirementUpdate';
    return l;
  }
  function RequirementClient(client) {
    this.u6k_1 = client;
  }
  RequirementClient.prototype.v6k = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$requirementGet$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementGetQueryDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(RequirementGetQueryDTOBase);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(RequirementGetQueryDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementGetResultDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementGetResultDTOBase);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementGetResultDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.w6k = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$getRequirement$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(GetRequirementQuery), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(GetRequirementQuery);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(GetRequirementQuery), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(GetRequirementQueryResult), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(GetRequirementQueryResult);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(GetRequirementQueryResult), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.x6k = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$getRequirements$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(GetRequirementListQuery), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(GetRequirementListQuery);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(GetRequirementListQuery), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(GetRequirementListQueryResult), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(GetRequirementListQueryResult);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(GetRequirementListQueryResult), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.y6k = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$constraintCreate$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(ConstraintCreateCommandDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(ConstraintCreateCommandDTOBase);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(ConstraintCreateCommandDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementCreatedEvent);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.z6k = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$criterionCreate$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(CriterionCreateCommandDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(CriterionCreateCommandDTOBase);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(CriterionCreateCommandDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementCreatedEvent);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.a6l = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$informationRequirementCreate$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(InformationRequirementCreateCommandDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(InformationRequirementCreateCommandDTOBase);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(InformationRequirementCreateCommandDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementCreatedEvent);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.b6l = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$requirementCreate$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementCreateCommandDTOBase), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(RequirementCreateCommandDTOBase);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(RequirementCreateCommandDTOBase), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementCreatedEvent);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementCreatedEvent), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  RequirementClient.prototype.c6l = function () {
    var tmp$ret$10;
    // Inline function 'f2.client.function' call
    var tmp0_function = this.u6k_1;
    var tmp1_function = RequirementClient$requirementUpdate$ref(this).callableName;
    var tmp$ret$4;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$1;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_0 = JsType_getInstance();
      var tmp_1 = getKClass(List);
      var tmp$ret$0;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_2;
      try {
        tmp_2 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementUpdateCommand), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_3;
        if ($p instanceof Error) {
          tmp_3 = null;
        } else {
          throw $p;
        }
        tmp_2 = tmp_3;
      }
      tmp$ret$0 = tmp_2;
      tmp$ret$1 = typeInfoImpl(tmp_0, tmp_1, tmp$ret$0);
      tmp = tmp$ret$1;
    } else {
      var tmp$ret$3;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_4 = JsType_getInstance();
      var tmp_5 = getKClass(RequirementUpdateCommand);
      var tmp$ret$2;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_6;
      try {
        tmp_6 = createKType(getKClass(RequirementUpdateCommand), arrayOf([]), false);
      } catch ($p) {
        var tmp_7;
        if ($p instanceof Error) {
          tmp_7 = null;
        } else {
          throw $p;
        }
        tmp_6 = tmp_7;
      }
      tmp$ret$2 = tmp_6;
      tmp$ret$3 = typeInfoImpl(tmp_4, tmp_5, tmp$ret$2);
      tmp = tmp$ret$3;
    }
    tmp$ret$4 = tmp;
    var queryTypeInfo = tmp$ret$4;
    var tmp$ret$9;
    // Inline function 'f2.client.getTypeInfo' call
    var tmp_8;
    if (tmp0_function.type.equals(F2ClientType_HTTP_getInstance())) {
      var tmp$ret$6;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_9 = JsType_getInstance();
      var tmp_10 = getKClass(List);
      var tmp$ret$5;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_11;
      try {
        tmp_11 = createKType(getKClass(List), arrayOf([createInvariantKTypeProjection(createKType(getKClass(RequirementUpdatedEvent), arrayOf([]), false))]), false);
      } catch ($p) {
        var tmp_12;
        if ($p instanceof Error) {
          tmp_12 = null;
        } else {
          throw $p;
        }
        tmp_11 = tmp_12;
      }
      tmp$ret$5 = tmp_11;
      tmp$ret$6 = typeInfoImpl(tmp_9, tmp_10, tmp$ret$5);
      tmp_8 = tmp$ret$6;
    } else {
      var tmp$ret$8;
      // Inline function 'io.ktor.util.reflect.typeInfo' call
      var tmp_13 = JsType_getInstance();
      var tmp_14 = getKClass(RequirementUpdatedEvent);
      var tmp$ret$7;
      // Inline function 'io.ktor.util.reflect.tryGetType' call
      var tmp_15;
      try {
        tmp_15 = createKType(getKClass(RequirementUpdatedEvent), arrayOf([]), false);
      } catch ($p) {
        var tmp_16;
        if ($p instanceof Error) {
          tmp_16 = null;
        } else {
          throw $p;
        }
        tmp_15 = tmp_16;
      }
      tmp$ret$7 = tmp_15;
      tmp$ret$8 = typeInfoImpl(tmp_13, tmp_14, tmp$ret$7);
      tmp_8 = tmp$ret$8;
    }
    tmp$ret$9 = tmp_8;
    var responseTypeInfo = tmp$ret$9;
    tmp$ret$10 = tmp0_function.function(tmp1_function, queryTypeInfo, responseTypeInfo);
    return tmp$ret$10;
  };
  function requirementClient(urlBase) {
    return f2SupplierSingle(requirementClient$slambda_0(urlBase, null));
  }
  function requirementClient$slambda($urlBase, resultContinuation) {
    this.l6l_1 = $urlBase;
    CoroutineImpl.call(this, resultContinuation);
  }
  requirementClient$slambda.prototype.m6l = function ($cont) {
    var tmp = this.xg($cont);
    tmp.fg_1 = Unit_getInstance();
    tmp.gg_1 = null;
    return tmp.wg();
  };
  requirementClient$slambda.prototype.z5e = function ($cont) {
    return this.m6l($cont);
  };
  requirementClient$slambda.prototype.wg = function () {
    var suspendResult = this.fg_1;
    $sm: do
      try {
        var tmp = this.dg_1;
        switch (tmp) {
          case 0:
            this.eg_1 = 2;
            this.dg_1 = 1;
            suspendResult = await_0(get(F2ClientBuilder_getInstance(), this.l6l_1), this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            var tmp0_let = suspendResult;
            return new RequirementClient(tmp0_let);
          case 2:
            throw this.gg_1;
        }
      } catch ($p) {
        if (this.eg_1 === 2) {
          throw $p;
        } else {
          this.dg_1 = this.eg_1;
          this.gg_1 = $p;
        }
      }
     while (true);
  };
  requirementClient$slambda.prototype.xg = function (completion) {
    var i = new requirementClient$slambda(this.l6l_1, completion);
    return i;
  };
  function requirementClient$slambda_0($urlBase, resultContinuation) {
    var i = new requirementClient$slambda($urlBase, resultContinuation);
    var l = function ($cont) {
      return i.m6l($cont);
    };
    l.$arity = 0;
    return l;
  }
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$requirement = $cccev$s2.requirement || ($cccev$s2.requirement = {});
    var $cccev$s2$requirement$client = $cccev$s2$requirement.client || ($cccev$s2$requirement.client = {});
    $cccev$s2$requirement$client.RequirementClient = RequirementClient;
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$requirement = $cccev$s2.requirement || ($cccev$s2.requirement = {});
    var $cccev$s2$requirement$client = $cccev$s2$requirement.client || ($cccev$s2$requirement.client = {});
    $cccev$s2$requirement$client.requirementClient = requirementClient;
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_dsl_model.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_event_sourcing_dsl.$jsExportAll$(_);
  kotlin_city_smartb_cccev_request_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_evidence_f2_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_unit_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_unit_f2_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_concept_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_concept_f2_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_evidence_type_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_evidence_type_f2_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_requirement_domain.$jsExportAll$(_);
  kotlin_city_smartb_cccev_requirement_f2_domain.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_client_core.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_client_ktor_http.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_client_ktor_rsocket.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_client_ktor.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-requirement-f2-client.js.map
