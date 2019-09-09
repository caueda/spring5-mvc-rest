package guru.springfamework.controllers.v1;


import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import guru.springfamework.api.v1.model.PetDTO;
import guru.springfamework.services.PetService;

@RestController
@RequestMapping(PetController.BASE_URL)
public class PetController {
	public static final String BASE_URL = "/api/v1/pets";
	
	private final PetService petService;

	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}
	
	@GetMapping("/{id}")
	public PetDTO getPetById(@PathVariable Long id) {
		return petService.findById(id);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> createNewPet(@RequestBody PetDTO petDTO) {
		PetDTO savedPetDTO = petService.createNewPet(petDTO);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedPetDTO.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
