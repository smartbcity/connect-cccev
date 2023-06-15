import city.smartb.gradle.dependencies.FixersDependencies
import city.smartb.gradle.dependencies.FixersPluginVersions
import city.smartb.gradle.dependencies.FixersVersions
import city.smartb.gradle.dependencies.Scope
import city.smartb.gradle.dependencies.add

object Framework {
	val fixers = FixersPluginVersions.fixers
	val connect = "experimental-SNAPSHOT"
}

object PluginVersions {
	const val kotlin = FixersPluginVersions.kotlin
	const val springBoot = FixersPluginVersions.springBoot
	val fixers = Framework.fixers
	val d2 = Framework.fixers
}

object Versions {
	val fs = "experimental-1961-SNAPSHOT"//Framework.connect
	val springBoot = PluginVersions.springBoot

	const val cucumber = FixersVersions.Test.cucumber
	const val awaitility = "4.1.1"
	const val datafaker = "1.8.1"
}

object Repo {
	val snapshot: List<String> = listOf(
		// For fixers
		"https://oss.sonatype.org/content/repositories/snapshots",
	)
}

object Dependencies {
	object Jvm {

		fun s2Bdd(scope: Scope) = scope.add(
			"city.smartb.s2:s2-test-bdd:${Framework.fixers}",
			"org.springframework.boot:spring-boot-starter-test:${PluginVersions.springBoot}"
		).also(::cucumber)
			.also(::junit)

		fun f2(scope: Scope) = scope.add(
			"city.smartb.f2:f2-spring-boot-starter-function:${Framework.fixers}"
		)
		fun f2Http(scope: Scope) = scope.add(
			"city.smartb.f2:f2-spring-boot-starter-function-http:${Framework.fixers}",
			"city.smartb.f2:f2-spring-boot-openapi:${Framework.fixers}"
		)

		fun fs(scope: Scope) = scope.add(
			"city.smartb.fs:file-client:${Versions.fs}"
		)

		fun s2EventSouringBc(scope: Scope) = scope.add(
			"city.smartb.s2:s2-spring-boot-starter-sourcing-ssm:${Framework.fixers}",
			"city.smartb.s2:s2-spring-boot-starter-utils-logger:${Framework.fixers}"
		)
		fun jackson(scope: Scope) = FixersDependencies.Jvm.Json.jackson(scope)
		fun coroutines(scope: Scope) = FixersDependencies.Jvm.Kotlin.coroutines(scope)
		fun cucumber(scope: Scope) = FixersDependencies.Jvm.Test.cucumber(scope).also {
			scope.add("io.cucumber:cucumber-spring:${Versions.cucumber}")
		}
		fun junit(scope: Scope) = FixersDependencies.Jvm.Test.junit(scope).also {
			scope.add("org.awaitility:awaitility:${Versions.awaitility}")
		}

		object Spring {
			fun dataCommons(scope: Scope) = FixersDependencies.Jvm.Spring.dataCommons(scope)
			fun tx(scope: Scope) = FixersDependencies.Jvm.Test.junit(scope).also {
				scope.add("org.springframework:spring-tx:${FixersVersions.Spring.framework}")
			}
		}

		object Test {
			fun dataFaker(scope: Scope) = scope.add(
				"net.datafaker:datafaker:${Versions.datafaker}",
			)
		}

	}
	object Mpp {
		fun f2(scope: Scope) = scope.add(
			"city.smartb.f2:f2-dsl-cqrs:${Framework.fixers}",
			"city.smartb.f2:f2-dsl-function:${Framework.fixers}"
		)

		fun f2CLient(scope: Scope) = scope.add(
			"city.smartb.f2:f2-client-ktor:${Framework.fixers}",
		)

		fun fs(scope: Scope) = scope.add(
			"city.smartb.fs:file-domain:${Versions.fs}"
		)

		fun s2(scope: Scope) = scope.add(
			"city.smartb.s2:s2-automate-core:${Framework.fixers}",
			"city.smartb.s2:s2-automate-dsl:${Framework.fixers}"
		)
	}
}
