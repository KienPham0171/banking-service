package com.kienpham.service;

import com.kienpham.domain.BankInfo;

import java.util.Optional;

public interface BankInfoService {
    Optional<BankInfo> findBankInfoById(long id);

    BankInfo createBankInfo(BankInfo bi);

    BankInfo findBankInfoByBankName(String bankName);
    BankInfo findBankInfoByBankId(String bankId);
}
