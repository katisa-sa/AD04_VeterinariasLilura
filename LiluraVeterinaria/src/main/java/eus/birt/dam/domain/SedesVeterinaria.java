package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok para añadir getters, setters y constructores
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="sedesVeterinaria")
public class SedesVeterinaria {

	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="cyclism")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;

	private String name;
	
	private String direccion;
	
	private String city;
	
	private String telefono;
	
	@OneToMany (mappedBy = "sede",cascade = CascadeType.ALL)
	List <Mamiferos> mamiferos = new ArrayList<>();
	
	
	public SedesVeterinaria(String name, String direccion, String city, String telefono) {
		this.name = name;
		this.direccion = direccion;
		this.city = city;
		this.telefono = telefono;
	}
	
}
