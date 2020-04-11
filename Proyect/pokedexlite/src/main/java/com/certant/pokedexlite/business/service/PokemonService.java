/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant.pokedexlite.business.repository.PokemonRepository;
import com.certant.pokedexlite.business.repository.TypeRepository;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;

/**
 * Class to define Pokemon's services
 * 
 * @author Matias
 *
 */
@Service
@Transactional(readOnly = true)
public class PokemonService {

	private final PokemonRepository pokemonRepository;
	
	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	/**
	 * Pokemon creator method
	 * 
	 * @param pokemon
	 * @return
	 */
	@Transactional
	public Pokemon create(Pokemon pokemon) {
		return this.pokemonRepository.save(pokemon);
	}

	/**
	 * Pokemon updater method
	 * 
	 * @param pokemon
	 * @return
	 */
	@Transactional
	public Pokemon update(Pokemon pokemon) {
		return this.pokemonRepository.save(pokemon);
	}

	/**
	 * Pokemon dropper method
	 * 
	 * @param pokemon
	 */
	@Transactional
	public void delete(Pokemon pokemon) {
		this.pokemonRepository.delete(pokemon);
	}

	/**
	 * Method definition to search all the pokemons
	 */
	public List<Pokemon> findAll() {
		return this.pokemonRepository.findAll();
	}

	/**
	 * Method definition to search pokemons by name
	 * 
	 * @param name
	 * @return
	 */
	public Pokemon findByName(String name) {
		return this.pokemonRepository.findByName(name);
	}

	/**
	 * Method definition to search pokemons by id
	 * @param pokemonId
	 * @return
	 */
	public Pokemon findByPokemonId(String pokemonId) {
		return this.pokemonRepository.findByPokemonId(pokemonId);
	}
	
	
}
