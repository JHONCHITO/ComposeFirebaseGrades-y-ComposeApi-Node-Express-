Proyecto Compose + Firestore (Grades)
El objetivo es registrar estudiantes y sus calificaciones directamente en Firebase Firestore.
La pantalla permite ingresar tres campos: nombre, correo y nota.
Cuando se presiona el botón “Guardar en Firebase”, la información se guarda en la base de datos de Firebase dentro de una colección llamada grades.

Lo más interesante es que los registros se muestran en tiempo real, sin necesidad de recargar la app. Esto se logra con un sistema de escucha que detecta cada nuevo dato que se guarda en Firestore y lo actualiza en la lista que se ve abajo.
Por eso, apenas se guarda un estudiante, aparece de inmediato en el listado con su nombre, correo y nota.

Esta parte demuestra cómo Jetpack Compose puede conectarse a servicios en la nube como Firebase, usando un diseño moderno y limpio. Además, permite probar la sincronización directa entre la app móvil y la base de datos, algo muy común en aplicaciones reales que manejan información dinámica.

video donde esplicamos los pasos de la aplicacion de Compose + Firestore (Grades) 

video 1. https://youtube.com/shorts/UyxHOQqADsY?si=iY0Ib42A6xOVx2aG

imagen aplicacion
<img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/15a3880a-07f1-4b3c-9dab-f476ff5134a9" />


IMAGEN BASE DE DATOS FIREBASE

<img width="801" height="950" alt="image" src="https://github.com/user-attachments/assets/ccab8c6c-62a4-469c-a966-54ee42d54326" />



