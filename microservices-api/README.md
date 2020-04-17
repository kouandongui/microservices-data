- supprimer la collection customer de la base shop

```mongojs
use shop
db.cutsomer.drop()
```

- Basculer l'application microservice-mongo api sur la base shop

```yaml
spring:
  port: 0
  application:
    name: spring-rective-mongoapi

  data:
    mongodb:
      uri: mongodb://192.168.99.101:27017,192.168.99.101:27017 # localhost pblm liée à dockers 192.168.99.101 IP link with quickStart docker
   -> database: shop <-
```

- creer le model mongo de produit

    >com.inti.formation.shop.api.repository.model.Product

```java

package com.inti.formation.shop.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Alexandre Guillemot
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

/**
 *
 * @Document(collection = nomDelacollection)
 * permet de spécifier au module spring Data que ceci et une instance
 * de table mongodb c'est l'équivalant de @Entity de JPA pour mongodb
 *
 */

@Document(collection = "product")

/**
 *
 * @CompoundIndexes({
 *         @CompoundIndex(name = "product", def = "{ origine: 1}", unique = false)
 * })
 *
 * @CompoundIndexes permet de spécifier les indexs de la collection ci dessous
 *       @CompoundIndex permet de spécifier un index de la collection ci dessous
 * - name: nom de la collection
 * - def: clé valeur de l'index au format JSON
 * - unique: si les duplicatats sont ppermis ou non ici ils ne sont pas permis
 */

@CompoundIndexes({
        @CompoundIndex(name = "product", def = "{ origine: 1}", unique = false)
})
public class Product {

    @Id
    private String libelle;
    private String description;
    private String origine;
    private String[] couleur = {"bleu", "jaune", "gris"};

}

```  
- creer le model mongo de tockinit

    >com.inti.formation.shop.api.repository.model.Stockinit

```java

package com.inti.formation.shop.api.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

/**
 *
 * @Document(collection = nomDelacollection)
 * permet de spécifier au module spring Data que ceci et une instance
 * de table mongodb c'est l'équivalant de @Entity de JPA pour mongodb
 *
 */

@Document(value = "stockinit")

/**
 *
 * @CompoundIndexes({
 *         @CompoundIndex(name = "product", def = "{ origine: 1}", unique = false)
 * })
 *
 * @CompoundIndexes permet de spécifier les indexs de la collection ci dessous
 *       @CompoundIndex permet de spécifier un index de la collection ci dessous
 * - name: nom de la collection
 * - def: clé valeur de l'index au format JSON
 * - unique: si les duplicatats sont ppermis ou non ici ils ne sont pas permis
 */

@CompoundIndexes({
        @CompoundIndex(name = "product", def = "{ idproduct: 1}", unique = false)
})

public class stockinit {

    @Id
    private String magasin;
    private String quantite;
    private Boolean active;
    private Integer idproduct; // pour poouvoir effectuer des recherche sybler sur des produits données

    @Transient
    private Date date; // = new DateOperators.IsoDateFromParts();

    public Date getDate() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-ddTHH:mm:ssZ");
        return df.parse(df.format(new Date()));
    }

}

``` 

- creer le repositorie product

    > com.inti.formation.shop.api.repository.IProductRepository

````java

package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {

}

````

- creer le repositorie stockinit 

    > com.inti.formation.shop.api.repository.IStockinitRepository

````java

package com.inti.formation.shop.api.repository;

import com.inti.formation.shop.api.repository.model.Stockinit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IStockinitRepository extends ReactiveMongoRepository<Stockinit, String> {
}


````

- creer un service produit pour l'enregistrement de produit et un autre pour la liste des produits

```java

package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    public Mono<Product> saveProduct(Product product);
    public Flux<Product> findAllProduct();

}



```


- crer un service stock pour l'enregistrement de stockinit et un autre pour la liste des stoks

```java

package com.inti.formation.shop.api.service;

import com.inti.formation.shop.api.repository.model.Stockinit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStockinitService {

    public Mono<Stockinit> saveStock(final Stockinit stock);
    public Flux<Stockinit> findAllStock();

}



```

 - créer dans Endpoint ( le controller) des roots pour enregister un produit, lister les produits
 
    >com.inti.formation.shop.api.Endpoint
                                                                                                       >
 ```java
 
public class Endpoint {
    
    @Autowired
    IProductService productService;

    @GetMapping
    @RequestMapping(value = "/products")
    public Flux<Product> getProducts() {
        return productService.findAllProduct()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(product -> product);
    }

    @PostMapping(value = "/saveProduct", headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Product is registered")
    public Mono<String> createProduct(@RequestBody Product product) {
    
          if (ObjectUtils.anyNotNull(product) && !ObjectUtils.allNotNull(product.getCouleur(), product.getDescription(), product.getLibelle(), product.getOrigine())) {
              log.error("Validation error: one of parameter is not found");
              return Mono.error(new ValidationParameterException("Validation error"));
          }
          return Mono.just(product)
                  .map(data ->
                  {
                      return productService.saveProduct(data).subscribe().toString();
                  });
    
        }

}
 
 ```
 
 - créer dans Endpoint ( le controller) des roots pour enregister un stockinit, lister les stoksinit
 
    >com.inti.formation.shop.api.Endpoint

 ```java

public class Endpoint {

    @Autowired
    IStockinitService stockinitService;

    @GetMapping
    @RequestMapping(value = "/stocks")
    public Flux<Stockinit> getStocks() {
        return stockinitService.findAllStock()
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(stock -> stock);
    }

    @PostMapping(value = "/saveStock", headers = "Accept=application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Product is registered")
    public Mono<String> createStock(@RequestBody Stockinit stock) {
    
            if (ObjectUtils.anyNotNull(stock) && !ObjectUtils.allNotNull(stock.getActive(), stock.getIdproduct(), stock.getMagasin(), stock.getQuantite())) {
                log.error("Validation error: one of parameter is not found");
                return Mono.error(new ValidationParameterException("Validation error"));
            }
            return Mono.just(stock)
                    .map(data ->
                    {
                        return stockinitService.saveStock(data).subscribe().toString();
                    });
    
    }
}
 
 ```