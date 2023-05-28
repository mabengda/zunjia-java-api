package com.bengda.quantify.entity.eum;

public enum ExchangeEnum {
    SSE("SSE", "上交所"),
    SZSE("SZSE", "深交所"),
    HKEX("HKEX", "港交所"),
    US("US", "美股场内市场"),
    USOTC("USOTC", "美股OTC市场");

    private final String code;
    private final String describe;

    ExchangeEnum(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}