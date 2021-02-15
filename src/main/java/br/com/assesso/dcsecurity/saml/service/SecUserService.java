package br.com.assesso.dcsecurity.saml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assesso.dcsecurity.saml.entity.SecUser;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.UserAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.UserNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecUserRepository;
import br.com.assesso.dcsecurity.saml.utils.ChaveUtil;

@Service
//public class SecUserService implements UserDetailsService {
public class SecUserService {

	@Autowired
	private SecUserRepository userRepo;
	
	public List<SecUser> getAllUsers() {
		return userRepo.findAll();
	}
	
  public SecUser loadUserById(byte[] id) throws UserNotFoundException {

		SecUser user = userRepo.findByIdUser(id);		
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}	
    
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(SecUser user) throws CustomConstraintViolationException {		
		userRepo.delete(user);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecUser createUser(SecUser user) throws UserAlreadyExistsException, UserNotFoundException  {
		
		String id = ChaveUtil.executa();
		user.setIdUserString(id);
		
		SecUser byUsername = userRepo.findByDsUsername(user.getDsUsername());
		SecUser userSaved;
		
		// verifica se o usuário já foi cadastrado
		if (byUsername != null) {
			throw new UserAlreadyExistsException();
		} else {
			userSaved = userRepo.save(user);

			// envia e-mail para o usuário adicionado
			//userService.sendEmailAccountVerification(user, token);
		}

		return userSaved;
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public void updateUser(SecUser user) throws UserNotFoundException {

		SecUser userAux = userRepo.findByIdUser(user.getIdUser());
		if (userAux == null) {
			throw new UserNotFoundException();
		}
		
		// atualiza
		userRepo.save(user);
	}	
	
	public SecUser loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SecUser user = userRepo.findByDsUsername(username);
		
		if (user == null) { 
			throw new UsernameNotFoundException(String.format("Usuário %s não existe.", username));
		}
		
		return user;
	}
 
    
	@Transactional(rollbackFor = Exception.class)
  public void createVerificationCodeForUser(final SecUser user, final String verificationCode) {
   	user.setVerificationCode(verificationCode);
   	userRepo.save(user);
  }
    
    
//    public void deleteUser(final SecUser user) {
//        final VerificationToken verificationToken = tokenRepo.findByUser(user);
//
//        if (verificationToken != null) {
//            tokenRepo.delete(verificationToken);
//        }
//
//        final PasswordResetToken passwordToken = passwordTokenRepo.findByUser(user);
//
//        if (passwordToken != null) {
//            passwordTokenRepo.delete(passwordToken);
//        }
//
//        userRepo.delete(user);
//    }
	
	


}