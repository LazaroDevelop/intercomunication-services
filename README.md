# Intercommunication Services

Microservices infrastructure built with **Spring Boot**, implementing an API Gateway, Service Registry, Configuration Server, and core/order services.  
Designed to demonstrate inter-service communication, centralized configuration, and modular architecture.

---

## 🌐 Architecture

- **api-gateway**: Entry point that routes requests to the appropriate services.  
- **service-registry**: Dynamic service registry (Eureka / Spring Cloud Discovery).  
- **config-server**: Centralized configuration server for all services.  
- **service-core**: Shared business logic and common utilities.  
- **order-service**: Example of a functional microservice that manages orders.

---

## 🛠 Tech Stack

| Component              | Technology                               |
|------------------------|-------------------------------------------|
| Backend                | Java 17, Spring Boot, Spring Cloud        |
| Service Discovery      | Eureka / Spring Cloud Discovery           |
| Centralized Config     | Spring Cloud Config Server                |
| API Gateway            | Spring Cloud Gateway |
| Shared Dependencies    | Maven common modules (service-core)       |

---

## 🚀 How to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/LazaroDevelop/intercomunication-services.git
   cd intercomunication-services
   
2. Navigate to the project folder:
   ```cd intercomunication-services```
   
3. Build the project and all the modules:
   ```mvn clean install```
   
4. Start the services in the following order:
     1. config-server – ensures centralized configuration is available.
     2. service-registry – enables service discovery (Eureka).
     3. core and order-service – domain microservices.
     4. api-gateway – the entry point to the system.
   Example:
   
    ``` cd config-server mvn spring-boot:run```
    ``` cd service-registry mvn spring-boot:run ```
    ``` cd service-core mvn spring-boot:run ```
    ``` cd order-service mvn spring-boot:run```
    ``` cd api-gateway mvn spring-boot:run```
5. Access the system via:
    ``` http://localhost:8080 ```
   
---

## 🤝 Contributing

Contributions are welcome! Fork the repository, create a new branch, and submit a pull request.
