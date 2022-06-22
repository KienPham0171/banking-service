package com.kienpham.service;

import com.kienpham.domain.requestObj.PaymentReq;

public interface VietinbankService {
    Object createPayment(PaymentReq paymentReq);
}
