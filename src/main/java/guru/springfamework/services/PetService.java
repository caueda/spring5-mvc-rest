package guru.springfamework.services;

import guru.springfamework.api.v1.model.PetDTO;

public interface PetService {
	PetDTO findById(Long id);
	
	PetDTO createNewPet(PetDTO petDTO);
}
