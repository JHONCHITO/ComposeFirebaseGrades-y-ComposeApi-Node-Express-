package com.example.composefirebasegrades.ui.firebase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefirebasegrades.data.firebase.FirestoreService
import com.example.composefirebasegrades.data.firebase.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudentsViewModel(
    private val service: FirestoreService = FirestoreService()
) : ViewModel() {

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students

    fun load() = viewModelScope.launch {
        _students.value = service.getStudents()
    }

    fun add(name: String, email: String, grade: Int) = viewModelScope.launch {
        service.addStudent(name, email, grade)
        _students.value = service.getStudents()
    }
}
