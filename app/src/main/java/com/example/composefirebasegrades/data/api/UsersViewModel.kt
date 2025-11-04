package com.example.composefirebasegrades.ui.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefirebasegrades.data.api.User
import com.example.composefirebasegrades.data.api.UsersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface UsersUiState {
    data object Loading : UsersUiState
    data class Success(val data: List<User>) : UsersUiState
    data class Error(val message: String) : UsersUiState
}

class UsersViewModel(
    private val repo: UsersRepository = UsersRepository()
) : ViewModel() {

    private val _state = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val state: StateFlow<UsersUiState> = _state

    fun load() {
        viewModelScope.launch {
            _state.value = UsersUiState.Loading
            try {
                val users = repo.fetchUsers()
                _state.value = UsersUiState.Success(users)
            } catch (e: Exception) {
                _state.value = UsersUiState.Error(e.message ?: "Error")
            }
        }
    }
}
