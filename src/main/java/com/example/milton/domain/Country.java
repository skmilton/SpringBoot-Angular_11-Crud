package com.example.milton.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table (name = "country")
public class Country extends BaseEntity{
    private String code;
    private String name;
    private List<State> states;

 }
