package com.pokemon.exception;

import com.pokemon.util.Constants;
import com.pokemon.util.TerminationUtility;

/**
 * Custom implementation of Exception class
 * 
 * @author dipali
 * @since 05/17/2019
 */
public class PokemonException extends Exception {

	private static final long serialVersionUID = -842609350282363441L;

	public PokemonException() {
		Constants.LOGGER.logError("There is some exception in the Pokemon Game");
		TerminationUtility.exit();
	}

}