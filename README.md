# Spring Cloud Gateway for Hello World App

Spring Cloud Getting Started for Gataway

- Gradle Multi Project
  - [spring-cloud-gateway-eureka-hello-world](https://github.com/shinyay/spring-cloud-gateway-eureka-hello-world)

## Description

### Building Block for Gateway

|Name|Description|
|----|-----------|
|**Route**|Primary API of the Gateway<BR>Defined by followings<BR>- ID<BR>- Destination(URI)<BR>- Set of Predicates and Fileters|
|**Predicate**|HTTP Request Matching<BR>`Java 8 Function Predicate`<BR>Used for followings<BR>- Header <BR>- Method <BR>- Parameter|
|**Filter**|`Spring WebFilter`|

### Route Predicate Factories
- After Route Predicate Factory
```yaml
predicates:
- After=2017-01-20T17:42:47.789-07:00[America/Denver]
```

- Before Route Predicate Factory
```yaml
predicates:
- Before=2017-01-20T17:42:47.789-07:00[America/Denver]
```

- Between Route Predicate Factory
```yaml
predicates:
- Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
```

- Cookie Route Predicate Factory
```yaml
predicates:
- Cookie=chocolate, ch.p
```

- Header Route Predicate Factory
```yaml
predicates:
- Header=X-Request-Id, \d+
```

- Host Route Predicate Factory
```yaml
predicates:
- Host=**.somehost.org,**.anotherhost.org
```

- Method Route Predicate Factory
```yaml
predicates:
- Method=GET
```

- Path Route Predicate Factory
```yaml
predicates:
- Path=/foo/{segment},/bar/{segment}
```

- Query Route Predicate Factory
```yaml
predicates:
- Query=baz
```

- RemoteAddr Route Predicate Factory
```yaml
predicates:
- RemoteAddr=192.168.1.1/24
```

- Weight Route Predicate Factory
```yaml
routes:
- id: weight_high
  uri: https://weighthigh.org
  predicates:
  - Weight=group1, 8
- id: weight_low
  uri: https://weightlow.org
  predicates:
  - Weight=group1, 2
```

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
