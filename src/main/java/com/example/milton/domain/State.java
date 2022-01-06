package com.example.milton.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "state")
public class State extends BaseEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
