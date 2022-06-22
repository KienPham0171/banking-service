package com.kienpham.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "approver")
public class Approver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "approver_name")
    private String approverName;
    @ManyToOne
    @JoinColumn(name = "account_info_id")
    private AccountInfo accountInfo;

    public Approver() {
    }

    public Approver(long id, String approverName, AccountInfo accountInfo) {
        this.id = id;
        this.approverName = approverName;
        this.accountInfo = accountInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
