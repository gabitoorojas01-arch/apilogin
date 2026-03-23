API Login - Taller Fénix Diesel

Este proyecto consiste en el desarrollo de una API REST utilizando Spring Boot, la cual permite la gestión de usuarios y la autenticación mediante login. La API fue construida como parte de la evidencia de aprendizaje del SENA, aplicando conceptos de desarrollo backend, conexión a base de datos y pruebas de servicios web.

El sistema permite realizar operaciones básicas sobre los usuarios como crear, listar, buscar, actualizar y eliminar registros, además de validar credenciales mediante un endpoint de login.

Para el desarrollo se utilizaron tecnologías como Java, Spring Boot, Spring Data JPA, MySQL y Maven. Las pruebas de funcionamiento de los endpoints se realizaron utilizando la herramienta Postman.

La API se ejecuta localmente en la siguiente URL base:
http://localhost:9090/api/usuarios

Los endpoints disponibles son:

- GET /api/usuarios → Permite listar todos los usuarios registrados
- GET /api/usuarios/{id} → Permite buscar un usuario por su ID
- POST /api/usuarios → Permite crear un nuevo usuario
- POST /api/usuarios/login → Permite validar el acceso de un usuario (login)
- PUT /api/usuarios/{id} → Permite actualizar un usuario existente
- DELETE /api/usuarios/{id} → Permite eliminar un usuario

Para el correcto funcionamiento del sistema es necesario configurar la conexión a la base de datos en el archivo application.properties, incluyendo la URL, usuario y contraseña de MySQL.

Durante las pruebas se validó el correcto funcionamiento de cada endpoint, incluyendo casos exitosos y errores como credenciales incorrectas o usuarios inexistentes.

Este proyecto demuestra la implementación de una API funcional con operaciones CRUD completas, validaciones básicas y autenticación, cumpliendo con los requisitos de la evidencia GA7-220501096-AA5-EV04.

Autor: Gabriel Rojas