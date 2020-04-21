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
 * 
 * @author Cecile Pieters
 *
 */
@Data
@Document(collection = "stockinit")
@CompoundIndexes({
     //  @CompoundIndex(name = "stockinit", def = "{ magasin: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons
})

public class Stockinit implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 private long id;
	 //@Indexed(unique = false)
	 private long quantite;
	 private String magasin;
	 private Boolean active;
	 private long idproduct;
	 private Date date;

}
