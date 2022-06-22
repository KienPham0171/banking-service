package com.kienpham.service.mapper;

import com.kienpham.domain.BankBranch;
import com.kienpham.domain.BankInfo;
import com.kienpham.domain.requestObj.BankBranchReq;
import com.kienpham.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankBranchMapper {
    @Autowired
    BankInfoService bankInfoService;
    public BankBranch bankBranchReqToBankBranch(BankBranchReq bbr){
        System.err.println("bankInfoId: " +bbr.getBankId());
        BankInfo bankInfo = bankInfoService.findBankInfoById(bbr.getBankId()).get();
        if(bankInfo != null) {
            return new BankBranch(bbr.getBranchId(),bankInfo,bbr.getBranchName(),bbr.getBranchAddress());
        }else{
            return null;
        }
    }
}
