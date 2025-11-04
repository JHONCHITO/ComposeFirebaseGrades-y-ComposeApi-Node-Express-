Proyecto Compose + Firestore (Grades)
El objetivo es registrar estudiantes y sus calificaciones directamente en Firebase Firestore.
La pantalla permite ingresar tres campos: nombre, correo y nota.
Cuando se presiona el botón “Guardar en Firebase”, la información se guarda en la base de datos de Firebase dentro de una colección llamada grades.

Lo más interesante es que los registros se muestran en tiempo real, sin necesidad de recargar la app. Esto se logra con un sistema de escucha que detecta cada nuevo dato que se guarda en Firestore y lo actualiza en la lista que se ve abajo.
Por eso, apenas se guarda un estudiante, aparece de inmediato en el listado con su nombre, correo y nota.

Esta parte demuestra cómo Jetpack Compose puede conectarse a servicios en la nube como Firebase, usando un diseño moderno y limpio. Además, permite probar la sincronización directa entre la app móvil y la base de datos, algo muy común en aplicaciones reales que manejan información dinámica.


<img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/15a3880a-07f1-4b3c-9dab-f476ff5134a9" />


🔹 API (Node/Express)

Demuestra la conexión con un servidor local hecho en Node.js y Express, al que la app envía nombre y correo mediante una petición HTTP POST.
Si el servidor responde correctamente, se muestra el mensaje “Usuario creado en API ✅”.
Esta parte permite probar la comunicación cliente-servidor usando la dirección http://10.0.2.2:3001/api/users, que enlaza el emulador con el backend del computador.


- <img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/34d0cbde-5d88-49ab-b454-3746b1e9051e" />

IMAGEN BASE DE DATOS FIREBASE

<img width="801" height="950" alt="image" src="https://github.com/user-attachments/assets/ccab8c6c-62a4-469c-a966-54ee42d54326" />


videos donde esplicamos los pasos de la aplicacion de Compose + Firestore (Grades) Y Compose+Api(Node/Express) 

video 1. https://youtube.com/shorts/UyxHOQqADsY?si=iY0Ib42A6xOVx2aG

video 2. https://youtube.com/shorts/uzdoG8vKLxk?si=3pk5juDx44tKf-yo

video 3. https://youtube.com/shorts/ObvOHzF4jqY?si=VXBPCRoYMq20bLdm


Tecnologías utilizadas

Frontend móvil: Jetpack Compose (Kotlin)
Backend: Node.js + Express
Base de datos: Firebase Firestore
Gestión de dependencias: Gradle (KTS)
Control de versiones: Git + GitHub
Objetivo académico El proyecto fue realizado como actividad investigativa universitaria para demostrar el uso práctico de API REST y Firebase dentro de una aplicación Android nativa, aplicando conceptos de desarrollo móvil, arquitectura de software y comunicación cliente-servidor.

Este proyecto demuestra que una app Android moderna puede comunicarse tanto con servicios en la nube (Firebase) como con una API local (Node.js). Logré integrar ambas tecnologías en un mismo entorno funcional, aplicando todo lo aprendido sobre: Conexión cliente-servidor, Gestión de dependencias, Uso de corutinas y navegación, Configuración de seguridad de red y Publicación del código en GitHub

Además, se configuró un archivo especial llamado network_security_config.xml junto con permisos en el AndroidManifest.xml para permitir que la app pueda comunicarse sin problema con el servidor local (tráfico sin HTTPS, solo HTTP). Esto es importante porque sin esa configuración el emulador no puede enviar datos a la API.

En el diseño, usé Material Design 3, lo que le da un estilo moderno y ordenado a la interfaz. El sistema se divide en dos pantallas principales, que se navegan desde una barra inferior (Bottom Navigation):

Firebase, donde se prueban las operaciones con Firestore. API, donde se prueba el envío y recepción de datos hacia Node.js. Para los procesos que demoran (como guardar datos o enviar peticiones), se usaron corutinas de Kotlin para que las tareas se ejecuten en segundo plano sin congelar la interfaz.
