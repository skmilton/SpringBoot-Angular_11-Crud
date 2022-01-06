package com.example.milton.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.milton.service.EmployeeInfoService;

import lombok.AllArgsConstructor;

import com.example.milton.dto.request.EmployeeDtoRequest;
import com.example.milton.dto.response.EmployeeDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;



@AllArgsConstructor
@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
    private EmployeeInfoService employeeInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse>createEmployee(
    	@RequestBody @Valid	EmployeeDtoRequest employeeDtoRequest,BindingResult bindingResult, 
    	HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
    	
    	return new ResponseEntity(employeeInfoService.createEmployee(employeeDtoRequest),HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
public ResponseEntity<EmployeeDtoResponse> getAllEmployee(){
	
	return new ResponseEntity(employeeInfoService.getAllEmployeeList(), HttpStatus.OK);
}
    
    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<EmployeeDtoResponse> getAllEmployeeById(@PathVariable String id){
		return new ResponseEntity<EmployeeDtoResponse>(employeeInfoService.getEmployeeById(id), HttpStatus.OK);
    	
    	
    }
    @PostMapping("/update/employee/by/{id}")
    public void updateEmployeeList(@RequestBody EmployeeDtoRequest employeeDtoRequest, @PathVariable String id) {
    	employeeInfoService.updateEmployee(employeeDtoRequest, id);
    }
    @DeleteMapping("/delete/employeeList/by/{id}")
    public void deleteEmployee(@PathVariable String id ) {
		employeeInfoService.deleteEmployee(id);
	}
    
}
