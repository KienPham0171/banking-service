package com.kienpham.service;

import com.kienpham.domain.BankBranch;

public interface BankBranchService {
    BankBranch saveBankBranch(BankBranch bankBranch);
    BankBranch findBankBranchById(long bankBranchId);
}
