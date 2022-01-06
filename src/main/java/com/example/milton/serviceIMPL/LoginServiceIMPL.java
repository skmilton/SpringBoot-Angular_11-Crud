package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.LoginDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.LoginDtoResponse;

import java.util.List;

public interface LoginServiceIMPL {

    public IdentificationResponse createLogin(LoginDtoRequest loginDtoRequest);
    public List<LoginDtoResponse> getAllLoginList();
    public LoginDtoResponse getLoginById(String id);
    public void updateLogin(LoginDtoRequest loginDtoRequest, String id);
    public void deleteLogin(String id);
}
