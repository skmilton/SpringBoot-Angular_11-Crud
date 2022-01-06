package com.example.milton.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.milton.serviceIMPL.EmployeeServiceIMPL;
import org.springframework.stereotype.Service;
import com.example.milton.domain.Employee;
import com.example.milton.dto.request.EmployeeDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.repository.EmployeeRepository;
import com.example.milton.util.UuidUtil;
import com.example.milton.dto.response.EmployeeDtoResponse;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class EmployeeInfoService implements EmployeeServiceIMPL {


    private EmployeeRepository employeeRepository;

    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createEmployee(EmployeeDtoRequest employeeDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        Employee employeeInformation = new Employee();

        employeeInformation.setId(id);
        employeeInformation.setFirstName(employeeDtoRequest.getFirstName());
        employeeInformation.setLastName(employeeDtoRequest.getLastName());
        employeeInformation.setEmail(employeeDtoRequest.getEmail());
        employeeInformation.setDob(employeeDtoRequest.getDob());
        employeeInformation.setNid(employeeDtoRequest.getNid());
        employeeInformation.setJobQualification(employeeDtoRequest.getJobQualification());
        employeeInformation.setPhoneNumber(employeeDtoRequest.getPhoneNumber());
        employeeInformation.setOrgName(employeeDtoRequest.getOrgName());

        employeeRepository.saveAndFlush(employeeInformation);
        return new IdentificationResponse();

    }

    @Override
    public List<EmployeeDtoResponse> getAllEmployeeList() {

        List<Employee> employeeInformationList = employeeRepository.findAll();
        List<EmployeeDtoResponse> employeeDtoResponseList = new ArrayList<>();
        for (Employee employeeInformation : employeeInformationList) {

            EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();

            employeeDtoResponse.setId(employeeInformation.getId());
            employeeDtoResponse.setFirstName(employeeInformation.getFirstName());
            employeeDtoResponse.setLastName(employeeInformation.getLastName());
            employeeDtoResponse.setDob(employeeInformation.getDob());
            employeeDtoResponse.setEmail(employeeInformation.getEmail());
            employeeDtoResponse.setNid(employeeInformation.getNid());
            employeeDtoResponse.setJobQualification(employeeInformation.getJobQualification());
            employeeDtoResponse.setPhoneNumber(employeeInformation.getPhoneNumber());
            employeeDtoResponse.setOrgName(employeeInformation.getOrgName());

            employeeDtoResponseList.add(employeeDtoResponse);

        }

        return employeeDtoResponseList;

    }

    @Override
    public EmployeeDtoResponse getEmployeeById(String id) {

        Optional<Employee> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()) {

            throw new RuntimeException("Employee Not Found");
        }

        Employee employeeInformation = employeeInformationOptional.get();

        EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();

        employeeDtoResponse.setId(employeeInformation.getId());
        employeeDtoResponse.setFirstName(employeeInformation.getFirstName());
        employeeDtoResponse.setLastName(employeeInformation.getLastName());
        employeeDtoResponse.setDob(employeeInformation.getDob());
        employeeDtoResponse.setEmail(employeeInformation.getEmail());
        employeeDtoResponse.setNid(employeeInformation.getNid());
        employeeDtoResponse.setPhoneNumber(employeeInformation.getPhoneNumber());
        employeeDtoResponse.setJobQualification(employeeInformation.getJobQualification());
        employeeDtoResponse.setOrgName(employeeInformation.getOrgName());

        return employeeDtoResponse;
    }

    @Override
    public void updateEmployee(EmployeeDtoRequest employeeDtoRequest, String id) {

        Optional<Employee> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()) {
            throw new RuntimeException("Employee Nnnot Found");
        }
        Employee employeeInformation = employeeInformationOptional.get();

        employeeInformation.setId(employeeDtoRequest.getId());
        employeeInformation.setFirstName(employeeDtoRequest.getFirstName());
        employeeInformation.setLastName(employeeDtoRequest.getLastName());
        employeeInformation.setDob(employeeDtoRequest.getDob());
        employeeInformation.setEmail(employeeDtoRequest.getEmail());
        employeeInformation.setNid(employeeDtoRequest.getNid());
        employeeInformation.setPhoneNumber(employeeDtoRequest.getPhoneNumber());
        employeeInformation.setJobQualification(employeeDtoRequest.getJobQualification());
        employeeInformation.setOrgName(employeeDtoRequest.getJobQualification());

        employeeRepository.save(employeeInformation);
    }

    @Override
    public void deleteEmployee(String id) {

        Optional<Employee> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()) {
            throw new RuntimeException("Employee not Found");
        }
        Employee employeeInformation = employeeInformationOptional.get();
        employeeRepository.delete(employeeInformation);

    }

}
