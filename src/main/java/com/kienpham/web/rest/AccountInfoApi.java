package com.kienpham.web.rest;

import com.kienpham.domain.AccountInfo;
import com.kienpham.domain.requestObj.AccountInfoReq;
import com.kienpham.service.AccountInfoService;
import com.kienpham.service.mapper.AccountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountInfoApi {
    @Autowired
    private AccountInfoService accountInfoService;
    @Autowired private AccountInfoMapper accountInfoMapper;
    @GetMapping("/accountInfoes/{type}")
    public List<AccountInfo> getAccountInfos(@PathVariable(name = "type") String type){
        return accountInfoService.findAccountInfoByAccountType(type) ;
    }
    @GetMapping("/accountInfoes")
    public List<AccountInfo> getAllAccountInfos(){
        return accountInfoService.findAllAccountInfo() ;
    }
    @PostMapping("/accountInfoes")
    public Object createAccountInfo(@RequestBody AccountInfoReq ai){
        if(accountInfoService.findAccountInfoByAccountId(ai.getAccountId())!= null)
            return ResponseEntity.status(303).body("This resource has been existed");
        return accountInfoService.createAccountInfo(accountInfoMapper.mapAccountInfoReqToAccountInfo(ai));
    }
}
