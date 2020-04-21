# SPRING REACTIVE API ( spring 5 ) 
Running spring-reactive-mongoapi
```
cd microservices-data

mvn clean install

To run spring-reactive-mpongoapi

cd microservices-api/spring-reactive-mongoapi/

Run ApplicationShop.java ( from com.inti.formation.shop.api )
```

Creating image docker 
* Image will be created from  Dockerfile
```
cd  spring-reactive-mongoapi
mvn clean install
docker build -t api:latest .
```

