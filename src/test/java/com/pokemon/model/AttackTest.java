package com.pokemon.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>AttackTest</code> contains tests for the class
 * <code>{@link Attack}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class AttackTest {

	private Integer points;
	private String name;
	private Attack attack;

	@Before
	public void setUp() throws Exception {
		name = "attackA";
		points = new Integer(1);
		attack = new Attack(name, points);
	}

	@After
	public void tearDown() throws Exception {
		name = null;
		points = null;
		attack = null;
	}

	@Test
	public void testAttack_1() throws Exception {
		assertNotNull(attack);
		assertEquals("Attacks [name=attackA, points=1]", attack.toString());
		assertEquals("attackA", attack.getName());
		assertEquals(new Integer(1), attack.getPoints());
	}

	@Test
	public void testGetName_1() throws Exception {
		String result = attack.getName();
		assertEquals("attackA", result);
	}

	@Test
	public void testGetPoints_1() throws Exception {
		Integer result = attack.getPoints();
		assertNotNull(result);
		assertEquals("1", result.toString());
	}

	@Test
	public void testSetName_1() throws Exception {
		attack.setName(name);
	}

	@Test
	public void testSetPoints_1() throws Exception {
		attack.setPoints(points);
	}
}