package com.bengda.quantify.schedule;

import com.bengda.quantify.client.OrderHttpApi;
import com.bengda.quantify.entity.request.QueryAccountRequest;
import com.bengda.quantify.entity.pojo.Account;
import com.bengda.quantify.entity.response.QueryAccountResponse;
import com.bengda.quantify.util.AccountUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class QueryAccountTask {

    @Resource
    private OrderHttpApi orderHttpApi;

    @Scheduled(cron = "*/2 * * * * *")
    private void queryAccount(){
        System.out.println("start!");
        QueryAccountResponse queryAccountResponse = orderHttpApi.queryAccount(QueryAccountRequest.builder().currency("").build());
        Account baseAccount = AccountUtil.findBaseAccount(queryAccountResponse);
        System.out.printf("账户：%s\n总余额：%s\n可用余额：%s%n",baseAccount.getAccount(),baseAccount.getBalance().toString(),baseAccount.getAvailable().toString());
        System.out.println("end!");
    }
}
