**Customer Satisfaction App Challenge v .1.1**

    RQ Funcionales:
    1.-Desarrollar una aplicacion que permita:

    1.1-Crear una evaluación del servicio brindado utilizando su correo, seguido de sus nombres y una calificacion del 1 al 10. Considere que cliente puede dejar múltiples opiniones en un solo día.
    1.1-Modificar una evaluación
    1.1-Obtener las evaluaciones en un rango de fechas


    RQ Técnicos: 
    2.-Basada en un back end Restfull (se evaluara el adecuado uso de los verbos http y códigos de respuesta incluyendo errores) y un front end React que consumirá datos del back end.
    3.-El back end deberá estar desarrolado en  Java utilizando Spring Boot y MongoDB, mientras que el front utilizará React (utilizando bootstrap)
    4.-El API deberá estar documentada (se recomiendo utilizar swagger) 
    5.-Incluir un Dockerfile que permita iniciar la aplicación sin necesidad de tener ningún software base instalado además de docker.
    6.-Las tareas de build deberán estar automatizadas (compilación , build y test) utilizando maven
    7.- Deberá presentar pruebas automatizadas unitarias  tanto para front end como back end (deberán ser suficientes para probar el conocimiento en ellas y la habilidad de crear pruebas adecuadas que aseguren algún ámbito del requerimiento) 
    8.-Deberá incluir un archivo .md con las instrucciones para ejecutar el app de manera local y mediante el archivo docker, así como sus asumpciones y la documentación que considere conveniente. 


## Solución

Se desarolló las 2 aplicaciones en base a lo establecido, la base de datos puede ser obtenido desde el repositorio de DockerHub.

A continuación las guías para visualizar los proyectos.

- [Deploy-Local](https://github.com/RodLopezR/fullstack-challenge/blob/master/1.localhost.md): Instrucciones para ejecutar las aplicaciones localmente.

- [Deploy-Images](https://github.com/RodLopezR/fullstack-challenge/blob/master/2.docker-images.md): Instrucciones para crear las imágenes para las aplicaciones.

- [Deploy-Containers](https://github.com/RodLopezR/fullstack-challenge/blob/master/3.docker-container.md): Instruciones para obtener las imagenes de las aplicaciones desde DockerHub.

- [Deploy-Compose](https://github.com/RodLopezR/fullstack-challenge/blob/master/4.docker-compose.md): Instrucciones para ejecutar todas las app en simultáneo.

- [Public](https://github.com/RodLopezR/fullstack-challenge/blob/master/5.Public.md): Guía para visualizar el proyecto público.

Agradezco la posibilidad de participar en el desafío y acepto cualquier recomendación en busca de feedback.