/**
 * 
 */
package com.certant.pokedexlite.model;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Trainer
 * @author Matias
 *
 */
@Data
@Entity
@Table(name="trainer")
public class Trainer {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	private String trainerId;
	private String trainerName;
	private String trainerPass;
    @OneToMany(
            mappedBy = "trainer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    private Set<TrainersPokemons> trainersPokemons;

	
	public Trainer() {
		
	}
	
	public Trainer(String trainerName, String trainerPass) {
		this.trainerName=trainerName;
		this.trainerPass=trainerPass;
	}
	
}
