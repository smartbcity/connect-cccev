plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":cccev-dsl:dsl-model"))

	implementation(project(":api-config"))

	implementation(project(":cccev-f2"))
	implementation(project(":cccev-f2:concept-f2:concept-f2-api"))
	implementation(project(":cccev-f2:evidence-f2:evidence-f2-api"))
	implementation(project(":cccev-f2:evidence-type-f2:evidence-type-f2-api"))
	implementation(project(":cccev-f2:framework-f2:framework-f2-api"))
	implementation(project(":cccev-f2:certification-f2:certification-f2-api"))
	implementation(project(":cccev-f2:requirement-f2:requirement-f2-api"))
	implementation(project(":cccev-f2:unit-f2:unit-f2-api"))

	implementation(project(":cccev-s2:concept:concept-api"))
	implementation(project(":cccev-s2:evidence-type:evidence-type-api"))
	implementation(project(":cccev-s2:framework:framework-api"))
	implementation(project(":cccev-s2:certification:certification-api"))
	implementation(project(":cccev-s2:requirement:requirement-api"))
	implementation(project(":cccev-s2:unit:unit-api"))

	Dependencies.Jvm.s2Bdd(::api)
	Dependencies.Jvm.Test.dataFaker(::implementation)
}
