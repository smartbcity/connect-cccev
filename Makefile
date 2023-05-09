FRONT_CCCEV_DOCKERFILE	:= infra/docker/cccev-web-app/Dockerfile
FRONT_CCCEV_NAME	    := smartbcity/cccev-web-app
FRONT_CCCEV_IMG	    	:= ${FRONT_CCCEV_NAME}:${VERSION}
FRONT_CCCEV_LATEST		:= ${FRONT_CCCEV_NAME}:latest

CCCEV_APP_NAME	   	 	:= smartbcity/cccev-gateway
CCCEV_APP_IMG	    	:= ${CCCEV_APP_NAME}:${VERSION}
CCCEV_APP_LATEST		:= ${CCCEV_APP_NAME}:latest
CCCEV_APP_PACKAGE	   	:= :api-gateway

STORYBOOK_DOCKERFILE	:= infra/docker/storybook/Dockerfile
STORYBOOK_NAME	   	 	:= smartbcity/cccev-storybook
STORYBOOK_IMG	    	:= ${STORYBOOK_NAME}:${VERSION}

libs: package-kotlin
docker: docker-build docker-push
docs: docs-build docs-push

docker-build: docker-cccev-api-build
docker-push: docker-cccev-api-push

docs-build: package-storybook-build
docs-push: package-storybook-push

package-kotlin:
	VERSION=${VERSION} ./gradlew build publishToMavenLocal publish --stacktrace

local:
	VERSION=${VERSION} ./gradlew build publishToMavenLocal --stacktrace

docker-cccev-api-build:
	VERSION=${VERSION} ./gradlew build ${CCCEV_APP_PACKAGE}:bootBuildImage -x test

docker-cccev-api-push:
	@docker push ${CCCEV_APP_IMG}

push-latest-cccev-api:
	@docker tag ${CCCEV_APP_IMG} ${CCCEV_APP_LATEST}
	@docker push ${CCCEV_APP_LATEST}

docker-cccev-front:
	@docker build -f ${FRONT_CCCEV_DOCKERFILE} -t ${FRONT_CCCEV_IMG} .
	@docker push ${FRONT_CCCEV_IMG}

package-storybook-build:
	@docker build --no-cache=true -f ${STORYBOOK_DOCKERFILE} -t ${STORYBOOK_IMG} .

package-storybook-push:
	@docker push ${STORYBOOK_IMG}
