package com.example.milton.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "login")
public class Login extends BaseEntity{
    private String email;
    private String password;
}
