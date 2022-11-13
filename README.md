# Spring JDBC Template Tutorial: Learn to build a full CRUD application in Spring Boot
Tutorial tomado del canal de youtube de [Dan Vega](https://www.youtube.com/watch?v=0uLqdBpYAVA)

# Sobre la BD H2
En el application properties se configuraron tres propiedades para h2

```
spring.datasource.name=course_platform
spring.datasource.generate-unique-name=false
spring.h2.console.enabled=true
```

Esta segunda propiedad configurada
```
spring.datasource.generate-unique-name=false
```
Le permite configurar, siempre que se vuelva a arrancar el proyecto, el mismo nombre de la BD 
**(course_platform)**
```
'jdbc:h2:mem:course_platform'
```
Si no se configura dicha propiedad, se tendría una conexión
a la BD más o menos similar a:

```
jdbc:h2:mem:550f90aa-2860-46c1-ae11-fbe7ce2fb69e
```
Lo que significa que siempre se vuelva a iniciar el proyecto, el nombre de la BD
**(550f90aa-2860-46c1-ae11-fbe7ce2fb69e)** cambiará, es decir, siempre será única
en las diferentes ejecuciones que se hagan
