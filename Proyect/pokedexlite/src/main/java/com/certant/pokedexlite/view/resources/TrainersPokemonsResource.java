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

import com.certant.pokedexlite.business.service.TrainersPokemonsService;
import com.certant.pokedexlite.model.TrainersPokemons;
import com.certant.pokedexlite.view.resources.vo.TrainersPokemonsVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * TrainersPokemons web service class
 * 
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/trainerspokemons")
@Api(tags = "trainerspokemons")
public class TrainersPokemonsResource {

	private TrainersPokemonsService trainersPokemonsService;

	public TrainersPokemonsResource(TrainersPokemonsService trainersPokemonsService) {
		this.trainersPokemonsService = trainersPokemonsService;
	}

	@PostMapping
	@ApiOperation(value = "Create TrainerPokemon", notes = "TrainerPokemon creator service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "TrainerPokemon successfully created"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<TrainersPokemons> createTrainerPokemon(@RequestBody TrainersPokemonsVO tpVo) {
		TrainersPokemons tp = new TrainersPokemons();

		tp.setPokemon(tpVo.getPokemon());
		tp.setTrainer(tpVo.getTrainer());
		tp.setFoundedLvl(tpVo.getFoundedLvl());

		return new ResponseEntity<>(this.trainersPokemonsService.create(tp), HttpStatus.CREATED);

	}

	@PutMapping("/{trainersPokemonsId}")
	@ApiOperation(value = "Update trainersPokemons", notes = "trainersPokemons updater service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "trainersPokemons successfully updated"),
			@ApiResponse(code = 404, message = "trainersPokemons not found") })
	public ResponseEntity<TrainersPokemons> updateTrainerPokemon(@PathVariable("trainersPokemonsId") String id,
			TrainersPokemonsVO tpVo) {

		TrainersPokemons tp = this.trainersPokemonsService.findByTrainersPokemonsId(id);

		if (tp == null) {
			return new ResponseEntity<TrainersPokemons>(HttpStatus.NOT_FOUND);
		} else {
			tp.setTrainersPokemonsId(tpVo.getTrainersPokemonsId());
			tp.setPokemon(tpVo.getPokemon());
			tp.setTrainer(tpVo.getTrainer());
			tp.setFoundedLvl(tpVo.getFoundedLvl());
		}

		return new ResponseEntity<>(this.trainersPokemonsService.update(tp), HttpStatus.OK);
	}

	@DeleteMapping("/{trainersPokemonsId}")
	@ApiOperation(value = "Delete trainersPokemons", notes = "trainersPokemons dropper service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "trainersPokemons successfully deleted"),
			@ApiResponse(code = 404, message = "trainersPokemons not found") })
	public void removeTrainerPokemon(@PathVariable("trainersPokemonsId") String trainersPokemonsId) {

		TrainersPokemons tp = this.trainersPokemonsService.findByTrainersPokemonsId(trainersPokemonsId);

		if (tp != null) {
			this.trainersPokemonsService.delete(tp);
		}

	}

	@GetMapping
	@ApiOperation(value = "List all the trainersPokemons", notes = "Service to list all the trainersPokemons")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "trainersPokemons found"),
			@ApiResponse(code = 404, message = "trainersPokemons not found") })
	public ResponseEntity<List<TrainersPokemons>> findAll() {
		return ResponseEntity.ok(this.trainersPokemonsService.findAll());
	}

	@GetMapping("/{trainersPokemonsId}")
	@ApiOperation(value = "List an Ability", notes = "Service to list an ability")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Ability found"),
			@ApiResponse(code = 404, message = "Ability not found") })
	public ResponseEntity<TrainersPokemons> findByTrainersPokemonsId(@PathVariable("trainersPokemonsId") String id) {
		TrainersPokemons tp = this.trainersPokemonsService.findByTrainersPokemonsId(id);

		if (tp == null) {
			return new ResponseEntity<TrainersPokemons>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(this.trainersPokemonsService.findByTrainersPokemonsId(id), HttpStatus.OK);
	}
}
