package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
	@Document(collection = "product")
//	@CompoundIndexes({
//	        @CompoundIndex(name = "product", def = "{ libelle: 1 }", unique = false)
//	        // unique = false acceptation des doublons true non
//	        // unique = true rejet  des doublons (écrase le document)
//	})

	/**
	 * 
	 * @author IN-LL-056
	 *
	 */     //prour use slash + ** = met auto

public class Product implements Serializable{
	
	
	//Identifiant du produit
	
	
	private static final long serialVersionUID = -6226128267607337868L;
	
	
	@Id  //  def key primaire 
	private Long id;
	 @Indexed(unique = false) //permet de lier le libelle à l'index
	private String libelle;
	private String description;
	private String origine;
	private List<String> couleur;
	

	
}
