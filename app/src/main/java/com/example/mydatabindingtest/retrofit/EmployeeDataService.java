package com.example.mydatabindingtest.retrofit;

import com.example.mydatabindingtest.model.EmployeesData;

import retrofit2.Call;
import retrofit2.http.GET;
 
public interface EmployeeDataService {
  @GET("users/?per_page=12&amp;page=1")
  Call<EmployeesData> getEmployees();
}