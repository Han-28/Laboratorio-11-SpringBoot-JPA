# Laboratorio-11-SpringBoot- JPA - Farmacia

## Descripción

Laboratorio de CRUD completo de dos tablas relacionadas y pruebas unitarias en Postman.


---

## Requisitos

- Java 23+  
- Maven  
- Base de datos MySQL (o la que uses)  
- Postman para probar APIs REST

---

## Configuración

1. Clonar el repositorio:

```bash
git clone https://github.com/Han-28/Laboratorio-11-SpringBoot-JPA.git
cd tu-repo

La API estará disponible en: http://localhost:8080
Endpoints Especialidad
GET	/especialidades	Lista todos los especialidades	
POST	/especialidades	Inserta un nuevo especialidad	
PUT	/especialidades/{id}	Actualiza especialidad por ID	
DELETE	/especialidades/{id}	Elimina especialidad por ID	

Endpoints Medicamento

GET	/medicamentos	Lista todos los medicamentos	
POST	/medicamentos	Inserta un nuevo medicamento	
PUT	/medicamentos/{id}	Actualiza medicamento por ID
DELETE	/medicamentos/{id}	Elimina medicamento por ID	
