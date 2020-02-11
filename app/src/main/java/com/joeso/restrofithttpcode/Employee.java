package com.joeso.restrofithttpcode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Employee implements Serializable {
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("employee_name")
    private String employeeName;
    @SerializedName("employee_salary")
    private String employeeSalary;
    @SerializedName("id")
    private String id;
    @SerializedName("employee_age")
    private String employeeAge;

    public void setProfileImage(String profileImage){
        this.profileImage = profileImage;
    }
    public String getProfileImage(){
        return profileImage;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public void setEmployeeSalary(String employeeSalary){
        this.employeeSalary = employeeSalary;
    }
    public String getEmployeeSalary(){
        return employeeSalary;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setEmployeeAge(String employeeAge){
        this.employeeAge = employeeAge;
    }
    public String getEmployeeAge(){
        return employeeAge;
    }
}