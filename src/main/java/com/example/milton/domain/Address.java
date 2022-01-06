package com.example.milton.domain;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    private String country;
    private String city;
    private String state;
    private String street;
    private String zipCode;
   @OneToOne
   @PrimaryKeyJoinColumn
   private Order order;
}
