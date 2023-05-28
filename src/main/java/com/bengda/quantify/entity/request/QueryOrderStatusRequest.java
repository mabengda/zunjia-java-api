package com.bengda.quantify.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderStatusRequest {
    /**
     * 由 API 调用者下单时赋值的订单 ID，如果与 order_id 都不存在或者都为空表示查询所有订单
     */
    private String clord_id;
    /**
     * 尊嘉交易系统生成的订单 ID，如“0000206243”
     */
    private String order_id;
}
