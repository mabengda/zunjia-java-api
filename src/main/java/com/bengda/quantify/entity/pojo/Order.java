package com.bengda.quantify.entity.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    /**
     * 尊嘉资金账号
     */
    private String account;

    /**
     * 由 API 调用者下单时赋值的订单 ID
     */
    private String clord_id;

    /**
     * 尊嘉交易系统生成的订单 ID，如“0000206243”
     */
    private String order_id;

    /**
     * 交易所 ID
     */
    private String exchange;

    /**
     * 股票或期权代码
     */
    private String symbol;
    /**
     * 订单类型: Market = 市价; Limit = 限价; Limit-E = 增强限价(用于港交所)
     */
    private String type;
    /**
     * 买卖方向: BUY = 买入; SELL = 卖出
     */
    private String side;
    /**
     * 开平标志: OPEN = 开仓; CLOSE = 平仓
     */
    private String open_close;
    /**
     * 委托价格
     */
    private BigDecimal price;
    /**
     * 委托数量
     */
    private BigDecimal qty;
    /**
     * PENDING = 正报，尊嘉交易系统已经生成订单 ID，还未 发送给交易所或上手
     * NEW = 已报
     * PARTIALLY_FILLED = 部分成交
     * FILLED = 全部成交
     * CANCELED =已撤销
     * REJECTED = 已拒单
     * ERROR = 废单
     * MODIFYING = 改单中
     * CANCELING = 撤单中
     */
    private String status;
    /**
     * 累计成交量
     */
    private BigDecimal trade_qty;
    /**
     * 剩余量
     */
    private BigDecimal remain_qty;
    /**
     * DAY = 当日有效
     * IOC = 立即成交剩余部分被撤单
     * AC = 集合竞价期间有效, 包含开盘前和收盘前的竞价
     */
    private String tif;
    /**
     * 如果是美股参与盘前盘后订单，有值且为 YES
     */
    private String allow_eth;
    /**
     * 委托日期 YYYYMMDD(北京时间)
     */
    private String insert_date;
    /**
     * 委托时间 HHMMSSxxx(北京时间）
     */
    private String insert_time;
    /**
     * 最后更新日期 YYYYMMDD(北京时间)
     */
    private String update_date;
    /**
     * 最后更新时间 HHMMSSxxx(北京时间）
     */
    private String update_time;
    /**
     * 参考附表的尊嘉 OMS 的错误码
     */
    private Integer error_id;
    /**
     * 错误消息
     */
    private String error_msg;
}
