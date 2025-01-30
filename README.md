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
![Docker](https://www.docker.com/sites/default/files/d8/2019-07/Moby-logo.png)  
Docker allows you to package the app and its dependencies in containers, making it easier to deploy across different environments.

### Kubernetes
![Kubernetes](https://kubernetes.io/images/kubernetes-horizontal-color.png)  
Kubernetes automates the deployment, scaling, and management of containerized applications like your Match Odds Manager.

### Swagger UI
![Swagger UI](https://swagger.io/wp-content/uploads/2019/06/swagger_logo_horiz.png)  
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
