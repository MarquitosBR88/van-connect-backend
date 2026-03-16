# Estágio de construção e execução unificado (mais seguro para versões muito novas)
FROM amazoncorretto:25

# Instalar Maven manualmente
RUN yum install -y maven

WORKDIR /app
COPY . .

# Build do projeto
RUN mvn clean package -DskipTests

# Expor a porta e rodar o JAR
EXPOSE 8080
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]