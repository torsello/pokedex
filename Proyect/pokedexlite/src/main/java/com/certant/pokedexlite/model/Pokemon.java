/**
 * 
 */
package com.certant.pokedexlite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

/**
 * Pokemons representative class
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

	@ManyToOne
	@JoinColumn(name = "evolves_from_id")
	@JsonBackReference
	private Pokemon evolutionFrom;

	@OneToMany(mappedBy = "evolutionFrom", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pokemon> evolutions;

	@Column(nullable = true)
	private int evolveLvl;

	@ManyToMany
	@JoinTable(name = "pokemonsabilities", joinColumns = @JoinColumn(name = "pokemonId"), inverseJoinColumns = @JoinColumn(name = "abilityId"))
	private List<Ability> pokemonsabilities = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "pokemonstypes", joinColumns = @JoinColumn(name = "pokemonId"), inverseJoinColumns = @JoinColumn(name = "typeId"))
	private List<Type> pokemonstypes = new ArrayList<>();

	public Pokemon() {

	}

	public Pokemon(String name, int evolveLvl) {
		this.name = name;
		this.evolveLvl = evolveLvl;
	}

}
