/**
 * 
 */
package com.certant.pokedexlite.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.pokedexlite.model.Pokemon;

/**
 * Interface to define database operations with pokemons
 * 
 * @author Matias
 *
 */
public interface PokemonRepository extends JpaRepository<Pokemon, String> {

	/**
	 * Method definition to search pokemons by id
	 * 
	 * @param pokemonId
	 * @return
	 */
	public Pokemon findByPokemonId(String pokemonId);
	
	/**
	 * Method definition to search all the pokemons
	 */
	public List<Pokemon> findAll();

	/**
	 * Method definition to search pokemons by name
	 * 
	 * @param name
	 * @return
	 */
	public Pokemon findByName(String name);

}
