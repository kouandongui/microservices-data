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
