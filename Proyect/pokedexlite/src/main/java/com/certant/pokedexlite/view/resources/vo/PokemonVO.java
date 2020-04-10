/**
 * 
 */
package com.certant.pokedexlite.view.resources.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.TrainersPokemons;
import com.certant.pokedexlite.model.Type;

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
	private Pokemon evolution;
	private int evolveLvl;
	private Set<Pokemon> evolutions;
	private Set<TrainersPokemons> trainersPokemons;
	private Set<Ability> pokemonsabilities;
	private Set<Type> pokemonstypes;
}
