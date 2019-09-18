package com.example.mydatabindingtest

import com.example.mydatabindingtest.model.Employee
import androidx.lifecycle.LiveData
import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val employeeRepository: EmployeeRepository

    val allEmployee: LiveData<List<Employee>>
        get() = employeeRepository.getMutableLiveData()

    init {
        employeeRepository = EmployeeRepository()
    }
}