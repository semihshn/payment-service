FROM maven:3.8.3-openjdk-17 AS compiler
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

FROM mcr.microsoft.com/java/jre:17-zulu-alpine
WORKDIR /app
COPY --from=compiler /usr/src/app/target/payment-service-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "payment-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 7777