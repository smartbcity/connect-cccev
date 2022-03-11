(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin_city_smartb_cccev_cccev_dsl_core.js', './kotlin_city_smartb_f2_f2_dsl_cqrs.js', './kotlin_city_smartb_f2_f2_dsl_function.js', './kotlin_city_smartb_ssm_ssm_chaincode_dsl.js', './kotlin_city_smartb_s2_s2_automate_dsl.js', './kotlin_city_smartb_cccev_request_domain.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin_city_smartb_cccev_cccev_dsl_core.js'), require('./kotlin_city_smartb_f2_f2_dsl_cqrs.js'), require('./kotlin_city_smartb_f2_f2_dsl_function.js'), require('./kotlin_city_smartb_ssm_ssm_chaincode_dsl.js'), require('./kotlin_city_smartb_s2_s2_automate_dsl.js'), require('./kotlin_city_smartb_cccev_request_domain.js'));
  else {
    if (typeof kotlin_city_smartb_cccev_cccev_dsl_core === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_cccev_cccev_dsl_core' was not found. Please, check whether 'kotlin_city_smartb_cccev_cccev_dsl_core' is loaded prior to 'cccev-request-api-domain'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_cqrs === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_cqrs' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_cqrs' is loaded prior to 'cccev-request-api-domain'.");
    }
    if (typeof kotlin_city_smartb_f2_f2_dsl_function === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_f2_f2_dsl_function' was not found. Please, check whether 'kotlin_city_smartb_f2_f2_dsl_function' is loaded prior to 'cccev-request-api-domain'.");
    }
    if (typeof kotlin_city_smartb_ssm_ssm_chaincode_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' was not found. Please, check whether 'kotlin_city_smartb_ssm_ssm_chaincode_dsl' is loaded prior to 'cccev-request-api-domain'.");
    }
    if (typeof kotlin_city_smartb_s2_s2_automate_dsl === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_s2_s2_automate_dsl' was not found. Please, check whether 'kotlin_city_smartb_s2_s2_automate_dsl' is loaded prior to 'cccev-request-api-domain'.");
    }
    if (typeof kotlin_city_smartb_cccev_request_domain === 'undefined') {
      throw new Error("Error loading module 'cccev-request-api-domain'. Its dependency 'kotlin_city_smartb_cccev_request_domain' was not found. Please, check whether 'kotlin_city_smartb_cccev_request_domain' is loaded prior to 'cccev-request-api-domain'.");
    }
    root['cccev-request-api-domain'] = factory(typeof this['cccev-request-api-domain'] === 'undefined' ? {} : this['cccev-request-api-domain'], kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_request_domain);
  }
}(this, function (_, kotlin_city_smartb_cccev_cccev_dsl_core, kotlin_city_smartb_f2_f2_dsl_cqrs, kotlin_city_smartb_f2_f2_dsl_function, kotlin_city_smartb_ssm_ssm_chaincode_dsl, kotlin_city_smartb_s2_s2_automate_dsl, kotlin_city_smartb_cccev_request_domain) {
  'use strict';
  //region block: pre-declaration
  //endregion
  //region block: exports
  kotlin_city_smartb_cccev_cccev_dsl_core.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_cqrs.$jsExportAll$(_);
  kotlin_city_smartb_f2_f2_dsl_function.$jsExportAll$(_);
  kotlin_city_smartb_ssm_ssm_chaincode_dsl.$jsExportAll$(_);
  kotlin_city_smartb_s2_s2_automate_dsl.$jsExportAll$(_);
  kotlin_city_smartb_cccev_request_domain.$jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-request-api-domain.js.map