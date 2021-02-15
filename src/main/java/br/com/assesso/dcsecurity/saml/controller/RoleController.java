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

import br.com.assesso.dcsecurity.saml.dto.RoleDTO;
import br.com.assesso.dcsecurity.saml.entity.SecRole;
import br.com.assesso.dcsecurity.saml.entity.SecRolePK;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.RoleAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.RoleNotFoundException;
import br.com.assesso.dcsecurity.saml.service.SecRoleService;
import br.com.assesso.dcsecurity.saml.utils.Constantes;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins="*", allowedHeaders="*")
public class RoleController {

	@Autowired
	private SecRoleService roleService;

	@PostMapping("/create")
	  @ApiOperation(value = "Insere uma nova role")
    @Secured("ROLE_USER")
	public SecRole createRole(@Valid @RequestBody RoleDTO roleDto) throws RoleAlreadyExistsException, RoleNotFoundException {
		
		SecRole role = extractSecRoleFromDTO(roleDto);
		role.setVersao(Constantes.VERSAO_EDICAO);

		SecRole roleSaved = roleService.createRole(role);
		return roleSaved;
	}

	@DeleteMapping(path = "/delete")
    @ApiOperation(value = "Deleta um role pelo ID")
    @Secured("ROLE_USER")
	public void deleteRole(@RequestBody SecRolePK secRolePK) throws RoleNotFoundException, CustomConstraintViolationException {	
		SecRole role = roleService.loadRoleByChave(secRolePK.getIdRole(), secRolePK.getVersao(), secRolePK.getIdProduct());
		roleService.deleteRole(role);
	}	
	
  @GetMapping("/all")
    @ApiOperation(value = "Recupera todas as roles")
  public List<SecRole> getAllRoles() {
   	return roleService.getAllRoles();
  }

  @PostMapping(path = "/search/chave")
    @ApiOperation(value = "Recupera uma role pela Chave")
    @Secured("ROLE_USER")
  public SecRole getRoleByChave(@RequestBody SecRolePK rolePK) throws RoleNotFoundException {
  	SecRole roleRecovered = roleService.loadRoleByChave(rolePK.getIdRole(), rolePK.getVersao(), rolePK.getIdProduct());
  	return roleRecovered;
  }
    
	@PutMapping(path = "/update")
    @ApiOperation(value = "Atualiza um usuário")
    @Secured("ROLE_USER")
	public SecRole updateRole(@RequestBody SecRole role) throws RoleNotFoundException {
		return roleService.updateRole(role);
	}

	
  private SecRole extractSecRoleFromDTO(RoleDTO roleDto) {
    	
    	SecRole role = new SecRole();
    	
    	role.setDsName(roleDto.getDsName());
    	role.setDsRole(roleDto.getDsRole());
    	role.setDsCompRole(roleDto.getDsCompRole());
    	role.setIdProduct(roleDto.getIdProduct());
    	role.setVersao(Constantes.VERSAO_EDICAO);
    	role.setSystemRegistry(false);
    	
    	return role;
    	
    }
    
}