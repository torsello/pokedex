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

import com.certant.pokedexlite.business.service.TypeService;
import com.certant.pokedexlite.model.Type;
import com.certant.pokedexlite.view.resources.vo.TypeVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Type web services class
 * 
 * @author Matias
 *
 */
@RestController
@RequestMapping("/api/type")
@Api(tags = "type")
public class TypeResource {

	private TypeService typeService;

	public TypeResource(TypeService typeService) {
		this.typeService = typeService;
	}

	@PostMapping
	@ApiOperation(value = "Create Type", notes = "Type creator service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Type successfully created"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Type> createType(@RequestBody TypeVO typeVo) {
		Type type = new Type();

		type.setType(typeVo.getType());

		return new ResponseEntity<>(this.typeService.create(type), HttpStatus.CREATED);
	}

	@PutMapping("/{typeId}")
	@ApiOperation(value = "Update Type", notes = "Type updater service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Type successfully updated"),
			@ApiResponse(code = 404, message = "Type not found") })
	public ResponseEntity<Type> updateType(@PathVariable("typeId") String typeId, TypeVO typeVo) {

		Type type = this.typeService.findByTypeId(typeId);

		if (type == null) {
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
		} else {
			type.setType(typeVo.getType());
		}

		return new ResponseEntity<>(this.typeService.update(type), HttpStatus.OK);
	}

	@DeleteMapping("/{typeId}")
	@ApiOperation(value = "Delete type", notes = "Type dropper service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Type successfully deleted"),
			@ApiResponse(code = 404, message = "Type not found") })
	public void removeType(@PathVariable("typeId") String typeId) {
		Type type = this.typeService.findByTypeId(typeId);

		if (type != null) {
			this.typeService.delete(type);
		}
	}

	@GetMapping
	@ApiOperation(value = "List all the types", notes = "Service to list all the types")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Types found"),
			@ApiResponse(code = 404, message = "Types not found") })
	public ResponseEntity<List<Type>> findAll() {
		return ResponseEntity.ok(this.typeService.findAll());
	}

	@GetMapping("/{typeId}")
	@ApiOperation(value = "List a type", notes = "Service to list a types")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Type found"),
			@ApiResponse(code = 404, message = "Type not found") })
	public ResponseEntity<Type> findByTypeId(@PathVariable("typeId") String typeId) {

		Type type = this.typeService.findByTypeId(typeId);

		if (type == null) {
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(this.typeService.findByTypeId(typeId), HttpStatus.OK);
	}
}
