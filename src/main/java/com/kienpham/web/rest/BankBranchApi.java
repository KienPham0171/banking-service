package com.kienpham.web.rest;

import com.kienpham.domain.BankBranch;
import com.kienpham.domain.requestObj.BankBranchReq;
import com.kienpham.service.BankBranchService;
import com.kienpham.service.mapper.BankBranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BankBranchApi {
    @Autowired
    private BankBranchService bankBranchService;
    @Autowired private BankBranchMapper bankBranchMapper;

    @PostMapping("/bankBranches")
    public BankBranch createBankBranch(@RequestBody BankBranchReq bbr){
        return bankBranchService.saveBankBranch(bankBranchMapper.bankBranchReqToBankBranch(bbr));
    }
}
