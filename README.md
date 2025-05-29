# 📌 Proyecto de Gestión de Proveedores

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.4-green?style=for-the-badge&logo=springboot) ![DB2](https://img.shields.io/badge/Database-DB2-blue?style=for-the-badge&logo=ibm) ![Thymeleaf](https://img.shields.io/badge/Template%20Engine-Thymeleaf-orange?style=for-the-badge&logo=thymeleaf) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

### 🏗 **Descripción del Proyecto**
Este es un sistema de gestión de proveedores desarrollado en **Spring Boot**, que permite registrar, buscar y administrar proveedores de una empresa. Además, se ha migrado la base de datos de **MySQL a IBM DB2** y se ha implementado la funcionalidad para visualizar documentos asociados a cada proveedor.
El proyecto se realiza como resultado de la alternativo para la etapa productiva de tecnología en análisis y desarrollo de software del SENA
---
## 🚀 **Características Principales**
✅ **Migración a DB2**: Adaptación del esquema y consultas a la nueva base de datos.  
✅ **Gestión de proveedores**: Consulta y búsqueda de proveedores.  
✅ **Carga y visualización de documentos**: Asociar documentos PDF a proveedores y verlos desde la interfaz.  
✅ **Seguridad**: Autenticación de usuarios con roles y permisos.  
✅ **Interfaz intuitiva**: Uso de **Thymeleaf** para una experiencia fluida. 
✅ **Descarga de reportes**: Posibilidad de descarga de reportes en distintos formatos, de resultado de búsquedas o listado general .

---
## 🛠 **Tecnologías Utilizadas**
- **Back-End**: Java, Spring Boot, Spring Data JPA, Spring Security
- **Base de Datos**: IBM DB2
- **Front-End**: Thymeleaf, HTML, CSS, Bootstrap
- **Otros**: Maven, Git, Lombok

---
## 🎯 **Requisitos Previos**
Antes de ejecutar el proyecto, asegúrese de tener instalado:
- **JDK 17** o superior
- **Maven**
- **IBM DB2 Express-C** (o una versión compatible)
- **Docker** (opcional, si desea usar DB2 en contenedor)

---
## 🔧 **Configuración y Ejecución**
### 1️⃣ **Clonar el repositorio**
```sh
git clone https://github.com/Mitsukai74/ProveedoresEcsi_VF
```

### 2️⃣ **Configurar DB2**
Asegúrese de que DB2 esté en ejecución y actualice `application.properties` con credenciales válidas:
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
Este proyecto está bajo la licencia MIT. desarrollado para le empresa de soplado e inyección ECSI SAS. 🙌

📧 **Contacto**: [Ángel Barón Bernate]  
💻 **Correo**: [abaron@ecsi.com.co]
