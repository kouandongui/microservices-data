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

    >com.inti.formation.shop.api.repository.model.stockinit

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

- creer les repositories product et stockinit 

- creer un service produit pour l'enregistrement de produit et un autre pour la liste des produits

- crer un service stok pour l'enregistrement de stockinit et un autre pour la liste des stoks

 - créer dans Endpoint ( le controller) des roots pour enregister un produit, lister les produits
 
 - créer dans Endpoint ( le controller) des roots pour enregister un stockinit, lister les stoksinit