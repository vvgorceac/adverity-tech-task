package com.adverity.avg_price.controller.dto;

import com.adverity.avg_price.model.AdvertDto;
import lombok.Data;

@Data
public class AdvertResponseDto {

    private String name;
    private String url;
    private Integer price;

    public AdvertResponseDto(AdvertDto advertDto) {
        name = advertDto.getName();
        url = advertDto.getUrl();
        price = advertDto.getPrice();
    }
}
