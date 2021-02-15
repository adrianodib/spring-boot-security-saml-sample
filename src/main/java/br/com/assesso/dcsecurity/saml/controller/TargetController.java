package br.com.assesso.dcsecurity.saml.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

import br.com.assesso.dcsecurity.saml.dto.TargetDTO;
import br.com.assesso.dcsecurity.saml.entity.SecTarget;
import br.com.assesso.dcsecurity.saml.exception.CustomConstraintViolationException;
import br.com.assesso.dcsecurity.saml.exception.TargetAlreadyExistsException;
import br.com.assesso.dcsecurity.saml.exception.TargetNotFoundException;
import br.com.assesso.dcsecurity.saml.repository.SecTargetRepository;
import br.com.assesso.dcsecurity.saml.service.SecTargetService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/target")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TargetController {

	@Autowired
	private SecTargetService targetService;

	@Autowired
	private SecTargetRepository secTargetRepo;
	
	@PostMapping("/create")
	@ApiOperation(value = "Insere uma nova target")
    @Secured("ROLE_USER")
	public SecTarget createUser(@Valid @RequestBody TargetDTO targetDto) throws TargetAlreadyExistsException, TargetNotFoundException {
		
		SecTarget target = extractSecTargetFromDTO(targetDto);
		

		SecTarget targetSaved = targetService.createTarget(target);
		return targetSaved;
	}
	
	@DeleteMapping(path = "/delete/{idString}")
    @ApiOperation(value = "Deleta um target pelo ID")
    @Secured("ROLE_USER")
	public void deleteTarget(@PathVariable String idString) throws TargetNotFoundException, CustomConstraintViolationException {	
		SecTarget target = targetService.loadTargetById(idString.getBytes());
		targetService.deleteTarget(target);
	}	
	
    @GetMapping("/all")
    @ApiOperation(value = "Recupera todas as targets")
    public List<SecTarget> getAllTargets() {
    	return targetService.getAllTargets();
    }

    @GetMapping(path = "/search/id/{idString}")
    @ApiOperation(value = "Recupera uma target pelo id")
    @Secured("ROLE_USER")
    public SecTarget getUserByTarget(@PathVariable String idString) throws TargetNotFoundException {
    	SecTarget targetRecovered = targetService.loadTargetById(idString.getBytes());
    	return targetRecovered;
    }
    
	@PutMapping(path = "/update")
    @ApiOperation(value = "Atualiza uma target")
    @Secured("ROLE_USER")
	public void updateTarget(@RequestBody SecTarget target) throws TargetNotFoundException {
		targetService.updateTarget(target);
	}

	
  private SecTarget extractSecTargetFromDTO(TargetDTO targetDto) {
    	
    	SecTarget target = new SecTarget();
    	
    	target.setDsDefault(targetDto.getDsDefault());
    	target.setDsGif(targetDto.getDsGif());
    	target.setDsPath(targetDto.getDsPath());
    	target.setDsTarget(targetDto.getDsTarget());
    	target.setDsCompTarget(targetDto.getDsCompTarget());
    	target.setDsUrl(targetDto.getDsUrl());
    	target.setDsValue(targetDto.getDsValue());
    	target.setIdProduct(targetDto.getIdProduct());
    	target.setNuOrder(targetDto.getNuOrder());
    	target.setTpTarget(targetDto.getTpTarget());
    	target.setSystemRegistry(false);
    	
    	return target;
    	
    }
    
    @PostMapping(value = "/alltargets")
    @ApiOperation(value = "Recupera todos os targets de um determinado usuário")
    public Set<SecTarget> validateToken(@RequestParam("idProduct") int idProduct, @RequestParam("idAppString") String idAppString, @RequestParam("username") String username) {
    	
    	Set<SecTarget> targets = secTargetRepo.findByIdProductIdUserIdApp(idProduct, idAppString.getBytes(), username);

    	return targets;
    }
    
    @PostMapping(value = "/alltargetsbyusername")
    @ApiOperation(value = "Recupera todos os targets de um determinado usuário, produto e app")
    public Set<SecTarget> allTargetsByUsername(HttpServletRequest request, @RequestParam("product") String product, @RequestParam("app") String app, @RequestParam("username") String username) {
    	
    	Set<SecTarget> targets = secTargetRepo.findByProductUserApp(product, app, username);

    	return targets;
    }
	
}