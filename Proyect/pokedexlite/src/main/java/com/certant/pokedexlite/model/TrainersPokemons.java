
package com.certant.pokedexlite.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase que representa la tabla TrainersPokemons
 * 
 * @author Matias
 *
 */

@Data
@Entity
@Table(name = "trainerspokemons")
public class TrainersPokemons {

	@EmbeddedId
	private TrainersPokemonsId trainersPokemonsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("trainerId")
	@JoinColumn(name = "trainerId")
	private Trainer trainer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pokemonId")
	@JoinColumn(name = "pokemonId")
	private Pokemon pokemon;

	@Column(name = "foundedLvl")
	private int foundedLvl;

	public TrainersPokemons(Trainer trainer, Pokemon pokemon, int foundedLvl) {
		this.trainer = trainer;
		this.pokemon = pokemon;
		this.foundedLvl = foundedLvl;
	}

	public TrainersPokemons() {

	}

}
