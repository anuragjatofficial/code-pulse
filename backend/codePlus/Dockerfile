FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . ./
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/codePlus-0.0.1-SNAPSHOT.jar codePlus.jar
EXPOSE 8888
CMD ["java", "-jar", "codePlus.jar"]