package com.example.milton.service;

import com.example.milton.domain.*;
import com.example.milton.domain.Login;
import com.example.milton.domain.Login;
import com.example.milton.domain.Login;
import com.example.milton.dto.request.LoginDtoRequest;
import com.example.milton.dto.response.LoginDtoResponse;
import com.example.milton.dto.response.LoginDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.LoginDtoResponse;
import com.example.milton.repository.LoginRepository;
import com.example.milton.serviceIMPL.LoginServiceIMPL;
import com.example.milton.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class LoginService implements LoginServiceIMPL {
    private LoginRepository loginRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createLogin(LoginDtoRequest loginDtoRequest) {
        String id = uuidUtil.getUuidUtil();

        Login loginInformation = new Login();

        loginInformation.setId(id);
        BeanUtils.copyProperties(loginDtoRequest, loginInformation);
        loginRepository.saveAndFlush(loginInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<LoginDtoResponse> getAllLoginList() {
        List<Login> loginInformationList = loginRepository.findAll();
        List<LoginDtoResponse> loginDtoResponseList = new ArrayList<>();
        for (Login loginInformation : loginInformationList) {
            LoginDtoResponse loginDtoResponse = new LoginDtoResponse();

            loginDtoResponse.setEmail(loginInformation.getEmail());
            loginDtoResponse.setPassword(loginInformation.getPassword());
        }
        return loginDtoResponseList;
    }

    @Override
    public LoginDtoResponse getLoginById(String id) {
        Optional<Login> loginOptional = loginRepository.findAllById(id);

        if (!loginOptional.isPresent()) {
            throw new RuntimeException("Login Not Found");
        }

        Login loginInformation = loginOptional.get();

        LoginDtoResponse loginDtoResponse = new LoginDtoResponse();

        loginDtoResponse.setEmail(loginInformation.getEmail());
        loginDtoResponse.setPassword(loginInformation.getPassword());
        return loginDtoResponse;
    }

    @Override
    public void updateLogin(LoginDtoRequest loginDtoRequest, String id) {

        Optional<Login> loginInformationOptional = loginRepository.findAllById(id);

        if (!loginInformationOptional.isPresent()) {
            throw new RuntimeException("Login Nnnot Found");
        }
        Login loginInformation = loginInformationOptional.get();

        loginInformation.setEmail(loginDtoRequest.getEmail());
        loginInformation.setPassword(loginDtoRequest.getPassword());
        loginRepository.save(loginInformation);
    }


    @Override
    public void deleteLogin(String id) {
        Optional<Login> loginInformationOptional = loginRepository.findAllById(id);
        if (!loginInformationOptional.isPresent()) {
            throw new RuntimeException("Login not Found");

        }
        Login loginInformation = loginInformationOptional.get();
        loginRepository.delete(loginInformation);
    }
}
