package com.kienpham.domain;

import java.util.Date;
import java.util.List;

public class VietinBodyReq {
    private String model;
    private String requestId;
    private String providerId;
    private String merchantId;
    private int priority;
    private int version;
    private String softwareProviderId;
    private String language;
    private String appointedApprover;
    private String feeAccount;
    private String feeType;
    private Date scheduledDate;
    private String approver;
    private String transTime;
    private String channel;
    private String clientIP;
    private String signature;
    private List<Record> records;

    public VietinBodyReq(String model, String requestId, String providerId, String merchantId,
                         int priority, int version, String softwareProviderId, String language, String appointedApprover,
                         String feeAccount, String feeType, Date scheduledDate, String approver,
                         String transTime, String channel, String clientIP, String signature, List<Record> records) {
        this.model = model;
        this.requestId = requestId;
        this.providerId = providerId;
        this.merchantId = merchantId;
        this.priority = priority;
        this.version = version;
        this.softwareProviderId = softwareProviderId;
        this.language = language;
        this.appointedApprover = appointedApprover;
        this.feeAccount = feeAccount;
        this.feeType = feeType;
        this.scheduledDate = scheduledDate;
        this.approver = approver;
        this.transTime = transTime;
        this.channel = channel;
        this.clientIP = clientIP;
        this.signature = signature;
        this.records = records;
    }

    public VietinBodyReq() {
    }


    public String getSignatureData(){
        StringBuilder result= new StringBuilder();
        result.append(requestId);
        result.append(providerId);
        result.append(merchantId);
        result.append(model);
        result.append(priority);
        result.append(softwareProviderId);
        result.append(appointedApprover);
        result.append(feeAccount);
        result.append(feeType);
        result.append(scheduledDate);
        result.append(approver);
        for(Record r : records){
            result.append(r.getTransId());
            result.append(r.getSenderAcctId());
            result.append(r.getRecvAcctId());
            result.append(r.getAmount());
        }
        result.append(transTime);
        result.append(channel);
        result.append(version);
        result.append(clientIP);
        result.append(language);
        return result.toString();
    }
    @Override
    public String toString() {
        return "VietinBodyReq{" +
            "model='" + model + '\'' +
            ", requestId='" + requestId + '\'' +
            ", providerId='" + providerId + '\'' +
            ", merchantId='" + merchantId + '\'' +
            ", priority=" + priority +
            ", version=" + version +
            ", softwareProviderId='" + softwareProviderId + '\'' +
            ", language='" + language + '\'' +
            ", appointedApprover='" + appointedApprover + '\'' +
            ", feeAccount='" + feeAccount + '\'' +
            ", feeType='" + feeType + '\'' +
            ", scheduledDate=" + scheduledDate +
            ", approver='" + approver + '\'' +
            ", transTime='" + transTime + '\'' +
            ", channel='" + channel + '\'' +
            ", clientIP='" + clientIP + '\'' +
            ", signature='" + signature + '\'' +
            ", records=" + records +
            '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSoftwareProviderId() {
        return softwareProviderId;
    }

    public void setSoftwareProviderId(String softwareProviderId) {
        this.softwareProviderId = softwareProviderId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAppointedApprover() {
        return appointedApprover;
    }

    public void setAppointedApprover(String appointedApprover) {
        this.appointedApprover = appointedApprover;
    }

    public String getFeeAccount() {
        return feeAccount;
    }

    public void setFeeAccount(String feeAccount) {
        this.feeAccount = feeAccount;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
