# 📌 Proyecto de Gestión de Proveedores
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.4-green?style=for-the-badge&logo=springboot) ![DB2](https://img.shields.io/badge/Database-DB2-blue?style=for-the-badge&logo=ibm) ![Thymeleaf](https://img.shields.io/badge/Template%20Engine-Thymeleaf-orange?style=for-the-badge&logo=thymeleaf)

###[Imágen de logo nuevo](https://github.com/Mitsukai74/ProveedoresEcsi_VF/blob/master/logonew.jpg)

### 🏗 **Descripción del Proyecto**
Este un proyecto realizado para la etapa productiva en el programa de tecnología en análisis y desarrollo de sofware del SENA. Es un sistema de gestión de proveedores como aplicación web, desarrollado en **Spring Boot**, que permite, presentar y visualizar proveedores de la empresa ECSI SAS como también, todo el CRUD para los usuarios de la aplicación.
Se ha migrado la base de datos de **MySQL a IBM DB2** y se ha implementado la funcionalidad para visualizar documentos asociados a cada proveedor.
---
---
## 🚀 **Características Principales**
✅ **Gestión de usuarios**: Creación, edición, visualización de roles y permisos de los usuarios potenciales de la aplicación.
✅ **Visualización de proveedores creados**: vista con listado de todos los proveedores creados al momento de visualización con toda la información pertinente.
✅ **Opciones de búsqueda**: Adaptación del esquema de MySql a DB2 y distintos criterio para consultas a la base de datos.    
✅ **Carga y visualización de documentos**: Asociar documentos PDF a proveedores y verlos desde la interfaz.  
✅ **Seguridad**: Autenticación de usuarios con roles y permisos.  
✅ **Interfaz intuitiva**: Uso de **Thymeleaf** para una experiencia fluida.  

---
## 🛠 **Tecnologías Utilizadas**
- **Back-End**: Java, Spring Boot, Spring Data JPA, Spring Security
- **Base de Datos**: IBM DB2
- **Front-End**: Thymeleaf, HTML, CSS, Bootstrap
- **Otros**: Maven, Git, Lombok

## 🎯 **Requisitos Previos**
Antes de ejecutar el proyecto, asegúrate de tener instalado:
- **JDK 17** o superior
- **Maven**
- **IBM DB2 Express-C** (o una versión compatible)
- **Docker** (opcional, si deseas usar DB2 en contenedor)

---
## 🔧 **Configuración y Ejecución**
### 1️⃣ **Clonar el repositorio**
```sh
git clone https://github.com/tu-usuario/nombre-del-repositorio.git
cd nombre-del-repositorio
```

### 2️⃣ **Configurar DB2**
Asegúrate de que DB2 esté en ejecución y actualiza `application.properties` con tus credenciales:
```properties
spring.datasource.url=jdbc:db2://localhost:50000/NOMBRE_BD
spring.datasource.username=usuario_db2
spring.datasource.password=tu_contraseña
spring.jpa.database-platform=org.hibernate.dialect.DB2Dialect
```

### 3️⃣ **Instalar dependencias y ejecutar**
```sh
mvn clean install
mvn spring-boot:run
```

---
## 📂 **Estructura del Proyecto**
```plaintext
📦 gestion-proveedores
 ┣ 📂 src/main/java/com/empresa/proveedores
 ┃ ┣ 📂 controllers
 ┃ ┣ 📂 models
 ┃ ┣ 📂 repositories
 ┃ ┣ 📂 services
 ┣ 📂 src/main/resources/templates
 ┣ 📂 src/main/resources/static
 ┣ 📜 application.properties
 ┣ 📜 pom.xml
 ┗ 📜 README.md
```

---
## 📄 **Licencia**
Este proyecto está bajo la licencia MIT. 🙌

📧 **Contacto**: [abaron@ecsi.com.co]  
💻 **Repositorio**: [(https://github.com/Mitsukai74/ProveedoresEcsi_VF)]

---
🚀 _¡Gracias por visitar este proyecto!_ 😊


