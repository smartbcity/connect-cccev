(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports'], factory);
  else if (typeof exports === 'object')
    factory(module.exports);
  else
    root['cccev-cccev-dsl-core'] = factory(typeof this['cccev-cccev-dsl-core'] === 'undefined' ? {} : this['cccev-cccev-dsl-core']);
}(this, function (_) {
  'use strict';
  //region block: pre-declaration
  //endregion
  function Code() {
  }
  Code.$metadata$ = {
    simpleName: 'Code',
    kind: 'interface',
    interfaces: []
  };
  function EvidenceDTO() {
  }
  EvidenceDTO.$metadata$ = {
    simpleName: 'EvidenceDTO',
    kind: 'interface',
    interfaces: []
  };
  function EvidenceTypeList() {
  }
  EvidenceTypeList.$metadata$ = {
    simpleName: 'EvidenceTypeList',
    kind: 'interface',
    interfaces: []
  };
  function EvidenceType() {
  }
  EvidenceType.$metadata$ = {
    simpleName: 'EvidenceType',
    kind: 'interface',
    interfaces: []
  };
  function CoreLocationLocation() {
  }
  CoreLocationLocation.$metadata$ = {
    simpleName: 'CoreLocationLocation',
    kind: 'class',
    interfaces: []
  };
  function PeriodOfTime_init_$Init$(duration, endTime, startTime, $mask0, $marker, $this) {
    if (!(($mask0 & 1) === 0))
      duration = null;
    if (!(($mask0 & 2) === 0))
      endTime = null;
    if (!(($mask0 & 4) === 0))
      startTime = null;
    PeriodOfTime.call($this, duration, endTime, startTime);
    return $this;
  }
  function PeriodOfTime_init_$Create$(duration, endTime, startTime, $mask0, $marker) {
    return PeriodOfTime_init_$Init$(duration, endTime, startTime, $mask0, $marker, Object.create(PeriodOfTime.prototype));
  }
  function PeriodOfTime(duration, endTime, startTime) {
    var duration_0 = duration === void 1 ? null : duration;
    var endTime_0 = endTime === void 1 ? null : endTime;
    var startTime_0 = startTime === void 1 ? null : startTime;
  }
  PeriodOfTime.$metadata$ = {
    simpleName: 'PeriodOfTime',
    kind: 'class',
    interfaces: []
  };
  function InformationConcept() {
  }
  InformationConcept.$metadata$ = {
    simpleName: 'InformationConcept',
    kind: 'interface',
    interfaces: []
  };
  function SupportedValueDTO() {
  }
  SupportedValueDTO.$metadata$ = {
    simpleName: 'SupportedValueDTO',
    kind: 'interface',
    interfaces: []
  };
  function CUnitDTO() {
  }
  CUnitDTO.$metadata$ = {
    simpleName: 'CUnitDTO',
    kind: 'interface',
    interfaces: []
  };
  //region block: exports
  function $jsExportAll$(_) {
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
    $ccev$dsl$core.CoreLocationLocation = CoreLocationLocation;
    $ccev$dsl$core.PeriodOfTime = PeriodOfTime;
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
    var $ccev = _.ccev || (_.ccev = {});
    var $ccev$dsl = $ccev.dsl || ($ccev.dsl = {});
    var $ccev$dsl$core = $ccev$dsl.core || ($ccev$dsl.core = {});
  }
  $jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-cccev-dsl-core.js.map