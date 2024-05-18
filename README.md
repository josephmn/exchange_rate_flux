[![java](https://img.shields.io/badge/Java-v17.0.3.1-blue)](https://adoptium.net/es/temurin/releases/?os=windows&arch=any&package=jdk&version=17)
![spring boot](https://img.shields.io/badge/SpringBoot-v3.2.5-blue?logo=springboot)
[![lombok](https://img.shields.io/badge/Lombok-v1.18.32-blue)](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.32)
![apache_tomcat](https://img.shields.io/badge/Apache_Tomcat-v10.1.20-important?logo=apache)

# API EXCHANGE (v1.0)

Api creado para consumir la siguiente 
URL: https://open.er-api.com/v6/latest/USD gratuita para el tipo de cambio, usando JWT, Spring Webflux, H2 y r2dbc.

## Instalación

1. Descargar el repositorio y ejecutar los siguientes comando para dockerizar:
    ```
    docker build -t exchange_rate:1.0 .
    docker run -p 8080:8080 --name app_exchange exchange_rate:1.0
    ```
   Deberia tener lo siguiente en docker Desktop:
   - Al ejecutar el primer comando
    ![img.png](src/main/resources/img/img.png)
   - Al ejecutar el segundo comando
    ![img_1.png](src/main/resources/img/img_1.png)

2. Al levantar el contenedor **app_exchange**, ingresar al postman con las siguientes rutas:
   ```
   ## RUTA PARA LOGIN
   http://localhost:8080/v1/api/user/signIn
   ```
   Aqui se debe usar el siguiente json en el body:
      ```
      {
          "username": "usuario",
          "password": "123456789"
      }
      ```
   Aqui deberia al ejecutar con el metodo POST la siguiente respuesta:
   ![img_2.png](src/main/resources/img/img_2.png)

   ```
   ## RUTA PARA TIPO DE CAMBIO
   http://localhost:8080/api/v1/exchange
   ```
    AQUI DEBE INGRESAR EL TOKEN EN Bearer Token PARA CONSULTAR EL ENDPOINT
   ![img_4.png](src/main/resources/img/img_4.png)
    ```
    {
        "amount": "500",
        "fromCurrency": "USD",
        "toCurrency": "PEN"
    }
    ```
   Aqui deberia al ejecutar con el metodo GET, obtener la siguiente respuesta:
   ![img_3.png](src/main/resources/img/img_3.png)

   ```
   ## RUTA PARA LISTADO DE CAMBIO CONSULTADOS
   http://localhost:8080/api/v1/listexchangesave
   ```
   AQUI DEBE INGRESAR EL TOKEN EN Bearer Token PARA CONSULTAR EL ENDPOINT
    ![img_5.png](src/main/resources/img/img_5.png)
   
## Recomendaciones

- El aplicativo esta en su primera verson, se seguira implementando nuevas librerías y actualizaciones.
- No olvidar que cada petición se debe agregar el JWT para que pueda funcionar los métodos.
