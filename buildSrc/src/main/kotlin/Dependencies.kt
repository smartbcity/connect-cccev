import city.smartb.gradle.dependencies.FixersPluginVersions

object PluginVersions {
//	const val kotlin = FixersPluginVersions.kotlin
	const val kotlin = "1.6.20-M1"
	const val springBoot = FixersPluginVersions.springBoot
	const val fixers = "experimental-SNAPSHOT"
	const val d2 = "0.3.1"
}

object Versions {
	const val s2 = "experimental-x-SNAPSHOT"
	const val f2 = PluginVersions.fixers

	const val coroutines = "1.6.0"

	const val junit = "5.7.0"
	const val junitPlateform = "1.8.1"
	const val assertj = "3.15.0"
	const val cucumber = "7.0.0"
}

object Repo {
	val snapshot: List<String> = listOf(
		// For fixers
		"https://oss.sonatype.org/content/repositories/snapshots",
		//For pdfbox
		"https://jitpack.io"
	)
}

object Dependencies {
	object Jvm {
		val s2Mongo = arrayOf(
			"city.smartb.s2:s2-spring-boot-starter-automate:${Versions.s2}",
			"city.smartb.s2:s2-spring-boot-starter-automate-data:${Versions.s2}",
			"city.smartb.f2:f2-spring-data-mongodb:${Versions.f2}",
			"city.smartb.s2:s2-spring-boot-starter-utils-logger:${Versions.s2}"
		)

		val junit = arrayOf(
			"org.junit.jupiter:junit-jupiter:${Versions.junit}",
			"org.junit.jupiter:junit-jupiter-api:${Versions.junit}",
			"org.junit.platform:junit-platform-suite:${Versions.junitPlateform}",
			"org.assertj:assertj-core:${Versions.assertj}"
		)

		val coroutines = arrayOf(
			"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}",
			"org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${Versions.coroutines}",
			"org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.coroutines}",
			"org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.coroutines}"
		)
	}
}
