package com.adverity.avg_price.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;

@Data
@Log4j2
public class AvgPriceDto {
    private AdvertDto min;
    private AdvertDto max;
    private AdvertDto avg;
    private Integer avgPrice;

    public AvgPriceDto(List<AdvertDto> advertDtos) {
        avgPrice = advertDtos.stream().mapToInt(AdvertDto::getPrice).reduce(0, Integer::sum) / advertDtos.size();
        min = advertDtos.stream().min(Comparator.comparing(AdvertDto::getPrice)).get();
        max = advertDtos.stream().max(Comparator.comparing(AdvertDto::getPrice)).get();
        avg = advertDtos.stream().min(Comparator.comparing(AdvertDto::getPrice, Comparator.comparingInt(p -> Math.abs(p - avgPrice)))).get();
    }
}
