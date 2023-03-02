(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './cccev-unit-domain.js', './cccev-dsl-model.js', './f2-f2-dsl-cqrs.js', './f2-f2-dsl-function.js', './ssm-ssm-chaincode-dsl.js', './s2-s2-automate-dsl.js', './s2-s2-event-sourcing-dsl.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./cccev-unit-domain.js'), require('./cccev-dsl-model.js'), require('./f2-f2-dsl-cqrs.js'), require('./f2-f2-dsl-function.js'), require('./ssm-ssm-chaincode-dsl.js'), require('./s2-s2-automate-dsl.js'), require('./s2-s2-event-sourcing-dsl.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['cccev-unit-domain'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'cccev-unit-domain' was not found. Please, check whether 'cccev-unit-domain' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['cccev-dsl-model'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'cccev-dsl-model' was not found. Please, check whether 'cccev-dsl-model' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-cqrs'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'f2-f2-dsl-cqrs' was not found. Please, check whether 'f2-f2-dsl-cqrs' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['f2-f2-dsl-function'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'f2-f2-dsl-function' was not found. Please, check whether 'f2-f2-dsl-function' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['ssm-ssm-chaincode-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 'ssm-ssm-chaincode-dsl' was not found. Please, check whether 'ssm-ssm-chaincode-dsl' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['s2-s2-automate-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 's2-s2-automate-dsl' was not found. Please, check whether 's2-s2-automate-dsl' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    if (typeof this['s2-s2-event-sourcing-dsl'] === 'undefined') {
      throw new Error("Error loading module 'cccev-unit-f2-domain'. Its dependency 's2-s2-event-sourcing-dsl' was not found. Please, check whether 's2-s2-event-sourcing-dsl' is loaded prior to 'cccev-unit-f2-domain'.");
    }
    root['cccev-unit-f2-domain'] = factory(typeof this['cccev-unit-f2-domain'] === 'undefined' ? {} : this['cccev-unit-f2-domain'], this['kotlin-kotlin-stdlib-js-ir'], this['cccev-unit-domain'], this['cccev-dsl-model'], this['f2-f2-dsl-cqrs'], this['f2-f2-dsl-function'], this['ssm-ssm-chaincode-dsl'], this['s2-s2-automate-dsl'], this['s2-s2-event-sourcing-dsl']);
  }
}(this, function (_, kotlin_kotlin, kotlin_city_smartb_cccev_unit_domain, kotlin_city_smartb_cccev_dsl_model, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_s2_s2_event_sourcing_dsl) {
  'use strict';
  //region block: imports
  var interfaceMeta = kotlin_kotlin.$_$.x1;
  var setMetadataFor = kotlin_kotlin.$_$.b2;
  var DataUnitCreatedEventDTO = kotlin_city_smartb_cccev_unit_domain.$_$.a;
  var DataUnitType_BOOLEAN_getInstance = kotlin_city_smartb_cccev_unit_domain.$_$.b;
  var DataUnitType_DATE_getInstance = kotlin_city_smartb_cccev_unit_domain.$_$.c;
  var DataUnitType_NUMBER_getInstance = kotlin_city_smartb_cccev_unit_domain.$_$.d;
  var DataUnitType_STRING_getInstance = kotlin_city_smartb_cccev_unit_domain.$_$.e;
  var objectMeta = kotlin_kotlin.$_$.a2;
  //endregion
  //region block: pre-declaration
  setMetadataFor(DataUnitCreateCommandDTO, 'DataUnitCreateCommandDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(DataUnitCreatedEventDTO_0, 'DataUnitCreatedEventDTO', interfaceMeta, undefined, [DataUnitCreatedEventDTO], undefined, undefined, []);
  setMetadataFor(DataUnitDTO, 'DataUnitDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(DataUnitTypeValues, 'DataUnitTypeValues', objectMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(DataUnitGetQueryDTO, 'DataUnitGetQueryDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(DataUnitGetResultDTO, 'DataUnitGetResultDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  //endregion
  function DataUnitCreateCommandDTO() {
  }
  function DataUnitCreatedEventDTO_0() {
  }
  function DataUnitDTO() {
  }
  function DataUnitTypeValues() {
    DataUnitTypeValues_instance = this;
  }
  DataUnitTypeValues.prototype.boolean = function () {
    return DataUnitType_BOOLEAN_getInstance().f3_1;
  };
  DataUnitTypeValues.prototype.date = function () {
    return DataUnitType_DATE_getInstance().f3_1;
  };
  DataUnitTypeValues.prototype.number = function () {
    return DataUnitType_NUMBER_getInstance().f3_1;
  };
  DataUnitTypeValues.prototype.string = function () {
    return DataUnitType_STRING_getInstance().f3_1;
  };
  var DataUnitTypeValues_instance;
  function DataUnitTypeValues_getInstance() {
    if (DataUnitTypeValues_instance == null)
      new DataUnitTypeValues();
    return DataUnitTypeValues_instance;
  }
  function DataUnitGetQueryDTO() {
  }
  function DataUnitGetResultDTO() {
  }
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$unit = $cccev$f2.unit || ($cccev$f2.unit = {});
    var $cccev$f2$unit$domain = $cccev$f2$unit.domain || ($cccev$f2$unit.domain = {});
    var $cccev$f2$unit$domain$command = $cccev$f2$unit$domain.command || ($cccev$f2$unit$domain.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$unit = $cccev$f2.unit || ($cccev$f2.unit = {});
    var $cccev$f2$unit$domain = $cccev$f2$unit.domain || ($cccev$f2$unit.domain = {});
    var $cccev$f2$unit$domain$model = $cccev$f2$unit$domain.model || ($cccev$f2$unit$domain.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$unit = $cccev$f2.unit || ($cccev$f2.unit = {});
    var $cccev$f2$unit$domain = $cccev$f2$unit.domain || ($cccev$f2$unit.domain = {});
    var $cccev$f2$unit$domain$model = $cccev$f2$unit$domain.model || ($cccev$f2$unit$domain.model = {});
    Object.defineProperty($cccev$f2$unit$domain$model, 'DataUnitTypeValues', {
      configurable: true,
      get: DataUnitTypeValues_getInstance
    });
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$f2 = $cccev.f2 || ($cccev.f2 = {});
    var $cccev$f2$unit = $cccev$f2.unit || ($cccev$f2.unit = {});
    var $cccev$f2$unit$domain = $cccev$f2$unit.domain || ($cccev$f2$unit.domain = {});
    var $cccev$f2$unit$domain$query = $cccev$f2$unit$domain.query || ($cccev$f2$unit$domain.query = {});
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_dsl_model.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_event_sourcing_dsl.$jsExportAll$(_);
  kotlin_city_smartb_cccev_unit_domain.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-unit-f2-domain.js.map
