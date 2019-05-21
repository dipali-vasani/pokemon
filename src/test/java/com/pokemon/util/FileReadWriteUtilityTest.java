package com.pokemon.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.pokemon.model.Trainer;

/**
 * The class <code>FileReadWriteUtilityTest</code> contains tests for the class
 * <code>{@link FileReadWriteUtility}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class FileReadWriteUtilityTest {

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
	public void testReadFromStorage_1() throws Exception {
		String name = "dipali";
		Trainer result = FileReadWriteUtility.readFromStorage(name);
		assertEquals(null, result);
	}

	@Test
	public void testWriteToStorage_1() throws Exception {
		Path filePath = Paths.get(Constants.DATA_FOLDER + trainer.getName());
		File file = filePath.toFile();
		FileReadWriteUtility.writeToStorage(trainer);
		assertTrue(file.exists());
		// Deleting the file created for test
		file.delete();
	}

}