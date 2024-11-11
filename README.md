# Spring Boot Reactive Employee Service

This project is a Spring Boot application that demonstrates both synchronous and asynchronous endpoints. It serves employee data via traditional and reactive approaches using Spring WebFlux. The application is containerized with Docker, allowing easy deployment and scalability.

## Features

- **Two Endpoints**:
    - **Synchronous Endpoint**: `/k8s/getAllEmployee`
        - Returns a list of 10 static employees after a 100-millisecond delay.
    - **Reactive Endpoint**: `/k8s/reactiveway`
        - Streams employee data every second to demonstrate asynchronous behavior.
- **Containerization**: Docker-ready with Maven build profiles.

## Tech Stack

- **Java**, **Spring Boot**
- **Spring WebFlux** (for reactive endpoint)
- **Docker**

## Getting Started

### Prerequisites

- **Java** 17
- **Maven** 3.x
- **SpringBoot** 3.x
- **Docker** (optional, for containerization)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/tauseef-ameen/springreactive.git
   cd springreactive
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   By default, the server will start on port **8081**.

### Usage

- Access the synchronous endpoint:
  ```plaintext
  http://localhost:8081/k8s/getAllEmployee
  ```
- Access the reactive endpoint:
  ```plaintext
  http://localhost:8081/k8s/reactiveway
  ```

### Docker Containerization

To create and run a Docker container for the application:

1. **Build the Docker image**:
   ```bash
   mvn clean install -Pcreateimage
   ```

2. **Run the Docker container**:
   ```bash
   docker run -p 8080:8080 springreactive/docker-containerize:0.0.2-SNAPSHOT
   ```

The application will be available on `http://localhost:8081`.

## License

This project is licensed under the [MIT License](LICENSE).

---

 
