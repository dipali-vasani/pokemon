package com.pokemon;

import java.util.List;

import com.pokemon.service.Game;
import com.pokemon.service.impl.PokemonGameImpl;
import com.pokemon.util.ApplicationProperties;
import com.pokemon.util.Constants;
import com.pokemon.util.TerminationUtility;

/**
 * The Class Application.
 * 
 * @author dipali
 * @since 05/17/2019
 */
public class Application {

	/**
	 * Method for initial setup of levels and points at each level reading the
	 * config files.
	 *
	 * @return number of enemies in the game
	 */
	private static Integer init() {
		Integer noOfOpponents = 0;
		// Registering a TerminationUtility for JVM Termination activity
		Runtime.getRuntime().addShutdownHook(new TerminationUtility());
		ApplicationProperties properties = ApplicationProperties.getApplicationProperties();
		// listing available pokemons
		List<String> listPokemon = properties.listPokemon();

		noOfOpponents = listPokemon.size() - 1;

		return noOfOpponents;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		final Game pokemon = new PokemonGameImpl(init());
		Constants.LOGGER.logInstructions(Constants.BANNER);
		pokemon.displayMenu();
	}

}
