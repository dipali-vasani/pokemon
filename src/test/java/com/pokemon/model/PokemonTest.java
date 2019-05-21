package com.pokemon.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>PokemonTest</code> contains tests for the class
 * <code>{@link Pokemon}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class PokemonTest {

	private Pokemon pokemon;

	@Before
	public void setUp() throws Exception {
		pokemon = new Pokemon("pikachu");
	}

	@After
	public void tearDown() throws Exception {
		pokemon = null;
	}

	@Test
	public void testGetName_1() throws Exception {
		String result = pokemon.getName();
		assertEquals("pikachu", result);
	}

	@Test
	public void testSetName_1() throws Exception {
		String name = "pikachu";
		pokemon.setName(name);
	}

}