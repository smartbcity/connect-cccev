plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.jpa")
	kotlin("plugin.spring")
}

dependencies {
    Dependencies.Jvm.s2Mongo(::implementation)
}
