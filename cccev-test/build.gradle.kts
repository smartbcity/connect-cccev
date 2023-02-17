plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":cccev-core:cccev-core-dsl"))

	implementation(project(":cccev-f2"))
	implementation(project(":cccev-f2:concept-f2:concept-f2-api"))
	implementation(project(":cccev-f2:evidence-f2:evidence-f2-api"))
	implementation(project(":cccev-f2:evidence-type-f2:evidence-type-f2-api"))
	implementation(project(":cccev-f2:request-f2:request-f2-api"))
	implementation(project(":cccev-f2:requirement-f2:requirement-f2-api"))
	implementation(project(":cccev-f2:unit-f2:unit-f2-api"))

	implementation(project(":cccev-s2:concept:concept-api"))
	implementation(project(":cccev-s2:evidence-type:evidence-type-api"))
	implementation(project(":cccev-s2:request:request-api"))
	implementation(project(":cccev-s2:requirement:requirement-api"))
	implementation(project(":cccev-s2:unit:unit-api"))

	api(project(":fixers-bdd"))

	implementation("org.springframework.boot:spring-boot-starter-test:${PluginVersions.springBoot}")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:${PluginVersions.springBoot}")
}
