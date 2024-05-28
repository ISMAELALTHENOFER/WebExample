#utiliza el jdk
FROM openjdk:20
#crea un volumen
VOLUME /tmp
#expone el puerto 8080
EXPOSE 8080
#pasa como argumento el jar
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
#agrega el jar a la constante JAR_FILE
ADD ${JAR_FILE} app.jar
#levanta la aplicicion
ENTRYPOINT ["java","-jar","/app.jar"]