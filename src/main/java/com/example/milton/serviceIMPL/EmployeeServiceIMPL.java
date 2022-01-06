package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.EmployeeDtoRequest;
import com.example.milton.dto.response.EmployeeDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;

import java.util.List;

public interface EmployeeServiceIMPL {
    public IdentificationResponse createEmployee(EmployeeDtoRequest employeeDtoRequest);
    public List<EmployeeDtoResponse> getAllEmployeeList();
    public EmployeeDtoResponse getEmployeeById(String id);
    public void updateEmployee(EmployeeDtoRequest employeeDtoRequest, String id);
    public void deleteEmployee(String id);

}

