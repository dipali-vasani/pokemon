package com.pokemon.util;

import static com.pokemon.util.Constants.LOGGER;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.pokemon.model.Trainer;

/**
 * The Class FileReadWriteUtility. This class contains static methods to read and write game state.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class FileReadWriteUtility {

	/**
	 * Instantiates a new file read write utility.
	 */
	private FileReadWriteUtility() {
	}

	/**
	 * Read from storage.
	 *
	 * @param name
	 *            the name
	 * @return the trainer
	 */
	public static Trainer readFromStorage(String name) {
		if (!ObjectUtils.validateString(name)) {// name validation
			return null;
		}
		Path filePath = Paths.get(Constants.DATA_FOLDER + name);
		File file = filePath.toFile();

		// Using try-with-resources as resources used inside try will be auto-closed
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			if (!file.exists()) {
				return null;
			}

			Trainer a = (Trainer) ois.readObject();
			LOGGER.log("Data found and read from storage");
			return a;

		} catch (Exception e) {
			return null;// exception swallowed to send null to indicate creation of new object
		}
	}

	/**
	 * Write to storage.
	 *
	 * @param trainer
	 *            the trainer
	 */
	public static void writeToStorage(Trainer trainer) {
		if (!ObjectUtils.validateObject(trainer)) {// Pokemon object validation-null check
			LOGGER.log("Null Pokemon can't be saved");
			return;
		}
		Path filePath = Paths.get(Constants.DATA_FOLDER + trainer.getName());
		File file = filePath.toFile();
		boolean filePresent = true;

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				filePresent = file.createNewFile();
			} catch (IOException e) {
				TerminationUtility.exitWithErrorLog("Unable to create file due to IOException");
			}
		}

		// try-with-resources is used here as resources used inside try will be
		// auto-closed
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			if (filePresent) {
				oos.writeObject(trainer);
				LOGGER.log("Your Trainer " + trainer.getName() + " is successfully saved");
			}

		} catch (FileNotFoundException e) {// exception swallowed and moving ahead with the application
			LOGGER.logError("FileNotFoundException while writing to the object");
		} catch (IOException e) {
			LOGGER.logError("IOException while writing the object");
		}
	}
}
