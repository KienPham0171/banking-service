package com.kienpham.service;

import com.kienpham.domain.AccountInfo;
import io.undertow.security.idm.Account;

import java.util.List;
import java.util.Optional;

public interface AccountInfoService {
    List<AccountInfo> findAccountInfoByAccountType(String type);
    AccountInfo createAccountInfo(AccountInfo ai);
    AccountInfo findAccountInfoByAccountId(String accountId);

    List<AccountInfo> findAllAccountInfo();
    Optional<AccountInfo> findAccountInfoById(long id);
}
