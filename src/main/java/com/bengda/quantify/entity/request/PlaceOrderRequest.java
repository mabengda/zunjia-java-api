package com.bengda.quantify.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 下单请求实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {
    /**
     * 订单ID
     * 最长31个字符，由API调用者赋值的订单ID，尽量保证唯一性，后台不做检查
     */
    private String clord_id;

    /**
     * 交易所ID
     * SSE = 上交所
     * SZSE = 深交所
     * HKEX = 港交所
     * US = 美股场内市场
     * USOTC = 美股OTC市场
     */
    private String exchange;

    /**
     * 股票或期权代码
     * 美股代码要大写，如BABA
     * 港股代码为5位数字，如01810
     */
    private String symbol;

    /**
     * 买卖方向
     * BUY = 买入
     * SELL = 卖出
     */
    private String side;

    /**
     * 开平标志，不填或空字符串时，根据side后台自动赋值
     * OPEN = 开仓
     * CLOSE = 平仓
     */
    private String open_close;

    /**
     * 委托量
     */
    private BigDecimal qty;

    /**
     * 订单类型
     * Market = 市价
     * Limit = 限价
     * Limit-E = 增强限价(用于港交所)
     * 港股竞价单 type=Market 同时 tif=AC
     * 港股竞价限价单 type= Limit 同时 tif=AC
     * 港股特别限价单 type= Limit 同时 tif=IOC
     */
    private String type;

    /**
     * 委托价格，当type等于Limit或Limit-E时，需要赋值
     */
    private BigDecimal price;

    /**
     * Time In Force，默认DAY
     * DAY = 当日有效
     * IOC = 立即成交剩余部分被撤单
     * AC = 集合竞价期间有效，包含开盘前和收盘前的竞价
     */
    private String tif;

    /**
     * 允许美股参与盘前盘后交易
     * YES = 允许
     * 不填或其他字符串表示不允许
     */
    private String allow_eth;
}