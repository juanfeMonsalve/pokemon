Tecnologias usadas
Java 17
Spring boot 3.3.1
Maven wrapper (el de intellij)
Se hace llamado al servicio de pokemon mediante RestTemplate


Para correr la aplicacion se debe ejecutar 

mvn comple

Si salen errores de importacion dar en reload project de maven
para actualizar el proyecto

mvn spring-boot:run

Se adjunta un xml llamado PokemonSoap.xml importar este como proyecto en 
Soap UI y deberia estar respondiendo correctamente le servicio

Se utiliza patron de diseño adapter para realizar un mappeo de objetos y poder tener
comunicacion entre dos partes
