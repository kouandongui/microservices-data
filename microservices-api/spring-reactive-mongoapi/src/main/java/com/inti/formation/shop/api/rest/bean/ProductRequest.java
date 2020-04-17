package com.inti.formation.shop.api.rest.bean;

import com.inti.formation.shop.api.repository.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ProductRequest extends Product {
}
