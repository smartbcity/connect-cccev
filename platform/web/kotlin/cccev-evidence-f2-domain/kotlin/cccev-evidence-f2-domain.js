(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './cccev-dsl-model.js', './f2-f2-dsl-cqrs.js', './f2-f2-dsl-function.js', './ssm-ssm-chaincode-dsl.js', './s2-s2-automate-dsl.js', './s2-s2-event-sourcing-dsl.js', './cccev-request-domain.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./cccev-dsl-model.js'), require('./f2-f2-dsl-cqrs.js'), require('./f2-f2-dsl-function.js'), require('./ssm-ssm-chaincode-dsl.js'), require('./s2-s2-automate-dsl.js'), require('./s2-s2-event-sourcing-dsl.js'), require('./cccev-request-domain.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['cccev-dsl-model'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'cccev-dsl-model' was not found. Please, check whether 'cccev-dsl-model' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-cqrs'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'f2-f2-dsl-cqrs' was not found. Please, check whether 'f2-f2-dsl-cqrs' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-function'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'f2-f2-dsl-function' was not found. Please, check whether 'f2-f2-dsl-function' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['ssm-ssm-chaincode-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'ssm-ssm-chaincode-dsl' was not found. Please, check whether 'ssm-ssm-chaincode-dsl' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['s2-s2-automate-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 's2-s2-automate-dsl' was not found. Please, check whether 's2-s2-automate-dsl' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['s2-s2-event-sourcing-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 's2-s2-event-sourcing-dsl' was not found. Please, check whether 's2-s2-event-sourcing-dsl' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    if (typeof this['cccev-request-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-f2-domain'. Its dependency 'cccev-request-domain' was not found. Please, check whether 'cccev-request-domain' is loaded prior to 'cccev-evidence-f2-domain'.");
    }
    root['cccev-evidence-f2-domain'] = factory(typeof this['cccev-evidence-f2-domain'] === 'undefined' ? {} : this['cccev-evidence-f2-domain'], this['kotlin-kotlin-stdlib-js-ir'], this['cccev-dsl-model'], this['f2-f2-dsl-cqrs'], this['f2-f2-dsl-function'], this['ssm-ssm-chaincode-dsl'], this['s2-s2-automate-dsl'], this['s2-s2-event-sourcing-dsl'], this['cccev-request-domain']);
  }
}(this, function (_, kotlin_kotlin, kotlin_city_smartb_cccev_dsl_model, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_s2_s2_event_sourcing_dsl, kotlin_city_smartb_cccev_request_domain) {
  'use strict';
  //region block: imports
  var interfaceMeta = kotlin_kotlin.$_$.x1;
  var setMetadataFor = kotlin_kotlin.$_$.b2;
  var EvidenceType = kotlin_city_smartb_cccev_dsl_model.$_$.b;
  var EvidenceTypeList = kotlin_city_smartb_cccev_dsl_model.$_$.a;
  //endregion
  //region block: pre-declaration
  setMetadataFor(GetEvidenceTypeListsQueryDTO, 'GetEvidenceTypeListsQueryDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(GetEvidenceTypeListsQueryResultDTO, 'GetEvidenceTypeListsQueryResultDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(EvidenceTypeDTO, 'EvidenceTypeDTO', interfaceMeta, undefined, [EvidenceType], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListChoicesDTO, 'EvidenceTypeListChoicesDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(EvidenceTypeListDTO, 'EvidenceTypeListDTO', interfaceMeta, undefined, [EvidenceTypeList], undefined, undefined, []);
  //endregion
  function GetEvidenceTypeListsQueryDTO() {
  }
  function GetEvidenceTypeListsQueryResultDTO() {
  }
  function EvidenceTypeDTO() {
  }
  function EvidenceTypeListChoicesDTO() {
  }
  function EvidenceTypeListDTO() {
  }
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$evidence = $cccev$f2.evidence || ($cccev$f2.evidence = {});
    var $cccev$f2$evidence$domain = $cccev$f2$evidence.domain || ($cccev$f2$evidence.domain = {});
    var $cccev$f2$evidence$domain$features = $cccev$f2$evidence$domain.features || ($cccev$f2$evidence$domain.features = {});
    var $cccev$f2$evidence$domain$features$query = $cccev$f2$evidence$domain$features.query || ($cccev$f2$evidence$domain$features.query = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$evidence = $cccev$f2.evidence || ($cccev$f2.evidence = {});
    var $cccev$f2$evidence$domain = $cccev$f2$evidence.domain || ($cccev$f2$evidence.domain = {});
    var $cccev$f2$evidence$domain$model = $cccev$f2$evidence$domain.model || ($cccev$f2$evidence$domain.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$evidence = $cccev$f2.evidence || ($cccev$f2.evidence = {});
    var $cccev$f2$evidence$domain = $cccev$f2$evidence.domain || ($cccev$f2$evidence.domain = {});
    var $cccev$f2$evidence$domain$model = $cccev$f2$evidence$domain.model || ($cccev$f2$evidence$domain.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$evidence = $cccev$f2.evidence || ($cccev$f2.evidence = {});
    var $cccev$f2$evidence$domain = $cccev$f2$evidence.domain || ($cccev$f2$evidence.domain = {});
    var $cccev$f2$evidence$domain$model = $cccev$f2$evidence$domain.model || ($cccev$f2$evidence$domain.model = {});
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_dsl_model.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_event_sourcing_dsl.$jsExportAll$(_);
  kotlin_city_smartb_cccev_request_domain.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-evidence-f2-domain.js.map
