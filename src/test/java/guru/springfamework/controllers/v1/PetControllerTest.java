package guru.springfamework.controllers.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

import guru.springfamework.api.v1.model.PetDTO;
import guru.springfamework.services.PetService;

public class PetControllerTest {
	
	@Mock
	PetService petService;
	
	@InjectMocks
	PetController petController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
	}

	@Test
	public void getPetById() throws Exception {
		PetDTO pet = new PetDTO();
		pet.setId(1L);
		pet.setName("Bono");
		pet.setBreed("Pug");
		
		Mockito.when(petService.findById(Mockito.anyLong())).thenReturn(pet);
		
		mockMvc.perform(get(PetController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.breed", equalTo("Pug")));
	}

	@Test
	public void createNewPet() throws Exception {
		PetDTO pet = new PetDTO();
		pet.setId(1L);
		pet.setName("Bono");
		pet.setBreed("Pug");
		
		PetDTO returnDTO = new PetDTO();
		returnDTO.setName(pet.getName());
		returnDTO.setId(pet.getId());
		returnDTO.setBreed(pet.getBreed());
		
		Mockito.when(petService.createNewPet(pet)).thenReturn(returnDTO);
		
		mockMvc.perform(post(PetController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(pet)))
		.andExpect(status().isCreated())
		//.andExpect(jsonPath("$.name", equalTo("Bono"))
		.andExpect(header().string("location", containsString(PetController.BASE_URL + "/1"))
		);
	}
}
