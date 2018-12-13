# Microservice - Spring boot, Gradle, Postgres and Docker

### Reference
  part 1 - https://www.javacodegeeks.com/2018/11/spring-microservices-docker-kubernetes.html
  
  part 2 - https://www.javacodegeeks.com/2018/11/spring-microservices-docker-kubernetes-2.html

  github - https://github.com/anirudh83/productService
  
  docker - https://severalnines.com/blog/deploying-postgresql-docker-container
  
  docker - https://www.linode.com/docs/applications/containers/docker-container-communication/#before-you-begin

### Gradle build and app execution
    $ ./gradlew build
    $ ./gradlew bootRun

### Docker - Postgres Database
Create Postgresql database container based on the below configuration provided.

    $ docker run --name oms_postgres -p 5432:5432 -e POSTGRES_USER=dbuser -e POSTGRES_DB=products_db -e POSTGRES_PASSWORD=password -d postgres

Enable oms_postgres container to accept connection from other containers

    $ docker exec -it oms_postgres /bin/bash
    root@b2837994112d: echo "host all  all    0.0.0.0/0  md5" >> ./var/lib/postgresql/data/pg_hba.conf 

### Building docker image
    $ docker build . -t product

### Running docker image
    $ docker run -p 8080:8080 --link=oms_postgres:database product

### Debuggin steps if any issue comes
Login to postgres db server via postgres client
  > $ docker exec -it oms_postgres
  
	root@b2837994112d:/# psql -U dbuser -d products_db --password
	Password:
	psql (11.1 (Debian 11.1-1.pgdg90+1))
	Type "help" for help.
	
	products_db=# \dt
	         List of relations
	 Schema |  Name   | Type  | Owner
	--------+---------+-------+--------
	 public | product | table | dbuser
	(1 row)
	
	products_db=# select * from product;
	 id | description | name | sku
	----+-------------+------+-----
	(0 rows)
	
	products_db=#

Directly login with postgres schema
	docker exec -it oms_postgres psql -d postgres -U dbuser

### POST http request
    $ curl --header "Content-Type: application/json" --request POST --data '{"name" : "Nike shoes", "description" : "mens shoes size 10","sku" : "1234asc"}' http://localhost:8080/products
