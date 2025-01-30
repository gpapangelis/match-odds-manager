# Match Odds Manager

Match Odds Manager is an application that allows users to manage match data and odds. The app provides a backend API for CRUD operations on matches and odds. It also comes with sample SQL scripts for creating and initializing the required tables in the database.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete match and odds data.
- **Sample Data**: Pre-configured SQL scripts to initialize the database with sample data.
- **Swagger UI**: API documentation available for easy interaction with the backend.

## Technologies Used

- Spring Boot (Java)
- PostgreSQL
- Docker
- Kubernetes
- Swagger UI

### Docker
![docker-image](https://github.com/user-attachments/assets/0d9809b2-48cb-4f4a-8788-33a2e7d697c1)
Docker allows you to package the app and its dependencies in containers, making it easier to deploy across different environments.

Kubernetes
### ![kubernetes-image](https://github.com/user-attachments/assets/fcc988e7-96e5-4d89-8587-4ef2bff3e9d6)
Kubernetes automates the deployment, scaling, and management of containerized applications like your Match Odds Manager.

### Swagger UI
![swagger-image](https://github.com/user-attachments/assets/58bb94b9-900c-40d0-8cd3-74ea49270f3b)
Swagger UI provides a powerful, interactive API documentation interface to interact with the backend API.

## Getting Started

### Docker Compose

To run the app with Docker Compose:

1. Clone the repository.
2. Navigate to the project folder.
3. Make sure you have Docker and Docker Compose installed.
4. Run the following command to start the app:

    ```sh
    docker-compose up -d
    ```

5. The app will be accessible on **port 8080**.

### Kubernetes Deployment

To deploy the app on Kubernetes:

1. Navigate to the `kubernetes-deployments` folder.
2. Apply the PostgreSQL and app deployments using the following commands:

    ```sh
    kubectl apply -f postgres-deployment.yaml
    kubectl apply -f app-deployment.yaml
    ```

3. The app should now be deployed on your Kubernetes cluster.

### Swagger Documentation

Once the app is running, you can access the API documentation via **Swagger UI** at:

http://localhost:8080/swagger-ui/index.html#/
