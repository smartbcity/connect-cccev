plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    Dependencies.Jvm.coroutines(::jvmMainApi)
    Dependencies.Jvm.f2Http(::jvmMainApi)
    Dependencies.Jvm.fs(::jvmMainApi)
    Dependencies.Jvm.s2EventSouringBc(::jvmMainApi)
    Dependencies.Jvm.Spring.tx(::jvmMainApi)
}
