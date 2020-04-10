/**
 * 
 */
package com.certant.pokedexlite.view.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certant.pokedexlite.business.service.AbilityService;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.view.resources.vo.AbilityVO;

/**
 * Ability web service class
 * 
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/ability")
public class AbilityResource {

	private AbilityService abilityService;
	
	public AbilityResource(AbilityService abilityService) {
		this.abilityService=abilityService;
	}
	
	@PostMapping
	public ResponseEntity<Ability> createAbility(@RequestBody AbilityVO abilityVo){
		Ability ability = new Ability();
		
		ability.setAbility(abilityVo.getAbility());
		
		return new ResponseEntity<>(this.abilityService.create(ability), HttpStatus.CREATED);
	}
	
	@PutMapping("/{abilityId}")
	public ResponseEntity<Ability> updateAbility(@PathVariable("abilityId") String abilityId, 
			AbilityVO abilityVo){
		
		Ability ability = this.abilityService.findByAbilityId(abilityId);
		
		if(ability == null) {
			return new ResponseEntity<Ability>(HttpStatus.NOT_FOUND);
		}else {
			ability.setAbilityId(abilityVo.getAbilityId());
			ability.setAbility(abilityVo.getAbility());
		}
		
		return new ResponseEntity<>(this.abilityService.update(ability), HttpStatus.OK);
	}
	
}
