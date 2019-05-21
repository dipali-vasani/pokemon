package com.pokemon.service;

/**
 * Interface created for the logs on console, right now it is log on console as
 * instructed not to use any 3rd party library, but in future it can implement
 * 3rd party log service.
 *
 * @author Dipali
 * @since 05/17/2019
 */
public interface Logger {

	/**
	 * Log the contents on console.
	 *
	 * @param log            String to be logged
	 */
	void log(String log);

	/**
	 * Log as error on the console.
	 *
	 * @param log            String to be logged
	 */
	void logError(String log);

	/**
	 * Append the contents on console onto same line.
	 *
	 * @param log            String to be logged
	 */
	void logAppend(String log);
	
	
	/**
	 * Log instructions.
	 *
	 * @param log the log
	 */
	void logInstructions(String log);

}
