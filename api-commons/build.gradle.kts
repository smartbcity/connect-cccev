plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    Dependencies.Jvm.f2(::jvmMainApi)
    Dependencies.Jvm.springTx(::jvmMainApi)
    Dependencies.Jvm.s2EventSouringBc(::jvmMainApi)
    Dependencies.Jvm.coroutines(::jvmMainApi)
}
