/**
 * 
 */
package com.certant.pokedexlite.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.pokedexlite.business.repository.TypeRepository;
import com.certant.pokedexlite.model.Type;

/**
 * Class to define Types services
 * 
 * @author Matias
 *
 */
@Service
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
	public Type create(Type type) {
		return this.typeRepository.save(type);
	}

	/**
	 * Type updater method
	 * 
	 * @param type
	 * @return
	 */
	public Type update(Type type) {
		return this.typeRepository.save(type);
	}

	/**
	 * Type dropper method
	 * 
	 * @param type
	 */
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
