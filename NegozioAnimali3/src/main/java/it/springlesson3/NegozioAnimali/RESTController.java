package it.springlesson3.NegozioAnimali;

import javax.servlet.http.HttpServletResponse;

import it.springlesson1.negozioAnimali.jpa.PetDAOJpaRepository;
import it.springlesson1.negozioAnimali.model.Pet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@Controller
@RequestMapping("pets")
public class RESTController {

	private static final Logger logger = LoggerFactory.getLogger(RESTController.class);
	
	@Autowired
	private PetDAOJpaRepository petRepo;
	
	//READ
	@RequestMapping(value="/pet/{id}")
	public @ResponseBody Pet getPet(@PathVariable String id){
		
		Pet p = petRepo.findOne(id);
		return p;
	}
	//CREATE
	@RequestMapping(value="/pet", method =RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Pet postPet(@RequestBody Pet p, 
							 BindingResult res,
							 HttpServletResponse response)throws BindException 
	{
		if (res.hasErrors()) {
			throw new BindException(res);
		}
		logger.warn("POST: "+p.getNome()+" "+p.getDataNascita());
		petRepo.saveAndFlush(p);
		response.setHeader("Location","/pets/pet/"+p.getNome());
		return p;
	}
	//DELETE
	@RequestMapping(value="/pet/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePet(@PathVariable String id){
		
		petRepo.delete(id);
	}
	//UPDATE
	@RequestMapping(value="/pet/{id}", method= RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updatePet(@PathVariable String id, @RequestBody Pet p){
		petRepo.saveAndFlush(p);		
	}
	
	
}
