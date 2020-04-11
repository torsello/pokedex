/**
 * 
 */
package com.certant.pokedexlite.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.pokedexlite.model.Trainer;

/**
 * Interface to define database operations with Trainers
 * 
 * @author Matias
 *
 */
public interface TrainerRepository extends JpaRepository<Trainer, String> {

	/**
	 * Method definition to search trainers by their id
	 * 
	 * @param trainerId
	 * @return
	 */
	public Trainer findByTrainerId(String trainerId);

	/**
	 * Method definition to search all the pokemons
	 */
	public List<Trainer> findAll();
}
