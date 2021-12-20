package com.adverity.avg_price.model;

import com.adverity.avg_price.model.enums.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdvertDto {
    private Long id;
    private Categories category;
    private String name;
    private String url;
    private String imgSrc;
    private Integer price;


    public AdvertDto(String url, String name, Integer price, String imgSrc) {
        this.url = url;
        this.name = name;
        this.price = price;
        this.imgSrc = imgSrc;
    }

}
