package eus.birt.dam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="Mamiferos")

public class Mamiferos extends Animales {
	
	private String tipo;
	
	private String raza;
	
	private String tamaño;
	
	private String chip;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "sede_id")
	private SedesVeterinaria sede;

	public Mamiferos(String name, String dueño, String tipo, String raza, String tamaño, String chip, String descripcion) {
		super(name, dueño);
		this.tipo = tipo;
		this.raza = raza;
		this.tamaño = tamaño;
		this.chip = chip;
		this.descripcion = descripcion;
	}
	
	

}
