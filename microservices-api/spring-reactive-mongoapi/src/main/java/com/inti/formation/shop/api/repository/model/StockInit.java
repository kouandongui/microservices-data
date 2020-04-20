package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


/**
 * @author Benjamin Thomas
 */
@Data
@Document(collection = "stockinit")
//@CompoundIndexes({
//        @CompoundIndex(name = "stockinit", def = "{ magasin : 1}", unique = false)
//        // unique = false acceptation des doublons true non
//        // unique = true rejet  des doublons
//})

public class StockInit implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5640779920226065057L;
	/**
     * stockinit identifer
     */
    @Id
    private Long id;
    @Indexed(unique = false)
    private long quantite;
    private String magasin;
    private boolean active;
    private long idproduct;
    private Date date;
    
}
