# tarifamicro
Lee los csv, adjunta tarifas a los terminales y devuelve un JSON a la petición HTTP. Los modelos han sido realizados con Lombok

Su estructura es:

## model: Paquete donde se encuentran los modelos
 
  #### Terminal: El modelo de los terminales con sus datos
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/51a7de18-13c0-45ec-8b15-7fabd8f66891)

Tiene los campos necesarios para guardar la información requerida, tales como: su id, el stock y la tarifa.

## reader: Paquete que contiene los distintos readers de la aplicación
  
  #### TerminalReader: Contiene los readers del modelo Terminal
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/b416e705-730f-4a61-9073-4a420378446f)
  ![image](https://github.com/RickDvn/tarifamicro/assets/168721035/ebc9e2ca-c1f2-470b-a61a-24c492caaac5)

El método privado **readTarifas** lee el fichero de tarifas y el público **adjuntarTarifas** adjunta la tarifa que corresponda a cada terminal según su id

 ##### readTarifas

 Utiliza el **CSVReader** para leer los datos del fichero csv deseado y transforma cada fila en un array de Strings que guardo en un hashmap con la columna id como clave, 
 una vez leídos los datos devuelve el hashmap.
 
 ##### adjuntarTarifas

 Recibe una lista por parámetros y utiliza el readTarifas para obtener las tarifas del fichero, después recorre la lista que se le ha pasado y va mirando en el HashMap con el id del terminal 
 para ver si hay alguna tarifa para él, si la hay se la asigna calculando el precio que tendría una vez subido el iva, si no, se queda en null. Una vez acabado ese proceso se devuelve la lista.

## buisness: Contiene todo lo que tenga que ver con la capa de negocio
  
 ### service: Contiene los servicios de la aplicacion
    
 #### TerminalService: El servicio del modelo Terminal
 -interfaz

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/1216cce9-0698-4e9d-904e-e53a5fd6b1e6)
      
 -implementacion
      
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/4f2dbb7f-95cf-4b31-aaad-a80f919671cd)

El único método de esta capa llama al adjuntarTarifas() del reader y devuelve la lista con las tarifas adjuntadas

## presentation: Contiene todo lo que tenga que ver con la capa de presentiacion
  
 ### controller: Contiene los controladores de la aplicacion
    
 #### TerminalController: El controller del modelo Terminal
    
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/28b87b97-8b23-4104-a0cc-86c45e48bbee)

Este controller se encarga de la petición /getTarifas, para la cual devuelve un JSON con los terminales una vez adjuntadas sus terifas

## Tests

### TerminalReaderTest

#### testAdjuntarTarifas

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/4291e586-b6e7-4eda-ac3b-b7994d75fede)

Creo dos listas, una para los datos de prueba y otra para los resultados, la primera es la que va a tener los datos y la segunda los resultados.
Creo dos objetos de prueba y los meto en la primera lista, esos objetos tienen ids que existen en el fichero para que el reader pueda trabajar.

Llamo al método, obtengo los resultados y compruebo que la lista no sea nula, no esté vacía y contenga el mismo número de elementos que la primera.
Después compruebo que tengan el nombre y el precio de la tarifa.

##### Resultado:

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/95159f47-9d92-4926-8d3f-1d1f6fd6a6b2)


### TerminalServiceImplTest
![image](https://github.com/RickDvn/tarifamicro/assets/168721035/90b0c4cf-76be-44bc-9e6f-c32771b0dd6f)

#### testAdjuntarTarifa

En este test se crean dos listas, la que tiene los datos de prueba (la primera) y la que va a guardar el resultado (la segunda).
Los dos primeros objetos de prueba tienen ids que corresponden con ids de tarifas, último no.

Ejecuto el método, guardo el resultado y compruebo que: no es nulo, no está vacío, tiene el mismo número de datos que la primera lista salvo el último objeto que no debe añadirse y 
que las ids de los dos primeros objetos coinciden con los de la lista de prueba.

#### testGetbyId

En este test creo un objeto de prueba  y otro para guardar los resultados. el objeto de prueba lo meto a la fuerza en el mapa del servicio, 
después ejecuto el método con la id de ese objeto y guardo el resultado en el otro objeto y compruebo: que no sea nulo y que tengan la misma id, si todo eso se cumple, el resto debería ser igual

##### Resultado

![image](https://github.com/RickDvn/tarifamicro/assets/168721035/1f9d746d-5f73-4528-84c1-866d414b7471)
