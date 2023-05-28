package com.bengda.quantify.entity.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Position {
    /**
     * 尊嘉资金账号
     */
    private String account;
    /**
     * 交易所 ID:
     *
     * SSE = 上交所
     * SZSE = 深交所
     * HKEX = 港交所
     * US = 美股场内市场
     * USOTC = 美股 OTC 市场
     */
    private String exchange;
    /**
     * 股票或期权代码
     */
    private String symbol;
    /**
     * 成本价
     */
    private BigDecimal cost_px;
    /**
     * 总持仓量
     */
    private BigDecimal total_qty;
    /**
     * 昨持仓量
     */
    private BigDecimal pre_qty;
    /**
     * 已冻结量
     */
    private BigDecimal frozen_qty;
    /**
     * 可平仓
     */
    private BigDecimal closeable_qty;
    /**
     * 交易日 YYYYMMDD
     */
    private String trading_day;
}
