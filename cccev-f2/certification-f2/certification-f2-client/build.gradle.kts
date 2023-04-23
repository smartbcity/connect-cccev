plugins {
	id("city.smartb.fixers.gradle.kotlin.mpp")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.serialization")
}

dependencies {
	commonMainApi(project(":cccev-f2:certification-f2:certification-f2-domain"))
	Dependencies.Mpp.f2CLient(::commonMainApi)
	Dependencies.Jvm.jackson(::jvmMainApi)
}
