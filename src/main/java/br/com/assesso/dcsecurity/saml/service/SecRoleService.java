package br.com.assesso.dcsecurity.saml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assesso.dcsecurity.saml.entity.SecRole;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.RoleAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.RoleNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecRoleRepository;
import br.com.assesso.dcsecurity.saml.utils.ChaveUtil;

@Service
public class SecRoleService {

	@Autowired
	private SecRoleRepository roleRepo;
	
	public List<SecRole> getAllRoles() {
		return roleRepo.findAll();
	}
	
  public SecRole loadRoleByChave(byte[] idRole, long versao, int idProduct) throws RoleNotFoundException {

		SecRole role = roleRepo.findByIdRoleVersaoIdProduct(idRole, versao, idProduct);		
		if (role == null) {
			throw new RoleNotFoundException();
		}
		return role;
	}	
    
	@Transactional(rollbackFor = Exception.class)
	public void deleteRole(SecRole role) throws CustomConstraintViolationException {		
		roleRepo.delete(role);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecRole createRole(SecRole role) throws RoleAlreadyExistsException, RoleNotFoundException  {
		
		String id = ChaveUtil.executa();
		role.setIdRoleString(id);
		
		return roleRepo.save(role);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecRole updateRole(SecRole role) throws RoleNotFoundException {

		SecRole roleAux = roleRepo.findByIdRoleVersaoIdProduct(role.getIdRole(), role.getVersao(), role.getIdProduct());
		if (roleAux == null) {
			throw new RoleNotFoundException();
		}

		return roleRepo.saveAndFlush(role);
	}	

}