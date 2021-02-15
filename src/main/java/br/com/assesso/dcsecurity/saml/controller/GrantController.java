package br.com.assesso.dcsecurity.saml.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.assesso.dcsecurity.saml.dto.GrantDTO;
import br.com.assesso.dcsecurity.saml.entity.SecGrant;
import br.com.assesso.dcsecurity.saml.entity.SecGrantPK;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.GrantAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.GrantNotFoundException;
import br.com.assesso.dcsecurity.saml.service.SecGrantService;
import br.com.assesso.dcsecurity.saml.utils.Constantes;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/grant")
@CrossOrigin(origins="*", allowedHeaders="*")
public class GrantController {

	@Autowired
	private SecGrantService grantService;
	
	@PostMapping("/create")
	@ApiOperation(value = "Insere uma nova grant")
    @Secured("ROLE_USER")
	public SecGrant createUser(@Valid @RequestBody GrantDTO grantDto) throws GrantAlreadyExistsException, GrantNotFoundException {
		
		SecGrant grant = extractSecGrantFromDTO(grantDto);
		

		SecGrant grantSaved = grantService.createGrant(grant);
		return grantSaved;
	}

	 @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Deleta um grant pelo ID")
    @Secured("ROLE_USER")
		public void deleteGrant(@RequestBody SecGrantPK secGrantPK) throws GrantNotFoundException, CustomConstraintViolationException {	
			SecGrant grant = grantService.loadGrantByChave(secGrantPK.getIdGrant(), secGrantPK.getVersao(), secGrantPK.getIdProduct());
			grantService.deleteGrant(grant);
		}	
	
    @GetMapping("/all")
    @ApiOperation(value = "Recupera todas as grants")
    public List<SecGrant> getAllGrants() {
    	return grantService.getAllGrants();
    }

    @PostMapping(path = "/search/chave")
    @ApiOperation(value = "Recupera uma grant pela Chave")
    @Secured("ROLE_USER")
    public SecGrant getUserByGrant(@RequestBody SecGrantPK secGrantPK) throws GrantNotFoundException {
    	SecGrant grantRecovered = grantService.loadGrantByChave(secGrantPK.getIdGrant(), secGrantPK.getVersao(), secGrantPK.getIdProduct());
    	return grantRecovered;
    }
    
	@PutMapping(path = "/update")
    @ApiOperation(value = "Atualiza um usuário")
    @Secured("ROLE_USER")
	public void updateUser(@RequestBody SecGrant grant) throws GrantNotFoundException {
		grantService.updateGrant(grant);
	}

	
  private SecGrant extractSecGrantFromDTO(GrantDTO grantDto) {
    	
    	SecGrant grant = new SecGrant();
    	
    	grant.setDsName(grantDto.getDsName());
    	grant.setDsGrant(grantDto.getDsGrant());
    	grant.setDsCompGrant(grantDto.getDsCompGrant());
    	grant.setIdProduct(grantDto.getIdProduct());
    	grant.setVersao(Constantes.VERSAO_EDICAO);
    	grant.setSystemRegistry(false);
    	
    	return grant;
    	
    }
    
}