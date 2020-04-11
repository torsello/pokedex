/**
 * 
 */
package com.certant.pokedexlite.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Class to map the composite Primary Key which belongs to the intermediary join
 * table
 * 
 * @author Matias
 *
 */
@Data
@Embeddable
public class TrainersPokemonsId implements Serializable {

	@Column(name = "trainer_id")
	private String trainerId;

	@Column(name = "pokemon_id")
	private String pokemonId;

	private TrainersPokemonsId() {

	}

	public TrainersPokemonsId(String trainerId, String pokemonId) {
		this.trainerId = trainerId;
		this.pokemonId = pokemonId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if(o==null || getClass() != o.getClass())
			return false;
		
		TrainersPokemonsId that = (TrainersPokemonsId) o;
		return Objects.equals(trainerId, that.trainerId) && Objects.equals(pokemonId, that.pokemonId);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(trainerId, pokemonId);
	}

}
