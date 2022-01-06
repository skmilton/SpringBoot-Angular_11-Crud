package com.example.milton.dto.request;

import com.example.milton.domain.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDtoRequest {

    private String id;
    private String code;
    private String name;
    private List<State> states;
}

