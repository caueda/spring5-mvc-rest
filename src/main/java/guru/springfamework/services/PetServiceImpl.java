package guru.springfamework.services;

import org.springframework.stereotype.Service;

import guru.springfamework.api.v1.mapper.PetMapper;
import guru.springfamework.api.v1.model.PetDTO;
import guru.springfamework.domain.Pet;
import guru.springfamework.repositories.PetRepository;

@Service
public class PetServiceImpl implements PetService {
	private PetRepository petRepository;
	private PetMapper petMapper;
	
	public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
		super();
		this.petRepository = petRepository;
		this.petMapper = petMapper;
	}
	
	public PetDTO findById(Long id) {
		return petMapper.petToPetDTO(petRepository.findById(id).get());
	}

	@Override
	public PetDTO createNewPet(PetDTO petDTO) {
		
		Pet pet = petMapper.petDTOToPet(petDTO);
		
		return petMapper.petToPetDTO(petRepository.save(pet));
	}
}
