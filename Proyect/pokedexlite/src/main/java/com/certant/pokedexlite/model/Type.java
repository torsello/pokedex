/**
 * 
 */
package com.certant.pokedexlite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Type representative class
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

	public Type() {

	}

	public Type(String type) {
		this.type = type;
	}

}
