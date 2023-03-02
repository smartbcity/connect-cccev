(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './kotlinx-serialization-kotlinx-serialization-core-js-ir.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./kotlinx-serialization-kotlinx-serialization-core-js-ir.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-dsl-model'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'cccev-dsl-model'.");
    }
    if (typeof this['kotlinx-serialization-kotlinx-serialization-core-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'cccev-dsl-model'. Its dependency 'kotlinx-serialization-kotlinx-serialization-core-js-ir' was not found. Please, check whether 'kotlinx-serialization-kotlinx-serialization-core-js-ir' is loaded prior to 'cccev-dsl-model'.");
    }
    root['cccev-dsl-model'] = factory(typeof this['cccev-dsl-model'] === 'undefined' ? {} : this['cccev-dsl-model'], this['kotlin-kotlin-stdlib-js-ir'], this['kotlinx-serialization-kotlinx-serialization-core-js-ir']);
  }
}(this, function (_, kotlin_kotlin, kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core) {
  'use strict';
  //region block: imports
  var interfaceMeta = kotlin_kotlin.$_$.a1;
  var setMetadataFor = kotlin_kotlin.$_$.d1;
  var classMeta = kotlin_kotlin.$_$.u;
  var objectMeta = kotlin_kotlin.$_$.c1;
  var PluginGeneratedSerialDescriptor = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.g;
  var StringSerializer_getInstance = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.c;
  var get_nullable = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.d;
  var IntSerializer_getInstance = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.b;
  var Unit_getInstance = kotlin_kotlin.$_$.l;
  var UnknownFieldException_init_$Create$ = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.a;
  var THROW_CCE = kotlin_kotlin.$_$.h1;
  var typeParametersSerializers = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.e;
  var GeneratedSerializer = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.f;
  var throwMissingFieldException = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.h;
  //endregion
  //region block: pre-declaration
  setMetadataFor(Code, 'Code', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(EvidenceDTO, 'EvidenceDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(EvidenceTypeList, 'EvidenceTypeList', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(EvidenceType, 'EvidenceType', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(CoreLocationLocation, 'CoreLocationLocation', classMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(Companion, 'Companion', objectMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor($serializer, '$serializer', objectMeta, undefined, [GeneratedSerializer], undefined, undefined, []);
  setMetadataFor(PeriodOfTime, 'PeriodOfTime', classMeta, undefined, undefined, undefined, {0: $serializer_getInstance}, []);
  setMetadataFor(InformationConcept, 'InformationConcept', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(SupportedValueDTO, 'SupportedValueDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  setMetadataFor(CUnitDTO, 'CUnitDTO', interfaceMeta, undefined, undefined, undefined, undefined, []);
  //endregion
  function Code() {
  }
  function EvidenceDTO() {
  }
  function EvidenceTypeList() {
  }
  function EvidenceType() {
  }
  function CoreLocationLocation() {
  }
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
  function Companion() {
    Companion_instance = this;
  }
  Companion.prototype.serializer = function () {
    return $serializer_getInstance();
  };
  var Companion_instance;
  function Companion_getInstance() {
    if (Companion_instance == null)
      new Companion();
    return Companion_instance;
  }
  function $serializer() {
    $serializer_instance = this;
    var tmp0_serialDesc = new PluginGeneratedSerialDescriptor('cccev.dsl.model.PeriodOfTime', this, 3);
    tmp0_serialDesc.y7('duration', true);
    tmp0_serialDesc.y7('endTime', true);
    tmp0_serialDesc.y7('startTime', true);
    this.q8_1 = tmp0_serialDesc;
  }
  $serializer.prototype.m6 = function () {
    return this.q8_1;
  };
  $serializer.prototype.v7 = function () {
    var tmp$ret$2;
    // Inline function 'kotlin.arrayOf' call
    var tmp0_arrayOf = [get_nullable(StringSerializer_getInstance()), get_nullable(IntSerializer_getInstance()), get_nullable(IntSerializer_getInstance())];
    var tmp$ret$1;
    // Inline function 'kotlin.js.unsafeCast' call
    var tmp$ret$0;
    // Inline function 'kotlin.js.asDynamic' call
    tmp$ret$0 = tmp0_arrayOf;
    tmp$ret$1 = tmp$ret$0;
    tmp$ret$2 = tmp$ret$1;
    return tmp$ret$2;
  };
  $serializer.prototype.r8 = function (decoder) {
    var tmp0_desc = this.q8_1;
    var tmp1_flag = true;
    var tmp2_index = 0;
    var tmp3_bitMask0 = 0;
    var tmp4_local0 = null;
    var tmp5_local1 = null;
    var tmp6_local2 = null;
    var tmp7_input = decoder.s8(tmp0_desc);
    if (tmp7_input.y6()) {
      tmp4_local0 = tmp7_input.a7(tmp0_desc, 0, StringSerializer_getInstance(), tmp4_local0);
      tmp3_bitMask0 = tmp3_bitMask0 | 1;
      tmp5_local1 = tmp7_input.a7(tmp0_desc, 1, IntSerializer_getInstance(), tmp5_local1);
      tmp3_bitMask0 = tmp3_bitMask0 | 2;
      tmp6_local2 = tmp7_input.a7(tmp0_desc, 2, IntSerializer_getInstance(), tmp6_local2);
      tmp3_bitMask0 = tmp3_bitMask0 | 4;
    } else
      while (tmp1_flag) {
        tmp2_index = tmp7_input.z6(tmp0_desc);
        switch (tmp2_index) {
          case -1:
            tmp1_flag = false;
            break;
          case 0:
            tmp4_local0 = tmp7_input.a7(tmp0_desc, 0, StringSerializer_getInstance(), tmp4_local0);
            tmp3_bitMask0 = tmp3_bitMask0 | 1;
            break;
          case 1:
            tmp5_local1 = tmp7_input.a7(tmp0_desc, 1, IntSerializer_getInstance(), tmp5_local1);
            tmp3_bitMask0 = tmp3_bitMask0 | 2;
            break;
          case 2:
            tmp6_local2 = tmp7_input.a7(tmp0_desc, 2, IntSerializer_getInstance(), tmp6_local2);
            tmp3_bitMask0 = tmp3_bitMask0 | 4;
            break;
          default:
            throw UnknownFieldException_init_$Create$(tmp2_index);
        }
      }
    tmp7_input.x6(tmp0_desc);
    return PeriodOfTime_init_$Create$_0(tmp3_bitMask0, tmp4_local0, tmp5_local1, tmp6_local2, null);
  };
  $serializer.prototype.t8 = function (encoder, value) {
    var tmp0_desc = this.q8_1;
    var tmp1_output = encoder.s8(tmp0_desc);
    if (tmp1_output.b7(tmp0_desc, 0) ? true : !(value.duration == null)) {
      tmp1_output.c7(tmp0_desc, 0, StringSerializer_getInstance(), value.duration);
    }
    if (tmp1_output.b7(tmp0_desc, 1) ? true : !(value.endTime == null)) {
      tmp1_output.c7(tmp0_desc, 1, IntSerializer_getInstance(), value.endTime);
    }
    if (tmp1_output.b7(tmp0_desc, 2) ? true : !(value.startTime == null)) {
      tmp1_output.c7(tmp0_desc, 2, IntSerializer_getInstance(), value.startTime);
    }
    tmp1_output.x6(tmp0_desc);
  };
  $serializer.prototype.u8 = function (encoder, value) {
    return this.t8(encoder, value instanceof PeriodOfTime ? value : THROW_CCE());
  };
  var $serializer_instance;
  function $serializer_getInstance() {
    if ($serializer_instance == null)
      new $serializer();
    return $serializer_instance;
  }
  function PeriodOfTime_init_$Init$_0(seen1, duration, endTime, startTime, serializationConstructorMarker, $this) {
    if (!(0 === (0 & seen1))) {
      throwMissingFieldException(seen1, 0, $serializer_getInstance().q8_1);
    }
    if (0 === (seen1 & 1))
      $this.duration = null;
    else
      $this.duration = duration;
    if (0 === (seen1 & 2))
      $this.endTime = null;
    else
      $this.endTime = endTime;
    if (0 === (seen1 & 4))
      $this.startTime = null;
    else
      $this.startTime = startTime;
    return $this;
  }
  function PeriodOfTime_init_$Create$_0(seen1, duration, endTime, startTime, serializationConstructorMarker) {
    return PeriodOfTime_init_$Init$_0(seen1, duration, endTime, startTime, serializationConstructorMarker, Object.create(PeriodOfTime.prototype));
  }
  function PeriodOfTime(duration, endTime, startTime) {
    Companion_getInstance();
    var duration_0 = duration === void 1 ? null : duration;
    var endTime_0 = endTime === void 1 ? null : endTime;
    var startTime_0 = startTime === void 1 ? null : startTime;
    this.duration = duration_0;
    this.endTime = endTime_0;
    this.startTime = startTime_0;
  }
  PeriodOfTime.prototype.v8 = function () {
    return this.duration;
  };
  PeriodOfTime.prototype.w8 = function () {
    return this.endTime;
  };
  PeriodOfTime.prototype.x8 = function () {
    return this.startTime;
  };
  function InformationConcept() {
  }
  function SupportedValueDTO() {
  }
  function CUnitDTO() {
  }
  //region block: post-declaration
  $serializer.prototype.w7 = typeParametersSerializers;
  //endregion
  //region block: exports
  function $jsExportAll$(_) {
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
    $cccev$dsl$model.CoreLocationLocation = CoreLocationLocation;
    $cccev$dsl$model.PeriodOfTime = PeriodOfTime;
    $cccev$dsl$model.PeriodOfTime.PeriodOfTime_init_$Create$ = PeriodOfTime_init_$Create$_0;
    Object.defineProperty($cccev$dsl$model.PeriodOfTime, 'Companion', {
      configurable: true,
      get: Companion_getInstance
    });
    Object.defineProperty($cccev$dsl$model.PeriodOfTime, '$serializer', {
      configurable: true,
      get: $serializer_getInstance
    });
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
    var $cccev = _.cccev || (_.cccev = {});
    var $cccev$dsl = $cccev.dsl || ($cccev.dsl = {});
    var $cccev$dsl$model = $cccev$dsl.model || ($cccev$dsl.model = {});
  }
  $jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=cccev-dsl-model.js.map
