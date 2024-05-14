# tarifamicro
Lee los csv, adjunta tarifas a los terminales y devuelve un JSON a la petición HTTP. Los modelos han sido realizados con Lombok

Su estructura es:

## model: Paquete donde se encuentran los modelos
 
  #### Terminal: El modelo de los terminales con sus datos
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/51a7de18-13c0-45ec-8b15-7fabd8f66891)


## reader: Paquete que contiene los distintos readers de la aplicación
  
  #### TerminalReader: Contiene los readers del modelo Terminal
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/00b84aec-145f-47f9-8bf5-fb8ebf03ea19)
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/fa4d66d0-8396-400e-9bd1-475cb4c669ad)

El método privado lee el fichero de tarifas y el público adjunta la tarifa que corresponda a cada terminal según su id

## buisness: Contiene todo lo que tenga que ver con la capa de negocio
  
 ### service: Contiene los servicios de la aplicacion
    
 #### TerminalService: El servicio del modelo Terminal
 -interfaz

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/a106a4b6-2533-460b-ae59-252602126a01)
      
 -implementacion
      
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/0cedb8fb-0ac4-465d-8b5e-76233b05556c)

El único método de esta capa llama al adjuntarTarifas() del reader y devuelve la lista con las tarifas adjuntadas

## presentation: Contiene todo lo que tenga que ver con la capa de presentiacion
  
 ### controller: Contiene los controladores de la aplicacion
    
 #### TerminalController: El controller del modelo Terminal
    
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/28b87b97-8b23-4104-a0cc-86c45e48bbee)

Este controller se encarga de la petición /getTarifas, para la cual devuelve un JSON con los terminales una vez adjuntadas sus terifas

## Tests

### TerminalReaderTest
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/4291e586-b6e7-4eda-ac3b-b7994d75fede)

Creo dos listas, una para los datos de prueba y otra para los resultados, la primera es la que va a tener los datos y la segunda los resultados.
Creo dos objetos de prueba y los meto en la primera lista, esos objetos tienen ids que existen en el fichero para que el reader pueda trabajar.

Llamo al método, obtengo los resultados y compruebo que la lista no sea nula, no esté vacía y contenga el mismo número de elementos que la primera.
Después compruebo que tengan el nombre y el precio de la tarifa.

-Resultado:

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/95159f47-9d92-4926-8d3f-1d1f6fd6a6b2)


### TerminalServiceImplTest
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/1c87b090-0cdf-4d2e-8f30-06d6175c0a06)
