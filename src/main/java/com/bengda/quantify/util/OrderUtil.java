package com.bengda.quantify.util;

import com.bengda.quantify.entity.pojo.Order;
import com.bengda.quantify.entity.response.QueryOrderStatusResponse;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

public class OrderUtil {

    public static Order findMatchOrder(QueryOrderStatusResponse orderStatusResponse, String order_id) {
        Order result = null;
        if (null != orderStatusResponse && !CollectionUtils.isEmpty(orderStatusResponse.getOrders())) {
            Optional<Order> first = orderStatusResponse.getOrders().stream().filter(item -> order_id.equals(item.getOrder_id())).findFirst();
            if (first.isPresent()) {
                result = first.get();
            }
        }
        return result;
    }
}
