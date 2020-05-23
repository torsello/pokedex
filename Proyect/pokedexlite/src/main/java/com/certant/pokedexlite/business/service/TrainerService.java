/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant.pokedexlite.business.repository.TrainerRepository;
import com.certant.pokedexlite.model.Trainer;

/**
 * Class to define Trainer's services
 * 
 * @author Matias
 *
 */
@Service
@Transactional(readOnly = true)
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
	@Transactional
	public Trainer create(Trainer trainer) {
		return this.trainerRepository.save(trainer);
	}

	/**
	 * Trainer updater method
	 * 
	 * @param trainer
	 * @return
	 */
	@Transactional
	public Trainer update(Trainer trainer) {
		return this.trainerRepository.save(trainer);
	}

	/**
	 * Trainer dropper method
	 * 
	 * @param trainer
	 * @return
	 */
	@Transactional
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
	 * Method definition to search all the trainers
	 */
	public List<Trainer> findAll() {
		return this.trainerRepository.findAll();
	}
}
