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
 * @author IN-LL-056
 *
 */


@Data
@Document(collection = "customer")
//@CompoundIndexes({
//        @CompoundIndex(name = "customer", def = "{ name: 1, dateNaissance: 1 }", unique = false)
//        // unique = false acceptation des doublons true non
//        // unique = true rejet  des doublons
//})
public class StockInit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8222863240299137209L;
	
	@Id
	private Long id;
	@Indexed(unique = false)
	private String magasin;
	private Integer quantite;
	private boolean active;
	private Long idproduct;
	private Date date;
	
	
}
