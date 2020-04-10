/**
 * 
 */
package com.certant.pokedexlite.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Pokemons
 * 
 * @author Matias
 *
 */
@Data
@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String pokemonId;
	@Column(unique = true)
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition = "text", name = "evolvesFromId")
	private Pokemon evolution;
	@Column(nullable = true)
	private int evolveLvl;
	@OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TrainersPokemons> trainersPokemons;
	@ManyToMany
	@JoinTable(name = "pokemonsabilities", joinColumns = @JoinColumn(name = "pokemonId"), inverseJoinColumns = @JoinColumn(name = "abilityId"))
	private Set<Ability> pokemonsabilities;
	@ManyToMany
	@JoinTable(name = "pokemonstypes", joinColumns = @JoinColumn(name = "pokemonId"), inverseJoinColumns = @JoinColumn(name = "typeId"))
	private Set<Type> pokemonstypes;

	public Pokemon() {

	}

	public Pokemon(String name, Pokemon evolution, int evolveLvl, Set<Ability> pokemonsabilities,
			Set<Type> pokemonstypes) {
		super();
		this.name = name;
		this.evolution = evolution;
		this.evolveLvl = evolveLvl;
		this.pokemonsabilities = pokemonsabilities;
		this.pokemonstypes = pokemonstypes;
	}

}
