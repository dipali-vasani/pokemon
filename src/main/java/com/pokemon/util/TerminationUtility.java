package com.pokemon.util;

import static com.pokemon.util.Constants.LOGGER;

/**
 * Utility class created to perform System.exit (termination), if required.
 * 
 * @author dipali
 * @since 05/17/2019
 */
public class TerminationUtility extends Thread {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		LOGGER.log("------------------------------");
		LOGGER.log("Pokemon game shutdown trigger. Terminating the program...");
	}

	/**
	 * Termination.
	 */
	public static void exit() {
		System.exit(-1);
	}

	/**
	 * Termination with error log.
	 *
	 * @param log
	 *            Log to be printed on console before exit
	 */
	public static void exitWithErrorLog(String log) {
		LOGGER.logError(log);
		System.exit(-1);
	}
}