package com.example.mydatabindingtest

import androidx.lifecycle.MutableLiveData
import com.example.mydatabindingtest.model.Employee
import com.example.mydatabindingtest.model.EmployeesData
import com.example.mydatabindingtest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class EmployeeRepository {
    private var employees = ArrayList<Employee>()
    private val mutableLiveData = MutableLiveData<List<Employee>>()

    fun getMutableLiveData(): MutableLiveData<List<Employee>> {

        val userDataService = RetrofitClient.getService()

        val call = userDataService.employees
        call.enqueue(object : Callback<EmployeesData> {
            override fun onResponse(call: Call<EmployeesData>, response: Response<EmployeesData>) {
                val employeeDBResponse = response.body()
                if (employeeDBResponse != null && employeeDBResponse.data != null) {
                    employees = employeeDBResponse.data as ArrayList<Employee>
                    mutableLiveData.setValue(employees)
                }
            }

            override fun onFailure(call: Call<EmployeesData>, t: Throwable) {}
        })

        return mutableLiveData
    }

    companion object {
        private val TAG = "EmployeeRepository"
    }
}