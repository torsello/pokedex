/**
 * 
 */
package com.certant.pokedexlite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.certant.pokedexlite.business.repository.PokemonRepository;
import com.certant.pokedexlite.business.service.PokemonService;
import com.certant.pokedexlite.model.Pokemon;

/**
 * Pokemon Resource test class
 * 
 * @author Matias
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PokemonResourceTests {

	@InjectMocks
	private PokemonService service;

	@Mock
	private PokemonRepository repository;

	// All pokemons listed
	@Test
	public void findAllTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Pokemon("Bulbasaur", 16), new Pokemon("Ivysaur", 32),
				new Pokemon("Venusaur", 0), new Pokemon("Charmander", 16), new Pokemon("Charmeleon", 36),
				new Pokemon("Charizard", 0), new Pokemon("Squirtle", 16), new Pokemon("Wartortle", 36),
				new Pokemon("Blastoise", 0), new Pokemon("Caterpie", 7)).collect(Collectors.toList()));
		assertEquals(10, service.findAll().size());
	}

	// Given a specific pokemon´s name, its name, type/s and lvlevolution
	@Test
	public void getPokemonbyNameTypeLvlTest() {
		String name = "Bulbasaur";
		Pokemon p = new Pokemon("Bulbasaur", 16);
		when(repository.findByName(name)).thenReturn(p);
		assertThat(p, org.hamcrest.Matchers.hasProperty("name"));
		assertThat(p, org.hamcrest.Matchers.hasProperty("pokemonstypes"));
		assertThat(p, org.hamcrest.Matchers.hasProperty("evolveLvl"));
	}

	// Given a specific Pokemon’s name, its Abilities and Evolutions are retrieved
	@Test
	public void getPokemonbyNameAbilityEvolutionTest() {
		String name = "Bulbasaur";
		Pokemon p = new Pokemon("Bulbasaur", 16);
		when(repository.findByName(name)).thenReturn(p);
		assertThat(p, org.hamcrest.Matchers.hasProperty("pokemonsabilities"));
		assertThat(p, org.hamcrest.Matchers.hasProperty("evolutions"));
	}

	// Given a specific Pokemon’s name, all its Evolutions and their information
	// (Name, Type/s and
	// Level)
	@Test
	public void getPokemonbyNameEvolutionsTest() {
		String name = "Bulbasaur";
		Pokemon p = new Pokemon("Bulbasaur", 16);
		Pokemon evo = new Pokemon("Ivysaur", 32);
		List<Pokemon> evolutions = new ArrayList<>();
		evolutions.add(evo);
		p.setEvolutions(evolutions);
		when(repository.findByName(name)).thenReturn(p);
		assertThat(p, org.hamcrest.Matchers.hasProperty("evolutions"));
		assertThat(evo, org.hamcrest.Matchers.hasProperty("name"));
		assertThat(evo, org.hamcrest.Matchers.hasProperty("pokemonstypes"));
		assertThat(evo, org.hamcrest.Matchers.hasProperty("evolveLvl"));
	}

	// A new Pokemon can be added and later retrieve
	@Test
	public void createPokemonTest() {
		Pokemon p = new Pokemon("Bulbasaur", 16);
		when(repository.save(p)).thenReturn(p);
		assertEquals(p, service.create(p));
	}

	// A known pokemons information can be updated
	@Test
	public void updatePokemonTest() {
		Pokemon p = new Pokemon("Bulbasaur", 16);
		when(repository.save(p)).thenReturn(p);
		final Pokemon expected = service.update(p);
		assertNotNull(expected);

		verify(repository).save(p);
	}

}
