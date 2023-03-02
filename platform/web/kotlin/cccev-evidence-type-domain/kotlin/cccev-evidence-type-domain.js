(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './s2-s2-automate-dsl.js', './kotlin-kotlin-stdlib-js-ir.js', './f2-f2-dsl-cqrs.js', './cccev-dsl-model.js', './f2-f2-dsl-function.js', './ssm-ssm-chaincode-dsl.js', './s2-s2-event-sourcing-dsl.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./s2-s2-automate-dsl.js'), require('./kotlin-kotlin-stdlib-js-ir.js'), require('./f2-f2-dsl-cqrs.js'), require('./cccev-dsl-model.js'), require('./f2-f2-dsl-function.js'), require('./ssm-ssm-chaincode-dsl.js'), require('./s2-s2-event-sourcing-dsl.js'));
  else {
    if (typeof this['s2-s2-automate-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 's2-s2-automate-dsl' was not found. Please, check whether 's2-s2-automate-dsl' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['f2-f2-dsl-cqrs'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 'f2-f2-dsl-cqrs' was not found. Please, check whether 'f2-f2-dsl-cqrs' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['cccev-dsl-model'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 'cccev-dsl-model' was not found. Please, check whether 'cccev-dsl-model' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['f2-f2-dsl-function'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 'f2-f2-dsl-function' was not found. Please, check whether 'f2-f2-dsl-function' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['ssm-ssm-chaincode-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 'ssm-ssm-chaincode-dsl' was not found. Please, check whether 'ssm-ssm-chaincode-dsl' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    if (typeof this['s2-s2-event-sourcing-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-evidence-type-domain'. Its dependency 's2-s2-event-sourcing-dsl' was not found. Please, check whether 's2-s2-event-sourcing-dsl' is loaded prior to 'cccev-evidence-type-domain'.");
    }
    root['cccev-evidence-type-domain'] = factory(typeof this['cccev-evidence-type-domain'] === 'undefined' ? {} : this['cccev-evidence-type-domain'], this['s2-s2-automate-dsl'], this['kotlin-kotlin-stdlib-js-ir'], this['f2-f2-dsl-cqrs'], this['cccev-dsl-model'], this['f2-f2-dsl-function'], this['ssm-ssm-chaincode-dsl'], this['s2-s2-event-sourcing-dsl']);
  }
}(this, function (_, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_kotlin, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_cccev_dsl_model, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_event_sourcing_dsl) {
  'use strict';
  //region block: imports
  var S2InitCommand = kotlin_city_smartb_s2_s2_automate_dsl.$_$.b;
  var interfaceMeta = kotlin_kotlin.$_$.x1;
  var setMetadataFor = kotlin_kotlin.$_$.b2;
  var S2Command = kotlin_city_smartb_s2_s2_automate_dsl.$_$.a;
  var Event = kotlin_city_smartb_f2_f2_dsl_cqrs.$_$.b;
  var WithId = kotlin_city_smartb_s2_s2_automate_dsl.$_$.c;
  //endregion
  //region block: pre-declaration
  setMetadataFor(EvidenceTypeInitCommand, 'EvidenceTypeInitCommand', interfaceMeta, undefined, [S2InitCommand], undefined, undefined, []);
  setMetadataFor(EvidenceTypeCommand, 'EvidenceTypeCommand', interfaceMeta, undefined, [S2Command], undefined, undefined, []);
  setMetadataFor(EvidenceTypeEvent, 'EvidenceTypeEvent', interfaceMeta, undefined, [Event, WithId], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListInitCommand, 'EvidenceTypeListInitCommand', interfaceMeta, undefined, [S2InitCommand], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListCommand, 'EvidenceTypeListCommand', interfaceMeta, undefined, [S2Command], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListEvent, 'EvidenceTypeListEvent', interfaceMeta, undefined, [Event, WithId], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListCreateCommandDTO, 'EvidenceTypeListCreateCommandDTO', interfaceMeta, undefined, [EvidenceTypeListInitCommand], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListCreatedEventDTO, 'EvidenceTypeListCreatedEventDTO', interfaceMeta, undefined, [EvidenceTypeListEvent], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListUpdateCommandDTO, 'EvidenceTypeListUpdateCommandDTO', interfaceMeta, undefined, [EvidenceTypeListCommand], undefined, undefined, []);
  setMetadataFor(EvidenceTypeListUpdatedEventDTO, 'EvidenceTypeListUpdatedEventDTO', interfaceMeta, undefined, [EvidenceTypeListEvent], undefined, undefined, []);
  setMetadataFor(EvidenceTypeCreateCommandDTO, 'EvidenceTypeCreateCommandDTO', interfaceMeta, undefined, [EvidenceTypeInitCommand], undefined, undefined, []);
  setMetadataFor(EvidenceTypeCreatedEventDTO, 'EvidenceTypeCreatedEventDTO', interfaceMeta, undefined, [EvidenceTypeEvent], undefined, undefined, []);
  //endregion
  function EvidenceTypeInitCommand() {
  }
  function EvidenceTypeCommand() {
  }
  function EvidenceTypeEvent() {
  }
  function EvidenceTypeListInitCommand() {
  }
  function EvidenceTypeListCommand() {
  }
  function EvidenceTypeListEvent() {
  }
  function EvidenceTypeListCreateCommandDTO() {
  }
  function EvidenceTypeListCreatedEventDTO() {
  }
  function EvidenceTypeListUpdateCommandDTO() {
  }
  function EvidenceTypeListUpdatedEventDTO() {
  }
  function EvidenceTypeCreateCommandDTO() {
  }
  function EvidenceTypeCreatedEventDTO() {
  }
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$evidence = $cccev$s2.evidence || ($cccev$s2.evidence = {});
    var $cccev$s2$evidence$domain = $cccev$s2$evidence.domain || ($cccev$s2$evidence.domain = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$evidence = $cccev$s2.evidence || ($cccev$s2.evidence = {});
    var $cccev$s2$evidence$domain = $cccev$s2$evidence.domain || ($cccev$s2$evidence.domain = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$evidence = $cccev$s2.evidence || ($cccev$s2.evidence = {});
    var $cccev$s2$evidence$domain = $cccev$s2$evidence.domain || ($cccev$s2$evidence.domain = {});
    var $cccev$s2$evidence$domain$command = $cccev$s2$evidence$domain.command || ($cccev$s2$evidence$domain.command = {});
    var $cccev$s2$evidence$domain$command$list = $cccev$s2$evidence$domain$command.list || ($cccev$s2$evidence$domain$command.list = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$evidence = $cccev$s2.evidence || ($cccev$s2.evidence = {});
    var $cccev$s2$evidence$domain = $cccev$s2$evidence.domain || ($cccev$s2$evidence.domain = {});
    var $cccev$s2$evidence$domain$command = $cccev$s2$evidence$domain.command || ($cccev$s2$evidence$domain.command = {});
    var $cccev$s2$evidence$domain$command$list = $cccev$s2$evidence$domain$command.list || ($cccev$s2$evidence$domain$command.list = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$evidence = $cccev$s2.evidence || ($cccev$s2.evidence = {});
    var $cccev$s2$evidence$domain = $cccev$s2$evidence.domain || ($cccev$s2$evidence.domain = {});
    var $cccev$s2$evidence$domain$command = $cccev$s2$evidence$domain.command || ($cccev$s2$evidence$domain.command = {});
    var $cccev$s2$evidence$domain$command$type = $cccev$s2$evidence$domain$command.type || ($cccev$s2$evidence$domain$command.type = {});
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_dsl_model.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_event_sourcing_dsl.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-evidence-type-domain.js.map
