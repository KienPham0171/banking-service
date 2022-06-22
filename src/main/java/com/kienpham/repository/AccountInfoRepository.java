package com.kienpham.repository;

import com.kienpham.domain.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo,Long> {
    List<AccountInfo> findAccountInfoByAccountType(String accountType);

    AccountInfo findAccountInfoByAccountId(String accountId);

    Optional<AccountInfo> findAccountInfoById(long id);
}
