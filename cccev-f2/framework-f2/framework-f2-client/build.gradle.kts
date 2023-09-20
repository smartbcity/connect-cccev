plugins {
	id("city.smartb.fixers.gradle.kotlin.mpp")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.serialization")
}

dependencies {
	commonMainApi(project(":cccev-f2:framework-f2:framework-f2-domain"))
	Dependencies.Mpp.f2Client(::commonMainApi)
}
