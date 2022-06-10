package com.abn.amro.recipe.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.model.User;

/**
 * CustomUserDetailsImpl class implemented UserDetails Interface and It provides core information of the User.
 * @author gpvkki
 *
 */
public class CustomUserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
    
    private User user;
	private Collection<GrantedAuthority> authorities;
   
 
	public CustomUserDetailsImpl(User user) {
		super();
		this.user=user;
		// TODO Auto-generated constructor stub
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		authorities = new ArrayList<>();
        for(Role role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
           // logger.debug("role" + role + " role.getRole()" + (role.getRolename()));
        }
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
