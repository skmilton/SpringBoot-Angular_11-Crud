package com.example.milton.dto.response;

import com.example.milton.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StateDtoResponse {

    private String id;
    private String name;
    private Country country;
}
