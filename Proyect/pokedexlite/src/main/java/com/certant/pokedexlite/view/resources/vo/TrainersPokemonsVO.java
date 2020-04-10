
package com.certant.pokedexlite.view.resources.vo;

import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Trainer;
import com.certant.pokedexlite.model.TrainersPokemonsId;

import lombok.Data;

/**
 * Clase que representa la tabla TrainersPokemons
 * 
 * @author Matias
 *
 */

@Data
public class TrainersPokemonsVO {

	private TrainersPokemonsId trainersPokemonsId;
	private Trainer trainer;
	private Pokemon pokemon;
	private int foundedLvl;


}
