/**
 * 
 */
package com.certant.pokedexlite.view.resources.vo;

import lombok.Data;

/**
 * Clase que representa la tabla Pokemons
 * 
 * @author Matias
 *
 */
@Data
public class PokemonVO {

	private String name;
	private PokemonVO evolution;
	private int evolveLvl;

}
