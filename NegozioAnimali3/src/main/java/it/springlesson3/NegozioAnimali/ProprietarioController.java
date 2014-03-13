package it.springlesson3.NegozioAnimali;

import javax.servlet.http.HttpServletResponse;

import it.springlesson1.negozioAnimali.jpa.ProprietarioDAOJpaRepository;
import it.springlesson1.negozioAnimali.model.Proprietario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value="/p")
public class ProprietarioController {
	private static final Logger logger = LoggerFactory.getLogger(ProprietarioController.class);
	
	@Autowired
	private ProprietarioDAOJpaRepository propRepo;
	
	//READ
	@RequestMapping(value="/prop/{id}", method=RequestMethod.GET)
	public @ResponseBody Proprietario getProprietario(@PathVariable Long id){
		logger.info(id.toString()+ " GET");
		if (propRepo.exists(id)) {
			Proprietario p = propRepo.findOne(id);
			logger.info(p.getNome()+" "+p.getId()+" ciao");
			return p;
		}
		return null;
	}
	//CREATE
	@RequestMapping(value="/prop", method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Proprietario postProprietario(@RequestBody Proprietario prop,
									 BindingResult res, 
									 HttpServletResponse servResp)throws BindException 
	{
		if (res.hasErrors()) {
			throw new BindException(res);
		}
	
		logger.info(prop.getId()+" "+prop.getNome());
		if (res.hasErrors()) {
			return null;
		}
		
		Proprietario p =propRepo.saveAndFlush(prop);
		
		servResp.setHeader("Location","/p/prop/"+p.getId());
		
		return p;
	}
	//DELETE
	@RequestMapping(value="/prop/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProprietario(@PathVariable Long id){
		if(propRepo.exists(id))
			propRepo.delete(id);
	}
	//UPDATE
	@RequestMapping(value="/prop/{id}",method=RequestMethod.PUT)
	public @ResponseBody Proprietario updateProprietario(@PathVariable String id,@RequestBody Proprietario prop){
		return propRepo.saveAndFlush(prop);
	}
	
}

