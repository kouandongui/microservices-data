package com.inti.formation.shop.api.repository.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Sylvanius Kouandongui
 */

@Data
@Document(collection = "produit")
@CompoundIndexes({
        @CompoundIndex(name = "produit", def = "{ libelle: 1, origine: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons
})

public class Produit implements Serializable {
    /**
     * stockinit identifier
     */
    @Id
    private int id;
    @Indexed(unique = false)
    private String libelle;
    @Indexed(unique = false)
    private String origine;
    private String description;
    @Indexed(unique = false)
    private String[] couleur;
}
