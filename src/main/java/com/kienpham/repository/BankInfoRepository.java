package com.kienpham.repository;

import com.kienpham.domain.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankInfoRepository extends JpaRepository<BankInfo,Long> {
    BankInfo findBankInfoByBankName(String bankName);

    BankInfo findBankInfoByBankId(String bankId);
}
