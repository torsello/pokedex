/**
 * 
 */
package com.certant.pokedexlite.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Class to map the composite Primary Key which belongs to the intermediary join table
 * 
 * @author Matias
 *
 */
@Data
@Embeddable
public class TrainersPokemonsId implements Serializable  {
	
	    @Column(name="trainerId")
		private String trainerId;
	    
	    @Column(name="pokemonId")
	    private String pokemonId;
	 
	    private TrainersPokemonsId() {
	    	
	    }

		public TrainersPokemonsId(String trainerId, String pokemonId) {
			this.trainerId = trainerId;
			this.pokemonId = pokemonId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(trainerId, pokemonId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			TrainersPokemonsId other = (TrainersPokemonsId) obj;
			if (pokemonId == null) {
				if (other.pokemonId != null) {
					return false;
				}
			} else if (!pokemonId.equals(other.pokemonId)) {
				return false;
			}
			if (trainerId == null) {
				if (other.trainerId != null) {
					return false;
				}
			} else if (!trainerId.equals(other.trainerId)) {
				return false;
			}
			return true;
		}

		
	 
	    

	    
	
}
