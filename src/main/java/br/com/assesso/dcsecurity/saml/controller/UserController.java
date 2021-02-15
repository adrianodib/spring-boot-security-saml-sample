package br.com.assesso.dcsecurity.saml.controller;

import static br.com.assesso.dcsecurity.saml.utils.PasswordUtil.validatePasswordSize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.assesso.dcsecurity.saml.email.NotificacaoService;
import br.com.assesso.dcsecurity.saml.email.to.ContactTO;
import br.com.assesso.dcsecurity.saml.email.to.UserTO;

import br.com.assesso.dcsecurity.saml.dto.NewPassDto;
import br.com.assesso.dcsecurity.saml.dto.SecUserDTO;
import br.com.assesso.dcsecurity.saml.entity.SecUser;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.NotificacaoException;
import br.com.assesso.dcsecurity.saml.exception.NotificacaoRuntimeException;
import br.com.assesso.dcsecurity.saml.exception.PassNotMatchException;
import br.com.assesso.dcsecurity.saml.exception.PasswordMininumSizeException;
import br.com.assesso.dcsecurity.saml.exception.TargetNotFoundException;
import br.com.assesso.dcsecurity.saml.exception.UserAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.UserNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecUserRepository;
import br.com.assesso.dcsecurity.saml.service.SecUserService;
import br.com.assesso.dcsecurity.saml.utils.Constantes;
import br.com.assesso.dcsecurity.saml.utils.GenericResponse;
import io.swagger.annotations.ApiOperation;

/**
 * User Controller
 * 
 * @author adriano.dib
 * @since nov/2020
 *
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private SecUserService userService;

	@Autowired
	private SecUserRepository userRepo;

	@Autowired
	private Environment env;

	@PostMapping("/create")
	@ApiOperation(value = "Insere um novo usuário")
	@Secured("ROLE_USER")
	public SecUser createUser(@Valid @RequestBody SecUserDTO userDto)
	    throws UserAlreadyExistsException, UserNotFoundException, PasswordMininumSizeException {

		String passSizeProperty = env.getProperty("app.password.minimum.size");

		String formPassword = userDto.getDsPass();

		validatePasswordSize(passSizeProperty, formPassword);

		SecUser user = extractSecUserFromDTO(userDto);
		
		SecUser userSaved = userService.createUser(user);
		return userSaved;
	}

	@DeleteMapping(path = "/delete/{userIdString}")
	@ApiOperation(value = "Deleta um usuário pelo ID")
	@Secured("ROLE_USER")
	public void deleteUser(@PathVariable String userIdString)
	    throws UserNotFoundException, CustomConstraintViolationException {
		SecUser user = userService.loadUserById(userIdString.getBytes());
		userService.deleteUser(user);
	}

	@GetMapping("/all")
	@ApiOperation(value = "Recupera todos os usuários")
	public List<SecUser> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/search/username/{username}")
	@ApiOperation(value = "Recupera um usuário pelo nome")
	@Secured("ROLE_USER")
	public SecUser getUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
		SecUser userRecovered = userService.loadUserByUsername(username);
		return userRecovered;
	}

	@PutMapping(path = "/{userId}")
	@ApiOperation(value = "Edita um usuário")
	@Secured("ROLE_USER")
	public void updateUser(@PathVariable int userId, @Valid @RequestBody SecUser user) throws UserNotFoundException {
		userService.updateUser(user);
	}

	@GetMapping(path = "/search/id/{id}")
	@ApiOperation(value = "Recupera um usuario pelo id")
	@Secured("ROLE_USER")
	public SecUser searchUser(@PathVariable String id) throws TargetNotFoundException {
		SecUser usuario = userRepo.findByIdUser(id.getBytes());
		return usuario;
	}

	@PostMapping(path = "/search")	  
	@ApiOperation(value = "Recupera um usuario pelo nome do produto, nome do app e username") 
	/* Metodo criado inicialmente para manter compatibilidade com o legado */
	public SecUser searchUserByProductAppUsername(HttpServletRequest request, @RequestParam("product") String product, @RequestParam("app") String app, @RequestParam("username") String username) 
	  		throws TargetNotFoundException { 

		 SecUser usuario = userRepo.findByProductUserApp(product, app, username); 
	   return usuario; 
	}

	@PostMapping("/resetpassword")
	@ApiOperation(value = "Reseta o password.")
	public GenericResponse resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail)
	    throws UserNotFoundException, NotificacaoRuntimeException, NotificacaoException {

		SecUser user = userRepo.findByDsEmail(userEmail);

		if (user == null) {
			throw new UserNotFoundException();
		}
		//String token = UUID.randomUUID().toString();
		// userService.createPasswordResetTokenForUser(user, token);
		NotificacaoService notificacao = new NotificacaoService("Reset Password", "Seu Password será resetado");

		ContactTO contato = new ContactTO();
		contato.setNotify(true);
		contato.setType(Constantes.TIPO_CONTATO_POR_EMAIL);
		contato.setValue(userEmail);

		List<ContactTO> contatos = new ArrayList<ContactTO>();
		contatos.add(contato);

		UserTO usuario = new UserTO();
		usuario.setName(user.getDsName());
		usuario.setListContactTO(contatos);

		List<UserTO> usuarios = new ArrayList<>();
		usuarios.add(usuario);

		notificacao.notifica(usuarios);

		// notificacao.enviaEmail()

		return null;
	}

	@PostMapping("/newpassword")
	@ApiOperation(value = "Novo password")
	public GenericResponse newPassword(@RequestBody NewPassDto form)
	    throws UserNotFoundException, PassNotMatchException, PasswordMininumSizeException {

		SecUser user = userRepo.findByIdUser(form.getId());

		if (user == null) {
			throw new UserNotFoundException();
		}

		String passSizeProperty = env.getProperty("app.password.minimum.size");
		String formPassword = form.getPassNovo1();

		validatePasswordSize(passSizeProperty, formPassword);

		if (form.getPassAntigo().equals(user.getDsPass())) {
			if (form.getPassNovo1().equals(form.getPassNovo2())) {
				user.setDsPass(form.getPassNovo1());
				user.setChangePass(false);
				userRepo.save(user);
			} else {
				throw new PassNotMatchException();
			}
		} else {
			throw new PassNotMatchException();
		}

		return new GenericResponse("success");
	}

	private SecUser extractSecUserFromDTO(SecUserDTO userDto) {

		SecUser user = new SecUser();

		user.setDsCell(userDto.getDsCell());
		user.setDsEmail(userDto.getDsEmail());
		user.setDsName(userDto.getDsName());
		user.setDsPass(userDto.getDsPass());
		user.setDsUsername(userDto.getDsUsername());
		user.setChangePass(userDto.getIsChangePass());
		user.setNotifyCell(userDto.isNotifyCell());
		user.setNotifyCellCall(user.isNotifyCellCall());
		user.setNotifyEmail(user.isNotifyEmail());
		user.setStatus(Constantes.STATUS_ATIVO);
		user.setDtUltChangePass(new Date(System.currentTimeMillis()));
		
		user.setDtExpiryCode_2FA(null);
		user.setVerificationCode(null);
		user.setVerificationCodeExpiryDate(null);

		return user;

	}

	@PostMapping(value = "/verifyUser")
	@ApiOperation(value = "Verifica se um determinado um usuario existe a partir das informações do usuário, produto, app, email")
	public boolean verifyUser(@RequestParam("product") String product, @RequestParam("app") String app,
	    @RequestParam("username") String username, @RequestParam("email") String email) {

		SecUser secUser = userRepo.findByProductUserAppEmail(product, app, username, email);

		return secUser == null ? false : true;
	}

//    public User getUserByLogin(String login) {
//        LdapContextSource contextSource = new LdapContextSource();
//        try {
//            contextSource.setUrl("secret");
//            contextSource.setBase("secret");
//            contextSource.setUserDn("secret");
//            contextSource.setPassword("secret");
//            contextSource.afterPropertiesSet();
//            LdapTemplate ldapTemplate = new LdapTemplate(contextSource);
//            User user = ldapTemplate.findOne(query().where("uid").is(login), User.class);
//            return user;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

//	public void createPasswordResetTokenForUser(SecUser user, String token) {
//	    PasswordResetToken myToken = new PasswordResetToken(token, user);
//	    passwordTokenRepository.save(myToken);
//	}
//
//    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final SecUser user) {
//        final String url = contextPath + "/user/changePassword?token=" + token;
//        final String message = messages.getMessage("message.resetPassword", null, locale);
//        return constructEmail("Reset Password", message + " \r\n" + url, user);
//    }

}