package com.bengda.quantify.entity.eum;

public enum PlaceOrderTimeInForceEnum {
    DAY("DAY","当日有效"),
    IOC("IOC","立即成交剩余部分被撤单"),
    AC("AC","集合竞价期间有效");

    private final String code;
    private final String description;

    PlaceOrderTimeInForceEnum(String code,String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
