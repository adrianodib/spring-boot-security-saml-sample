package br.com.assesso.dcsecurity.saml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.assesso.dcsecurity.saml.dto.GeneralDto;
import br.com.assesso.dcsecurity.saml.repository.SecUserRepository;
import io.swagger.annotations.ApiOperation;

/**
 * Controller geral 
 * @author adriano.dib
 * @since dez/2020
 *
 */
@RestController
@RequestMapping("/api")
public class GeneralController {

	@Autowired
	private SecUserRepository userRepo;
	
	@Autowired
	private Environment env;
	
    @GetMapping("/initdef")
    @ApiOperation(value = "Obtém definições gerais do ambiente antes do login")
    @Secured({ "ROLE_ADMIN" })
    public GeneralDto getInitialDefinitions() {
    	
    	String language = env.getProperty("app.default.language");
    	String internet = env.getProperty("app.has.internet.connection");
    	String tokenTimeSms = env.getProperty("app.resend.token.time.sms");
    	String tokenTimeEmail = env.getProperty("app.resend.token.time.email");
    	String passwordMinimumSize = env.getProperty("app.password.minimum.size");
    	
    	return new GeneralDto(language, internet, tokenTimeSms, tokenTimeEmail, passwordMinimumSize);
    }
    
    @GetMapping("/validateconnection")
    @ApiOperation(value = "Verifica se a conexão com o banco de dados está OK")
    @Secured({ "ROLE_ADMIN" })
    public boolean getValidateConnection() {
    	
    	userRepo.count();
    	
    	return true;
    }

    
}
