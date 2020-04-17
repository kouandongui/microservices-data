package com.inti.formation.shop.api.repository.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Marion Gloriant
 */
@Data
@Document(collection = "stockinit")

public class StockInit implements Serializable {
	
	@Id
	private Integer id;
	@Indexed(unique=false)
	private int quantite;
	private String magasin;
	private Boolean active;
	private int idproduct;
	private Date date;
	
}
