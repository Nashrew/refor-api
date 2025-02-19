# Refor-API Documentation

## Application Overview

The `refor-api` application is a Spring Boot application designed to manage reforestation data. It uses Kotlin for the backend logic, H2 as an in-memory database for development, and Flyway for database migrations. The application is containerized using Docker and can be run using Docker Compose.

## Flyway Migrations

Flyway is used to manage database migrations. Migrations are SQL scripts that define changes to the database schema.

### Adding a New Migration

1. Create a new SQL file in the `src/main/resources/db/migration` directory. The file name should follow the Flyway naming convention: `V<version>__<description>.sql`. For example, `V2__Add_new_table.sql`.
2. `<version>` should represent the date the migration was created in the following format: `<YYYYMMDDHHMM>` (e.g., January 1st 2022 at noon would be `202201011200`).
3. Add the SQL statements to define the changes. For example:
    ```sql
    CREATE TABLE "new_table" (
        "id" VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
        "name" VARCHAR(255) NOT NULL
    );
    ```
4. Save the file. Flyway will detect and apply the new migration when the application starts.

## How to Run the Application

### From IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Navigate to the `src/main/kotlin/com/nashsoft/refor_api` directory.
3. Right-click on the `ReforApiApplication.kt` file and select `Run 'ReforApiApplication'`.
4. The application will start, and you can access it at `http://localhost:8080`.

### Using Docker Compose

1. Ensure Docker is installed and running on your machine.
2. Open a terminal and navigate to the project directory.
3. Run the following command to build and start the application:
    ```sh
    docker-compose up --build
    ```
4. The application will start, and you can access it at `http://localhost:8080`.
5. To avoid conflicts with the local database and re-apply all migrations, you can stop the application and remove the containers using the following command:
    ```sh
    docker-compose down
    ```
-----------------------------------

## Deployment to GCP using GitHub Actions

This project is configured to deploy to Google Cloud Platform (GCP) using GitHub Actions. The deployment process involves building a Docker image, pushing it to Google Container Registry (GCR), and deploying it to Google Kubernetes Engine (GKE).

### Prerequisites

1. **GCP Project**: Ensure you have a GCP project set up.
2. **GKE Cluster**: Create a GKE cluster.
3. **Service Account**: Create a service account with the necessary permissions and download the JSON key file.
4. **GitHub Secrets**: Add the following secrets to your GitHub repository:
    - `GCP_PROJECT_ID`: Your GCP project ID.
    - `GCP_SA_KEY`: The JSON key file content of your service account.

### GitHub Actions Workflow

The deployment process is defined in the `.github/workflows/deploy.yaml` file. It consists of two jobs: `build` and `deploy`.

#### Build Job

1. **Checkout Code**: Checks out the repository code.
2. **Set up Cloud SDK**: Sets up the Google Cloud SDK.
3. **Build and Push Docker Image**: Builds the Docker image and pushes it to GCR.

#### Deploy Job

1. **Checkout Code**: Checks out the repository code.
2. **Set up Cloud SDK**: Sets up the Google Cloud SDK.
3. **Install gke-gcloud-auth-plugin**: Installs the GKE auth plugin.
4. **Configure kubectl**: Configures `kubectl` to use the GKE cluster.
5. **Deploy to GKE**: Deploys the application to GKE using `kubectl`.

### Deployment Configuration

The deployment configuration is defined in the following files:

- `cloudbuild.yaml`: Defines the steps to build and push the Docker image.
- `deployment.yaml`: Defines the Kubernetes deployment.
- `service.yaml`: Defines the Kubernetes service.

### Steps to Deploy

1. **Push to Main Branch**: Push your changes to the `main` branch.
2. **GitHub Actions**: GitHub Actions will automatically trigger the deployment workflow.

-----------------------------------

## TODO / Next Steps
* Tests? (:
* Move on to a FE? Try Cursor maybe.
