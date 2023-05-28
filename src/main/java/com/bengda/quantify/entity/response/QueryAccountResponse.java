package com.bengda.quantify.entity.response;

import com.bengda.quantify.entity.pojo.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryAccountResponse {

    private List<Account> accounts;
}
