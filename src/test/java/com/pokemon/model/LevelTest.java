package com.pokemon.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>LevelTest</code> contains tests for the class
 * <code>{@link Level}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class LevelTest {

	private Level level;

	@Before
	public void setUp() throws Exception {
		level = new Level();
		level.setAttacks(new ArrayList<Attack>());
		level.setNumber(1);
	}

	@After
	public void tearDown() throws Exception {
		level = null;
	}

	@Test
	public void testLevel_1() throws Exception {
		assertNotNull(level);
	}

	@Test
	public void testGetAttacks_1() throws Exception {
		List<Attack> result = level.getAttacks();
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetNumber_1() throws Exception {
		int result = level.getNumber();
		assertEquals(1, result);
	}

	@Test
	public void testSetAttacks_1() throws Exception {
		List<Attack> attacks = new ArrayList<Attack>();
		level.setAttacks(attacks);

	}

	@Test
	public void testSetNumber_1() throws Exception {
		int number = 1;
		level.setNumber(number);
	}

}