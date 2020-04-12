/**
 * 
 */
package com.certant.pokedexlite.view.resources.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.certant.pokedexlite.model.Pokemon;

import lombok.Data;

/**
 * Pokemon virtual object
 * 
 * @author Matias
 *
 */
@Data
public class PokemonVO {

	private String name;
	private int evolveLvl;
	private String evolutionFromName;
	private List<EvolutionVO> evolutions = new ArrayList<>();
	private List<AbilityVO> pokemonsabilities = new ArrayList<>();
	private List<TypeVO> pokemonstypes = new ArrayList<>();
}
