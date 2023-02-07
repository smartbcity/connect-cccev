plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    Dependencies.Jvm.coroutines(::jvmMainApi)
    Dependencies.Jvm.s2Mongo(::jvmMainApi)
}
