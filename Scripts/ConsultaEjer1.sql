#Ejercicio1 Consultas

#1. Obtener todos los datos almacenados de las aplicaciones (nombre y descripción).

select * from aplicaciones;

#2. Obtener el NIF y el nombre de los programadores.

select NIF, NOMBRE from programadores;

#3. Obtener todas las incidencias que todavía no han sido cerradas.

SELECT * FROM incidencias WHERE FECHA_CIERRE IS NULL;

#4. Obtener todos los programadores que han participado en la incidencia 1.

select programador from programador_incidencia p_i where p_i.incidencia=1;

select p.* from programadores p, programador_incidencia pi2 where pi2.INCIDENCIA = 1 and p.NIF = pi2.PROGRAMADOR;

#5. Obtener todas las incidencias en las que ha participado el programador con DNI 10264495D.

select id, programador from incidencias where incidencias.programador="10264495D";
select i.*, pi2.PROGRAMADOR as participa from incidencias i, programador_incidencia pi2 
	where pi2.PROGRAMADOR='10264495D' and i.ID=pi2.INCIDENCIA;

#6. Obtener el tiempo total que se ha trabajado en la incidencia 170.

select * from programador_incidencia where incidencia=170;
select sum(tiempo) as tiempo_total from programador_incidencia where incidencia=170;

#7. Obtener el nombre de la aplicación con más versiones y la cantidad de versiones de esta.

#Pendiente

#8. Obtener el nombre de la aplicación con la versión más alta y cuál es.

select APLICACION ,ID_VERSION from versiones v where v.ID_VERSION =(select max(cast(ID_VERSION as int))from versiones v2);

#9. Obtener la incidencia más antigua iniciada y la más actual iniciada (en una sola consulta).

select min(fecha_apertura), max(fecha_apertura) from incidencias;
select * from incidencias where FECHA_APERTURA = (select min(fecha_apertura) from incidencias) 
	or FECHA_APERTURA =(select max(fecha_apertura) from incidencias);

#10. Obtener el email y el NSS de los programadores que han participado en incidencias de la aplicación OrTravel.

select email, NSS from programadores p where p.NIF = (select programador from programador_incidencia pi2 where incidencia=(select id from incidencias i where aplicacion="OrTravel"));

select distinct p.email, p.nss from programadores p, incidencias i, programador_incidencia pi2 
	where p.NIF = pi2.PROGRAMADOR
		and pi2.INCIDENCIA = i.ID 
		and i.APLICACION = "OrTravel";

#11. Obtener el nombre y la descripción de todas las aplicaciones que comienzan por S.

select nombre, descripcion from aplicaciones where nombre like 'S%';

#12. Obtener el nombre completo de todos los programadores cuyo NSS termina por 6.

select nombre, NSS from programadores where NSS like '%6';

#13. Obtener todos los datos de los programadores que tengan un email del dominio de gmail.com.

select * from programadores where email like '%gmail.com';

#14. Obtener el nombre de todos los programadores ordenados por orden alfabético en base a su nombre.

select nombre from programadores order by nombre asc;

#15. Obtener todos los datos de las aplicaciones cuya descripción contenga menos de 20 caracteres.

select * from aplicaciones where length (DESCRIPCION) < 20;




