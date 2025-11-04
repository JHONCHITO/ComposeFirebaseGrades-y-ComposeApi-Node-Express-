package com.example.composefirebasegrades.data.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

class FirestoreService(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val col = db.collection("grades")

    suspend fun addStudent(name: String, email: String, grade: Int): String {
        val doc = col.add(
            mapOf(
                "name" to name,
                "email" to email,
                "grade" to grade,
                "createdAt" to System.currentTimeMillis()
            )
        ).await()
        return doc.id
    }

    suspend fun getStudents(): List<Student> {
        val snap = col.orderBy("createdAt", Query.Direction.DESCENDING).get().await()
        return snap.documents.map {
            Student(
                id = it.id,
                name = it.getString("name") ?: "",
                email = it.getString("email") ?: "",
                grade = (it.getLong("grade") ?: 0).toInt()
            )
        }
    }
}
