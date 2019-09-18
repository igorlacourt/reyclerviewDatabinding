package com.example.mydatabindingtest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EmployeesData(
    @SerializedName("data")
    @Expose
    val data: List<Employee>,
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("per_page")
    @Expose
    val per_page: Int,
    @SerializedName("total")
    @Expose
    val total: Int,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int
)