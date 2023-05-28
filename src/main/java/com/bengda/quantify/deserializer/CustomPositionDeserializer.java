package com.bengda.quantify.deserializer;

import com.alibaba.fastjson2.JSON;
import com.bengda.quantify.entity.pojo.Position;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomPositionDeserializer extends JsonDeserializer<List<Position>> {

    @Override
    public List<Position> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.readValueAsTree();
        if (node.isNull() || node.isEmpty()) {
            return new ArrayList<>();
        } else {
            // 处理非空节点的情况，可以按需解析节点并返回列表
            // 这里仅作示例，将节点的文本值作为列表的一个元素
            return JSON.parseArray(node.toString(), Position.class);
        }
    }
}
