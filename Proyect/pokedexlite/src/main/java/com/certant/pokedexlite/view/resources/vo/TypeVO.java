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
public class TypeVO {

	private String type;
	
}
