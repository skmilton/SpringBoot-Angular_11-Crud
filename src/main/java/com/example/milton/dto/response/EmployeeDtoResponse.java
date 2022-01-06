package com.example.milton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String nid;
    private String email;
    private String phoneNumber;
    private String jobQualification;
    private String orgName;


    }

