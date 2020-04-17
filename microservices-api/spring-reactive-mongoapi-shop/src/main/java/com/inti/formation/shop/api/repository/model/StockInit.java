package com.inti.formation.shop.api.repository.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
@Document(collection = "stockinit")
@CompoundIndexes({
        @CompoundIndex(name = "stockinit", def = "{ idproduct: 1, magasin: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons
})

public class StockInit implements Serializable {
    /**
     * stockinit identifier
     */
    @Id
    private int id;
    @Indexed(unique = false)
    private int quantite;
    @Indexed(unique = false)
    private String magasin;
    private String active;
    @Indexed(unique = false)
    private int idproduct;
    private Date date;
}
