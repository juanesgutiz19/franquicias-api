A continuación se muestran algunas especificaciones técnicas:

#### Arquitectura hexagonal
Arquitectura que fomenta  que nuestro dominio sea el n&uacute;cleo de todas las capas, tambi&eacute;n conocida como puertos y adaptadores en la cual el dominio define los puertos y en las capas superiores se definen los adaptadores para desacoplar el dominio. Se divide princialmente en tres capas, **aplicaci&oacute;n**, **dominio** e **infraestructura**
- **Infraestructura**: Capa que tiene las responsabilidades de realizar los adaptadores a los puertos definidos en el domino, exponer web services, consumir web services, realizar conexiones a bases de datos, ejecutar sentencias DML, en general todo lo que sea implementaciones de cualquier framework
- **Aplicaci&oacute;n**: Capa encargada de enrutar los eventos entrantes de la capa de infraestructura hac&iacute;a la capa del dominio, generalmente se conoce como una barrera transaccional la cual agrupa toda la invocaci&oacute;n de un caso de uso, se pueden encontrar patrones como Fabricas, Manejadores de Comandos, Bus de eventos, etc 
- **Dominio**: Representa toda la l&oacute;gica de negocio de la aplicaci&oacute;n la cual es la raz&oacute;n de existir del negocio. 

#### Patr&oacute;n CQRS:  
Patr&oacute;n con el cual dividimos nuestro modelo de objetos en dos, un modelo para consulta y un modelo para comando (modificaci&oacute;n de datos). Este patr&oacute;n es recomendado cuando se va desarrollar l&oacute;gica de negocio compleja porque nos ayuda a separar las responsabilidades y a mantener un modelo de negocio consistente. 

 - **Consulta**: modelo a trav&eacute;s del cual se divide la responsabilidad para presentar datos en la interfaz de usuario, los objetos se modelan basado en lo que se va a presentar y no en la l&oacute;gica de negocio, ejm: ver facturas, consultar clientes
 - **Comando**: son todas las operaciones que cambian el estado del sistema, ejm: (facturar, aplicar descuento), este modelo se construye todo el modelo de objetos basado en la l&oacute;gica de negocio de la aplicaci&oacute;n  

#### Especificaciones t&eacute;cnicas: 

 - Spring boot 2.1.2
 - Flyway -> Administrar todos los script DDL e inicializadores de la bd 
 - Acceso a la base de datos por medio de JDBC template
 - CQRS
 - Java 8
 - Se debe tener configurado el IDE con Lombok


#### Importar el proyecto:
Para importar el proyecto se recomienda usar Gradle en la versi&oacute;n 5.0, se debe importar desde la ruta *microservicio/build.gradle*