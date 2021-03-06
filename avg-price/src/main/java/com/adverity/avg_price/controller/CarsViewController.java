package com.adverity.avg_price.controller;

import com.adverity.avg_price.exception.InvalidInputException;
import com.adverity.avg_price.model.AvgPriceDto;
import com.adverity.avg_price.model.enums.Categories;
import com.adverity.avg_price.service.AvgPriceService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CarsViewController {
    private final AvgPriceService avgPriceService;


    @GetMapping("/calculate")
    public String getAvgPriceByCarName(
            @RequestParam(name = "car") String carName,
            @RequestParam String year,
            Model model) {
        if (StringUtils.isEmpty(carName))
            throw new InvalidInputException("Please provide a valid CarName");

        if (StringUtils.isEmpty(year))
            throw new InvalidInputException("Please provide a valid Year");

        AvgPriceDto avgPriceDto = avgPriceService.calculateAvgPrice(Categories.CARS, carName, year);

        model.addAttribute("lowestPriceAdvert", avgPriceDto.getMin());
        model.addAttribute("avgPriceAdvert", avgPriceDto.getAvg());
        model.addAttribute("maxPriceAdvert", avgPriceDto.getMax());
        model.addAttribute("avgPrice", avgPriceDto.getAvgPrice());

        return "calculation";
    }
}
