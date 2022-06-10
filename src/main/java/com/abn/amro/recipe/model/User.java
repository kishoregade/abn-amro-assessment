package com.abn.amro.recipe.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * User Entity class with ManyToMany mapping
 * @author gpvkki
 *
 */
@Data
@Entity
@Table(name = "tbl_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name="user_id",referencedColumnName = "userid"),
			inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "Id"))
	private Collection<Role> roles;
	
}
