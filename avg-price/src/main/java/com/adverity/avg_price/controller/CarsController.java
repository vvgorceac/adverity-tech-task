package com.adverity.avg_price.controller;

import com.adverity.avg_price.controller.dto.CarAvgPriceResponseDto;
import com.adverity.avg_price.exception.InvalidInputException;
import com.adverity.avg_price.model.enums.Categories;
import com.adverity.avg_price.service.AvgPriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {

    private final AvgPriceService avgPriceService;

    @Autowired
    public CarsController(AvgPriceService carAvgPriceService) {
        this.avgPriceService = carAvgPriceService;
    }

    @GetMapping()
    public CarAvgPriceResponseDto getAvgPriceByCarName(
            @RequestParam(name = "car") String carName,
            @RequestParam String year) {
        if (StringUtils.isEmpty(carName))
            throw new InvalidInputException("Please provide a valid CarName");

        if (StringUtils.isEmpty(year))
            throw new InvalidInputException("Please provide a valid Year");

        return new CarAvgPriceResponseDto(avgPriceService.calculateAvgPrice(Categories.CARS, carName, year));
    }
}