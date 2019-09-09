package guru.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springfamework.domain.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{
}
