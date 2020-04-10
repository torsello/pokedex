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

import com.certant.pokedexlite.business.service.PokemonService;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.view.resources.vo.PokemonVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Pokemon web service class
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/pokemon")
@Api(tags = "pokemon")
public class PokemonResource {

	private PokemonService pokemonService;
	
	public PokemonResource(PokemonService pokemonService) {
		this.pokemonService=pokemonService;
	}
	
	@PostMapping
	@ApiOperation(value= "Create Pokemon", notes = "Pokemon creator service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Pokemon successfully created"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Pokemon> createPokemon(@RequestBody PokemonVO pokemonVo){
		Pokemon pokemon = new Pokemon();
		
		pokemon.setName(pokemonVo.getName());
		pokemon.setEvolution(pokemonVo.getEvolution());
		pokemon.setEvolutions(pokemonVo.getEvolutions());
		pokemon.setEvolveLvl(pokemonVo.getEvolveLvl());
		pokemon.setPokemonsabilities(pokemonVo.getPokemonsabilities());
		pokemon.setPokemonstypes(pokemonVo.getPokemonstypes());
		
		return new ResponseEntity<>(this.pokemonService.create(pokemon), HttpStatus.CREATED);
	}
	
	@PutMapping("/{pokemonId}")
	@ApiOperation(value= "Update Pokemon", notes = "Pokemon updater service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Pokemon successfully updated"),
			@ApiResponse(code = 404, message = "Pokemon not found")})
	public ResponseEntity<Pokemon> updatePokemon(@PathVariable("pokemonId") String pokemonId, 
			PokemonVO pokemonVo){
		
		Pokemon pokemon = this.pokemonService.findByPokemonId(pokemonId);
		
		if(pokemon == null) {
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}else {
			pokemon.setPokemonId(pokemonVo.getPokemonId());
			pokemon.setName(pokemonVo.getName());
			pokemon.setEvolution(pokemonVo.getEvolution());
			pokemon.setEvolutions(pokemonVo.getEvolutions());
			pokemon.setEvolveLvl(pokemonVo.getEvolveLvl());
			pokemon.setPokemonsabilities(pokemonVo.getPokemonsabilities());
			pokemon.setPokemonstypes(pokemonVo.getPokemonstypes());
		}
		
		return new ResponseEntity<>(this.pokemonService.update(pokemon), HttpStatus.OK);
	}
	
	@DeleteMapping("/{pokemonId}")
	@ApiOperation(value= "Delete Pokemon", notes = "Pokemon dropper service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Pokemon successfully deleted"),
			@ApiResponse(code = 404, message = "Pokemon not found")})
	public void removePokemon(@PathVariable("pokemonId") String pokemonId){
		Pokemon pokemon = this.pokemonService.findByPokemonId(pokemonId);
		
		if(pokemon != null) {
			this.pokemonService.delete(pokemon);
		}
	}
	
	@GetMapping
	@ApiOperation(value= "List all the pokemons", notes = "Service to list all the pokemons")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "pokemons found"),
			@ApiResponse(code = 404, message = "pokemons not found")})
	public ResponseEntity<List<Pokemon>> findAll(){
		return ResponseEntity.ok(this.pokemonService.findAll());
	}
	
	@GetMapping("/{pokemonId}")
	@ApiOperation(value= "List an Pokemon", notes = "Service to list an pokemon")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Pokemon found"),
			@ApiResponse(code = 404, message = "Pokemon not found")})
	public ResponseEntity<Pokemon> findByPokemonId(@PathVariable("pokemonId") String pokemonId){
		
		Pokemon pokemon = this.pokemonService.findByPokemonId(pokemonId);
		
		if(pokemon == null) {
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.pokemonService.findByPokemonId(pokemonId), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	@ApiOperation(value= "List an Pokemon", notes = "Service to list an pokemon")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Pokemon found"),
			@ApiResponse(code = 404, message = "Pokemon not found")})
	public ResponseEntity<Pokemon> findByName(@PathVariable("name") String name){
		
		Pokemon pokemon = this.pokemonService.findByName(name);
		
		if(pokemon == null) {
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.pokemonService.findByName(name), HttpStatus.OK);
	}
	
}
