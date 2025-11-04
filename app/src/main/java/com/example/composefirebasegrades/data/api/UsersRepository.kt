package com.example.composefirebasegrades.data.api

class UsersRepository(
    private val api: ApiService = RetrofitClient.api
) {
    suspend fun fetchUsers(): List<User> {
        // 1. Fetch the list of ApiUser from the network
        val apiUsers = api.getUsers()

        // 2. Convert (map) each ApiUser to a User object
        return apiUsers.map { apiUser ->
            User(
                // Assuming your User class has these properties.
                // Adjust them to match your actual User data class.
                id = apiUser.id,
                name = apiUser.name,
                email = apiUser.email
                // Copy any other relevant fields from apiUser to User
            )
        }
    }
}
