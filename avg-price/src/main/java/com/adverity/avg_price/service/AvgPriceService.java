package com.adverity.avg_price.service;

import com.adverity.avg_price.model.AdvertDto;
import com.adverity.avg_price.model.AvgPriceDto;
import com.adverity.avg_price.model.enums.Categories;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class AvgPriceService {

    private final AvgPriceCrawler avgPriceCrawler;

    @Autowired
    public AvgPriceService(AvgPriceCrawler avgPriceCrawler) {
        this.avgPriceCrawler = avgPriceCrawler;
    }

    public AvgPriceDto calculateAvgPrice(Categories category, String keyword, String year) {
        //TODO implement cache and check it before crawling page
        List<AdvertDto> advertsByCategoryAndName = new ArrayList<>();

        if (advertsByCategoryAndName.isEmpty()) {
            advertsByCategoryAndName = avgPriceCrawler.crawlFor(category, keyword, year);
        }

        return new AvgPriceDto(advertsByCategoryAndName);
    }
}
