package com.pokemon.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.pokemon.util.Constants;

/**
 * The class <code>TrainerTest</code> contains tests for the class
 * <code>{@link Trainer}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class TrainerTest {

	private Trainer trainer;

	@Before
	public void setUp() throws Exception {
		trainer = new Trainer("dipali");
		trainer.setNoOfFights(new Integer(1));
		trainer.setCurrentLevel(new Integer(1));
	}

	@After
	public void tearDown() throws Exception {
		trainer = null;
	}

	@Test
	public void testTrainer_1() throws Exception {
		assertNotNull(trainer);
		assertEquals("dipali", trainer.getName());
		assertEquals(new Integer(200), trainer.getScore());
		assertEquals(new Integer(1), trainer.getNoOfFights());
		assertEquals(null, trainer.destroyOpponent());
		assertEquals(false, trainer.isDead());
		assertEquals(null, trainer.getOpponents());
	}

	@Test
	public void testAdvanceToNextLevel_1() throws Exception {
		trainer.setNoOfFights(new Integer(3));
		trainer.advanceToNextLevel();
		assertEquals(new Integer(2), trainer.getCurrentLevel());
	}

	@Test
	public void testGetCurrentLevel_1() throws Exception {
		Integer result = trainer.getCurrentLevel();
		assertNotNull(result);
		assertEquals("1", result.toString());

	}

	@Test
	public void testGetLevel_1() throws Exception {
		Level result = trainer.getLevel();
		assertNotNull(result);
		assertEquals(0, result.getNumber());
		assertEquals(null, result.getAttacks());
	}

	@Test
	public void testGetName_1() throws Exception {
		String result = trainer.getName();
		assertEquals("dipali", result);
	}

	@Test
	public void testGetNoOfFights_1() throws Exception {
		Integer result = trainer.getNoOfFights();

		assertNotNull(result);
		assertEquals("1", result.toString());
	}

	@Test
	public void testGetPokemon_1() throws Exception {

		Pokemon result = trainer.getPokemon();

		assertNotNull(result);
		assertEquals(null, result.getName());
	}

	@Test
	public void testGetScore_1() throws Exception {
		Integer result = trainer.getScore();

		assertNotNull(result);
		assertEquals("200", result.toString());

	}

	@Test
	public void testIsDead_1() throws Exception {
		boolean result = trainer.isDead();
		assertEquals(false, result);
	}

	@Test
	public void testSave_1() throws Exception {
		Path filePath = Paths.get(Constants.DATA_FOLDER + trainer.getName());
		File file = filePath.toFile();
		trainer.save();
		assertTrue(file.exists());
		// Deleting the file created for test
		file.delete();
	}
}