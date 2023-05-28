package com.bengda.quantify.entity.eum;

import java.util.Arrays;

public enum OrderStatusEnum {

    PENDING("PENDING", "正报，尊嘉交易系统已经生成订单 ID，还未发送给交易所或上手"),
    NEW("NEW", "已报"),
    PARTIALLY_FILLED("PARTIALLY_FILLED", "部分成交"),
    FILLED("FILLED", "全部成交"),
    CANCELED("CANCELED", "已撤销"),
    REJECTED("REJECTED", "已拒单"),
    ERROR("ERROR", "废单"),
    MODIFYING("MODIFYING", "改单中"),
    CANCELING("CANCELING", "撤单中");

    private final String code;
    private final String description;

    private OrderStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static OrderStatusEnum getOrderStatusByCode(String code) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(status -> status.name().equals(code))
                .findFirst()
                .orElse(null); // 如果找不到匹配的枚举对象，返回null或者抛出异常，具体根据需求而定
    }
}
