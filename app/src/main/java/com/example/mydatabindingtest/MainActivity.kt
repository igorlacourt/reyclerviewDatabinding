package com.example.mydatabindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.mydatabindingtest.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydatabindingtest.model.Employee







class MainActivity : AppCompatActivity() {
    private var mainViewModel: MainViewModel? = null
    private var employeeDataAdapter: EmployeeDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

// bind RecyclerView
        val recyclerView = activityMainBinding.viewEmployees
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        employeeDataAdapter = EmployeeDataAdapter()
        recyclerView.setAdapter(employeeDataAdapter)
        getAllEmployee()
    }

    private fun getAllEmployee() {
        mainViewModel!!.allEmployee.observe(this, Observer {
            employeeDataAdapter?.setEmployeeList(it as ArrayList<Employee>)
        })
    }
}
