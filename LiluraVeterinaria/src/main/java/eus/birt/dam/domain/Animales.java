package eus.birt.dam.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor

public class Animales {

	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2", schema = "cyclism")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;

	private String name;
	
	private String dueño;

	public Animales() {
		super();
	}

	public Animales(String name, String dueño) {
		this.name = name;
		this.dueño = dueño;
	}
	
	

}