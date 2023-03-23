pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
		maven { url = uri("https://repo.spring.io/milestone") }
	}
}

rootProject.name = "cccev"

include(
	"cccev-dsl:dsl-model",
	"cccev-dsl:dsl-client",
)
include(
	"api-commons",
	"api-config",
	"api-gateway",
	"cccev-f2",
	"cccev-test"
)

include(
	"cccev-f2:concept-f2:concept-f2-api",
	"cccev-f2:concept-f2:concept-f2-client",
	"cccev-f2:concept-f2:concept-f2-domain",
	"cccev-f2:evidence-f2:evidence-f2-api",
	"cccev-f2:evidence-f2:evidence-f2-domain",
	"cccev-f2:evidence-type-f2:evidence-type-f2-api",
	"cccev-f2:evidence-type-f2:evidence-type-f2-client",
	"cccev-f2:evidence-type-f2:evidence-type-f2-domain",
	"cccev-f2:request-f2:request-f2-api",
	"cccev-f2:request-f2:request-f2-client",
	"cccev-f2:request-f2:request-f2-domain",
	"cccev-f2:unit-f2:unit-f2-api",
	"cccev-f2:unit-f2:unit-f2-client",
	"cccev-f2:unit-f2:unit-f2-domain",
)
include(
	"cccev-projection:projection-api",
	"cccev-projection:projection-domain"
)
include(
	"cccev-s2:concept:concept-api",
	"cccev-s2:concept:concept-domain",
	"cccev-s2:evidence-type:evidence-type-api",
	"cccev-s2:evidence-type:evidence-type-domain",
	"cccev-s2:request:request-api",
	"cccev-s2:request:request-domain",
	"cccev-s2:request:request-tasks",
	"cccev-s2:unit:unit-api",
	"cccev-s2:unit:unit-domain"
)

include(
	"cccev-f2:requirement-f2:requirement-f2-api",
	"cccev-f2:requirement-f2:requirement-f2-client",
	"cccev-f2:requirement-f2:requirement-f2-domain"
)

include(
	"cccev-s2:requirement:requirement-api",
	"cccev-s2:requirement:requirement-domain",
)
