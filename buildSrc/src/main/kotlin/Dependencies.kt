import city.smartb.gradle.dependencies.FixersDependencies
import city.smartb.gradle.dependencies.FixersPluginVersions
import city.smartb.gradle.dependencies.FixersVersions
import city.smartb.gradle.dependencies.Scope
import city.smartb.gradle.dependencies.add

object Framework {
	val fixers = FixersPluginVersions.fixers
	val connect = "0.15.0-RC2"
}

object PluginVersions {
	const val kotlin = FixersPluginVersions.kotlin
	const val springBoot = FixersPluginVersions.springBoot
	val fixers = Framework.fixers
	val d2 = Framework.fixers
}

object Versions {
	val fs = Framework.connect
	val springBoot = PluginVersions.springBoot

	const val cucumber = FixersVersions.Test.cucumber
	const val ktor = FixersVersions.Kotlin.ktor
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
			"city.smartb.f2:f2-spring-boot-starter-function:${Framework.fixers}",
			"city.smartb.f2:f2-spring-boot-exception-http:${Framework.fixers}"
		)

		fun f2Http(scope: Scope) = scope.add(
			"city.smartb.f2:f2-spring-boot-starter-function-http:${Framework.fixers}",
			"city.smartb.f2:f2-spring-boot-openapi:${Framework.fixers}"
		)

		object Fs {
			fun client(scope: Scope) = scope.add(
				"city.smartb.fs:fs-file-client:${Versions.fs}",
				"city.smartb.fs:fs-spring-utils:${Versions.fs}",
				"io.ktor:ktor-utils:${Versions.ktor}"
			)
		}


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
			fun autoConfigure(scope: Scope, ksp: Scope)
					= FixersDependencies.Jvm.Spring.autoConfigure(scope, ksp)
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

		fun f2Client(scope: Scope) = scope.add(
			"city.smartb.f2:f2-client-ktor:${Framework.fixers}",
			"io.ktor:ktor-client-auth:${Versions.ktor}",
			"io.ktor:ktor-client-logging:${Versions.ktor}",
		)

		fun fs(scope: Scope) = scope.add(
			"city.smartb.fs:fs-file-domain:${Versions.fs}"
		)

		fun s2(scope: Scope) = scope.add(
			"city.smartb.s2:s2-automate-core:${Framework.fixers}",
			"city.smartb.s2:s2-automate-dsl:${Framework.fixers}"
		)
	}
}

object Modules {
	object api {
		const val commons = ":api-commons"
		const val config = ":api-config"
		const val gateway = ":api-gateway"
	}

	object cccev {

		object dsl {
			const val client = ":cccev-dsl:cccev-dsl-client"
			const val model = ":cccev-dsl:cccev-dsl-model"
		}
		object f2 {
			object certification {
				const val api = ":cccev-f2:certification-f2:cccev-certification-f2-api"
				const val client = ":cccev-f2:certification-f2:cccev-certification-f2-client"
				const val domain = ":cccev-f2:certification-f2:cccev-certification-f2-domain"
			}
			object concept {
				const val api = ":cccev-f2:concept-f2:cccev-concept-f2-api"
				const val client = ":cccev-f2:concept-f2:cccev-concept-f2-client"
				const val domain = ":cccev-f2:concept-f2:cccev-concept-f2-domain"
			}
			object evidence {
				const val api = ":cccev-f2:evidence-f2:cccev-evidence-f2-api"
				const val client = ":cccev-f2:evidence-f2:cccev-evidence-f2-client"
				const val domain = ":cccev-f2:evidence-f2:cccev-evidence-f2-domain"
			}
			object evidenceType {
				const val api = ":cccev-f2:evidence-type-f2:cccev-evidence-type-f2-api"
				const val client = ":cccev-f2:evidence-type-f2:cccev-evidence-type-f2-client"
				const val domain = ":cccev-f2:evidence-type-f2:cccev-evidence-type-f2-domain"
			}
			object framework {
				const val api = ":cccev-f2:framework-f2:cccev-framework-f2-api"
				const val client = ":cccev-f2:framework-f2:cccev-framework-f2-client"
				const val domain = ":cccev-f2:framework-f2:cccev-framework-f2-domain"
			}
			object requirement {
				const val api = ":cccev-f2:requirement-f2:cccev-requirement-f2-api"
				const val client = ":cccev-f2:requirement-f2:cccev-requirement-f2-client"
				const val domain = ":cccev-f2:requirement-f2:cccev-requirement-f2-domain"
			}
			object unit {
				const val api = ":cccev-f2:unit-f2:cccev-unit-f2-api"
				const val client = ":cccev-f2:unit-f2:cccev-unit-f2-client"
				const val domain = ":cccev-f2:unit-f2:cccev-unit-f2-domain"
			}
		}
		object infra {
			const val fs = ":cccev-infra:fs"
		}
		object projection {
			const val api = ":cccev-projection:cccev-projection-api"
			const val domain = ":cccev-projection:cccev-projection-domain"
		}
		object s2 {
			object certification {
				const val api = ":cccev-s2:certification:cccev-certification-api"
				const val domain = ":cccev-s2:certification:cccev-certification-domain"
				const val task = ":cccev-s2:certification:cccev-certification-task"
			}
			object concept {
				const val api = ":cccev-s2:concept:cccev-concept-api"
				const val domain = ":cccev-s2:concept:cccev-concept-domain"
			}
			object evidence {
				const val api = ":cccev-s2:evidence:cccev-evidence-api"
				const val domain = ":cccev-s2:evidence:cccev-evidence-domain"
			}
			object evidenceType {
				const val api = ":cccev-s2:evidence-type:cccev-evidence-type-api"
				const val domain = ":cccev-s2:evidence-type:cccev-evidence-type-domain"
			}
			object framework {
				const val api = ":cccev-s2:framework:cccev-framework-api"
				const val domain = ":cccev-s2:framework:cccev-framework-domain"
			}
			object requirement {
				const val api = ":cccev-s2:requirement:cccev-requirement-api"
				const val domain = ":cccev-s2:requirement:cccev-requirement-domain"
			}
			object unit {
				const val api = ":cccev-s2:unit:cccev-unit-api"
				const val domain = ":cccev-s2:unit:cccev-unit-domain"
			}
		}
		const val test = ":cccev-test"

		private const val BASE = ":im-commons:im-commons"
		const val api = "$BASE-api"
		const val auth = "$BASE-auth"
		const val domain = "$BASE-domain"
	}


}