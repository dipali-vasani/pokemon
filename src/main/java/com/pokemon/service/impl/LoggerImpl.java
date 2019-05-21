package com.pokemon.service.impl;

import java.util.Objects;

import com.pokemon.service.Logger;
import com.pokemon.util.Constants;

/**
 * Singleton class used for logging in comments throughout the code.
 *
 * @author Dipali
 * @since 05/17/2019
 */
public class LoggerImpl implements Logger {

	/** The logger impl. */
	private static LoggerImpl loggerImpl = null;

	/**
	 * Instantiates a new logger impl.
	 */
	private LoggerImpl() {
	}

	/**
	 * The class is made singleton for future enhancements.
	 *
	 * @return LoggerImpl
	 */
	public static LoggerImpl getLoggerImpl() {
		if (Objects.isNull(loggerImpl)) {
			synchronized (LoggerImpl.class) {
				if (Objects.isNull(loggerImpl)) {
					loggerImpl = new LoggerImpl();
				}
			}
		}

		return loggerImpl;
	}

	/* (non-Javadoc)
	 * @see com.pokemon.service.Logger#logError(java.lang.String)
	 */
	@Override
	public void logError(String log) {
		System.out.println(Constants.ANSI_YELLOW_BACKGROUND + Constants.ANSI_RED + log + Constants.ANSI_RESET);

	}

	/* (non-Javadoc)
	 * @see com.pokemon.service.Logger#logAppend(java.lang.String)
	 */
	@Override
	public void logAppend(String log) {
		System.out.print(log);
	}

	/* (non-Javadoc)
	 * @see com.pokemon.service.Logger#log(java.lang.String)
	 */
	@Override
	public void log(String log) {
		System.out.println(log);
	}

	/* (non-Javadoc)
	 * @see com.pokemon.service.Logger#logInstructions(java.lang.String)
	 */
	@Override
	public void logInstructions(String log) {
		System.out.println(Constants.ANSI_BLUE + log + Constants.ANSI_RESET);
	}
}
