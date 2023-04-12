FROM openjdk:11
EXPOSE 9004
COPY  target/asset_management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/asset_management-0.0.1-SNAPSHOT.jar"]