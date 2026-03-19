# API Login - SENA

## Descripción
API REST desarrollada con Spring Boot para autenticación de usuarios.

## Tecnologías
- Java 21
- Spring Boot
- MySQL
- Maven

## Endpoint

### POST /api/login

Permite autenticar un usuario en el sistema.

### Ejemplo Request (JSON)
{
  "usuario": "admin",
  "password": "1234"
}

### Respuesta
- Autenticación satisfactoria
- Error en la autenticación

## Autor

Gabriel Rojas

