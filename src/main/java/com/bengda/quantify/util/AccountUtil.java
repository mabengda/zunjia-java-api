package com.bengda.quantify.util;

import com.bengda.quantify.entity.pojo.Account;
import com.bengda.quantify.entity.response.QueryAccountResponse;
import org.springframework.util.CollectionUtils;

import java.util.Optional;


public class AccountUtil {

    public static Account findBaseAccount(QueryAccountResponse queryAccountResponse) {
        Account result = null;
        if (null != queryAccountResponse && !CollectionUtils.isEmpty(queryAccountResponse.getAccounts())) {
            Optional<Account> first =
                    queryAccountResponse.getAccounts().stream().filter(item -> "BASE".equals(item.getSubtype())).findFirst();
            if (first.isPresent()) {
                result = first.get();
            }
        }
        return result;
    }
}
