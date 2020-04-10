/**
 * 
 */
package com.certant.pokedexlite.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.pokedexlite.model.Type;

/**
 * Interface to define database operations with Types
 * 
 * @author Matias
 *
 */
public interface TypeRepository extends JpaRepository<Type, String> {

	/**
	 * Method definition to search all the TrainersPokemons
	 */
	public List<Type> findAll();

}
