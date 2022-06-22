package com.kienpham.repository;

import com.kienpham.domain.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch,Long> {
    BankBranch findBankBranchByBranchId(String bankBranchId);

    BankBranch findBankBranchById(long bankBranchId);
}
