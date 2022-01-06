package com.example.milton.controller;

import com.example.milton.dto.request.StateDtoRequest;
import com.example.milton.dto.response.StateDtoResponse;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService stateInfoService ;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createState(
            @RequestBody @Valid StateDtoRequest stateDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return new ResponseEntity(stateInfoService.createState(stateDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/show/all/list")
    public ResponseEntity<StateDtoResponse> getAllState(){

        return new ResponseEntity(stateInfoService.getAllStateList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<StateDtoResponse> getAllStateById(@PathVariable String id){
        return new ResponseEntity<StateDtoResponse>(stateInfoService.getStateById(id), HttpStatus.OK);


    }
    @PostMapping("/update/state/by/{id}")
    public void updateStateList(@RequestBody StateDtoRequest stateDtoRequest, @PathVariable String id) {
        stateInfoService.updateState(stateDtoRequest, id);
    }
    @DeleteMapping("/delete/stateList/by/{id}")
    public void deleteState(@PathVariable String id ) {
        stateInfoService.deleteState(id);
    }

}
