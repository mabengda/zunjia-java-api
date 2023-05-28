package com.bengda.quantify.client;

import com.alibaba.fastjson2.JSON;
import com.bengda.quantify.entity.constants.HttpConstant;
import com.bengda.quantify.entity.eum.ExchangeEnum;
import com.bengda.quantify.entity.eum.PlaceOrderTypeEnum;
import com.bengda.quantify.entity.eum.SideEnum;
import com.bengda.quantify.entity.pojo.Account;
import com.bengda.quantify.entity.request.*;
import com.bengda.quantify.entity.response.*;
import com.bengda.quantify.util.AccountUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;


@SpringBootTest
class OrderHttpApiTest {
    @Resource
    private OrderHttpApi orderHttpApi;

    @Test
    void queryPosition() {
        QueryPositionRequest request = QueryPositionRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).build();
        QueryPositionResponse queryPositionResponse = orderHttpApi.queryPosition(request);
        if (null != queryPositionResponse && !CollectionUtils.isEmpty(queryPositionResponse.getPositions())) {
            System.err.println(JSON.toJSON(queryPositionResponse.getPositions()));
        } else {
            System.err.println("获取持仓失败或未持仓");
        }
    }

    @Test
    void queryAccount() {
        QueryAccountResponse queryAccountResponse = orderHttpApi.queryAccount(QueryAccountRequest.builder().build());
        Account baseAccount = AccountUtil.findBaseAccount(queryAccountResponse);
        System.err.printf("账户：%s\n总余额：%s\n可用余额：%s%n", baseAccount.getAccount(), baseAccount.getBalance().toString(), baseAccount.getAvailable().toString());

    }

    @Test
    void placeOrder() {
        PlaceOrderRequest.PlaceOrderRequestBuilder buyBuilder = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.BUY.getCode())
                .type(PlaceOrderTypeEnum.Limit.getCode());
        PlaceOrderRequest buyRequest = buyBuilder.qty(BigDecimal.valueOf(600)).price(BigDecimal.valueOf(10)).build();
        PlaceOrderResponse placeOrderResponse = orderHttpApi.placeOrder(buyRequest);
        if (HttpConstant.SUCCESS_CODE.equals(placeOrderResponse.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", placeOrderResponse.getError_msg(), placeOrderResponse.getOrder_id());
        } else {
            System.err.println("下单失败:" + placeOrderResponse.getError_id() + placeOrderResponse.getError_msg());
        }

    }

    @Test
    void queryOrderStatus() {
        QueryOrderStatusRequest request = QueryOrderStatusRequest.builder().order_id("1071665").build();
        QueryOrderStatusResponse response = orderHttpApi.queryOrderStatus(request);
        System.out.println(response);
//        if (null == response || CollectionUtils.isEmpty(response.getOrders())) {
//            System.err.printf("查询订单状态失败！orderId:%s%n", request.getOrder_id());
//            return;
//        }
//        Order matchOrder = OrderUtil.findMatchOrder(response, request.getOrder_id());
//        if (null != matchOrder && request.getOrder_id().equals(matchOrder.getOrder_id())) {
//            System.err.println("订单状态查询成功:\n" + matchOrder.getOrder_id() + " 状态：" + OrderStatusEnum.getOrderStatusByCode(matchOrder.getStatus()).getDescription());
//        } else {
//            System.err.printf("查询订单状态失败！orderId:%s%n", matchOrder);
//        }
    }

    @Test
    void cancelOrder(){
        CancelOrderResponse cancelOrderResponse = orderHttpApi.cancelOrder(CancelOrderRequest.builder().order_id("1071665").build());
        if (HttpConstant.SUCCESS_CODE.equals(cancelOrderResponse.getError_id())) {
            System.err.printf("取消成功:%s\n单号:%s%n", cancelOrderResponse.getError_msg(), cancelOrderResponse.getOrder_id());
        } else {
            System.err.println("取消失败:" + cancelOrderResponse.getError_id() + cancelOrderResponse.getError_msg());
        }
    }

    @Test
    void allTest(){
        //1.	买入指令：
        //交易所ID：HKEX，股票代码：00700，买卖方向：BUY，委托数量：600，订单类型：增强限价，委托价：10
        queryAccount();
        PlaceOrderRequest buyOrder1 = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.BUY.getCode()).qty(BigDecimal.valueOf(600)).type(PlaceOrderTypeEnum.Limit.getCode()).price(BigDecimal.valueOf(10)).build();
        PlaceOrderResponse buyOrderRes1 = orderHttpApi.placeOrder(buyOrder1);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes1.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", buyOrderRes1.getError_msg(), buyOrderRes1.getOrder_id());
        } else {
            System.err.println("下单失败:" + buyOrderRes1.getError_id() + buyOrderRes1.getError_msg());
        }
        queryPosition();

        //2.	卖出指令：
        //交易所ID：HKEX，股票代码：00700，买卖方向：SELL，委托数量：600，订单类型：增强限价，委托价：10
        queryAccount();
        PlaceOrderRequest buyOrder2 = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.SELL.getCode()).qty(BigDecimal.valueOf(600)).type(PlaceOrderTypeEnum.Limit.getCode()).price(BigDecimal.valueOf(10)).build();
        PlaceOrderResponse buyOrderRes2 = orderHttpApi.placeOrder(buyOrder2);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes2.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", buyOrderRes2.getError_msg(), buyOrderRes2.getOrder_id());
        } else {
            System.err.println("下单失败:" + buyOrderRes2.getError_id() + buyOrderRes2.getError_msg());
        }
        queryPosition();
        //3.	撤单指令：
        //委托买入200股，这时会部分成交100股。执行撤单100股的请求
        queryAccount();
        PlaceOrderRequest buyOrder3 = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.BUY.getCode()).qty(BigDecimal.valueOf(200)).type(PlaceOrderTypeEnum.Limit.getCode()).price(BigDecimal.valueOf(10)).build();
        PlaceOrderResponse buyOrderRes3 = orderHttpApi.placeOrder(buyOrder3);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes3.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", buyOrderRes3.getError_msg(), buyOrderRes3.getOrder_id());
        } else {
            System.err.println("下单失败:" + buyOrderRes3.getError_id() + buyOrderRes3.getError_msg());
        }


        CancelOrderRequest cancelOrder3 = CancelOrderRequest.builder().order_id(buyOrderRes3.getOrder_id()).build();
        CancelOrderResponse cancelOrderRes3 = orderHttpApi.cancelOrder(cancelOrder3);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes3.getError_id())) {
            System.err.printf("取消成功:%s\n单号:%s%n", cancelOrderRes3.getError_msg(), cancelOrderRes3.getOrder_id());
        } else {
            System.err.println("取消失败:" + cancelOrderRes3.getError_id() + cancelOrderRes3.getError_msg());
        }
        queryPosition();
        //4.	市价指令：
        //参考测试用例1，订单类型修改为“市价”（Market）
        queryAccount();
        PlaceOrderRequest buyOrder4 = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.BUY.getCode()).qty(BigDecimal.valueOf(600)).type(PlaceOrderTypeEnum.Market.getCode()).build();
        PlaceOrderResponse buyOrderRes4 = orderHttpApi.placeOrder(buyOrder4);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes4.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", buyOrderRes4.getError_msg(), buyOrderRes4.getOrder_id());
        } else {
            System.err.println("下单失败:" + buyOrderRes4.getError_id() + buyOrderRes4.getError_msg());
        }
        queryPosition();
        //5.	限价指令：
        //参考测试用例1，订单类型修改为“限价”（Limit）
        queryAccount();
        PlaceOrderRequest buyOrder5 = PlaceOrderRequest.builder().exchange(ExchangeEnum.HKEX.getCode()).symbol("00700").side(SideEnum.BUY.getCode()).qty(BigDecimal.valueOf(600)).type(PlaceOrderTypeEnum.Limit.getCode()).price(BigDecimal.valueOf(10)).build();
        PlaceOrderResponse buyOrderRes5 = orderHttpApi.placeOrder(buyOrder5);
        if (HttpConstant.SUCCESS_CODE.equals(buyOrderRes5.getError_id())) {
            System.err.printf("下单成功:%s\n单号:%s%n", buyOrderRes5.getError_msg(), buyOrderRes5.getOrder_id());
        } else {
            System.err.println("下单失败:" + buyOrderRes5.getError_id() + buyOrderRes5.getError_msg());
        }
        queryPosition();
    }


    @Test
    void test1(){

        System.out.println(Integer.MAX_VALUE+2147480000);
    }
}