# Build conversor lib
FROM maven:3-openjdk-17 AS build-conversor
WORKDIR /workspace/app

COPY ./conversor /workspace/app
RUN mvn package

# Build API
FROM eclipse-temurin:17-jdk-alpine AS build-api
WORKDIR /workspace/app

COPY ./api /workspace/app

ARG BUILD_CONVERTER=/workspace/app/target
COPY --from=build-conversor ${BUILD_CONVERTER}/*.jar /libs

RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build-api ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build-api ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build-api ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","dev.danielarrais.Main"]