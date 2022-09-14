plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":api-commons"))
	implementation(project(":cccev-s2:request:request-app"))
	implementation(project(":cccev-f2:concept-api:concept-api-domain"))

	runtimeOnly("org.jetbrains.kotlin:kotlin-main-kts:${PluginVersions.kotlin}")
	runtimeOnly("org.jetbrains.kotlin:kotlin-scripting-jsr223:${PluginVersions.kotlin}")

	testImplementation(project(":cccev-test"))
	testImplementation(project(":cccev-s2:requirement:requirement-app"))

	testImplementation("org.awaitility:awaitility:3.0.0")
}
