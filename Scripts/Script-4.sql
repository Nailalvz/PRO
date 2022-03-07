#1.Obtener el nombre completo de todos los becarios ordenado por orden alfab�tico en base a los apellidos y en el orden: apellidos, nombre.
	
select apellidos, nombre from becario order by apellidos asc;
	
#2.Obtener todos los datos de los becarios ordenados por edad, de m�s joven a menos. 
	
select * from becario order by fecha_nac asc;
	
#3.Obtener el nombre completo de todos los becarios junto con el nombre completo de sus sustitutos. Utilizar subconsultas.

select nombre, apellidos from becario where sustituto in (select sustituto from becario); # no funciona

#4.Obtener el dni y la fecha de nacimiento de todos los becarios menores de 23 a�os.

select dni, fecha_nac, timestampdiff(year,fecha_nac, curdate()) as edad from becario; 

#5.Obtener todas las webs y los nombres de fabricantes cuyas webs todav�a son inseguras, es decir, que no siguen el protocolo https si no que todav�a mantienen el http. 



#6.Obtener las direcciones ip de todos los ordenadores de los laboratorios 1, 2 y 3.
	
	
	
#7.Obtener las descripciones de todos los componentes fabricados por Peter Underhill.
	
	
	
#8.Obtener las descripciones de todos los componentes de los ordenadores del laboratorio 6. 
	
	
	
#9.Obtener todos los datos de los ordenadores comprados en este milenio.
	
	
	
#10.Obtener el nombre y el apellido de los supervisores de los laboratorios de la segunda planta.
	
	
	
#11.Obtener una agrupaci�n de las ip de los ordenadores en base a los supervisores que vigilan los laboratorios d�nde est�n alojados. Agrupar estas IP por supervisores y mostrar tambi�n el nombre completo de dicho supervisor y el id del laboratorio en el que est� cada ordenador.
	
	
	
#12.Obtener los tel�fonos de los fabricantes cuya p�gina web sea segura. 
	
	
	
#13.Obtener el nombre del fabricante del que m�s componentes se almacenan.
	
	
	
#14.Obtener todos los datos de los componentes agrupados por fabricantes y ordenados por el id del fabricante de mayor a menor.
	
	
	
#15.Obtener los componentes de los ordenadores del laboratorio 6.








