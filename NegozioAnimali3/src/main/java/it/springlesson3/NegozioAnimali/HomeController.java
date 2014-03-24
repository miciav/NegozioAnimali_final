package it.springlesson3.NegozioAnimali;

import it.springlesson1.negozioAnimali.jpa.PetDAOJpaRepository;
import it.springlesson1.negozioAnimali.model.Pet;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	//@Autowired
	private PetDAOJpaRepository petRep;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/petList", method = RequestMethod.GET)
	public String petList( Model model) {
		
		List<Pet> pl = new ArrayList<Pet>();
		
		pl = petRep.findAll();
		
		model.addAttribute("petList", pl );
		
		return "petList";
	}
	@RequestMapping(value = "/addPet", method = RequestMethod.GET)
	public void addPet() {}
	
	@RequestMapping(value = "/addPet", method = RequestMethod.POST)
	public String addPet(@ModelAttribute("Nome") String name,
						@ModelAttribute("Date") String data,
						Model model) {
		logger.info("Welcome home! The pet name is {}.", name);
		logger.info("Welcome home! The pet date is {}.", data);
		
		Pet newPet = new Pet();
		newPet.setNome(name);
		newPet.setDataNascita(new Date(data));
		petRep.save(newPet);
		
		return this.petList( model);
	}
	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String delete() {
		petRep.deleteAll();
		return "deleteAll";
	}
	@RequestMapping(value = "/findPet", method = RequestMethod.GET)
	public void findPet() {
	}	
	@RequestMapping(value = "/findPet", method = RequestMethod.POST)
	public ModelAndView findPet(String Nome) {
		Pet p =petRep.findByNome(Nome);
		ModelAndView mv = new ModelAndView("petFound","pet", p);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Pet findPetJason(String Nome){
		Pet p =petRep.findByNome(Nome);
		
		return p;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void findPetJason(){}
	
}
