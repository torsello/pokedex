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

import com.certant.pokedexlite.business.service.TrainerService;
import com.certant.pokedexlite.model.Trainer;
import com.certant.pokedexlite.view.resources.vo.TrainerVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Trainer web service class
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/trainer")
@Api(tags = "trainer")
public class TrainerResource {

	private TrainerService trainerService;
	
	public TrainerResource(TrainerService trainerService) {
		this.trainerService=trainerService;
	}
	
	@PostMapping
	@ApiOperation(value= "Create Trainer", notes = "Trainer creator service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Trainer successfully created"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Trainer> createTrainer(@RequestBody TrainerVO trainerVo){
		Trainer trainer = new Trainer();
		
		trainer.setTrainerName(trainerVo.getTrainerName());
		trainer.setTrainerPass(trainerVo.getTrainerPass());
		
		return new ResponseEntity<>(this.trainerService.create(trainer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{trainerId}")
	@ApiOperation(value= "Update Trainer", notes = "Trainer updater service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Trainer successfully updated"),
			@ApiResponse(code = 404, message = "Trainer not found")})
	public ResponseEntity<Trainer> updateTrainer(@PathVariable("trainerId") String trainerId, 
			TrainerVO trainerVo){
		
		Trainer trainer = this.trainerService.findByTrainerId(trainerId);
		
		if(trainer == null) {
			return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
		}else {
			trainer.setTrainerName(trainerVo.getTrainerName());
			trainer.setTrainerPass(trainerVo.getTrainerPass());
		}
		
		return new ResponseEntity<>(this.trainerService.update(trainer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{trainerId}")
	@ApiOperation(value= "Delete Trainer", notes = "Trainer dropper service")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Trainer successfully deleted"),
			@ApiResponse(code = 404, message = "Trainer not found")})
	public void removeTrainer(@PathVariable("trainerId") String trainerId){
		Trainer trainer = this.trainerService.findByTrainerId(trainerId);
		
		if(trainer != null) {
			this.trainerService.delete(trainer);
		}
	}
	
	@GetMapping
	@ApiOperation(value= "List all the trainers", notes = "Service to list all the trainers")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "trainers found"),
			@ApiResponse(code = 404, message = "trainers not found")})
	public ResponseEntity<List<Trainer>> findAll(){
		return ResponseEntity.ok(this.trainerService.findAll());
	}
	
	@GetMapping("/{trainerId}")
	@ApiOperation(value= "List an Trainer", notes = "Service to list an trainer")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Trainer found"),
			@ApiResponse(code = 404, message = "Trainer not found")})
	public ResponseEntity<Trainer> findByTrainerId(@PathVariable("trainerId") String trainerId){
		
		Trainer trainer = this.trainerService.findByTrainerId(trainerId);
		
		if(trainer == null) {
			return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.trainerService.findByTrainerId(trainerId), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	@ApiOperation(value= "List an Trainer", notes = "Service to list an trainer")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Trainer found"),
			@ApiResponse(code = 404, message = "Trainer not found")})
	public ResponseEntity<Trainer> findByName(@PathVariable("name") String name){
		
		Trainer trainer = this.trainerService.findByTrainerName(name);
		
		if(trainer == null) {
			return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.trainerService.findByTrainerName(name), HttpStatus.OK);
	}
	
}
