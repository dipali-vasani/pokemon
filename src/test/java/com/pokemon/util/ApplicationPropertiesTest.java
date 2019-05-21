package com.pokemon.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.pokemon.model.Attack;
import com.pokemon.model.Pokemon;

/**
 * The class <code>ApplicationPropertiesTest</code> contains tests for the class
 * <code>{@link ApplicationProperties}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationPropertiesTest {

	private ApplicationProperties applicationProperties;

	@Before
	public void setUp() throws Exception {
		applicationProperties = ApplicationProperties.getApplicationProperties();

	}

	@After
	public void tearDown() throws Exception {
		applicationProperties = null;
	}

	@Test
	public void testGetApplicationProperties_1() throws Exception {
		ApplicationProperties applicationProperties = ApplicationProperties.getApplicationProperties();
		ApplicationProperties applicationProperties_new = ApplicationProperties.getApplicationProperties();
		ApplicationProperties applicationProperties_two = ApplicationProperties.getApplicationProperties();
		assertEquals(applicationProperties_new, applicationProperties);
		assertEquals(applicationProperties_new, applicationProperties_two);
	}

	@Test
	public void testListAttacksByLevel_1() throws Exception {
		Integer level = new Integer(1);
		String pokemon = "pikachu";
		List<Attack> result = applicationProperties.listAttacksByLevel(level, pokemon);
		assertNotNull(result);
		assertEquals(3, result.size());
	}

	@Test
	public void testListAttacksByLevel_2() throws Exception {
		Integer level = new Integer(1);
		String pokemon = "a";
		List<Attack> result = applicationProperties.listAttacksByLevel(level, pokemon);
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testListLevels_1() throws Exception {
		List<Integer> result = applicationProperties.listLevels();
		assertNotNull(result);
		assertEquals(3, result.size());
		assertTrue(result.contains(new Integer(1)));
		assertTrue(result.contains(new Integer(2)));
		assertTrue(result.contains(new Integer(3)));
	}

	@Test
	public void testListOpponents_1() throws Exception {
		String pokemon = "pikachu";
		List<Pokemon> result = applicationProperties.listOpponents(pokemon);
		assertNotNull(result);
		assertEquals(5, result.size());
	}

	@Test
	public void testListPokemon_1() throws Exception {
		List<String> result = applicationProperties.listPokemon();
		assertNotNull(result);
		assertEquals(6, result.size());
	}
}