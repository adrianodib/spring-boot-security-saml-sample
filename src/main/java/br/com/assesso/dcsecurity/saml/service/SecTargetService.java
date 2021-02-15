package br.com.assesso.dcsecurity.saml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assesso.dcsecurity.saml.entity.SecTarget;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.TargetAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.TargetNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecTargetRepository;
import br.com.assesso.dcsecurity.saml.utils.ChaveUtil;

@Service
public class SecTargetService {

	@Autowired
	private SecTargetRepository targetRepo;
	
	public List<SecTarget> getAllTargets() {
		return targetRepo.findAll();
	}
	
  public SecTarget loadTargetById(byte[] id) throws TargetNotFoundException {

		SecTarget target = targetRepo.findByIdTarget(id);		
		if (target == null) {
			throw new TargetNotFoundException();
		}
		return target;
	}	
    
	@Transactional(rollbackFor = Exception.class)
	public void deleteTarget(SecTarget target) throws CustomConstraintViolationException {		
		targetRepo.delete(target);
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecTarget createTarget(SecTarget target) throws TargetAlreadyExistsException, TargetNotFoundException  {
		
		String id = ChaveUtil.executa();
		target.setIdTargetString(id);
		
		SecTarget targetSaved = targetRepo.save(target);

		
		return targetSaved;
	}	
	
	@Transactional(rollbackFor = Exception.class)
	public SecTarget updateTarget(SecTarget target) throws TargetNotFoundException {

		SecTarget targetAux = targetRepo.findByIdTarget(target.getIdTarget());
		if (targetAux == null) {
			throw new TargetNotFoundException();
		}
		
		// atualiza
		return targetRepo.saveAndFlush(target);
	}	

}