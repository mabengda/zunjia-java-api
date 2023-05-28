package com.bengda.quantify.entity.pojo;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Account {
    private String account;          // 资金账户号码
    private String type;             // 账户类型
    private String subtype;          // 账户子类型
    private String currency;         // 币种
    private Double currency_rate;     // 币种汇率
    private String trading_day;    // 交易日
    private BigDecimal pre_balance;   // 昨日结存
    private BigDecimal pre_margin;    // 昨日占用保证金
    private BigDecimal balance;      // 账户总余额
    private BigDecimal frozen;       // 冻结金额
    private BigDecimal available;    // 可用余额
    private BigDecimal credit;       // 账户总授信额度
    private BigDecimal loan_limit;    // 账户可融资金额
    private BigDecimal profit;       // 当日盈亏
    private BigDecimal close_profit;  // 平仓盈亏
    private BigDecimal position_profit; // 持仓盈亏
    private BigDecimal fee;          // 手续费
    private BigDecimal margin;       // 占用保证金
    private BigDecimal ipo;          // 新股申购冻结资金
    private BigDecimal cash;         // 可取余额
    private BigDecimal cash_available; // 可取余额（可取金额-欠款）
    private BigDecimal frozen_fee;    // 冻结手续费
    private BigDecimal frozen_ipo;    // 冻结新股申购资金
    private BigDecimal position_mortgage; // 持仓抵押资金
    private BigDecimal arrears;      // 欠款
}
