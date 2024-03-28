FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /FiapEshopping-1

COPY . /FiapEshopping-1

RUN mvn package

FROM openjdk:17-jdk-slim

COPY --from=build /FiapEshopping/target/*.jar /FiapEshopping/1/FiapEshopping.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./unrandom", "-jar", "/FiapEshopping/1/FiapEshopping-1.jar"] 

EXPOSE 8082