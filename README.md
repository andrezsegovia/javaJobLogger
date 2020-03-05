# How to use the project

## Pre Requirements
- Jdk 6 or later
- Docker 19.03.6
- Docker Compose 1.24.1
- Maven 3.6.3

## Create the MySQL Docker Container

Downloads MySQl 5.7.27, set the database up and start the container
```bash
docker-compose up -d --force-recrate
```

## Create the table Log_Values

Once the docker container is running we need to create the table Log_Values in the Log database 

```bash
docker exec -i jobLogger mysql -u jobLogger --password='jobLogger123' --database='log' < ./createTableLogValues.sql 
```

## Run the test

With the following command we can run all the test
```bash
mvn test
```



