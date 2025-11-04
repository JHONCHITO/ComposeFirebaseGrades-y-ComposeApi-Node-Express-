videos donde esplicamos los pasos de la aplicacion de
Compose + Firestore (Grades) Y Compose+Api(Node/Express)
mas dos imagenes 

video 1. https://youtube.com/shorts/UyxHOQqADsY?si=iY0Ib42A6xOVx2aG

video 2. https://youtube.com/shorts/uzdoG8vKLxk?si=3pk5juDx44tKf-yo

video 3. https://youtube.com/shorts/ObvOHzF4jqY?si=VXBPCRoYMq20bLdm

<img width="90" height="160" alt="image" src="https://github.com/user-attachments/assets/b3bc5cbe-4e3b-40a5-b9e1-af9f7392ca8a" />
<img width="90" height="160" alt="image" src="https://github.com/user-attachments/assets/7e6bec91-a907-42fc-bf17-fb5c0d3aa15d" />


imagen de la base de datos en Firebase
<img width="300" height="500" alt="image" src="https://github.com/user-attachments/assets/6aaab4b7-e3bf-484d-814c-7f2c017410d1" />



Add-Content -Path README.md -Value @'
Compose + Firestore (Grades) Y Compose+Api(Node/Express)

**ComposeFirebaseGrades** es una aplicación desarrollada en **Jetpack Compose (Kotlin)** que integra dos funcionalidades principales:  
1️⃣ **Firebase Firestore** para registrar estudiantes con sus calificaciones, y  
2️⃣ **API Node.js + Express** para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.

La aplicación cuenta con una interfaz moderna y simple construida con **Material Design 3**, donde el usuario puede:
- Ingresar **nombre**, **correo** y **nota** para guardarlos directamente en **Firebase**.  
- Cambiar a la pestaña **API**, ingresar **nombre** y **correo**, y enviar los datos mediante una **petición HTTP POST** al servidor Node.js.

En el backend, la API está creada con **Express.js**, escucha en el puerto **3001** y permite recibir, registrar y consultar usuarios en formato JSON.  
La comunicación entre el emulador Android y el servidor se logra mediante la dirección **10.0.2.2**, que representa **localhost** dentro del entorno del emulador.

   Tecnologías utilizadas
- **Frontend móvil:** Jetpack Compose (Kotlin)  
- **Backend:** Node.js + Express  
- **Base de datos:** Firebase Firestore  
- **Gestión de dependencias:** Gradle (KTS)  
- **Control de versiones:** Git + GitHub  

 Objetivo académico
El proyecto fue realizado como actividad investigativa universitaria para demostrar el uso práctico de **API REST** y **Firebase** dentro de una aplicación Android nativa, aplicando conceptos de **desarrollo móvil**, **arquitectura de software** y **comunicación cliente-servidor**.

---
'@

git add README.md
git commit -m "docs: agregar descripción detallada del proyecto debajo del video"
git push
