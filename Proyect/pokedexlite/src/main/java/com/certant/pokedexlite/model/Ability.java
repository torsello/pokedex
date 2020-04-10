/**
 * 
 */
package com.certant.pokedexlite.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Ability
 * 
 * @author Matias
 *
 */
@Data
@Entity
@Table(name="ability")
public class Ability {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	private String abilityId;
	private String ability;
	@ManyToMany(mappedBy = "pokemonsabilities")
	private Set<Pokemon> pokemonsabilities;
	
	
	public Ability() {
		
	}
	
	public Ability(String ability) {
		this.ability = ability;
	}
	
	
	
}
