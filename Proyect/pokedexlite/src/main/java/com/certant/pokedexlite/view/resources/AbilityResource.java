/**
 * 
 */
package com.certant.pokedexlite.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certant.pokedexlite.business.service.AbilityService;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.view.resources.vo.AbilityVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Ability web service class
 * 
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/ability")
@Api(tags = "ability")
public class AbilityResource {

	private AbilityService abilityService;
	
	public AbilityResource(AbilityService abilityService) {
		this.abilityService=abilityService;
	}
	
	@PostMapping
	@ApiOperation(value= "Create Ability", notes = "Ability creator service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Ability successfully created"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Ability> createAbility(@RequestBody AbilityVO abilityVo){
		Ability ability = new Ability();
		
		ability.setAbility(abilityVo.getAbility());
		
		return new ResponseEntity<>(this.abilityService.create(ability), HttpStatus.CREATED);
	}
	
	@PutMapping("/{abilityId}")
	@ApiOperation(value= "Update Ability", notes = "Ability updater service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Ability successfully updated"),
			@ApiResponse(code = 404, message = "Ability not found")})
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
	
	@DeleteMapping("/{abilityId}")
	@ApiOperation(value= "Delete Ability", notes = "Ability dropper service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Ability successfully deleted"),
			@ApiResponse(code = 404, message = "Ability not found")})
	public void removeAbility(@PathVariable("abilityId") String abilityId){
		Ability ability = this.abilityService.findByAbilityId(abilityId);
		
		if(ability != null) {
			this.abilityService.delete(ability);
		}
	}
	
	@GetMapping
	@ApiOperation(value= "List all the Abilities", notes = "Service to list all the abilities")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Abilities found"),
			@ApiResponse(code = 404, message = "Abilities not found")})
	public ResponseEntity<List<Ability>> findAll(){
		return ResponseEntity.ok(this.abilityService.findAll());
	}
	
	@GetMapping("/{abilityId}")
	@ApiOperation(value= "List an Ability", notes = "Service to list an ability")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Ability found"),
			@ApiResponse(code = 404, message = "Ability not found")})
	public ResponseEntity<Ability> findByAbilityId(@PathVariable("abilityId") String abilityId){
		
		Ability ability = this.abilityService.findByAbilityId(abilityId);
		
		if(ability == null) {
			return new ResponseEntity<Ability>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.abilityService.findByAbilityId(abilityId), HttpStatus.OK);
	}
	
}
