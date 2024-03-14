## Prueba Directorio
A continuación adjunto capturas del funcionamiento del programa
El backend fue realizado con Quarkus y el cliente en Android Studio en lenguaje Java
Se utilizó la base de datos H2

1.	Crear un proyecto Java Spring Boot o Quarkus.
2.	Implementar el siguiente modelo de clases en el proyecto.

DirectorioRestService: Componente que expone el servicio REST.
Directorio: Servicio de negocio con el objetivo de gestionar la información de personas (almacenar, buscar, borrar), el borrado de una persona elimina todos los datos de una persona incluso su facturacion.
Ventas: Servicio de negocio con el objetivo de gestionar la información de facturacion (almacenar, buscar),
Persona: Clase del modelo de dominio, que representa a una persona.
Factura: Clase del modelo de dominio, que representa las facturas de un persona.
PersonaRepository: Componente encargado de la interacción del datasource para obtener, reconstruir los datos de las personas.
FacturaRepository: Componente encargado de la interacción del datasource para obtener, reconstruir los datos de las facturas.

Todos los atributos de la clase Persona son obligatorios para persistir el objeto excepto apellidoMaterno.

Utilizar una base de datos embebida como h2 para el ejercicio.

Como plus puedes agregar logger para mostrar en consola la información (elige uno de los métodos) recomendación de librería slf4j, pero puedes ocupar la que desees. 

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/a227b3f8-0be5-469c-9cda-976a201ef634)

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/e5de7fe7-170b-4664-be4d-a59fccadbef0)

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/cb76ccca-5357-4fdd-98fd-f1687475b2dc)

Se agrega una persona

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/53a9d54e-ed9d-4b54-9565-ef963c39e2a1)

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/67a6b5d5-5291-4edf-ad14-e18da392adb4)

Se buscan personas por su identificación

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/29de7fee-5eec-4b67-96fb-0dfe4d532536)

Se guarda una factura 

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/544338ec-abda-49d8-8cd4-769414a3ad7f)

Se obtiene la factura mediante el identificador

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/d125c79f-b624-4070-bd6b-275e700cd614)

El cliente realizado en Android Studio con formulario reactivo

![image](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/35f2df1f-06c5-4478-84ec-9559ccdf3226)

![Captura de pantalla 2024-03-14 112106](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/a2a0de2a-adb2-4fa1-bb09-87fb4f610f81)

![Captura de pantalla 2024-03-14 112155](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/3d6754fc-d9d6-455d-a82f-ce078331841c)

Verificar usuarios duplicados

![Captura de pantalla 2024-03-14 112306](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/1388492d-e7ce-438f-b48c-6bafc633d46e)

Se muestran los usuarios registrados

![Captura de pantalla 2024-03-14 112340](https://github.com/abelgrajales/TestGetechnologiesMxDirectorio/assets/158242303/24f37c84-457f-45e9-9a70-85950bd91f84)






