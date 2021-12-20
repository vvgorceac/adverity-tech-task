package com.adverity.avg_price.service;

import com.adverity.avg_price.config.MarketplaceConfig;
import com.adverity.avg_price.exception.AdvertNotFoundException;
import com.adverity.avg_price.model.AdvertDto;
import com.adverity.avg_price.model.enums.Categories;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvgPriceCrawler {

    private final MarketplaceConfig marketplaceConfig;

    @Autowired
    public AvgPriceCrawler(MarketplaceConfig marketplaceConfig) {
        this.marketplaceConfig = marketplaceConfig;
    }

    @SneakyThrows
    /*
     * As a technical task, crawler will be reading only first page of results
     * */
    public List<AdvertDto> crawlFor(Categories category, String keyword, String year) {
        String requestUrl = marketplaceConfig.getUrl()
                + marketplaceConfig.getCategoryPaths().get(category)
                + "?"
                + marketplaceConfig.getSearchParamName()
                + "="
                + keyword;

        Document doc = Jsoup.connect(requestUrl).get();
        Elements advertCards = doc.select("li[class='ads-list-photo-item   ']");

        List<AdvertDto> advertDtos = advertCards.stream().map(el -> {
                    Elements titleElement = el.getElementsByClass("ads-list-photo-item-title");
                    String titleWithYear = titleElement.text();
                    String url = marketplaceConfig.getUrl() + titleElement
                            .get(0).getElementsByTag("a")
                            .get(0).attr("href");
                    String price = el.getElementsByClass("ads-list-photo-item-price-wrapper").text();
                    String imgSrc = el.getElementsByTag("img").get(0).attr("src");

                    //Skipping adverts without particular price
                    if (price.matches(".*[а-яa-z]"))
                        return null;

                    // TODO add proper price parsing considering locale
                    return new AdvertDto(url, titleWithYear, Integer.parseInt(price.replaceAll("[^\\d.]+", "")), imgSrc);
                })
                .filter(advert -> {
                    if (advert == null)
                        return false;

                    String name = advert.getName();
                    return StringUtils.containsIgnoreCase(name, keyword) &&
                            StringUtils.containsIgnoreCase(name, year);
                }).collect(Collectors.toList());

        if (advertDtos.isEmpty())
            throw new AdvertNotFoundException("There are no adverts for provided criteria");

        return advertDtos;
    }
}
