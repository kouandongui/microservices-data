package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "stock")
//@CompoundIndexes({
//        @CompoundIndex(name = "stock", def = "{ magasin: 1 }", unique = false)
//        // unique = false acceptation des doublons true non
//        // unique = true rejet  des doublons, c'est à dire qu'il va écraser (update) le document
//})
/**
 * 
 * @author aimi-
 *
 */
public class Stockinit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
//	@Indexed(unique = false)
	private String magasin;
	private long quantite;
	private boolean active;
	private long idproduct;
	private Date date;

}
