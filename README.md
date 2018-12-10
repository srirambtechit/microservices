# Spring Boot Microservice Demo Project

#### Reference
  > http://www.springboottutorial.com/creating-microservices-with-spring-boot-part-1-getting-started

#### Background
  Forex Service - provides current currency value from one currency to another
  
  Currency Converter Service - Bulk of currency to know the today's value

  Netflix Ribbon - Provides client side load balancing
  
  Spring Feign Client - Plain Spring RestTemplate will not load balance traffic, whereas FeignClient has 
  the intelligence to route traffic
  
  Netflix Eureka - Auto discovery of the new instances added in the cluster

#### URLs
  Plain RestTemplate form
  > http://localhost:8100/currency-converter/from/EUR/to/INR/quantity/10000

  Feign Client form
  > http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000

  Eureka console
  > http://localhost:8761
  > http://localhost:8761/eureka
