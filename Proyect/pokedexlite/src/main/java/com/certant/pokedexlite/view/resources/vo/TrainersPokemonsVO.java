
package com.certant.pokedexlite.view.resources.vo;

import lombok.Data;

/**
 * Clase que representa la tabla TrainersPokemons
 * 
 * @author Matias
 *
 */

@Data
public class TrainersPokemonsVO {

	private TrainerVO trainer;
	private PokemonVO pokemon;
	private int foundedLvl;


}
