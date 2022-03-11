(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin_city_smartb_cccev_cccev_dsl_core.js', './kotlin_city_smartb_f2_f2_dsl_cqrs.js', './kotlin_city_smartb_f2_f2_dsl_function.js', './kotlin_city_smartb_ssm_ssm_chaincode_dsl.js', './kotlin_city_smartb_s2_s2_automate_dsl.js', './kotlin_city_smartb_cccev_request_domain.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin_city_smartb_cccev_cccev_dsl_core.js'), require('./kotlin_city_smartb_f2_f2_dsl_cqrs.js'), require('./kotlin_city_smartb_f2_f2_dsl_function.js'), require('./kotlin_city_smartb_ssm_ssm_chaincode_dsl.js'), require('./kotlin_city_smartb_s2_s2_automate_dsl.js'), require('./kotlin_city_smartb_cccev_request_domain.js'));
  else {
    if (typeof kotlin_city_smartb_cccev_cccev_dsl_core === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_cccev_cccev_dsl_core' was not found. Please, check whether 'kotlin_city_smartb_cccev_cccev_dsl_core' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_cqrs === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_cqrs' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_cqrs' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_function === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_function' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_function' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    if (typeof kotlin_city_smartb_ssm_ssm_chaincode_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' was not found. Please, check whether 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    if (typeof kotlin_city_smartb_s2_s2_automate_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_s2_s2_automate_dsl' was not found. Please, check whether 'kotlin_city_smartb_s2_s2_automate_dsl' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    if (typeof kotlin_city_smartb_cccev_request_domain === 'undefined') {
      throw new Error("Error loading module 'cccev-cccev-dsl-dto'. Its dependency 'kotlin_city_smartb_cccev_request_domain' was not found. Please, check whether 'kotlin_city_smartb_cccev_request_domain' is loaded prior to 'cccev-cccev-dsl-dto'.");
    }
    root['cccev-cccev-dsl-dto'] = factory(typeof this['cccev-cccev-dsl-dto'] === 'undefined' ? {} : this['cccev-cccev-dsl-dto'], kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_request_domain);
  }
}(this, function (_, kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_request_domain) {
  //region block: imports
  var EvidenceType = kotlin_city_smartb_cccev_cccev_dsl_core.$crossModule$.EvidenceType;
  var EvidenceTypeList = kotlin_city_smartb_cccev_cccev_dsl_core.$crossModule$.EvidenceTypeList;
  var InformationConcept = kotlin_city_smartb_cccev_cccev_dsl_core.$crossModule$.InformationConcept;
  //endregion
  'use strict';
  //region block: pre-declaration
  //endregion
  function EvidenceTypeDTO() {
  }
  EvidenceTypeDTO.$metadata$ = {
    simpleName: 'EvidenceTypeDTO',
    kind: 'interface',
    interfaces: [EvidenceType]
  };
  function EvidenceTypeListDTO() {
  }
  EvidenceTypeListDTO.$metadata$ = {
    simpleName: 'EvidenceTypeListDTO',
    kind: 'interface',
    interfaces: [EvidenceTypeList]
  };
  function InformationConceptDTO() {
  }
  InformationConceptDTO.$metadata$ = {
    simpleName: 'InformationConceptDTO',
    kind: 'interface',
    interfaces: [InformationConcept]
  };
  function GetEvidenceTypeListsQueryDTO() {
  }
  GetEvidenceTypeListsQueryDTO.$metadata$ = {
    simpleName: 'GetEvidenceTypeListsQueryDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetEvidenceTypeListsQueryResultDTO() {
  }
  GetEvidenceTypeListsQueryResultDTO.$metadata$ = {
    simpleName: 'GetEvidenceTypeListsQueryResultDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetInformationConceptsQueryDTO() {
  }
  GetInformationConceptsQueryDTO.$metadata$ = {
    simpleName: 'GetInformationConceptsQueryDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetInformationConceptsQueryResultDTO() {
  }
  GetInformationConceptsQueryResultDTO.$metadata$ = {
    simpleName: 'GetInformationConceptsQueryResultDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetRequestScoreQueryDTO() {
  }
  GetRequestScoreQueryDTO.$metadata$ = {
    simpleName: 'GetRequestScoreQueryDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetRequestScoreQueryResultDTO() {
  }
  GetRequestScoreQueryResultDTO.$metadata$ = {
    simpleName: 'GetRequestScoreQueryResultDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetRequirementQueryDTO() {
  }
  GetRequirementQueryDTO.$metadata$ = {
    simpleName: 'GetRequirementQueryDTO',
    kind: 'interface',
    interfaces: []
  };
  function GetRequirementQueryResultDTO() {
  }
  GetRequirementQueryResultDTO.$metadata$ = {
    simpleName: 'GetRequirementQueryResultDTO',
    kind: 'interface',
    interfaces: []
  };
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$model = $cccev$dsl$dto.model || ($cccev$dsl$dto.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$model = $cccev$dsl$dto.model || ($cccev$dsl$dto.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$model = $cccev$dsl$dto.model || ($cccev$dsl$dto.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$query = $cccev$dsl$dto.query || ($cccev$dsl$dto.query = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$query = $cccev$dsl$dto.query || ($cccev$dsl$dto.query = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$query = $cccev$dsl$dto.query || ($cccev$dsl$dto.query = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$dto = $cccev$dsl.dto || ($cccev$dsl.dto = {});
    var $cccev$dsl$dto$query = $cccev$dsl$dto.query || ($cccev$dsl$dto.query = {});
  }
  $jsExportAll$(_);
  kotlin_city_smartb_cccev_cccev_dsl_core.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_cccev_request_domain.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-cccev-dsl-dto.js.map