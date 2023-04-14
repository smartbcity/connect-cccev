FRONT_CCCEV_DOCKERFILE	:= infra/docker/cccev-web-app/Dockerfile
FRONT_CCCEV_NAME	    := smartbcity/cccev-web-app
FRONT_CCCEV_IMG	    	:= ${FRONT_CCCEV_NAME}:${VERSION}
FRONT_CCCEV_LATEST		:= ${FRONT_CCCEV_NAME}:latest

CCCEV_APP_NAME	   	 	:= smartbcity/cccev-gateway
CCCEV_APP_IMG	    	:= ${CCCEV_APP_NAME}:${VERSION}
CCCEV_APP_LATEST		:= ${CCCEV_APP_NAME}:latest
CCCEV_APP_PACKAGE	   	:= :api-gateway:bootBuildImage

STORYBOOK_DOCKERFILE	:= infra/docker/storybook/Dockerfile
STORYBOOK_NAME	   	 	:= smartbcity/cccev-storybook
STORYBOOK_IMG	    	:= ${STORYBOOK_NAME}:${VERSION}

libs: package-kotlin
docker: docker-cccev-api
docs: package-storybook

package-kotlin:
	VERSION=${VERSION} ./gradlew build publish --stacktrace
local:
	VERSION=${VERSION} ./gradlew build publishToMavenLocal --stacktrace

docker-cccev-api:
	VERSION=${VERSION} ./gradlew build ${CCCEV_APP_PACKAGE} -x test
	@docker push ${CCCEV_APP_IMG}

push-latest-cccev-api:
	@docker tag ${CCCEV_APP_IMG} ${CCCEV_APP_LATEST}
	@docker push ${CCCEV_APP_LATEST}

docker-cccev-front:
	@docker build -f ${FRONT_CCCEV_DOCKERFILE} -t ${FRONT_CCCEV_IMG} .
	@docker push ${FRONT_CCCEV_IMG}

package-storybook:
	@docker build --no-cache=true -f ${STORYBOOK_DOCKERFILE} -t ${STORYBOOK_IMG} .
	@docker push ${STORYBOOK_IMG}
