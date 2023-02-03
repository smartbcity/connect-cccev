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
	"cccev-core:cccev-core-dsl",
)
include(
	"api-gateway",
	"api-commons",
	"cccev-f2",
	"cccev-test"
)
include(
	"cccev-f2:concept-f2:concept-f2-api",
	"cccev-f2:concept-f2:concept-f2-domain",
	"cccev-f2:evidence-f2:evidence-f2-api",
	"cccev-f2:evidence-f2:evidence-f2-domain",
	"cccev-f2:request-f2:request-f2-api",
	"cccev-f2:request-f2:request-f2-domain",
	"cccev-f2:requirement-f2:requirement-f2-api",
	"cccev-f2:requirement-f2:requirement-f2-domain",
)
include(
	"cccev-s2:concept:concept-api",
	"cccev-s2:concept:concept-domain",
	"cccev-s2:evidence:evidence-api",
	"cccev-s2:evidence:evidence-domain",
	"cccev-s2:request:request-api",
	"cccev-s2:request:request-domain",
	"cccev-s2:request:request-tasks",
	"cccev-s2:requirement:requirement-api",
	"cccev-s2:requirement:requirement-domain"
)
