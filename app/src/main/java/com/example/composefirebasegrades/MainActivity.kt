package com.example.composefirebasegrades

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.composefirebasegrades.ui.theme.ComposeFirebaseGradesTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeFirebaseGradesTheme {
                AppNav() // 2 pantallas: Firebase y API
            }
        }
    }
}

/* -------------------------- NAV + BOTTOM BAR -------------------------- */

@Composable
fun AppNav() {
    val nav = rememberNavController()
    val routes = listOf("firebase", "api")

    Scaffold(
        bottomBar = {
            NavigationBar {
                val current = nav.currentBackStackEntryAsState().value?.destination?.route
                routes.forEach { r ->
                    NavigationBarItem(
                        selected = current == r,
                        onClick = {
                            nav.navigate(r) {
                                popUpTo(nav.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(if (r == "firebase") "Firebase" else "API") },
                        icon = {}
                    )
                }
            }
        }
    ) { inner ->
        NavHost(
            navController = nav,
            startDestination = "firebase",
            modifier = Modifier.padding(inner)
        ) {
            composable("firebase") {
                FirebaseGradesScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
            }
            composable("api") {
                UsersScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
            }
        }
    }
}

/* -------------------------- MODELO PARA LISTAR GRADES -------------------------- */

data class GradeDoc(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val grade: Int = 0
)

/* -------------------------- PANTALLA 1: FIREBASE -------------------------- */
/* Guarda en colección "grades" y LISTA en tiempo real lo que hay en Firestore. */

@Composable
fun FirebaseGradesScreen(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    val db = remember { FirebaseFirestore.getInstance() }

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }

    // Estado para la lista en tiempo real
    var items by remember { mutableStateOf(listOf<GradeDoc>()) }

    // Suscripción en tiempo real a la colección "grades"
    DisposableEffect(Unit) {
        var reg: ListenerRegistration? = db.collection("grades")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .addSnapshotListener { snap, err ->
                if (err != null) return@addSnapshotListener
                items = snap?.documents?.map {
                    GradeDoc(
                        id = it.id,
                        name = it.getString("name") ?: "",
                        email = it.getString("email") ?: "",
                        grade = (it.getLong("grade") ?: 0L).toInt()
                    )
                } ?: emptyList()
            }
        onDispose { reg?.remove() }
    }

    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
        Text("Compose + Firestore (grades)", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = grade,
            onValueChange = { grade = it },
            label = { Text("Grade (número)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                val g = grade.toIntOrNull()
                if (name.isBlank() || email.isBlank() || g == null) {
                    Toast.makeText(ctx, "Completa Name, Email y Grade (número)", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                loading = true
                scope.launch {
                    try {
                        // ⚠️ Guardamos en la colección "grades" (la misma de tu consola)
                        db.collection("grades")
                            .add(
                                mapOf(
                                    "name" to name.trim(),
                                    "email" to email.trim(),
                                    "grade" to g,
                                    "createdAt" to System.currentTimeMillis()
                                    // si quieres también: "uid" to "406620"  (tu campo custom)
                                )
                            )
                            .await()
                        Toast.makeText(ctx, "Guardado en Firestore ✅", Toast.LENGTH_SHORT).show()
                        name = ""; email = ""; grade = ""
                    } catch (e: Exception) {
                        Toast.makeText(ctx, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                    } finally {
                        loading = false
                    }
                }
            },
            enabled = !loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (loading) "Saving..." else "Guardar en Firebase")
        }

        Spacer(Modifier.height(20.dp))
        Text("Últimos registros:", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        // Lista en tiempo real
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(items) { s ->
                Text("• ${s.name} — ${s.email} — ${s.grade}")
                Spacer(Modifier.height(6.dp))
            }
        }
    }
}

/* -------------------------- PANTALLA 2: API (Node/Express) -------------------------- */
/* Se mantiene igual; si no tienes el server en 3001, te dará toast de error pero NO afecta Firebase. */

private const val API_URL = "http://localhost:3001/api/users"


@Composable
fun UsersScreen(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text("Compose + API (Node/Express)", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                if (name.isBlank() || email.isBlank()) {
                    Toast.makeText(ctx, "Completa Name y Email", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                loading = true
                scope.launch {
                    try {
                        val code = postUser(name.trim(), email.trim())
                        if (code in 200..299) {
                            Toast.makeText(ctx, "Usuario creado en API ✅", Toast.LENGTH_SHORT).show()
                            name = ""; email = ""
                        } else {
                            Toast.makeText(ctx, "API respondió estado $code", Toast.LENGTH_LONG).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(ctx, "Error API: ${e.message}", Toast.LENGTH_LONG).show()
                    } finally {
                        loading = false
                    }
                }
            },
            enabled = !loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (loading) "Sending..." else "Submit")
        }
    }
}

/* POST JSON sencillo para la pestaña API */
private suspend fun postUser(name: String, email: String): Int = withContext(Dispatchers.IO) {
    val url = URL(API_URL)
    val conn = (url.openConnection() as HttpURLConnection).apply {
        requestMethod = "POST"
        setRequestProperty("Content-Type", "application/json; charset=UTF-8")
        doOutput = true
        connectTimeout = 15000
        readTimeout = 15000
    }

    val body = JSONObject().apply {
        put("name", name)
        put("email", email)
    }.toString()

    BufferedWriter(OutputStreamWriter(conn.outputStream, Charsets.UTF_8)).use {
        it.write(body)
    }

    val code = conn.responseCode
    conn.disconnect()
    code
}

/* -------------------------- Preview opcional -------------------------- */

@Preview(showBackground = true)
@Composable
fun FirebasePreview() {
    ComposeFirebaseGradesTheme {
        Surface { FirebaseGradesScreen(Modifier.fillMaxSize().padding(20.dp)) }
    }
}
