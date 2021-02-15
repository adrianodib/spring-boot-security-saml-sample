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

import br.com.assesso.dcsecurity.saml.dto.GrantTargetDTO;
import br.com.assesso.dcsecurity.saml.entity.SecGrantTarget;
import br.com.assesso.dcsecurity.saml.entity.SecGrantTargetPK;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.GrantTargetAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.GrantTargetNotFoundException;
import br.com.assesso.dcsecurity.saml.service.SecGrantTargetService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/granttarget")
@CrossOrigin(origins="*", allowedHeaders="*")
public class GrantTargetController {

	@Autowired
	private SecGrantTargetService grantTargetService;

	@PostMapping("/create")
	@ApiOperation(value = "Insere o relacionamento de Grant com Target")
    @Secured("ROLE_USER")
	public SecGrantTarget createUser(@Valid @RequestBody GrantTargetDTO grantTargetDto) throws GrantTargetAlreadyExistsException, GrantTargetNotFoundException {
		
		SecGrantTarget grantTarget = extractSecGrantTargetFromDTO(grantTargetDto);
		

		SecGrantTarget grantTargetSaved = grantTargetService.createGrantTarget(grantTarget);
		return grantTargetSaved;
	}

	 @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Deleta o relacionamento de Grant com Target pela Chave da Tabela")
    @Secured("ROLE_USER")
		public void deleteGrantTarget(@RequestBody SecGrantTargetPK secGrantTargetPK) throws GrantTargetNotFoundException, CustomConstraintViolationException {	
			SecGrantTarget grantTarget = grantTargetService.loadGrantTargetByChave(secGrantTargetPK.getIdGrant(), secGrantTargetPK.getVersao(), secGrantTargetPK.getIdTarget(), secGrantTargetPK.getIdProduct());
			grantTargetService.deleteGrantTarget(grantTarget);
		}	
	
  @GetMapping("/all")
    @ApiOperation(value = "Recupera todos os relacionamentos de Grant com Target")
    public List<SecGrantTarget> getAllGrantTargets() {
    	return grantTargetService.getAllGrantTargets();
    }

  @PostMapping(path = "/search/chave")
    @ApiOperation(value = "Recupera o relacionamento de Grant com Target pela Chave")
    @Secured("ROLE_USER")
    public SecGrantTarget getUserByChave(@RequestBody SecGrantTargetPK secGrantTargetPK) throws GrantTargetNotFoundException {
    	SecGrantTarget grantTargetRecovered = grantTargetService.loadGrantTargetByChave(secGrantTargetPK.getIdGrant(), secGrantTargetPK.getVersao(), secGrantTargetPK.getIdTarget(), secGrantTargetPK.getIdProduct());
    	return grantTargetRecovered;
    }
    
	@PutMapping(path = "/update")
    @ApiOperation(value = "Atualiza o relacionamento de Grant com Target")
    @Secured("ROLE_USER")
	public void updateUser(@RequestBody SecGrantTarget grantTarget) throws GrantTargetNotFoundException {
		grantTargetService.updateGrantTarget(grantTarget);
	}

	
  private SecGrantTarget extractSecGrantTargetFromDTO(GrantTargetDTO grantTargetDto) {
    	
    	SecGrantTarget grantTarget = new SecGrantTarget();
    	
    	grantTarget.setIdGrant(grantTargetDto.getIdGrant());
    	grantTarget.setIdTarget(grantTargetDto.getIdTarget());
    	grantTarget.setIdProduct(grantTargetDto.getIdProduct());
    	grantTarget.setVersao(grantTargetDto.getVersao());
    	grantTarget.setReadonly(grantTargetDto.isReadonly());
    	
    	return grantTarget;
    	
    }
    
}