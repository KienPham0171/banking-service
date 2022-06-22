package com.kienpham.service.impl;

import com.kienpham.domain.BankBranch;
import com.kienpham.repository.BankBranchRepository;
import com.kienpham.service.BankBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBranchServiceImpl implements BankBranchService {
    @Autowired private BankBranchRepository bankBranchRepository;


    @Override
    public BankBranch saveBankBranch(BankBranch bankBranch) {
        return bankBranchRepository.save(bankBranch);
    }

    @Override
    public BankBranch findBankBranchById(long bankBranchId) {
        return bankBranchRepository.findBankBranchById(bankBranchId);
    }
}
