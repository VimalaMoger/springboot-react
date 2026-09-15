## Eazy Stickers - E-store application

Spring Boot: Created backend application using MySQL
- Set up Global Exception to centralize error handling logic across all controllers
  - with structured error response.
- Set up API documentation for the HTTP endpoints
- Back end validations to enforce data constraints via annotations
- Spring data JPA Auditing(Who did what and when)
- Logs to file and console with proper format
- Initial set up with In-memory H2 DB:
  - Setup, initialization, store DB data using file
- Spring Data JPA for interaction with MySQL database access
- Entity classes - POJO classes for tables in DB and Lombok library
- Fix CORS error - Configured backend to accept requests from frontend origin
- Health Checks and metrics using Spring actuator
  - configure and customize access to different groups

### REST API:
- Contact: GET, POST - Contacting support team and success response
- Login, Register: POST - Saving new customer details, and login success
- Admin: GET, PATCH - Building admin order request endpoint
- Orders: GET, POST - Saving Orders, get customer orders
- Payment: POST - Building create-payment-intent
- Csrf Token: GET
- Product: GET - Read all product data
- Profile: GET, PUT - Read profile data and update profile data
  - Mapping HTTP request body to Java Object, Query and Path parameters, HTTP headers, Request and response Entity

### Spring Security:
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

### Spring Data JPA:
- Spring Data JPA relationships using @OneToOne, @ManyToOne and @OneToMany
- Derived query method
- Custom @Query with JPQL, @NamedQuery and @NamedNativeQuery, @Transactional
- Reading properties using @Value, Environment, @ConfigurationProperties, @PropertySource
- Method execution to perform initialization after dependency injection @PostConstruct
- Stereotype and Bean annotation(scope, custom name, @Primary, @Qualifier), Autowiring

Profiles, Conditional Bean creation

Cashing for performance @Casheable
Spring Cashing with TTL configuration(Time-To-Live)

### Tables:
- Customer to store end users details
- Role, Contact, Product, BaseEntity
- New Address table to store customer address
- Orders table for orders, OrderItem for order details

### Enhancements:
- Custom Queries
- Transparent Auditing - Entity timestamps and tracking metadata(@CreatedDate/By, @LastModifiedBy/Date)
- Stopping duplicate customers during registration from custom query
- Stopping end users from using weak passwords with CompromisedPasswordChecker
- Custom Authentication provider for Login operation

***Migrating from H2 DB to MySQL DB***
- Set up MySQL DB

[App to view](https://lighthearted-stroopwafel-c66603.netlify.app/)

***Dependencies***:
```
Spring boot starter web, Spring boot starter data jpa, Lombok, Spring boot Dev tools, Spring boot starter actuator, Spring boot starter validation, Spring boot starter security,
Jjwt jackson, Jjwt impl, springdoc openapi starter webmvc ui, spring boot starter cashe, Caffeine, MySQL connector j
```
