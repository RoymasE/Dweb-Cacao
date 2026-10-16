# Intranet Agroindustrial - Cacao Premium del Perú S.A.C.
**Curso:** Desarrollo Web Integrado (UTP)  
**Docente:** Willabaldo Marcelino Estrada Aro  
**Integrantes:**
- Marco Antonio Zúñiga Bernabe (Product Owner)
- Fabian Morocho Rosales (Backend Lead)
- Edward Sebastián Marticorena García (Scrum Master)
- Erickson Roy Ramírez Tarazona (Frontend Lead)
- Fernando José Rivadeneira Medina (QA & Documentación)

---

## 🚀 Arquitectura del Backend

- **Lenguaje:** Java 21 LTS
- **Framework:** Spring Boot 3.3.4 (Spring Data JPA, Spring Security, Spring Web)
- **Base de Datos:** MySQL 9.7 (`cacao_db` en puerto 3306)
- **Seguridad:** Cifrado unidireccional BCrypt + Autenticación Token JWT (Stateless)
- **Documentación Interactiva:** OpenAPI 3 / Swagger UI (`/swagger-ui.html`)
- **Herramienta de Pruebas:** Postman (Colección preconfigurada: `Cacao_Premium_API.postman_collection.json`)

---

## 📦 Cobertura de Módulos (Sprints 1 al 5)

| Sprint | Historias de Usuario | Requerimientos | Funcionalidad Implementada |
|---|---|---|---|
| **Sprint 1** | HU-01, HU-02, HU-11 | RF-01, RF-02, RF-03, RNF-01, RNF-02, RNF-03, RNF-13 | Autenticación JWT, contraseñas BCrypt, gestión de roles (`ADMIN`, `GERENTE`, `JEFE_PLANTA`, `ACOPIADOR`, `VENDEDOR`, `SUPERVISOR_CALIDAD`) y usuarios. |
| **Sprint 2** | HU-03, HU-04, HU-12 | RF-04, RF-05, RF-06, RF-07, RF-08, RNF-07, RNF-08 | Catálogo de áreas de planta, agricultores asociados de acopio (San Martín), contratos comunales y clientes internacionales de exportación. |
| **Sprint 3** | HU-05, HU-06, HU-07, HU-08 | RF-08, RF-09, RF-10, RF-11, RF-12, RF-13 | Catálogo de cajones de madera, recepción de cosecha en baba, monitoreo de fermentación (4-6 días, volteos, temp 45-50°C y alertas), secado solar (~7% humedad) y pesaje en Sección 1 (Granos). |
| **Sprint 4** | HU-09, HU-10, HU-13 | RF-14, RF-15, RNF-04, RNF-05, RNF-09, RNF-10, RNF-11, RNF-12 | Contabilización Sección 2 (Polvo y derivados en molienda), validación transaccional de stock suficiente, pedidos de venta internacional, y emisión de Packing List marítimo oficial. |
| **Sprint 5** | HU-14, HU-15 | RF-18, RF-19, RNF-06, RNF-14, RNF-15 | Balance integral de masas ($Cosechado = Procesado + Exportado + Perdido$) y endpoints de Dashboard para gráficas estadísticas. |

---

## 🛠️ Cómo Ejecutar el Backend

### 1. Iniciar Base de Datos MySQL
Verifica que el servicio MySQL esté iniciado y con la base de datos creada:
```sql
CREATE DATABASE IF NOT EXISTS cacao_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Ejecutar la Aplicación Spring Boot
Abre una terminal en la carpeta `cacaormpresa` y ejecuta:
```bash
.\mvnw.cmd spring-boot:run
```
O directamente con el archivo `.jar` compilado:
```bash
java -jar target\cacaormpresa-0.0.1-SNAPSHOT.jar
```

El servidor iniciará en `http://localhost:8080`.
Al iniciar por primera vez, el sistema cargará automáticamente los datos base de prueba (usuarios, agricultores, clientes internacionales, cajones, lotes y pesajes).

---

## 🧪 Cómo Usar Postman (Guía Rápida Paso a Paso)

1. **Abrir Postman**: Si usas la versión Web o de Escritorio, inicia sesión con tu cuenta.
2. **Importar la Colección**:
   - En la esquina superior izquierda de Postman, haz clic en **Import**.
   - Arrastra o selecciona el archivo: `Cacao_Premium_API.postman_collection.json` (ubicado en la raíz de este proyecto).
3. **Estructura Importada**:
   - Verás la colección llamada **"Cacao Premium del Perú - API Backend"** con 14 carpetas organizadas por cada módulo del PDF.
4. **Hacer Login (Paso Clave)**:
   - Abre la carpeta **1. Autenticación y Control de Acceso (RF-01)**.
   - Selecciona la petición **Login (Admin)** y presiona el botón azul **Send**.
   - ¡Listo! En la respuesta verás el token JWT (`eyJhbGci...`) y la colección lo guardará automáticamente en la variable `{{token}}` para todas las demás peticiones.
5. **Probar cualquier endpoint**:
   - Puedes ir a cualquier carpeta (por ejemplo: **7. Recepción de Cosecha**, **10. Contabilización de Pesos**, **13. Balance de Masas** o **14. Dashboard Gerencial**) y presionar **Send**. Recibirás inmediatamente respuestas HTTP `200 OK` o `201 Created` en formato JSON.

---

## 🌐 Swagger UI (Documentación Interactiva en el Navegador)

Mientras el servidor esté corriendo, también puedes ver y probar todas las APIs directamente desde tu navegador en:
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
