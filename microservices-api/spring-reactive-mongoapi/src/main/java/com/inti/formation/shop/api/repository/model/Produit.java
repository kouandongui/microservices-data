package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Marion Gloriant
 */
@Data
@Document(collection="product")

public class Produit implements Serializable {

	@Id
	private Integer id;
	private String libelle;
	private String origine;
	private String description;
	private String couleur[];
	
}
