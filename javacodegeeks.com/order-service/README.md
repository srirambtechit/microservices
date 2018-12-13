# Microservice - Spring boot, Gradle, Postgres and Docker

### Reference
  site - https://www.javacodegeeks.com/2018/11/spring-microservices-docker-kubernetes-2.html

  github - https://github.com/anirudh83/orderService

part of order management system service

### Step 1 : Configure Postgres Database using docker
	$ docker run --name oms_order_postgres -p 5432:5432 -e POSTGRES_USER=dbuser -e POSTGRES_DB=orders_db -e POSTGRES_PASSWORD=password -d postgres

Note : if the container is already running :
	$ docker start oms_postgres

To create orders_db :

    docker exec -it oms_postgres psql -d postgres -U dbuser -c "CREATE DATABASE orders_db;"
	docker exec -it oms_postgres psql -d postgres -U dbuser -c "GRANT ALL PRIVILEGES ON DATABASE orders_db TO dbuser;"

Once the DB is up and running configure its details in application.properties file

#### Build
	./gradlew build

### Run
	./gradlew bootRun
	docker exec -it oms_postgres psql -d postgres -U dbuser

### Create order container
	$ docker build . -t order

### Start order container
	$ docker run -p 8081:8080 --link=oms_postgres:database order
