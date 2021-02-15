package br.com.assesso.dcsecurity.saml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assesso.dcsecurity.saml.entity.SecGrant;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.GrantAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.GrantNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecGrantRepository;
import br.com.assesso.dcsecurity.saml.utils.ChaveUtil;

@Service
public class SecGrantService {

	@Autowired
	private SecGrantRepository grantRepo;
	
	public List<SecGrant> getAllGrants() {
		return grantRepo.findAll();
	}
	
  public SecGrant loadGrantByChave(byte[] idGrant, long versao, int idProduct) throws GrantNotFoundException {

		SecGrant grant = grantRepo.findByIdGrantVersaoIdProduct(idGrant, versao, idProduct);		
		if (grant == null) {
			throw new GrantNotFoundException();
		}
		return grant;
	}	
    
	@Transactional(rollbackFor = Exception.class)
	public void deleteGrant(SecGrant grant) throws CustomConstraintViolationException {		
		grantRepo.delete(grant);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecGrant createGrant(SecGrant grant) throws GrantAlreadyExistsException, GrantNotFoundException  {
		
		String id = ChaveUtil.executa();
		grant.setIdGrantString(id);
		
		SecGrant grantSaved = grantRepo.save(grant);

		
		return grantSaved;
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public void updateGrant(SecGrant grant) throws GrantNotFoundException {

		SecGrant grantAux = grantRepo.findByIdGrantVersaoIdProduct(grant.getIdGrant(), grant.getVersao(), grant.getIdProduct());
		if (grantAux == null) {
			throw new GrantNotFoundException();
		}
		
		// atualiza
		grantRepo.save(grant);
	}	

}