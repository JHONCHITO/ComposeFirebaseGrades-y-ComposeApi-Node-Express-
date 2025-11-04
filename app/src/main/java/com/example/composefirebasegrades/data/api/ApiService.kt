package com.example.composefirebasegrades.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Renombrada de User a ApiUser
data class ApiUser(
    val id: Int? = null,
    val name: String,
    val email: String
)

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(): List<ApiUser> // Actualiza el tipo de retorno

    @POST("api/users")
    suspend fun createUser(@Body user: ApiUser): ApiUser // Actualiza el parámetro y el tipo de retorno
}
