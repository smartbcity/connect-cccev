plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    Dependencies.Jvm.coroutines(::api)
    Dependencies.Jvm.s2Mongo(::api)
}
