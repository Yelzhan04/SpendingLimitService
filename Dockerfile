FROM amazoncorretto:17-alpine

WORKDIR /app

COPY build/libs/CurrencyLimitManager-0.0.1-SNAPSHOT.jar .

CMD ["java", "-Xmx512m", "-Dlogging.level.root=INFO", "-jar", "CurrencyLimitManager-0.0.1-SNAPSHOT.jar"]
