package com.abn.amro.recipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * 
 * Ingredients Entity class 
 * @author gpvkki
 *
 */

@Entity
@Data
@Table(name = "tbl_ingrediants")
public class Ingrediants {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name = "name")
	 private String name;

	 @Column(name = "quantity")

	 private String quantity;

	 public Long getId() {
	        return id;
	 }
}
