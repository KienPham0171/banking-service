package com.kienpham.service.mapper;

import com.kienpham.domain.AccountInfo;
import com.kienpham.domain.BankBranch;
import com.kienpham.domain.BankInfo;
import com.kienpham.domain.requestObj.AccountInfoReq;
import com.kienpham.service.AccountInfoService;
import com.kienpham.service.BankBranchService;
import com.kienpham.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountInfoMapper {
    @Autowired private BankInfoService bankInfoService;
    @Autowired private BankBranchService bankBranchService;
    public AccountInfo mapAccountInfoReqToAccountInfo(AccountInfoReq aq){
        Optional<BankInfo> bankInfo = bankInfoService.findBankInfoById(aq.getBankInfoId());
        BankBranch bankBranch = bankBranchService.findBankBranchById(aq.getBankBranchId());
        // bankBranch not belong to bankInfo (ex: Vietcombank Branch, VietinBank Info)
        if(bankBranch.getBankInfo().getId() != bankInfo.get().getId())
            return null;
        return new AccountInfo(aq.getId(),aq.getAccountId(),aq.getAccountAddress(),aq.getAccountName(),
                                                aq.getAccountPhone(),aq.getAccountType(),bankInfo.get(),bankBranch);
    }
}
