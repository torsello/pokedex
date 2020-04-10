/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant.pokedexlite.business.repository.TypeRepository;
import com.certant.pokedexlite.model.Type;

/**
 * Class to define Types services
 * 
 * @author Matias
 *
 */
@Service
@Transactional(readOnly = true)
public class TypeService {

	private final TypeRepository typeRepository;

	public TypeService(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	/**
	 * Type creator method
	 * 
	 * @param type
	 * @return
	 */
	@Transactional
	public Type create(Type type) {
		return this.typeRepository.save(type);
	}

	/**
	 * Type updater method
	 * 
	 * @param type
	 * @return
	 */
	@Transactional
	public Type update(Type type) {
		return this.typeRepository.save(type);
	}

	/**
	 * Type dropper method
	 * 
	 * @param type
	 */
	@Transactional
	public void delete(Type type) {
		this.typeRepository.delete(type);
	}

	/**
	 * Method definition to search all the TrainersPokemons
	 */
	public List<Type> findAll() {
		return this.typeRepository.findAll();
	}

}
