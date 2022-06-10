package com.abn.amro.recipe;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.model.User;
import com.abn.amro.recipe.repository.RoleRepository;
import com.abn.amro.recipe.repository.UserRepository;

@SpringBootApplication
@Import(ModelMapper.class)
public class AbnamroReciepeAssignmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AbnamroReciepeAssignmentApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role role = Role.builder().rolename("ROLE_ADMIN").build();
		ArrayList<Role> roleList = new ArrayList<Role>();
		roleList.add(role);
		roleRepository.save(role);
		User user = User.builder().userid(1).
				userName("admin").password(passwordEncoder.encode("123456")).roles(roleList).build();
		userRepository.save(user);		
		
	}

}
