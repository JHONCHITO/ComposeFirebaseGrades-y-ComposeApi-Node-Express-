

📘 Compose + API (Node/Express)

ComposeFirebaseGrades es una aplicación desarrollada en Jetpack Compose (Kotlin) que integra dos funcionalidades principales:  
1️⃣ Firebase Firestore para registrar estudiantes con sus calificaciones, y  
2️⃣ API Node.js + Express para enviar y almacenar datos de usuarios desde la app móvil a un servidor local.

La aplicación cuenta con una interfaz moderna y simple construida con Material Design 3, donde el usuario puede:
- Ingresar nombre, correo y nota para guardarlos directamente en Firebase  
- Cambiar a la pestaña API, ingresar nombre y correo, y enviar los datos mediante una petición HTTP POST al servidor Node.js + Express

En el backend, la API está creada con Express.js, escucha en el puerto 3001 y permite recibir, registrar y consultar usuarios en formato JSON.  
La comunicación entre el emulador Android y el servidor se logra mediante la dirección 10.0.2.2, que representa localhost dentro del entorno del emulador.

  video Api    https://youtube.com/shorts/uzdoG8vKLxk?si=3pk5juDx44tKf-yo

- <img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/34d0cbde-5d88-49ab-b454-3746b1e9051e" />

🧩 Tecnologías utilizadas
🔹 API (Node/Express)

Node.js → entorno de ejecución del backend.

Express.js → framework para crear una API REST que recibe y guarda los datos enviados desde la app móvil.

HTTP POST (REST API) → protocolo usado para comunicar la aplicación Android con el servidor local.

JSON (JavaScript Object Notation) → formato de intercambio de datos entre la app y el backend.

10.0.2.2 (emulador Android) → dirección usada para conectar el emulador con el servidor Node.js del computador


👉 En esta parte se implementó la comunicación cliente-servidor, demostrando cómo una app móvil puede enviar datos a un backend real  
🎯 Objetivo académico
El proyecto fue realizado como actividad investigativa universitaria para demostrar el uso práctico de **API REST** y **Firebase** dentro de una aplicación **Android nativa**, aplicando conceptos de **desarrollo móvil**, **arquitectura de software** y **comunicación cliente-servidor**.

