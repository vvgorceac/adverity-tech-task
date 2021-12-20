# Techninal task for interview

### Part 1 - Automation framework to fetch photos from a REST API

Description:

**api-test** module is a small test automation framework with 1 test case for fetching photos
from https://jsonplaceholder.typicode.com/ and analyzing response. Framework generates Allure report after execution

### Technologies stack:

- [Cucumber](https://cucumber.io/)
- [Spring](https://spring.io/)
- [Retrofit](https://square.github.io/retrofit/)

### Usage instructions

###### note - java 11 should be installed

> - gradle clean
>- gradle api-test:test
>- gradle api-test:allureServe
>
> After test execution, a browser window with allure report will be opened.

### Part 2 - Application that analyzes prices on a marketplace

Description:

**avg-price** module is a spring application with small UI and API to fetch and analyze prices for a given car model and release year.
As a result of it you will get list of highest, average and lowest price on the market. It can be used both as trough UI as by calling REST endpoint

### Technologies stack:

- [Spring boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Jsoup](https://jsoup.org/)
- [Thymeleaf](https://www.thymeleaf.org/)

### Usage instructions

> - gradle clean
>- gradle avg-price:build
>- java -jar avg-price\build\libs\avg-price-1.0-SNAPSHOT.jar
> 
>
> **UI usage**
>- open [localhost:8080](localhost:8080)
>- populate form and click submit
>- page with price suggestions will be shown
>
> **API usage**
>- GET `http://localhost:8080/api/v1/cars?car=bmw x5&year=2016`


