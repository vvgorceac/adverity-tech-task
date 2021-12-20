package com.adverity.avg_price.controller.dto;

import com.adverity.avg_price.model.AvgPriceDto;
import lombok.Data;

@Data
public class CarAvgPriceResponseDto {
    private AdvertResponseDto min;
    private AdvertResponseDto max;
    private AdvertResponseDto avg;
    private Integer avgPrice;


    public CarAvgPriceResponseDto(AvgPriceDto calculateAvgPrice) {
        min = new AdvertResponseDto(calculateAvgPrice.getMin());
        max = new AdvertResponseDto(calculateAvgPrice.getMax());
        avg = new AdvertResponseDto(calculateAvgPrice.getAvg());
        avgPrice = calculateAvgPrice.getAvgPrice();
    }
}