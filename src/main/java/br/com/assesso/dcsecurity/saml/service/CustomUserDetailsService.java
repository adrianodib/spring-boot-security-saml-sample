package br.com.assesso.dcsecurity.saml.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.assesso.dcsecurity.saml.entity.SecUser;
import br.com.assesso.dcsecurity.saml.repository.SecUserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	private final SecUserRepository userRepo;
	
	@Autowired
	public CustomUserDetailsService(SecUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SecUser user = Optional.ofNullable(userRepo.findByDsUsername(username))
				.orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));
		
		//Pegar isso do Banco de Dados
		//List<GrantedAuthority> autorityListAdmin= AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"); 
		List<GrantedAuthority> autorityListUser= AuthorityUtils.createAuthorityList("ROLE_USER"); 
		
		User userDetails = new User(user.getDsUsername(), user.getDsPass(), autorityListUser);
				
		return userDetails;  
	}

}
