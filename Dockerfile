FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/expense-tracker-app.jar expense-tracker-app.jar

CMD ["java","-jar","expense-tracker-app.jar"]