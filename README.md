# hadcom

# Nombre del Proyecto

Descripción breve del proyecto.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java JDK 8 o superior

## Configuración

1. Clona este repositorio en tu máquina local: git clone https://github.com/tu-usuario/nombre-del-repo.git
   
2. Abre el proyecto en tu entorno de desarrollo preferido.

3. Configura la conexión a la base de datos MongoDB como en el archivo `application.yml`.

## Uso

1. Levanta el proyecto en tu máquina local:

- `POST http://localhost:9898/api/trace-msgs`: endpoint para el registro de TraceMsg, utilizar el siguiente ejemplo de JSON.
  {
    "sessionId": "abc123",
    "payload": "Test message",
    "ts": "2023-06-23T12:29:00Z"
  }
- `GET http://localhost:9898/api/trace-msgs/by-timestamp-range`: endpoint para obtener TraceMsg por intervalo de fechas, utilizar el siguiente ejemplo de JSON.
  {
      "from": "2023-06-21T12:00:00Z",
      "to": "2023-06-21T12:04:00Z"
  }

Asegúrate de enviar los parámetros necesarios y los formatos de datos adecuados en las solicitudes.

## Contacto

Si tienes alguna pregunta o sugerencia sobre este proyecto, no dudes en ponerte en contacto conmigo en jeferson.cayo16@gmail.com.
