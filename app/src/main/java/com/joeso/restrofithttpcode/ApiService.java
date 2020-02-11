package com.joeso.restrofithttpcode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v1/employees")
    Call<List<Employee>> GetEmployeeData();
}