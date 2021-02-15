package br.com.assesso.dcsecurity.saml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assesso.dcsecurity.saml.entity.SecGrantTarget;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.GrantTargetAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.GrantTargetNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecGrantTargetRepository;

@Service
public class SecGrantTargetService {

	@Autowired
	private SecGrantTargetRepository grantTargetRepo;
	
	public List<SecGrantTarget> getAllGrantTargets() {
		return grantTargetRepo.findAll();
	}
	
  public SecGrantTarget loadGrantTargetByChave(byte[] idGrant, long versao, byte[] idTarget, int idProduct) throws GrantTargetNotFoundException {

		SecGrantTarget grantTarget = grantTargetRepo.findByChave(idGrant, versao, idTarget, idProduct);		
		if (grantTarget == null) {
			throw new GrantTargetNotFoundException();
		}
		return grantTarget;
	}	
    
	@Transactional(rollbackFor = Exception.class)
	public void deleteGrantTarget(SecGrantTarget grantTarget) throws CustomConstraintViolationException {		
		grantTargetRepo.delete(grantTarget);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecGrantTarget createGrantTarget(SecGrantTarget grantTarget) throws GrantTargetAlreadyExistsException, GrantTargetNotFoundException  {
		
		SecGrantTarget grantTargetSaved = grantTargetRepo.save(grantTarget);
		
		return grantTargetSaved;
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public void updateGrantTarget(SecGrantTarget grantTarget) throws GrantTargetNotFoundException {

		SecGrantTarget grantTargetAux = grantTargetRepo.findByChave(grantTarget.getIdGrant(), grantTarget.getVersao(), grantTarget.getIdTarget(), grantTarget.getIdProduct());
		if (grantTargetAux == null) {
			throw new GrantTargetNotFoundException();
		}
		
		// atualiza
		grantTargetRepo.save(grantTarget);
	}	

}