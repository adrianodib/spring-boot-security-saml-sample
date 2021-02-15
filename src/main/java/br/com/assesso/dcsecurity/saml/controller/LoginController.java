package br.com.assesso.dcsecurity.saml.controller;

import static br.com.assesso.dcsecurity.saml.utils.MaskString.maskPhoneNumber;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.assesso.adf.mail.MailAddress;
import br.com.assesso.adf.mail.MailMessage;
import br.com.assesso.adf.mail.MailerService;
import br.com.assesso.adf.mail.MailerServiceLocator;
import br.com.assesso.adf.mail.SimpleMessage;
import br.com.assesso.adf.sms.Cell;
import br.com.assesso.adf.sms.SmsService;
import br.com.assesso.adf.sms.SmsServiceLocator;
import br.com.assesso.dcsecurity.saml.entity.SecUser;
import br.com.assesso.dcsecurity.saml.exception.VerificationCodeExpiredException;
import br.com.assesso.dcsecurity.saml.repository.SecUserRepository;
import br.com.assesso.dcsecurity.saml.service.SecUserService;
import br.com.assesso.dcsecurity.saml.utils.RandomGenerator;
import io.swagger.annotations.ApiOperation;

/**
 * Controller geral 
 * @author adriano.dib
 * @since dez/2020
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*", allowedHeaders="*")
public class LoginController {

	public static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private SecUserRepository userRepo;

	@Autowired
	private SecUserService userService;
	
	@Autowired
	private Environment env;
	
    @GetMapping(value = "/login")
    @ApiOperation(value = "Loga o usuário na aplicação")
    public String login(Authentication authentication) throws RuntimeException, Exception {
        
    	String isInternet = env.getProperty("app.has.internet.connection");
    	String is2FA = env.getProperty("app.has.2fa");
    	ObjectMapper mapper = new ObjectMapper();
    	
    	SecUser user = userRepo.findByDsUsername(authentication.getName());
    	
		  String jsonString = "";
    	
    	//Verifica se o cliente tem internet (properties)
    	if ("true".equals(isInternet)) {
    		
    		//Verifica autenticação 2 fatores (properties)
    		if ("true".equals(is2FA)) {

	    		//Usuario solicitou notificação por celular. Se for 1 é celular
	    		if (user.getTpNotify2fa() == 1) {
	    			
		    		String userCell = user.getDsCell();
		    		String verificationCode = RandomGenerator.getRandomNumberString();
		    		
		    		userService.createVerificationCodeForUser(user, verificationCode); 
		    	    
		    	    SmsService service = SmsServiceLocator.getInstance().getService();
		    	    service.addRecipients(new Cell(user.getDsCell()));
		    	    service.setMessage("Seu código de autenticação é: " + verificationCode);
		    	    service.send();
	
		    	    jsonString = "Enviado para ".concat(maskPhoneNumber(userCell));
	    		
		    	//Usuario solicitou notificação por email. Se for 0 é email
	    		} else if (user.getTpNotify2fa() == 0) { 
	    			
		    		//sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		    	    MailerService serviceMail =  MailerServiceLocator.getIntance().getMailer();
		    	    serviceMail.addRecipients(new MailAddress(user.getDsEmail(), user.getDsName()));
		    	    serviceMail.setSubject("Teste");
	
					String mensagem = "<pre>" + "TESTE EMAIL" + "</pre>";
					MailMessage mailMessage = new SimpleMessage(mensagem);
					serviceMail.send(mailMessage);
		    		
	    		} else {
	    			throw new Exception("Não foi encontrado meio de notificação de usuário"); 
	    		}
	    	
	    	//Quando tem internet, mas não tem autenticação 2 fatores configurada
    		} else {
        		jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
    		}

        //Quando o sistema cliente não possui internet	
    	} else {
    		jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
    	}

    	return jsonString;
    }
    
    @ApiOperation(value = "Valida o token")
    @PostMapping(value = "/validate/token")
    public SecUser validateToken(@RequestParam("username") final String username, @RequestParam("verificationCode") final String verificationCode) throws VerificationCodeExpiredException {
    	
    	SecUser user = userRepo.findByDsUsername(username);
    	final Calendar cal = Calendar.getInstance();
    	String i = env.getProperty("app.has.internet.connection");
    	
		if (user == null) {
	        throw new BadCredentialsException("Nome de usuário ou password inválido");
	    }

    	if (user.getVerificationCode() == null) {
    		throw new BadCredentialsException("Código de verificação não encontrado");
        }
		
    	if ("true".equals(i)) {
	    	
	        if (!user.getVerificationCode().equals(verificationCode)){
	        	throw new BadCredentialsException("Código de verificação não confere");
	        } else if ((user.getVerificationCodeExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        	throw new VerificationCodeExpiredException();
	        } else {
	        	return user;
	        }
	    }

    	return null;
    }    
    
	@PostMapping(value="/logout")
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "OK";
	}
	
}