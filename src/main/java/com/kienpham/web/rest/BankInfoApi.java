package com.kienpham.web.rest;

import com.kienpham.domain.BankInfo;
import com.kienpham.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BankInfoApi {

    @Autowired private BankInfoService bankInfoService;

    @GetMapping("/bankInfoes/{id}")
    public BankInfo getBankInfoById(@PathVariable(name = "id") long id){
        return bankInfoService.findBankInfoById(id).get();
    }


    @PostMapping("/bankInfoes")
    public Object createBankInfo(@RequestBody BankInfo bi){
        if(bankInfoService.findBankInfoByBankId(bi.getBankId())!= null)
            return ResponseEntity.status(303).body("This resource has been existed");
        return bankInfoService.createBankInfo(bi);
    }
}
