# Spring Boot Mustache Post Application

A modern web application built with Spring Boot 3.5.6, featuring OAuth2 authentication, JPA data persistence, and
Mustache templating for creating and managing blog posts.

## 🚀 Features

### Authentication & Security

- **OAuth2 Integration**: Google and Naver OAuth2 login support
- **Spring Security 6**: Modern security configuration with JWT support
- **Session Management**: JDBC-based session storage for scalability
- **Role-based Access**: User and Guest roles with appropriate permissions

### Core Functionality

- **Post Management**: Create, read, update, and delete blog posts
- **User Profiles**: User profile management with OAuth2 integration
- **Responsive UI**: Mustache templating with Bootstrap styling
- **Real-time Updates**: Dynamic content loading and updates

### Technical Stack

- **Framework**: Spring Boot 3.5.6
- **Template Engine**: Mustache (JMustache)
- **Database**: H2 (development), configurable for production
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Java Version**: 25 (LTS compatible)

## 📋 Prerequisites

- Java 21+ (Java 25 supported)
- Maven 3.6+
- IDE with Lombok support (IntelliJ IDEA, VS Code, Eclipse)

## 🛠️ Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/hendisantika/spring-boot-mustache-post.git
cd spring-boot-mustache-post
```

### 2. Configure OAuth2 Credentials

Create OAuth2 applications and update the configuration:

#### Google OAuth2 Setup

1. Visit [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select existing one
3. Enable Google+ API
4. Create OAuth2 credentials
5. Update `src/main/resources/application-oauth.properties`:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
```

#### Naver OAuth2 Setup

1. Visit [Naver Developers](https://developers.naver.com/)
2. Create a new application
3. Update `src/main/resources/application-oauth.properties`:

```properties
spring.security.oauth2.client.registration.naver.client-id=YOUR_NAVER_CLIENT_ID
spring.security.oauth2.client.registration.naver.client-secret=YOUR_NAVER_CLIENT_SECRET
```

### 3. Build the Application

```bash
mvn clean install
```

### 4. Run the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using Java directly
java -jar target/spring-boot-mustache-post-0.0.1-SNAPSHOT.jar

# With specific profile
mvn spring-boot:run -Dspring.profiles.active=oauth
```

The application will start on `http://localhost:8080`

## 🏗️ Project Architecture

### Package Structure

```
com.hendisantika/
├── config/                 # Configuration classes
│   ├── auth/              # Security & OAuth2 configuration
│   └── WebConfig.java     # Web MVC configuration
├── controller/            # REST & Web controllers
├── domain/                # JPA entities
│   ├── post/             # Post-related entities
│   └── user/             # User-related entities
├── dto/                   # Data Transfer Objects
├── service/              # Business logic layer
└── SpringBootMustachePostApplication.java
```

### Key Components

#### Controllers

- **IndexController**: Main page and navigation
- **PostsApiController**: REST API for post operations
- **HelloController**: API testing endpoint
- **ProfileController**: User profile management

#### Security Configuration

- **SecurityConfig**: Spring Security 6 configuration
- **CustomOAuth2UserService**: OAuth2 user service implementation
- **LoginUserArgumentResolver**: Custom authentication resolver

#### Data Layer

- **Posts**: Blog post entity with JPA annotations
- **User**: User entity with OAuth2 integration
- **BaseTimeEntity**: Auditing entity for created/modified timestamps

## 🗄️ Database Configuration

### H2 Database (Development)

Default configuration uses H2 in-memory database:

- **Console**: Available at `/h2-console`
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

### Production Database

Update `application-real-db.properties` for production:

```properties
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_webservice
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🎨 Frontend Structure

### Templates (Mustache)

```
src/main/resources/templates/
├── layout/
│   ├── header.mustache    # Common header
│   └── footer.mustache    # Common footer
├── index.mustache         # Home page
├── posts-save.mustache    # Create post form
└── posts-update.mustache  # Edit post form
```

### Static Resources

```
src/main/resources/static/
├── css/                   # Stylesheets
├── js/                    # JavaScript files
└── images/               # Static images
```

## 🔧 Configuration Profiles

### Available Profiles

- **default**: Development with H2 database
- **oauth**: OAuth2 configuration
- **real**: Production configuration
- **real-db**: Production database configuration

### Activating Profiles

```bash
# Single profile
java -jar app.jar --spring.profiles.active=oauth

# Multiple profiles
java -jar app.jar --spring.profiles.active=real,real-db
```

## 📝 API Endpoints

### Web Pages

- `GET /` - Home page with post list
- `GET /posts/save` - Create new post form
- `GET /posts/update/{id}` - Edit post form
- `GET /profile` - User profile page

### REST API

- `GET /api/v1/posts` - List all posts
- `POST /api/v1/posts` - Create new post
- `GET /api/v1/posts/{id}` - Get specific post
- `PUT /api/v1/posts/{id}` - Update post
- `DELETE /api/v1/posts/{id}` - Delete post
- `GET /hello` - Test endpoint

## 🔒 Security Features

### Authentication Flow

1. User clicks login button
2. Redirects to OAuth2 provider (Google/Naver)
3. User grants permissions
4. Application receives user information
5. Creates/updates user in database
6. Establishes authenticated session

### Authorization Rules

- `/`, `/css/**`, `/images/**`, `/js/**`, `/h2-console/**`, `/profile` - Public access
- `/api/v1/**` - Requires USER role
- All other endpoints - Requires authentication

## 🧪 Testing

### Run Tests

```bash
# All tests
mvn test

# Specific test class
mvn test -Dtest=SpringBootMustachePostApplicationTests

# With coverage
mvn test jacoco:report
```

### Test Structure

```
src/test/java/
└── com/hendisantika/
    └── SpringBootMustachePostApplicationTests.java
```

## 📊 Monitoring & Health

### Actuator Endpoints

Spring Boot Actuator provides monitoring endpoints:

- `/actuator/health` - Application health
- `/actuator/info` - Application information
- `/actuator/metrics` - Application metrics

## 🚀 Deployment

### Docker Deployment

```dockerfile
FROM openjdk:21-jdk
COPY target/spring-boot-mustache-post-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

### Build and Run

```bash
docker build -t spring-boot-mustache-post .
docker run -p 8080:8080 spring-boot-mustache-post
```

## 🔧 Troubleshooting

### Common Issues

#### Lombok Not Working

If you encounter compilation errors related to missing getters/setters:

1. Enable Lombok annotation processing in your IDE
2. Ensure Lombok plugin is installed
3. For Java 25, ensure compatible Lombok version

#### OAuth2 Configuration

1. Verify client ID and secret are correctly set
2. Check redirect URIs in OAuth2 provider settings
3. Ensure proper scopes are configured

#### Database Connection

1. Check H2 console is accessible at `/h2-console`
2. Verify database URL and credentials
3. For production, ensure database server is running

## 📚 Dependencies

### Core Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Mustache
- Spring Boot Starter OAuth2 Client
- Spring Session JDBC
- Spring Boot DevTools
- Lombok
- H2 Database

### Testing Dependencies

- Spring Boot Starter Test
- Spring Security Test

## 👨‍💻 Development

### Code Style

- Follow Java naming conventions
- Use Lombok annotations for reducing boilerplate
- Implement proper error handling
- Write comprehensive tests

### Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👤 Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34
- GitHub: [@hendisantika](https://github.com/hendisantika)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- OAuth2 providers (Google, Naver) for authentication services
- Open source community for valuable libraries and tools

---

**Note**: This application demonstrates modern Spring Boot development practices including OAuth2 authentication, JPA
data management, and template-based web development using Mustache.