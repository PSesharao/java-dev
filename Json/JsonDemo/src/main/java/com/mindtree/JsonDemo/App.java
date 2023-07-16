package com.mindtree.JsonDemo;

import com.google.gson.Gson;
import com.mindtree.JsonDemo.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        Employee employee = app.createEmployee();
        Gson gson = new Gson();
        String employeeJson = gson.toJson(employee);
        System.out.println(employeeJson);
        
        String empJson = "{\"firstName\":\"Todd\",\"lastName\":\"Grover\",\"gender\":\"Male\",\"salary\":5000}";
        		
        Employee employeeObject = gson.fromJson(empJson, Employee.class);
        
        System.out.println(employeeObject);
    }
    
    private Employee createEmployee()
    {
    	Employee employee = new Employee();
    	employee.setFirstName("Todd");
    	employee.setLastName("Grover");
    	employee.setGender("Male");
    	employee.setSalary(5000);
    	return employee;
    }
    
}
