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
 * @author Perrine
 *
 */

@Data
@Document(collection = "stockinit")
//@CompoundIndexes({
//        @CompoundIndex(name = "stockinit", def = "{ magasin: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons, si true il ecrase
//})
public class Stockinit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	private Long id;
	@Indexed(unique = false)
	private long quantite;
	private boolean active;
	private String magasin;
	private long idproduct;
	private Date date;

}
