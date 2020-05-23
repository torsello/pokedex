/**
 * 
 */
package com.certant.pokedexlite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

/**
 * Trainer representative class
 * 
 * @author Matias
 *
 */
@Data
@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String trainerId;
	@Column(unique = true)
	private String trainerName;
	private String trainerPass;
	@OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<TrainersPokemons> trainersPokemons = new ArrayList<>();

	public Trainer() {

	}

	public Trainer(String trainerName, String trainerPass) {
		this.trainerName = trainerName;
		this.trainerPass = trainerPass;
	}

}
