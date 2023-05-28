package com.bengda.quantify.entity.response;

import com.bengda.quantify.deserializer.CustomPositionDeserializer;
import com.bengda.quantify.entity.pojo.Position;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryPositionResponse {
    @JsonDeserialize(using = CustomPositionDeserializer.class)
    private List<Position> positions;
}
