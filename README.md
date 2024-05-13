# tarifamicro
Lee los csv, adjunta tarifas a los terminales y devuelve un JSON a la petición HTTP

Su estructura es:

-model: Paquete donde se encuentran los modelos
  -Terminal: El modelo de los terminales con sus datos
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/51a7de18-13c0-45ec-8b15-7fabd8f66891)


-reader: Paquete que contiene los distintos readers de la aplicación

-buisness.service: El paquete buisness contiene todo lo que tenga que ver con la capa de negocio, y el service los servicios de la aplicacion

-presentation.controller: El paquete presentation contiene todo lo que tenga que ver con la capa de presentiacion, y el controller los controladores de la aplicacion
