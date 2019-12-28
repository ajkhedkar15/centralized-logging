FROM amazoncorretto:11

COPY build/libs/*.jar app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
