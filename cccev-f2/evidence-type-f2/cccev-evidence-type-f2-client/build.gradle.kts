plugins {
	id("city.smartb.fixers.gradle.kotlin.mpp")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.serialization")
}

dependencies {
	commonMainApi(project(Modules.cccev.f2.evidenceType.domain))
	Dependencies.Mpp.f2Client(::commonMainApi)
}
