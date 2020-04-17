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
