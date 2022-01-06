package com.example.milton.service;

import com.example.milton.domain.State;
import com.example.milton.dto.request.StateDtoRequest;
import com.example.milton.dto.request.StateDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.StateDtoResponse;
import com.example.milton.dto.response.StateDtoResponse;
import com.example.milton.repository.StateRepository;
import com.example.milton.serviceIMPL.StateServiceIMPL;
import com.example.milton.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class StateService implements StateServiceIMPL {
    private StateRepository stateRepository;
    private UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createState(StateDtoRequest stateDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        State stateInformation = new State();
        stateInformation.setId(id);

        /*Bean Util Sob Entity thaka Sob nea asa*/
         BeanUtils.copyProperties(stateDtoRequest,stateInformation );

        stateRepository.saveAndFlush(stateInformation);

        return new IdentificationResponse(id);
    }

    @Override
    public List<StateDtoResponse> getAllStateList() {
//
        List<State> stateList = stateRepository.findAll();
        List<StateDtoResponse> stateDtoResponseList = new ArrayList<>();
        for (State state : stateList) {
            StateDtoResponse stateDtoResponse = new StateDtoResponse();

            stateDtoResponse.setId(state.getId());
            stateDtoResponse.setName(state.getName());

            stateDtoResponseList.add(stateDtoResponse);
        }

        return stateDtoResponseList;
    }

    @Override
    public StateDtoResponse getStateById(String id) {

        Optional<State> stateOptional = stateRepository.findAllById(id);

        if (!stateOptional.isPresent()) {
            throw new RuntimeException("State not Found");
        }
        State stateinfo = stateOptional.get();
        StateDtoResponse stateDtoResponse = new StateDtoResponse();

        stateDtoResponse.setId(stateinfo.getId());
      //  stateDtoResponse.setCountry(stateinfo.getCountry());
        stateDtoResponse.setName(stateinfo.getName());

        return stateDtoResponse;
    }

    @Override
    public void updateState(StateDtoRequest stateDtoRequest, String id) {

        Optional<State> stateOptional = stateRepository.findAllById(id);
        if (!stateOptional.isPresent()) {
            throw new RuntimeException("State not Found");
        }
        State stateinfo = stateOptional.get();
        BeanUtils.copyProperties(stateDtoRequest, stateOptional);
        stateRepository.save(stateinfo);
    }

    @Override
    public void deleteState(String id) {
        Optional<State> stateOptional = stateRepository.findAllById(id);
        if (!stateOptional.isPresent()) {
            throw new RuntimeException("State Not Found");
        }
        State stateinfo = stateOptional.get();
        stateRepository.delete(stateinfo);
    }
}
