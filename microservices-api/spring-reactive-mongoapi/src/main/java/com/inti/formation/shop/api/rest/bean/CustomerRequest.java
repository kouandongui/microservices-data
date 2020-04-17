package com.inti.formation.shop.api.rest.bean;

import com.inti.formation.shop.api.repository.model.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sylvanius Kouandongui
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerRequest extends Customer {

}
