package com.example.milton.serviceIMPL;

import com.example.milton.dto.request.StateDtoRequest;
import com.example.milton.dto.response.IdentificationResponse;
import com.example.milton.dto.response.StateDtoResponse;

import java.util.List;

public interface StateServiceIMPL {
    public IdentificationResponse createState(StateDtoRequest stateDtoRequest);
    public List<StateDtoResponse> getAllStateList();
    public StateDtoResponse getStateById(String id);
    public void updateState(StateDtoRequest stateDtoRequest, String id);
    public void deleteState(String id);
    
}
