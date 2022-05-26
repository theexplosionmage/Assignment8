package com.example.retrofittest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment8.Model
import com.example.assignment8.repository.Repository

class Factory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Model(repository) as T
    }
}