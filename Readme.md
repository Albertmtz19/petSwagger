# Pasos para arrancar el proyecto

1. Clonar el repositorio
2. Navegar a la carpeta del proyecto
3. previamente tener ambientado el JDK 17 y Gradle en el sistema
3. Ejecutar el comando `./gradlew bootJar` para construir el proyecto
4. Navegar a la carpeta `build/libs` y verificar que se haya generado el archivo `.jar`
3. Ejecutar el comando `java -jar [nombre del jar]` para iniciar la aplicación `java -jar pet-0.0.1-SNAPSHOT.jar`
4. Abrir una herramienta de pruebas como postman y acceder a `http://localhost:8080` para ver la aplicación en funcionamiento
### Servicios disponibles

* `GET /api/pet/{idPet}` - Devuelve la mascota con el id especificado
* `POST /api/pet` - Devuelve la mascota creada con el id generado

### Referencias
* Desarrollador - Jose Alberto Martinez
* email - albertmtzh03@gmail.com
* Tel - 5624680964
* linkedin - https://www.linkedin.com/in/jose-alberto-mart%C3%ADnez-hern%C3%A1ndez-365842207/
