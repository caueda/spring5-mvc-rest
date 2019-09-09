package guru.springfamework.services;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import guru.springfamework.api.v1.mapper.PetMapper;
import guru.springfamework.api.v1.model.PetDTO;
import guru.springfamework.domain.Pet;
import guru.springfamework.repositories.PetRepository;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetServiceImplTest {

	@Mock
	PetRepository petRepository;
	
	PetService petService;
	
	PetMapper petMapper = PetMapper.INSTANCE;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		petService = new PetServiceImpl(petRepository, PetMapper.INSTANCE);
	}
	
	@Test
	public void getPetById() {
		Pet pet = new Pet();
		pet.setId(1L);
		pet.setName("Bono");
		pet.setBreed("Pug");
		
		Mockito.when(petRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(pet));
		
		PetDTO petDTO = petService.findById(1L);
		
		assertThat(petDTO.getBreed(), equalTo("Pug"));
	}
	
	@Test
	public void createNewPet() {
		//given
		PetDTO petDTO = new PetDTO();
		petDTO.setId(1L);
		petDTO.setName("Bono");
		petDTO.setBreed("Pug");
		
		Pet pet = petMapper.petDTOToPet(petDTO);
		
		Mockito.when(petRepository.save(Mockito.any(Pet.class))).thenReturn(pet);
		
		//when
		PetDTO savedDto = petService.createNewPet(petDTO);
		assertThat(petDTO.getName(), equalTo(savedDto.getName()));
	}
}
