

📘 Proyecto Compose + Firestore (Grades) + API (Node/Express)

ComposeFirebaseGrades es una aplicación desarrollada en Jetpack Compose (Kotlin) que integra dos funcionalidades principales:  
1️⃣ Firebase Firestore para registrar estudiantes con sus calificaciones, y  
2️⃣ API Node.js + Express para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.

La aplicación cuenta con una interfaz moderna y simple construida con Material Design 3, donde el usuario puede:
- Ingresar nombre, correo y nota para guardarlos directamente en Firebase  
- Cambiar a la pestaña API, ingresar nombre y correo, y enviar los datos mediante una petición HTTP POST al servidor Node.js + Express

En el backend, la API está creada con Express.js, escucha en el puerto 3001 y permite recibir, registrar y consultar usuarios en formato JSON.  
La comunicación entre el emulador Android y el servidor se logra mediante la dirección 10.0.2.2, que representa localhost dentro del entorno del emulador.

🧩 Tecnologías utilizadas
- **Frontend móvil:** Jetpack Compose (Kotlin)  
- **Backend:** Node.js + Express  
- **Base de datos:** Firebase Firestore  
- **Gestión de dependencias:** Gradle (KTS)  
- **Control de versiones:** Git + GitHub  
🎯 Objetivo académico
El proyecto fue realizado como actividad investigativa universitaria para demostrar el uso práctico de **API REST** y **Firebase** dentro de una aplicación **Android nativa**, aplicando conceptos de **desarrollo móvil**, **arquitectura de software** y **comunicación cliente-servidor**.

