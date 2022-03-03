plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
}

dependencies {
    Dependencies.Jvm.coroutines(::api)
    Dependencies.Jvm.s2Mongo(::api)
}
