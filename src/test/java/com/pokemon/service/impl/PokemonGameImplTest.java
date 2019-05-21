package com.pokemon.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>PokemonGameImplTest</code> contains tests for the class
 * <code>{@link PokemonGameImpl}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class PokemonGameImplTest {

	private Integer noOfOpponents;
	private PokemonGameImpl pokemonGameImpl;

	@Before
	public void setUp() throws Exception {
		noOfOpponents = new Integer(1);
		pokemonGameImpl = new PokemonGameImpl(noOfOpponents);
	}

	@After
	public void tearDown() throws Exception {
		noOfOpponents = null;
		pokemonGameImpl = null;
	}

	@Test
	public void testPokemonGameImpl_1() throws Exception {
		assertNotNull(pokemonGameImpl);
	}
}