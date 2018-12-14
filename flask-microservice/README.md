# Microservice + Python + PostgreSQL + Redis + Docker compose

### Reference
  
  - https://www.linode.com/docs/applications/containers/deploying-microservices-with-docker/

### Test the Microservice
  1. Use Docker Compose to build all of the images and start the microservice:

    cd flask-microservice/ && docker-compose up

You should see all of the services start in your terminal.

  2. Open a new terminal window and make a request to the example application:

    curl localhost
   
   **Hello Linode! This page has been viewed 1 time(s).**

  3. Reset the page hit counter:

    curl localhost/resetcounter
   **Successfully deleted redis and postgres counters**

  4. Return to the terminal window where Docker Compose was started to view the standard out log:

   **flaskapp_1 | DEBUG in linode [/home/flask/app/web/linode.py:56]:**

   **flaskapp_1 | reset visitor count**

### Using Containers in Production: Best PracticesPermalink
The containers used in the example microservice are intended to demonstrate the following best practices for using containers in production:

Containers should be:

 - **Ephemeral** It should be easy to stop, destroy, rebuild, and redeploy containers with minimal setup and configuration.

The Flask microservice is an ideal example of this. The entire microservice can be brought up or down using Docker Compose. No additional configuration is necessary after the containers are running, which makes it easy to modify the application.
 - **Disposable** Ideally, any single container within a larger application should be able to fail without impacting the performance of the application. Using a restart: on-failure option in the docker-compose.yml file, as well as having a replica count, makes it possible for some containers in the example microservice to fail gracefully while still serving the web application with no degradation to the end user.

Note
The replica count directive will only be effective when this configuration is deployed as part of a Docker Swarm, which is not covered in this guide.
 - **Quick to start** Avoiding additional installation steps in the Docker file, removing dependencies that aren’t needed, and building a target image that can be reused are three of the most important steps in making a web application that has a quick initialization time within Docker. The example application uses short, concise, prebuilt Dockerfiles in order to minimize initialization time.
 - **Quick to stop** Validate that a `docker kill --signal=SIGINT {APPNAME}` stops the application gracefully. This, along with a restart condition and a replica condition, will ensure that when containers fail, they will be brought back online efficiently.
 - **Lightweight** Use the smallest base container that provides all of the utilities that are needed to build and run your application. Many Docker images are based on Alpine Linux, a light and simple Linux distribution that takes up only 5MB in a Docker image. Using a small distro saves network and operational overhead and greatly increases container performance. The example application uses alpine images where applicable (NGINX, Redis, and PostgreSQL), and uses a python-slim base image for the Gunicorn / Flask application.
 - **Stateless** Since they are ephemeral, containers typically shouldn’t maintain state. An application’s state should be stored in a separate, persistent data volume, as is the case with the microservice’s PostgreSQL data store. The Redis key-value store does maintain data within a container, but this data is not application-critical; the Redis store will fail back gracefully to the database should the container not be able to respond.
 - **Portable** All of an app’s dependencies that are needed for the container runtime should be locally available. All of the example microservice’s dependencies and startup scripts are stored in the directory for each component. These can be checked into version control, making it easy to share and deploy the application.
 - **Modular** Each container should have one responsibility and one process. In this microservice, each of the major processes (NGINX, Python, Redis, and PostgreSQL) is deployed in a separate container.
 - **Logging** All containers should log to STDOUT. This uniformity makes it easy to view the logs for all of the processes in a single stream.
 - **Resilient** The example application restarts its containers if they are exited for any reason. This helps give your Dockerized application high availability and performance, even during maintenance periods.
