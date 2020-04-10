/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.pokedexlite.business.repository.TrainersPokemonsRepository;
import com.certant.pokedexlite.model.TrainersPokemons;

/**
 * Class to define TrainersPokemons services
 * 
 * @author Matias
 *
 */
@Service
public class TrainersPokemonsService {
	
	private final TrainersPokemonsRepository trainersPokemonsRepository;

	public TrainersPokemonsService(TrainersPokemonsRepository trainersPokemonsRepository) {
		this.trainersPokemonsRepository = trainersPokemonsRepository;
	}
	
	/**
	 * TrainersPokemons creator method
	 * @param trainersPokemons
	 * @return
	 */
	public TrainersPokemons create(TrainersPokemons trainersPokemons) {
		return this.trainersPokemonsRepository.save(trainersPokemons);
	}
	
	/**
	 * TrainersPokemons updater method
	 * @param trainersPokemons
	 * @return
	 */
	public TrainersPokemons update(TrainersPokemons trainersPokemons) {
		return this.trainersPokemonsRepository.save(trainersPokemons);
	}
	
	/**
	 * TrainersPokemons dropper method
	 * @param trainersPokemons
	 */
	public void delete(TrainersPokemons trainersPokemons){
		this.trainersPokemonsRepository.delete(trainersPokemons);
	}
	
	/**
	 * Method definition to search all the TrainersPokemons
	 */
	public List<TrainersPokemons> findAll(){
		return this.trainersPokemonsRepository.findAll();
	}
	
}
