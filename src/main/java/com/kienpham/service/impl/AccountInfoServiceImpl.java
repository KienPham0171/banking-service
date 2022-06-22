package com.kienpham.service.impl;

import com.kienpham.domain.AccountInfo;
import com.kienpham.repository.AccountInfoRepository;
import com.kienpham.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Autowired
    private AccountInfoRepository accountInfoRepo;

    @Override
    public List<AccountInfo> findAccountInfoByAccountType(String type) {
        return accountInfoRepo.findAccountInfoByAccountType(type);
    }

    @Override
    public AccountInfo createAccountInfo(AccountInfo ai) {
        return accountInfoRepo.save(ai);
    }

    @Override
    public AccountInfo findAccountInfoByAccountId(String accountId) {
        return accountInfoRepo.findAccountInfoByAccountId(accountId);
    }

    @Override
    public List<AccountInfo> findAllAccountInfo() {
        return accountInfoRepo.findAll();
    }

    @Override
    public Optional<AccountInfo> findAccountInfoById(long id) {
        return accountInfoRepo.findAccountInfoById(id);
    }
}
