package com.bengda.quantify.client;

import com.bengda.quantify.entity.request.*;

import com.bengda.quantify.entity.response.*;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import retrofit2.http.Body;
import retrofit2.http.POST;

@RetrofitClient(baseUrl = "${local.gateway.address}")
public interface OrderHttpApi {


    @POST("query/position")
    QueryPositionResponse queryPosition(@Body QueryPositionRequest request);

    /**
     * 查询账户资金
     */
    @POST("query/account")
    QueryAccountResponse queryAccount(@Body QueryAccountRequest request);

    /**
     * 下单
     */
    @POST("order/insert")
    PlaceOrderResponse placeOrder(@Body PlaceOrderRequest request);

    /**
     * 查询订单状态
     */
    @POST("query/order")
    QueryOrderStatusResponse queryOrderStatus(@Body QueryOrderStatusRequest request);

    /**
     * 取消订单
     */
    @POST("order/cancel")
    CancelOrderResponse cancelOrder(@Body CancelOrderRequest request);
}
