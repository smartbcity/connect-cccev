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
	"cccev-dsl:cccev-dsl-core",
	"cccev-dsl:cccev-dsl-dto",
)
include(
	"api-gateway",
	"api-commons",
	"cccev-api",
	"cccev-f2",
	"cccev-test"
)
include(
	"cccev-s2:request:request-app",
	"cccev-s2:request:request-domain",
	"cccev-s2:request:request-tasks"
)
