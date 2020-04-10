/**
 * 
 */
package com.certant.pokedexlite.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.pokedexlite.model.Ability;

/**
 * Interface to define database operations with Abilities
 * 
 * @author Matias
 *
 */
public interface AbilityRepository extends JpaRepository<Ability, String> {

	/**
	 * Method definition to search all the abilities
	 */
	public List<Ability> findAll();

}