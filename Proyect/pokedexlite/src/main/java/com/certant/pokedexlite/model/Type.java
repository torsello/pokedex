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
 * Clase que representa la tabla Type
 * 
 * @author Matias
 *
 */
@Data
@Entity
@Table(name = "type")
public class Type {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String typeId;
	private String type;

	@ManyToMany(mappedBy = "pokemonstypes")
	private Set<Pokemon> pokemonstypes;

	public Type() {

	}

	public Type(String type) {
		this.type = type;
	}

}
