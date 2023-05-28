package com.bengda.quantify.entity.eum;

public enum SideEnum {

    BUY("BUY","买入"),
    SELL("SELL","卖出");


    private final String code;
    private final String describe;

    SideEnum(String code,String describe){
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
