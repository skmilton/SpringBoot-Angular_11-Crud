package com.example.milton.dto.request;

import com.example.milton.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StateDtoRequest {

    private String id;
    private String name;
    private Country country;
}
