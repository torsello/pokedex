
package com.certant.pokedexlite.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * TrainersPokemons representative class
 * 
 * @author Matias
 *
 */

@Data
@Entity(name = "TrainersPokemons")
@Table(name = "trainers_pokemons")
public class TrainersPokemons {

	@EmbeddedId
	private TrainersPokemonsId trainersPokemonsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("trainerId")
	@JsonBackReference
	private Trainer trainer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pokemonId")
	@JsonBackReference
	private Pokemon pokemon;

	@Column(name = "foundedLvl")
	private int foundedLvl;


	private TrainersPokemons() {

	}

	public TrainersPokemons(Trainer trainer, Pokemon pokemon) {
		this.trainer = trainer;
		this.pokemon = pokemon;
		this.trainersPokemonsId = new TrainersPokemonsId(trainer.getTrainerId(), pokemon.getPokemonId());
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o) return true;
		 
	        if (o == null || getClass() != o.getClass())
	            return false;
	 
	        TrainersPokemons that = (TrainersPokemons) o;
	        return Objects.equals(trainer, that.trainer) &&
	               Objects.equals(pokemon, that.pokemon);
	}

	@Override
    public int hashCode() {
        return Objects.hash(trainer, pokemon);
    }

	

}
