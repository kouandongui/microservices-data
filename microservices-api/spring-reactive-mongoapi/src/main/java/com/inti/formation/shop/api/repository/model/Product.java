package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "product")
//@CompoundIndexes({
////        @CompoundIndex(name = "product", def = "{ label: 1 }", unique = false)
//        // unique = false acceptation des doublons true non
//        // unique = true rejet  des doublons, si true il ecrase
//})

/**
 * 
 * @author Perrine
 *
 */
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6010144181226281299L;
	/**
	 * 
	 */

	@Id 
	private Long id;
//	@Indexed(unique = false)
	private String label;
	private String description;
	private String origine;
	private List <String> couleur;
	

}
