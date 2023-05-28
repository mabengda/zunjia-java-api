package com.bengda.quantify.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryPositionRequest {
    /**
     * 交易所ID:
     * SSE = 上交所
     * SZSE = 深交所
     * HKEX = 港交所
     * US = 美股场内市场
     * USOTC = 美股 OTC 市场
     */
    private String exchange;

    /**
     * 股票或期权代码，如果不存在或为空，则只根据 exchange 查询，
     * 如果和 exchange 都不存在或为空，则查询所有持仓
     */
    private String symbol;
}
