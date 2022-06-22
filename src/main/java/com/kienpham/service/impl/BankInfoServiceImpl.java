package com.kienpham.service.impl;

import com.kienpham.domain.BankInfo;
import com.kienpham.repository.BankInfoRepository;
import com.kienpham.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankInfoServiceImpl implements BankInfoService {
    @Autowired private BankInfoRepository bankInfoRepository;

    @Override
    public Optional<BankInfo> findBankInfoById(long id) {
        return bankInfoRepository.findById(id);
    }

    @Override
    public BankInfo createBankInfo(BankInfo bi) {
        return bankInfoRepository.save(bi);
    }

    @Override
    public BankInfo findBankInfoByBankName(String bankName) {
        return bankInfoRepository.findBankInfoByBankName(bankName);
    }

    @Override
    public BankInfo findBankInfoByBankId(String bankId) {
        return bankInfoRepository.findBankInfoByBankId(bankId);
    }


}
