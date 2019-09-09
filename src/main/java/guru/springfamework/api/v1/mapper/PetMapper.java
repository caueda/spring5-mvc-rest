package guru.springfamework.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springfamework.api.v1.model.PetDTO;
import guru.springfamework.domain.Pet;

@Mapper
public interface PetMapper {
	PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);
	
	PetDTO petToPetDTO(Pet pet);
	Pet petDTOToPet(PetDTO petDTO);
}
