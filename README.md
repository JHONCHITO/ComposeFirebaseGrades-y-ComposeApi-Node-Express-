Proyecto Compose + Firestore (Grades)

ComposeFirebaseGrades es una aplicación desarrollada en Jetpack Compose (Kotlin) que integra dos funcionalidades principales:  
Firebase Firestore para registrar estudiantes con sus calificaciones, y  API Node.js + Express para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.
La aplicación cuenta con una interfaz moderna y simple construida con Material Design 3, donde el usuario puede:
- Ingresar, nombre, correo  y nota para guardarlos directamente en Firebase
- Cambiar a la pestaña API, ingresar, nombre y correo, y enviar los datos mediante una petición HTTP POST al servidor Node.js.
En el backend, la API está creada con Express.js, escucha en el puerto 3001 y permite recibir, registrar y consultar usuarios en formato JSON.  
La comunicación entre el emulador Android y el servidor se logra mediante la dirección 10.0.2.2, que representa localhost dentro del entorno del emulador.

<img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/15a3880a-07f1-4b3c-9dab-f476ff5134a9" />


Proyecto Compose + Firestore (Grades) + API (Node/Express)

ComposeFirebaseGrades es una aplicación desarrollada en Jetpack Compose (Kotlin) que integra dos funcionalidades principales:  
Firebase Firestore para registrar estudiantes con sus calificaciones, y  API Node.js + Express para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.
La aplicación cuenta con una interfaz moderna y simple construida con Material Design 3, donde el usuario puede:
- Ingresar nombre, correo y nota para guardarlos directamente en Firebase
- Cambiar a la pestaña API, ingresar, nombre y correo, y enviar los datos mediante una petición HTTP POST al servidor Node.js + Express

- <img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/34d0cbde-5d88-49ab-b454-3746b1e9051e" />

IMAGEN BASE DE DATOS FIREBASE

<img width="801" height="950" alt="image" src="https://github.com/user-attachments/assets/ccab8c6c-62a4-469c-a966-54ee42d54326" />


En el backend, la API está creada con Express.js, escucha en el puerto 3001 y permite recibir, registrar y consultar usuarios en formato JSON.  
La comunicación entre el emulador Android y el servidor se logra mediante la dirección 10.0.2.2, que representa localhost Dentro del entorno del emulador


videos donde esplicamos los pasos de la aplicacion de Compose + Firestore (Grades) Y Compose+Api(Node/Express) 

video 1. https://youtube.com/shorts/UyxHOQqADsY?si=iY0Ib42A6xOVx2aG

video 2. https://youtube.com/shorts/uzdoG8vKLxk?si=3pk5juDx44tKf-yo

video 3. https://youtube.com/shorts/ObvOHzF4jqY?si=VXBPCRoYMq20bLdm



ComposeFirebaseGrades es una aplicación desarrollada en Jetpack Compose (Kotlin) que integra dos funcionalidades principales:
1️⃣ Firebase Firestore para registrar estudiantes con sus calificaciones, y
2️⃣ API Node.js + Express para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.

La aplicación cuenta con una interfaz moderna y simple construida con Material Design 3, donde el usuario puede:

Ingresar nombre, correo y nota para guardarlos directamente en Firebase.
Cambiar a la pestaña API, ingresar nombre y correo, y enviar los datos mediante una petición HTTP POST al servidor Node.js.
En el backend, la API está creada con Express.js, escucha en el puerto 3001 y permite recibir, registrar y consultar usuarios en formato JSON.
La comunicación entre el emulador Android y el servidor se logra mediante la dirección 10.0.2.2, que representa localhost dentro del entorno del emulador.

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
