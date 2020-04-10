/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.pokedexlite.business.repository.AbilityRepository;
import com.certant.pokedexlite.model.Ability;

/**
 * Class to define Abilities services
 * 
 * @author Matias
 *
 */
@Service
public class AbilityService {

	private AbilityRepository abilityRepository;

	public AbilityService(AbilityRepository abilityRepository) {
		this.abilityRepository = abilityRepository;
	}

	/**
	 * Ability creator method
	 * 
	 * @param ability
	 * @return
	 */
	public Ability create(Ability ability) {
		return this.abilityRepository.save(ability);
	}

	/**
	 * Ability updater method
	 * 
	 * @param ability
	 * @return
	 */
	public Ability update(Ability ability) {
		return this.abilityRepository.save(ability);
	}

	/**
	 * Ability dropper method
	 * 
	 * @param ability
	 */
	public void delete(Ability ability) {
		this.abilityRepository.delete(ability);
	}

	/**
	 * Method definition to search all the abilities
	 */
	public List<Ability> findAll() {
		return this.abilityRepository.findAll();
	}
}
