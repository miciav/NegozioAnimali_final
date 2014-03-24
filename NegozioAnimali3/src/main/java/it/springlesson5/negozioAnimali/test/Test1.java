package it.springlesson5.negozioAnimali.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import it.springlesson1.negozioAnimali.jpa.PetDAOJpaRepository;
import it.springlesson1.negozioAnimali.model.Pet;
import it.springlesson3.NegozioAnimali.HomeController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class Test1 {

	private List<Pet> pets = new ArrayList<Pet>();
	PetDAOJpaRepository dao = mock(PetDAOJpaRepository.class);
	@Before
	public void initPetList(){
		Pet p = new Pet();
		p.setDataNascita(new Date("10/03/2013"));
		p.setNome("Argo");
		this.pets.add(p);
	}
	
	@Before
	public void initMockDAO(){
		when(dao.findAll()).thenReturn(pets);
		when(dao.save(any(Pet.class))).thenAnswer(new Answer<Pet>() {

			@Override
			public Pet answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Pet innerPet = (Pet) invocation.getArguments()[0]; 
				pets.add(innerPet);
				return innerPet;
			}
		});
		when(dao.findByNome(anyString())).thenAnswer(new Answer<Pet>() {

			@Override
			public Pet answer(InvocationOnMock invocation) throws Throwable {
				String nome = (String) invocation.getArguments()[0];
				for (Pet p : pets) {
					if (p.getNome().compareTo(nome)==0) {
						return p;
					}
				}
				return null;
			}
		});
	}
	
	
	
	@Test
	public void testHome() {
		HomeController hc = new HomeController();
		ExtendedModelMap m = new ExtendedModelMap();
		Locale l = Locale.ITALY;
		String view = hc.home(l, m);
		assertNotNull(view);
		assertEquals("home", view);
		String date =  (String) m.get("serverTime");
		assertNotNull(date);
	}
	
	@Test
	public void testPetList(){
		HomeController hc = new HomeController();
		ReflectionTestUtils.setField(hc, "petRep", dao);
		ExtendedModelMap m = new ExtendedModelMap();
		String view = hc.petList(m);
		verify(dao, times(1)).findAll();
		assertNotNull(view);
		assertEquals("petList", view);
		List<Pet> pl =(List<Pet>) m.get("petList");
		assertEquals(1, pl.size());
	}
	
	@Test
	public void testAddPet(){
		HomeController hc = new HomeController();
		ReflectionTestUtils.setField(hc, "petRep", dao);
		ExtendedModelMap m = new ExtendedModelMap();
		String view = hc.addPet("Bobby", "11/03/2013",m);
		assertNotNull(view);
		assertEquals("petList", view);
		List<Pet> pl =(List<Pet>) m.get("petList");
		assertEquals(2, pl.size());
		assertEquals(2, pets.size());
	}
	
	@Test
	public void testFindPet(){
		assertEquals(1, pets.size());
		HomeController hc = new HomeController();
		ReflectionTestUtils.setField(hc, "petRep", dao);
		ModelAndView mv = hc.findPet("Argo");
		assertNotNull(mv);
		assertEquals("petFound", mv.getViewName());
		}
	

}
