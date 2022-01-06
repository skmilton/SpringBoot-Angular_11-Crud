package com.example.milton.dto.response;

import com.example.milton.domain.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDtoResponse {
    private String id;
    private String code;
    private String name;
    private List<State> states;
}
