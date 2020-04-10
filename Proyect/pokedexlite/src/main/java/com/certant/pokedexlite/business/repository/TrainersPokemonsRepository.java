/**
 * 
 */
package com.certant.pokedexlite.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.pokedexlite.model.TrainersPokemons;

/**
 * Interface to define database operations with TrainersPokemons
 * 
 * @author Matias
 *
 */
public interface TrainersPokemonsRepository extends JpaRepository<TrainersPokemons, String> {

	/**
	 * Method definition to search all the TrainersPokemons
	 */
	public List<TrainersPokemons> findAll();

}
