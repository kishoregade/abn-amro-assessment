package com.abn.amro.recipe.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

/* used Lombok annotation called @Data which is equivalent to setter and getter methods 
 * 
 * Recipe Entity class with one to many mapping 
 * 
 * */

@Entity
@Data
@Table(name="tbl_reciepies")
@ToString
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reciepeId;
	@Column(name = "reciepe_name")
	private String reciepeName;
	@Column(name = "veg")
	private boolean veg;
	@Column(name = "price")
	private float price;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Ingrediants.class)
	@JoinColumn(name ="ref_id", referencedColumnName = "reciepeId")
    private Set<Ingrediants> ingrediants;
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd‐MM‐yyyy HH:mm")
	@Column(name = "creation_date")	
	private Date date;
			
}
