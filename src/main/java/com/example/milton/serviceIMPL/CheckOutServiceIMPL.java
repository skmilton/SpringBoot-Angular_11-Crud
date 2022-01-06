package com.example.milton.serviceIMPL;

import com.example.milton.domain.Purchase;
import com.example.milton.dto.response.PurchaseDtoResponse;

public interface CheckOutServiceIMPL {
    PurchaseDtoResponse placeOrder(Purchase purchase);
}
