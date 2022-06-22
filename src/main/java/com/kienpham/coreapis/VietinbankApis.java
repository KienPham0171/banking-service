package com.kienpham.coreapis;

import com.kienpham.domain.requestObj.PaymentReq;
import com.kienpham.service.VietinbankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class VietinbankApis {
    @Autowired private VietinbankService vietinbankService;
    @PostMapping("/payments")
    public Object createPayment(@RequestBody PaymentReq paymentReq){
        return vietinbankService.createPayment(paymentReq);
    }
}
