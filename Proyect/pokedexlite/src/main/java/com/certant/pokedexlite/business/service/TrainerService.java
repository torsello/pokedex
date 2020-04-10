/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.pokedexlite.business.repository.TrainerRepository;
import com.certant.pokedexlite.model.Trainer;

/**
 * Class to define Trainer's services
 * 
 * @author Matias
 *
 */
@Service
public class TrainerService {

	private final TrainerRepository trainerRepository;

	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}

	/**
	 * Trainer creator method
	 * 
	 * @param trainer
	 * @return
	 */
	public Trainer create(Trainer trainer) {
		return this.trainerRepository.save(trainer);
	}

	/**
	 * Trainer updater method
	 * 
	 * @param trainer
	 * @return
	 */
	public Trainer update(Trainer trainer) {
		return this.trainerRepository.save(trainer);
	}

	/**
	 * Trainer dropper method
	 * 
	 * @param trainer
	 * @return
	 */
	public void delete(Trainer trainer) {
		this.trainerRepository.delete(trainer);
	}

	/**
	 * Method definition to search trainers by their id
	 * 
	 * @param trainerId
	 * @return
	 */
	public Trainer findByTrainerId(String trainerId) {
		return this.trainerRepository.findByTrainerId(trainerId);
	}

	/**
	 * Method definition to search trainers by name (Unique)
	 * 
	 * @param trainerName
	 * @return
	 */
	public Trainer findByTrainerName(String trainerName) {
		return this.trainerRepository.findByTrainerName(trainerName);
	}

	/**
	 * Method definition to search all the pokemons
	 */
	public List<Trainer> findAll() {
		return this.trainerRepository.findAll();
	}
}
