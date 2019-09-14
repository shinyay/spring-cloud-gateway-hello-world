# Spring Cloud Gateway for Hello World App

Spring Cloud Getting Started for Gataway

- Gradle Multi Project
  - [spring-cloud-gateway-eureka-hello-world](https://github.com/shinyay/spring-cloud-gateway-eureka-hello-world)

## Description

## Demo

### Routing to HTTPBIN access

- application.yml

```yml
server:
  port: 8080
spring:
  application:
    name: gateway
  cloud:
    gateway:
      routes:
        - id: hello
          uri: http://httpbin.org
          predicates:
            - Path=/post
          filters:
            - AddRequestHeader=X-Request-Hello, PostWold
```

## Features

- feature:1
- feature:2

## Requirement

- [httpbin.org](http://httpbin.org)
  - A simple HTTP Request & Response Service.

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
