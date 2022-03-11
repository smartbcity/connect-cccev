(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin_city_smartb_s2_s2_automate_dsl.js', './kotlin_city_smartb_cccev_cccev_dsl_core.js', './kotlin_city_smartb_f2_f2_dsl_cqrs.js', './kotlin_city_smartb_f2_f2_dsl_function.js', './kotlin_city_smartb_ssm_ssm_chaincode_dsl.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin_city_smartb_s2_s2_automate_dsl.js'), require('./kotlin_city_smartb_cccev_cccev_dsl_core.js'), require('./kotlin_city_smartb_f2_f2_dsl_cqrs.js'), require('./kotlin_city_smartb_f2_f2_dsl_function.js'), require('./kotlin_city_smartb_ssm_ssm_chaincode_dsl.js'));
  else {
    if (typeof kotlin_city_smartb_s2_s2_automate_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-request-domain'. Its dependency 'kotlin_city_smartb_s2_s2_automate_dsl' was not found. Please, check whether 'kotlin_city_smartb_s2_s2_automate_dsl' is loaded prior to 'cccev-request-domain'.");
    }
    if (typeof kotlin_city_smartb_cccev_cccev_dsl_core === 'undefined') {
      throw new Error("Error loading module 'cccev-request-domain'. Its dependency 'kotlin_city_smartb_cccev_cccev_dsl_core' was not found. Please, check whether 'kotlin_city_smartb_cccev_cccev_dsl_core' is loaded prior to 'cccev-request-domain'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_cqrs === 'undefined') {
      throw new Error("Error loading module 'cccev-request-domain'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_cqrs' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_cqrs' is loaded prior to 'cccev-request-domain'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_function === 'undefined') {
      throw new Error("Error loading module 'cccev-request-domain'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_function' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_function' is loaded prior to 'cccev-request-domain'.");
    }
    if (typeof kotlin_city_smartb_ssm_ssm_chaincode_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-request-domain'. Its dependency 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' was not found. Please, check whether 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' is loaded prior to 'cccev-request-domain'.");
    }
    root['cccev-request-domain'] = factory(typeof this['cccev-request-domain'] === 'undefined' ? {} : this['cccev-request-domain'], kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl);
  }
}(this, function (_, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl) {
  //region block: imports
  var S2Event = kotlin_city_smartb_s2_s2_automate_dsl.$crossModule$.S2Event;
  var S2Command = kotlin_city_smartb_s2_s2_automate_dsl.$crossModule$.S2Command;
  var S2InitCommand = kotlin_city_smartb_s2_s2_automate_dsl.$crossModule$.S2InitCommand;
  //endregion
  'use strict';
  //region block: pre-declaration
  //endregion
  function RequestEvent() {
  }
  RequestEvent.$metadata$ = {
    simpleName: 'RequestEvent',
    kind: 'interface',
    interfaces: [S2Event]
  };
  function RequestCommand() {
  }
  RequestCommand.$metadata$ = {
    simpleName: 'RequestCommand',
    kind: 'interface',
    interfaces: [S2Command]
  };
  function RequestAuditCommandDTO() {
  }
  RequestAuditCommandDTO.$metadata$ = {
    simpleName: 'RequestAuditCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestAuditedEventDTO() {
  }
  RequestAuditedEventDTO.$metadata$ = {
    simpleName: 'RequestAuditedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestEvidenceAddCommandDTO() {
  }
  RequestEvidenceAddCommandDTO.$metadata$ = {
    simpleName: 'RequestEvidenceAddCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestEvidenceAddedEventDTO() {
  }
  RequestEvidenceAddedEventDTO.$metadata$ = {
    simpleName: 'RequestEvidenceAddedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestEvidenceRemoveCommandDTO() {
  }
  RequestEvidenceRemoveCommandDTO.$metadata$ = {
    simpleName: 'RequestEvidenceRemoveCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestEvidenceRemovedEventDTO() {
  }
  RequestEvidenceRemovedEventDTO.$metadata$ = {
    simpleName: 'RequestEvidenceRemovedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestInitCommandDTO() {
  }
  RequestInitCommandDTO.$metadata$ = {
    simpleName: 'RequestInitCommandDTO',
    kind: 'interface',
    interfaces: [S2InitCommand]
  };
  function RequestInitializedEventDTO() {
  }
  RequestInitializedEventDTO.$metadata$ = {
    simpleName: 'RequestInitializedEventDTO',
    kind: 'interface',
    interfaces: []
  };
  function RequestRefuseCommandDTO() {
  }
  RequestRefuseCommandDTO.$metadata$ = {
    simpleName: 'RequestRefuseCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestRefusedEventDto() {
  }
  RequestRefusedEventDto.$metadata$ = {
    simpleName: 'RequestRefusedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestSendCommandDTO() {
  }
  RequestSendCommandDTO.$metadata$ = {
    simpleName: 'RequestSendCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestSentEventDto() {
  }
  RequestSentEventDto.$metadata$ = {
    simpleName: 'RequestSentEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestSignCommandDTO() {
  }
  RequestSignCommandDTO.$metadata$ = {
    simpleName: 'RequestSignCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestSignedEventDto() {
  }
  RequestSignedEventDto.$metadata$ = {
    simpleName: 'RequestSignedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  function RequestSupportedValueAddCommandDTO() {
  }
  RequestSupportedValueAddCommandDTO.$metadata$ = {
    simpleName: 'RequestSupportedValueAddCommandDTO',
    kind: 'interface',
    interfaces: [RequestCommand]
  };
  function RequestSupportedValueAddedEventDto() {
  }
  RequestSupportedValueAddedEventDto.$metadata$ = {
    simpleName: 'RequestSupportedValueAddedEventDTO',
    kind: 'interface',
    interfaces: [RequestEvent]
  };
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$s2 = $cccev.s2 || ($cccev.s2 = {});
    var $cccev$s2$request = $cccev$s2.request || ($cccev$s2.request = {});
    var $cccev$s2$request$domain = $cccev$s2$request.domain || ($cccev$s2$request.domain = {});
    var $cccev$s2$request$domain$features = $cccev$s2$request$domain.features || ($cccev$s2$request$domain.features = {});
    var $cccev$s2$request$domain$features$command = $cccev$s2$request$domain$features.command || ($cccev$s2$request$domain$features.command = {});
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_cccev_dsl_core.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-request-domain.js.map