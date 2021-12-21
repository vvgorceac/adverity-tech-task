# Technical task for interview

## Part 1 - Automation framework to fetch photos from a REST API

**api-test** module is a small test automation framework with 1 test case for fetching photos
from _https://jsonplaceholder.typicode.com/_ and analyzing response. Framework generates Allure report after execution.

### Technologies stack:

- [Cucumber](https://cucumber.io/)
- [Spring](https://spring.io/)
- [Retrofit](https://square.github.io/retrofit/)

### Usage

**_Note Java 11 should be installed_**

- ```
  gradle clean
  ```

- ```
  gradle api-test:test
  ```

- ```
  gradle api-test:allureServe
  ``` 

After test execution, a browser window with allure report will be opened.

### Example

![image](https://user-images.githubusercontent.com/95355681/146923278-b4585cb6-91d0-4d5e-8870-1a8592848be1.png)
![image](https://user-images.githubusercontent.com/95355681/146923322-8a0276b5-d056-410e-aaea-29df705478ac.png)

---

## Part 2 - Application that analyzes prices on a marketplace

**avg-price** module is a spring application with small UI and API to fetch and analyze prices for a given car model and
release year. As a result of it you will get list of highest, average and lowest price on the market. It can be used
both as trough UI as by calling REST endpoint.

### Technologies stack:

- [Spring boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Jsoup](https://jsoup.org/)
- [Thymeleaf](https://www.thymeleaf.org/)

### Usage

- ```
  gradle clean
  ```

- ```
  gradle avg-price:build
  ```

- ```
  java -jar avg-price\build\libs\avg-price-1.0-SNAPSHOT.jar
  ```

#### UI Usage

- Open [localhost:8080](localhost:8080)
- Populate form and click submit
- Page with price suggestions will be shown

##### Example

![image](https://user-images.githubusercontent.com/95355681/146923640-ced426b9-4c52-45e8-acf5-b7ff3403804d.png)
![image](https://user-images.githubusercontent.com/95355681/146923600-4aafd7ba-0d46-4b31-b4c9-9fa049b7e94e.png)

#### API Usage

- GET `http://localhost:8080/api/v1/cars?car=bmw x5&year=2016`

##### Example

![image](https://user-images.githubusercontent.com/95355681/146923466-e3ddd438-d1c3-4c99-b993-54a03745125b.png)