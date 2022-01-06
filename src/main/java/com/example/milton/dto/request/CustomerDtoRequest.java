package com.example.milton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDtoRequest {
    private String id;
    private String customerName;
    private String address;
    private String mobile;
    private String email;
    private String password;
}
