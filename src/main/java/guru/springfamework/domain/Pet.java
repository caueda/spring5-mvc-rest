package guru.springfamework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="PET")
public class Pet {
	@Id
	@GeneratedValue(generator = "PET", strategy = GenerationType.IDENTITY)
	private Long id;
	@Length(min = 2, message = "The length must be larger than 1")
	private String name;
	private String breed;
	
	public Pet() {
		super();
	}

	public Pet(Long id, String name, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
	}
}
