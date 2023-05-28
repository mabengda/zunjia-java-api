package com.bengda.quantify.entity.response;

import com.bengda.quantify.entity.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderStatusResponse {
    private List<Order> orders;
}
