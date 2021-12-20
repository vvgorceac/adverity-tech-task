package com.adverity.avg_price.config;


import com.adverity.avg_price.model.enums.Categories;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties("marketplace")
@Component
@Data
public class MarketplaceConfig {
    private String url;
    private Map<Categories, String> categoryPaths;
    private String searchParamName;
}
