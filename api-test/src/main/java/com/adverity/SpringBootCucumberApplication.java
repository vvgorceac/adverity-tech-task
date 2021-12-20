package com.adverity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"com.adverity"})
@EntityScan(basePackages = {"com.adverity"})
public class SpringBootCucumberApplication {
}
