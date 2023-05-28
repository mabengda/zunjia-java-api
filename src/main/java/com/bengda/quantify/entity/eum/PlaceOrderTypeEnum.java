package com.bengda.quantify.entity.eum;

public enum PlaceOrderTypeEnum {
    Market("Market","市价"),
    Limit("Limit","限价");

    private final String code;
    private final String describe;

    PlaceOrderTypeEnum(String code,String describe){
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
