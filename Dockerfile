FROM maven:3.8.4-openjdk-11 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -DskipTests

FROM openjdk:18 as LAYERS_BUILD
WORKDIR /tmp/
ARG JAR_FILE=/build/target/*.jar
COPY --from=MAVEN_BUILD ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:18
#RUN apk update  && apk upgrade
WORKDIR /usr/src/app/
COPY cr /usr/src/app/cr/
COPY --from=LAYERS_BUILD /tmp/dependencies/ ./
COPY --from=LAYERS_BUILD /tmp/spring-boot-loader ./
COPY --from=LAYERS_BUILD /tmp/snapshot-dependencies/ ./
COPY --from=LAYERS_BUILD /tmp/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]