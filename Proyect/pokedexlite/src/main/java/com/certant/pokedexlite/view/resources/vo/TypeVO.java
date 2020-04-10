/**
 * 
 */
package com.certant.pokedexlite.view.resources.vo;

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
public class TypeVO {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String typeId;
	private String type;

	@ManyToMany(mappedBy = "pokemonstypes")
	private Set<PokemonVO> pokemonstypes;

	public TypeVO() {

	}

	public TypeVO(String type) {
		this.type = type;
	}

}
