# E-store

**Initial set up**

Generated Spring Boot Web project using [Spring Initializer](https://start.spring.io/index.html)

***Dependencies in pom.xml***:
```
Spring boot starter web, Spring boot starter data jpa, Lombok, Spring boot Dev tools, Spring boot starter actuator, Spring boot starter validation, Spring boot starter security, Jjwt jackson, Jjwt impl, springdoc openapi starter webmvc ui, spring boot starter cashe, Caffeine, MySQL connector j
```
Code Editor: Intellij

## Project Structure
```bash
       
        │── src/e-store                                  
                ├── config
                    ├── AuditAwareImpl
                    ├── CaffeineCacheManager
                    ├── StripeConfig
                ├── constants
                    ├── ApplicationConstants
                |── controller
                    ├── AdminController
                    ├── AuthController
                    ├── ContactRequestController
                    ├── CreatePaymentIntent
                    ├── CsrfController
                    ├── OrderController
                    ├── ProductController
                    ├── ProfileController                                
                ├── dto
                    ├── AddressDto
                    ├── ContactDetailsDto
                    ├── ContactRequestDto
                    ├── ContactResponseDto
                    ├── ErrorResponse
                    ├── LoginRequestDto
                    ├── LoginResponseDto
                    ├── OrderItemDto
                    ├── OrderItemResponseDto
                    ├── OrderRequestDto
                    ├── OrderResponseDto
                    ├── PaymentRequestDto
                    ├── PaymentResponseDto
                    ├── ProductDto
                    ├── ProfileRequestDto
                    ├── ProfileResponseDto
                    ├── RegisterUserRequestDto
                    ├── ResponseDto
                    ├── UserDto
                │── entity
                    ├── Address
                    ├── BaseEntity
                    ├── Contact
                    ├── Customer
                    ├── Order
                    ├── OrderItem
                    ├── Product
                    ├── Role
                ├── exception
                    ├── GlobalExceptionHandler
                    ├── ResourceNotFoundException
                │── repository
                    ├── ContactRequestRepository
                    ├── CustomerRepository
                    ├── OrderRepository
                    ├── ProductRepository
                    ├── RoleRepository
                │── security
                    ├── JWTTokenValidatorFilter
                    ├── LoginAuthenticationProvider
                    ├── PublicPathConfig
                    ├── SecurityConfig
                ├── service
                    ├── ContactRequestService
                    ├── OrderService
                    ├── PaymentService
                    ├── ProductService
                    ├── ProfileService
                ├── serviceImpl
                    ├── ContactRequestServiceImpl
                    ├── OrderServiceImpl
                    ├── PaymentServiceImpl
                    ├── ProductServiceImpl
                    ├── ProfileServiceImpl
                ├── util
                    ├── JwtUtil                                
         ├── pom.xml
```

## Spring Boot Set up: 

- Initial set up with In-memory H2 DB:
  - Setup, initialization, store DB data in a file
- Entity classes - POJO classes for tables in DB
- Set up Global Exception to centralize error handling logic across all controllers
  - with structured error response.
- Develop RESTful services for front end
- Set up API documentation for the HTTP endpoints
- Validation check- Back end validations to enforce data constraints via annotations
- Spring data JPA Auditing - (Who did what and when)
- Logs to file / console with proper format
- Fix CORS error - Configure backend to accept requests from frontend origin
- Health Checks and metrics using Spring actuator
  - configure and customize access to different groups
- Spring Data JPA for interaction with MySQL database access

## Spring Security:

- Static user set up credentials
- Security config code per custom requirements
- Creating user with in-memoryUseDetailManager
- Security Authentication flow
- JWT Token for securing back end code
- Handling Token expiration
- Building a filter on back end to validate JWT token
- Authenticate and authorize users against role and authority
- Configuring Authorization roles, storing and fetching roles
- CSRF protection and token implementation
- Securing Actuator and Swagger paths using correct role configurations

## Spring Data JPA:

- Spring Data JPA relationships using @OneToOne, @ManyToOne and @OneToMany
- Derived query method
- Custom @Query with JPQL, @NamedQuery and @NamedNativeQuery, @Transactional
- Reading properties via @Value, Environment, @ConfigurationProperties, @PropertySource
- Method execution to perform initialization after dependency injection @PostConstruct
- Stereotype and Bean annotation(scope, custom name, @Primary, @Qualifier), Autowiring

### Enhancements:

- Custom Queries
- Transparent Auditing - Entity timestamps and tracking metadata(@CreatedDate/By, @LastModifiedBy/Date)
- Stopping duplicate customers during registration from custom query
- Stopping end users from using weak passwords with CompromisedPasswordChecker
- Custom Authentication provider for Login operation
- Profiles, Conditional Bean creation
- Cashing for performance @Casheable
  - Spring Cashing with TTL configuration(Time-To-Live)

***Migrating from H2 DB to MySQL DB***

- Set up MySQL DB

***Build and deployment to AWS cloud***
<!--
[App to view](https://lighthearted-stroopwafel-c66603.netlify.app/)

```test card 4242 4242 4242 4242```
-->
