package com.example.mydatabindingtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mydatabindingtest.model.Employee
import com.example.mydatabindingtest.databinding.ListItemBinding

import java.util.ArrayList

class EmployeeDataAdapter : RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder>() {

    private var employees: ArrayList<Employee>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmployeeViewHolder {
        val employeeListItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.list_item, viewGroup, false
        )
        return EmployeeViewHolder(employeeListItemBinding as ListItemBinding)
    }

    override fun onBindViewHolder(employeeViewHolder: EmployeeViewHolder, i: Int) {
        val currentStudent = employees!![i]
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent)
    }

    override fun getItemCount(): Int {
        return if (employees != null) {
            employees!!.size
        } else {
            0
        }
    }

    fun setEmployeeList(employees: ArrayList<Employee>) {
        this.employees = employees
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(val employeeListItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(employeeListItemBinding.getRoot())
}