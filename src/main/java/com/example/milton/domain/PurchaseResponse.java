package com.example.milton.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {

    @NonNull
    private String orderTrackingNumber;
}

