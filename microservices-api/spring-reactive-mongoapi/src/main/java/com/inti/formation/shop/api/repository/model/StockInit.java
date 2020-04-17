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
@Document(collection = "customer")
@CompoundIndexes({
        @CompoundIndex(name = "customer", def = "{ name: 1, dateNaissance: 1 }", unique = false)
        // unique = false acceptation des doublons true non
        // unique = true rejet  des doublons
})
public class StockInit implements Serializable{

	@Id
	private long id;
	@Indexed(unique = false)
	private String magasin;
	private Integer quantité;
	private boolean active;
	private long idproduct;
	private Date date;
	
	
}
