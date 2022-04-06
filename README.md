# Prueba Técnica Spring

### Consigna
Generar un endpoint que permita cargar archivos a través de FORM-DATA y por parámetro en la URL poder determinar el algoritmo de hash a aplicar sobre los archivos.
Las funciones hash que se deben aplicar sobre los archivos deben ser SHA-256 y SHA-512 del conjunto SHA-2

#### Herramientas usadas
- Java 11
- Spring Boot 2.6.6
- Spring Web
- Maven 
##### Para testear el endpoint
- Invoke-WebRequest

#### Consideraciones adicionales
Se establece que los archivos se encuentran en la carpeta `files`, se suben dos archivos de texto para testing 
