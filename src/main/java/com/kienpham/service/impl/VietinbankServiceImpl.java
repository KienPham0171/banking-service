package com.kienpham.service.impl;

import com.kienpham.domain.AccountInfo;
import com.kienpham.domain.Record;
import com.kienpham.domain.VietinBodyReq;
import com.kienpham.domain.requestObj.PaymentReq;
import com.kienpham.service.AccountInfoService;
import com.kienpham.service.VietinbankService;
import com.kienpham.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class VietinbankServiceImpl implements VietinbankService {
    @Value("${vietinbank.config.model}")
    private String model;
    @Value("${vietinbank.config.providerId}")
    private String providerId;
    @Value("${vietinbank.config.version}")
    private int version;
    @Value("${vietinbank.config.softwareProviderId}")
    private String softwareProviderId;
    @Value("${vietinbank.config.language}")
    private String language;
    @Value("${vietinbank.config.approver}")
    private String approver;
    @Value("${vietinbank.config.channel}")
    private String channel;
    @Value("${vietinbank.config.clientIP}")
    private String clientIP;
    @Value("${vietinbank.config.appointedApprover}")
    private String appointedApprover;
    @Value("${vietinbank.config.feeType}")
    private String feeType;
    @Value("${vietinbank.headers.x-ibm-client-secret}")
    private String clientSecret;
    @Value("${vietinbank.headers.x-ibm-client-id}")
    private String clientId;
    @Value("${vietinbank.payment.url}")
    private String paymentUrl;
    @Value("${vietinbank.key.aladin-private-key-path}")
    private String aladinPrivateKeyPath;

    @Autowired private AccountInfoService accountInfoService;
    @Override
    public Object createPayment(PaymentReq paymentReq) {


        List<Record> listRecords = createListRecords(paymentReq);
        VietinBodyReq vietinBody = new VietinBodyReq();
        vietinBody.setModel(model);
        vietinBody.setRequestId("kienAladin"+ generateId());
        vietinBody.setProviderId(providerId);
        vietinBody.setMerchantId(null);
        vietinBody.setPriority(3);
        vietinBody.setVersion(version);
        vietinBody.setSoftwareProviderId(softwareProviderId);
        vietinBody.setLanguage(language);
        vietinBody.setAppointedApprover(appointedApprover);
        AccountInfo budgetAccount = accountInfoService.findAccountInfoById(paymentReq.getBudgetAccountId()).get();
        String feeAccount = budgetAccount.getAccountId();
        vietinBody.setFeeAccount(feeAccount);
        vietinBody.setFeeType(feeType);
        vietinBody.setScheduledDate(null);
        vietinBody.setApprover(approver);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(date);

        vietinBody.setTransTime(strDate);
        vietinBody.setChannel(channel);
        vietinBody.setClientIP(clientIP);

        //test signature
        vietinBody.setSignature("");

        vietinBody.setRecords(listRecords);

        String signatureData = vietinBody.getSignatureData();
        String signature =SignatureUtil.signData(signatureData,aladinPrivateKeyPath);
        vietinBody.setSignature(signature);

       //System.err.println(vietinBody.toString());

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ibm-client-secret",clientSecret);
        headers.set("x-ibm-client-id",clientId);


        HttpEntity<VietinBodyReq> entity = new HttpEntity<>(vietinBody,headers);
        ResponseEntity<String> response = rest.exchange(paymentUrl, HttpMethod.POST,entity,String.class);
        //var response =rest.postForObject(paymentUrl,entity,String.class);
        String result = response.getBody();
        System.err.println(response);


       return null;
    }

    private List<Record> createListRecords(PaymentReq paymentReq){
        System.err.println("id: "+ paymentReq.getBudgetAccountId() );
        AccountInfo budgetAccount = accountInfoService.findAccountInfoById(paymentReq.getBudgetAccountId()).get();
        return paymentReq.getListSubPayments().stream().map(item ->{
            AccountInfo targetAccount = accountInfoService.findAccountInfoById(item.getTargetAccountId()).get();
            double amount = item.getAmount();
            String remark = item.getRemark();


            Record record = new Record();
            record.setTransId("aladinTech"+generateId() );
            record.setApprover("aladinpheduyet");
            if(budgetAccount.getBankInfo().getId() == targetAccount.getBankInfo().getId()){
                record.setTransType("in");
            }else{
                record.setTransType("ou");
            }
            record.setAmount(amount);
            record.setRecvAcctId(targetAccount.getAccountId());
            record.setRecvBankId(targetAccount.getBankBranch().getBranchId());
            record.setRecvBranchId(targetAccount.getBankBranch().getBranchId());
            record.setRecvAcctName(targetAccount.getBankBranch().getBranchName());
            record.setRecvAcctName(targetAccount.getAccountName());
            record.setRecvAddr(targetAccount.getAccountAddress());
            record.setRecvPhoneNo(targetAccount.getAccountPhone());
            record.setCurrencyCode("VND");
            record.setRemark(remark);
            record.setSenderBankId(budgetAccount.getBankBranch().getBranchId());
            record.setSenderBranchId(budgetAccount.getBankBranch().getBranchId());
            record.setSenderAddr(budgetAccount.getAccountAddress());
            record.setSenderAcctName(budgetAccount.getAccountName());
            record.setSenderAcctId(budgetAccount.getAccountId());
            return record;
        }).collect(Collectors.toList());
    }
    private String generateId (){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        Random rd = new Random();
        int rdNumber = rd.nextInt(20000);
        return "_"+day+month+rdNumber;
    }
}
