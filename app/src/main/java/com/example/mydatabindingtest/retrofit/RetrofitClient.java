package com.example.mydatabindingtest.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static Retrofit retrofit;
  private static final String BASE_URL = "https://reqres.in/api/";
 
  public static EmployeeDataService getService() {
    if (retrofit == null) {
      retrofit = new Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
 
    return retrofit.create(EmployeeDataService.class);
  }
}