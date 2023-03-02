(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './cccev-dsl-model.js', './f2-f2-dsl-cqrs.js', './f2-f2-dsl-function.js', './ssm-ssm-chaincode-dsl.js', './s2-s2-automate-dsl.js', './s2-s2-event-sourcing-dsl.js', './cccev-request-domain.js', './cccev-evidence-f2-domain.js', './cccev-unit-domain.js', './cccev-unit-f2-domain.js', './cccev-concept-domain.js', './cccev-concept-f2-domain.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./cccev-dsl-model.js'), require('./f2-f2-dsl-cqrs.js'), require('./f2-f2-dsl-function.js'), require('./ssm-ssm-chaincode-dsl.js'), require('./s2-s2-automate-dsl.js'), require('./s2-s2-event-sourcing-dsl.js'), require('./cccev-request-domain.js'), require('./cccev-evidence-f2-domain.js'), require('./cccev-unit-domain.js'), require('./cccev-unit-f2-domain.js'), require('./cccev-concept-domain.js'), require('./cccev-concept-f2-domain.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-dsl-model'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-dsl-model' was not found. Please, check whether 'cccev-dsl-model' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-cqrs'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'f2-f2-dsl-cqrs' was not found. Please, check whether 'f2-f2-dsl-cqrs' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-function'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'f2-f2-dsl-function' was not found. Please, check whether 'f2-f2-dsl-function' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['ssm-ssm-chaincode-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'ssm-ssm-chaincode-dsl' was not found. Please, check whether 'ssm-ssm-chaincode-dsl' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['s2-s2-automate-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 's2-s2-automate-dsl' was not found. Please, check whether 's2-s2-automate-dsl' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['s2-s2-event-sourcing-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 's2-s2-event-sourcing-dsl' was not found. Please, check whether 's2-s2-event-sourcing-dsl' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-request-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-request-domain' was not found. Please, check whether 'cccev-request-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-evidence-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-evidence-f2-domain' was not found. Please, check whether 'cccev-evidence-f2-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-unit-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-unit-domain' was not found. Please, check whether 'cccev-unit-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-unit-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-unit-f2-domain' was not found. Please, check whether 'cccev-unit-f2-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-concept-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-concept-domain' was not found. Please, check whether 'cccev-concept-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    if (typeof this['cccev-concept-f2-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-request-f2-domain'. Its dependency 'cccev-concept-f2-domain' was not found. Please, check whether 'cccev-concept-f2-domain' is loaded prior to 'cccev-request-f2-domain'.");
    }
    root['cccev-request-f2-domain'] = factory(typeof this['cccev-request-f2-domain'] === 'undefined' ? {} : this['cccev-request-f2-domain'], this['kotlin-kotlin-stdlib-js-ir'], this['cccev-dsl-model'], this['f2-f2-dsl-cqrs'], this['f2-f2-dsl-function'], this['ssm-ssm-chaincode-dsl'], this['s2-s2-automate-dsl'], this['s2-s2-event-sourcing-dsl'], this['cccev-request-domain'], this['cccev-evidence-f2-domain'], this['cccev-unit-domain'], this['cccev-unit-f2-domain'], this['cccev-concept-domain'], this['cccev-concept-f2-domain']);
  }
}(this, function (_, kotlin_kotlin, kotlin_city_smartb_cccev_dsl_model, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_s2_s2_event_sourcing_dsl, kotlin_city_smartb_cccev_request_domain, kotlin_city_smartb_cccev_evidence_f2_domain, kotlin_city_smartb_cccev_unit_domain, kotlin_city_smartb_cccev_unit_f2_domain, kotlin_city_smartb_cccev_concept_domain, kotlin_city_smartb_cccev_concept_f2_domain) {
  'use strict';
  //region block: imports
  var interfaceMeta = kotlin_kotlin.$_$.x1;
  var setMetadataFor = kotlin_kotlin.$_$.b2;
  //endregion
  //region block: pre-declaration
  setMetadataFor(GetRequestScoreQueryDTO, 'GetRequestScoreQueryDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(GetRequestScoreQueryResultDTO, 'GetRequestScoreQueryResultDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  //endregion
  function GetRequestScoreQueryDTO() {
  }
  function GetRequestScoreQueryResultDTO() {
  }
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$request = $cccev$f2.request || ($cccev$f2.request = {});
    var $cccev$f2$request$domain = $cccev$f2$request.domain || ($cccev$f2$request.domain = {});
    var $cccev$f2$request$domain$features = $cccev$f2$request$domain.features || ($cccev$f2$request$domain.features = {});
    var $cccev$f2$request$domain$features$query = $cccev$f2$request$domain$features.query || ($cccev$f2$request$domain$features.query = {});
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
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-request-f2-domain.js.map
