  /\        /\
(  [|]   [|] )
(      =  =  )
(            )



---->
Java 25
Spring boot

SQL Pstgre
*almacen
*Cache
*Libre
*Proceso
*Record
*Trabajadores 
*Transporte



------>Relacion{
almacen *---* Proceso 
Proceso *---* Record 
Proceso *---* Trabajadores 
Transporte *---* Almacen 
Transporte *---* Record 







}











-Deficion de la base de datos 
*Almacen
+Id del producto de producto
+La cantidad de productos
+El precio de compra hacia los proveedores
+El tipo de producto
+Tipo de proveedor que lo entrego 
+Precio de venta 




*Cache:
-colocar eslotes 


*Libre: 
-colocar 4 eslotes 


*Procesos: 
-Moho
-Humedad
-Grado de fermentacion 
-



*Record
-ensacado y peso 




*Trabajadores
-email
-contraseña
-nombre 
-apellido
-Tiempo de servicio 
-fin de servicio 




*Transporte
-fecha de entrega por proovedor 
-fecha de salñida del cacao procesado 
-compradores del cacao procesado 
-precio de transporte 
-kilos transportados 




*Proveedores 
-Cacao en bruto 
-Sacos
-tipos de sacos 

+++++++Controladores
-permitir el login 
-cargar los nuevos datos de entrega de datos de los productos 
-Cargar datos de los trabajadores y modificarlos 
-cargar datos de los proveedores y modificarlos 
-permitir ver los datros de las perdsiadas del cacao 
-permitir ver cuanto cacao se exporto 
-permitir ver porcentajes promedio por tiempo de produccion 




+++++++Servicios de uso 
-CRUD a alamcen 
-CRUD a cache 
-CRUD a libre 
-CRUD a Proceso 
-CRUD a Record 
-CRUD a Trabajadores 
-CRUD a Transporte 





++++++++Procesos de entrega 
-Se trabaja con la base de datos atrabes de hibernate con el jpa 
-Backend : SpringBoot
-Front end :  Angular 
-Lenguaje: Java , JDK 25
-Puerto: 8080



++++++++Contrase de administrador y detalles 
usuario: admin 
contraseña: admin
--------
Con respecto a la base de datos 

|Usuario|Rol          |Contraseña|
|Admin  |Administrador|root      |
----------
+++++++++Detallles de la seguridad 
-spring-security-test





++++++++Detalles de extenciones
- Maven 
- postgresql
- spring-boot-starter-webmvc-test







