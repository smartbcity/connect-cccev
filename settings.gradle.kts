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
	"cccev-f2:concept-api:concept-api-app",
	"cccev-f2:concept-api:concept-api-domain",
	"cccev-f2:evidence-api:evidence-api-app",
	"cccev-f2:evidence-api:evidence-api-domain",
	"cccev-f2:request-api:request-api-app",
	"cccev-f2:request-api:request-api-domain",
	"cccev-f2:requirement-api:requirement-api-app",
	"cccev-f2:requirement-api:requirement-api-domain",
)
include(
	"cccev-s2:concept:concept-app",
	"cccev-s2:concept:concept-domain",
	"cccev-s2:evidence:evidence-app",
	"cccev-s2:evidence:evidence-domain",
	"cccev-s2:request:request-app",
	"cccev-s2:request:request-domain",
	"cccev-s2:request:request-tasks",
	"cccev-s2:requirement:requirement-app",
	"cccev-s2:requirement:requirement-domain"
)
