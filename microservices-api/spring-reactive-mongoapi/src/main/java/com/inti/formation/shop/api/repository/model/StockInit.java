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
@Document(collection = "stockinit")
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
	@Indexed(unique = false)
	private Integer quantite;
	@Indexed(unique = false)
	private boolean active;
	@Indexed(unique = false)
	private Long idproduct;
	@Indexed(unique = false)
	private Date date;
	
	
}
