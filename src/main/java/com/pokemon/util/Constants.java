package com.pokemon.util;

import com.pokemon.service.Logger;
import com.pokemon.service.impl.LoggerImpl;

/**
 * The Class Constants.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class Constants {

	/** The Constant DATA_FOLDER. */
	public static final String DATA_FOLDER = System.getProperty("user.home") + "/pokemon/data/";

	/** The Constant LEVEL. */
	static final String LEVEL = "level";

	/** The Constant DIRECTORY. */
	static final String DIRECTORY = "config/";

	/** The Constant CONFIG_FILE. */
	static final String CONFIG_FILE = "application.properties";

	/** The Constant ATTACKS_IN_FIGHT. */
	public static final Integer ATTACKS_IN_FIGHT = 3;

	/** The Constant FIGHTS_IN_LEVEL. */
	public static final Integer FIGHTS_IN_LEVEL = 3;

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LoggerImpl.getLoggerImpl();

	/** The Constant POKEMON. */
	static final String POKEMON = "pokemon";

	/** The Constant ANSI_RESET. */
	public static final String ANSI_RESET = "\u001B[0m";

	/** The Constant ANSI_BLACK. */
	public static final String ANSI_BLACK = "\u001B[30m";

	/** The Constant ANSI_RED. */
	public static final String ANSI_RED = "\u001B[31m";

	/** The Constant ANSI_GREEN. */
	public static final String ANSI_GREEN = "\u001B[32m";

	/** The Constant ANSI_YELLOW. */
	public static final String ANSI_YELLOW = "\u001B[33m";

	/** The Constant ANSI_BLUE. */
	public static final String ANSI_BLUE = "\u001B[34m";

	/** The Constant ANSI_PURPLE. */
	public static final String ANSI_PURPLE = "\u001B[35m";

	/** The Constant ANSI_CYAN. */
	public static final String ANSI_CYAN = "\u001B[36m";

	/** The Constant ANSI_WHITE. */
	public static final String ANSI_WHITE = "\u001B[37m";

	/** The Constant ANSI_BLACK_BACKGROUND. */
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

	/** The Constant ANSI_RED_BACKGROUND. */
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

	/** The Constant ANSI_GREEN_BACKGROUND. */
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	/** The Constant ANSI_YELLOW_BACKGROUND. */
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

	/** The Constant ANSI_BLUE_BACKGROUND. */
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	/** The Constant ANSI_PURPLE_BACKGROUND. */
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

	/** The Constant ANSI_CYAN_BACKGROUND. */
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

	/** The Constant ANSI_WHITE_BACKGROUND. */
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	/** The Constant LINE_SEPERATOR. */
	public static final String LINE_SEPERATOR = "-------------------";

	/**
	 * Instantiates a new constants.
	 */
	private Constants() {

	}
}
