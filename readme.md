# Franquicias API 🏬

## Descripción

Este repositorio contiene una aplicación desarrollada como parte de una prueba técnica. La aplicación está construida utilizando Java 17, Gradle 7.3, y Spring Boot 2.6.7, siguiendo los principios de arquitectura hexagonal y CQRS.

## Espefificaciones técnicas

- **Java**: 17
- **Gradle**: 7.3 (o cualquier versión compatible con Java 17)
- **Spring Boot**: 2.6.7
- **Flyway**: Para la gestión de DDL y DML
- **Arquitectura**: Hexagonal
- **Patrón**: CQRS
- **Base de datos**:MySQL alojado en RDS (Amazon Web Services)
- **Acceso a la Base de Datos**: A través de JDBC Template
- **Lombok**: Biblioteca que simplifica la escritura de código Java mediante la generación automática de métodos repetitivos como getters, setters y constructores, reduciendo así el boilerplate code y mejorando la legibilidad del código.

## Arquitectura Hexagonal

La arquitectura hexagonal, también conocida como puertos y adaptadores, promueve que el dominio sea el núcleo de todas las capas. Se divide en tres capas principales:

- **Infraestructura**: Esta capa maneja los adaptadores a los puertos definidos en el dominio. Se encarga de exponer y consumir web services, realizar conexiones a bases de datos, ejecutar sentencias DML y otras implementaciones específicas del framework.
  
- **Aplicación**: Enruta los eventos entrantes de la capa de infraestructura hacia la capa del dominio. Actúa como una barrera transaccional que agrupa la invocación de un caso de uso, incluyendo patrones como fábricas, manejadores de comandos y bus de eventos.
  
- **Dominio**: Contiene toda la lógica de negocio de la aplicación, que es la razón de existir del negocio.

![Arquitectura Hexagonal](https://i.postimg.cc/fT3H2kpF/hexagonal.png)


## Patrón CQRS

El patrón CQRS divide el modelo de objetos en dos partes: un modelo para consulta y un modelo para comando (modificación de datos). Es recomendado para aplicaciones con lógica de negocio compleja, ya que ayuda a separar responsabilidades y mantener un modelo de negocio consistente.

- **Consulta**: Modelo utilizado para presentar datos en la interfaz de usuario. Los objetos se modelan en base a cómo se presentarán los datos, no en la lógica de negocio.
  
- **Comando**: Operaciones que cambian el estado del sistema. El modelo se construye en base a la lógica de negocio de la aplicación.

## URL de Swagger

Puedes acceder a la documentación de la API a través de Swagger en el siguiente enlace:

[http://localhost:8083/api/v1/swagger-ui/index.html](http://localhost:8083/api/v1/swagger-ui/index.html)

[![Screenshot-2024-07-28-220323.png](https://i.postimg.cc/qMK6qdWS/Screenshot-2024-07-28-220323.png)](https://postimg.cc/JG1zYSr5)

## Credenciales de Acceso a la Base de Datos (RDS AWS) 🛢️

- **Schema**: franquicias-database
- **Username**: admin
- **Password**: franquiciasnequi
- **URL**: franquicias-database.c5ckuq00i2hg.us-east-2.rds.amazonaws.com
- **Port**: 3306
- **Versión del MySQL**: 8.0.35

## Importar el Proyecto

Para importar el proyecto, se recomienda usar Gradle en la versión 7.3. Debes importar el proyecto desde la ruta `microservicio/build.gradle`.

1. Clona este repositorio:

    ```bash
    git clone https://github.com/juanesgutiz19/franquicias-api.git
    cd franquicias-api/franquicias-api/microservicio
    ```

2. Abre el proyecto en tu IDE (De preferencia Intellij Idea) y asegúrate de tener configurado Lombok.

3. Ejecuta la aplicación con Gradle. Usa gradlew en lugar de gradle para garantizar que se use la versión de Gradle configurada en el proyecto:

    ```bash
    gradlew bootRun
    ```
## Paso a paso para correr la aplicación desde Intellij Idea 👨‍💻

Primero importa el proyecto desde la ruta `microservicio/build.gradle`:

![Importación de proyecto](https://i.postimg.cc/vT75kF74/Screenshot-2024-07-28-204812.png)

Selecciona "Open as a Project":

![Open as a Project](https://i.postimg.cc/28mQvymh/Screenshot-2024-07-28-204824.png)

Ingresa a File -> Project Structure -> Project y selecciona Java 17

[![Screenshot-2024-07-28-204928.png](https://i.postimg.cc/52KLZmzS/Screenshot-2024-07-28-204928.png)](https://postimg.cc/tsPs6W2s)

En File -> Settings -> Build, Execution, Deployment asegúrate de tener también la versión 17 de Java

[![Screenshot-2024-07-28-205343.png](https://i.postimg.cc/k5VK9tF3/Screenshot-2024-07-28-205343.png)](https://postimg.cc/JyLG502P)

Ahora puedes ejecutar el proyecto 🎉🎉🎉

[![Screenshot-2024-07-28-205033.png](https://i.postimg.cc/9QQy8kDf/Screenshot-2024-07-28-205033.png)](https://postimg.cc/Cz9ZdmHy)

Projecto ejecutado, listo para ingresar a [http://localhost:8083/api/v1/swagger-ui/index.html](http://localhost:8083/api/v1/swagger-ui/index.html) ✅✅

[![Screenshot-2024-07-28-205439.png](https://i.postimg.cc/s2tS2DwB/Screenshot-2024-07-28-205439.png)](https://postimg.cc/SXfjTq0q)

**Nota:** Se está empleando un servicio gratuito para el almacenamiento de las imágenes del README.md, estás serán borradas automáticamente 31 días después


