package com.pokemon.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.StringTokenizer;

import com.pokemon.model.Attack;
import com.pokemon.model.Pokemon;
import com.pokemon.service.impl.ConsoleServiceImpl;

/**
 * The Class ApplicationProperties.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class ApplicationProperties {

	/** The properties. */
	private Properties properties;

	/** The list pokemon. */
	private List<String> listPokemon;

	/** The list levels. */
	private List<Integer> listLevels;

	/** The application properties. */
	private static ApplicationProperties applicationProperties = null;

	/**
	 * Instantiates a new application properties.
	 */
	private ApplicationProperties() {// The class is made singleton
		try {
			init();
		} catch (Exception e) {
			TerminationUtility.exitWithErrorLog("Terminating with error : " + e.getMessage());
		}
	}

	/**
	 * Gets the application properties.
	 *
	 * @return the application properties
	 */
	public static ApplicationProperties getApplicationProperties() {
		if (Objects.isNull(applicationProperties)) {
			synchronized (ConsoleServiceImpl.class) {
				if (Objects.isNull(applicationProperties)) {
					applicationProperties = new ApplicationProperties();
				}
			}
		}

		return applicationProperties;
	}

	/**
	 * List pokemon.
	 *
	 * @return the list
	 */
	public List<String> listPokemon() {
		if (listPokemon != null && !listPokemon.isEmpty()) {
			return listPokemon;
		}
		if (Objects.isNull(properties)) {
			TerminationUtility.exitWithErrorLog("Unable to find configuration file for stages");
		}
		List<String> pokemons = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(get(Constants.POKEMON), ",");
		while (stringTokenizer.hasMoreElements()) {
			pokemons.add(stringTokenizer.nextElement().toString());
		}
		listPokemon = pokemons;
		return pokemons;
	}

	/**
	 * List levels.
	 *
	 * @return the list
	 */
	public List<Integer> listLevels() {
		if (listLevels != null && !listLevels.isEmpty()) {
			return listLevels;
		}
		if (Objects.isNull(properties)) {
			TerminationUtility.exitWithErrorLog("Unable to find configuration file for stages");
		}
		List<Integer> levels = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(get(Constants.LEVEL), ",");
		while (stringTokenizer.hasMoreElements()) {
			levels.add(Integer.parseInt(stringTokenizer.nextElement().toString()));
		}
		listLevels = levels;
		return levels;
	}

	/**
	 * List attacks by level.
	 *
	 * @param level
	 *            the level
	 * @param pokemon
	 *            the pokemon
	 * @return the list
	 */
	public List<Attack> listAttacksByLevel(Integer level, String pokemon) {
		List<String> attackList = parseString(get(Constants.LEVEL + level + "." + pokemon + ".attacks"), ",");
		List<String> pointsList = parseString(get(Constants.LEVEL + level + "." + pokemon + ".points"), ",");
		List<Attack> attacks = new ArrayList<>();
		for (int i = 0; i < attackList.size(); i++) {
			attacks.add(new Attack(attackList.get(i), Integer.parseInt(pointsList.get(i))));
		}
		return attacks;
	}

	/**
	 * List opponents.
	 *
	 * @param pokemon
	 *            the pokemon
	 * @return the list
	 */
	public List<Pokemon> listOpponents(String pokemon) {
		List<String> opponentList = listPokemon();
		List<Pokemon> opponents = new ArrayList<>();
		opponentList.remove(pokemon);
		opponentList.forEach(e -> opponents.add(new Pokemon(e)));
		return opponents;
	}

	/**
	 * Inits the.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void init() throws IOException {
		this.properties = read();
		listPokemon();
		listLevels();
	}

	/**
	 * Gets the.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	private String get(Object key) {
		return properties.getProperty(key.toString());
	}

	/**
	 * Read.
	 *
	 * @return the properties
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private Properties read() throws IOException {
		this.properties = new Properties();
		InputStream in = readFile(Constants.DIRECTORY + Constants.CONFIG_FILE);
		properties.load(in);
		return properties;
	}

	/**
	 * Read file.
	 *
	 * @param input
	 *            the input
	 * @return the input stream
	 */
	private InputStream readFile(String input) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(input);

		if (Objects.isNull(inputStream)) {
			TerminationUtility.exitWithErrorLog("Unable to find file " + input);
		}
		return inputStream;
	}

	/**
	 * Parses the string.
	 *
	 * @param input
	 *            the input
	 * @param delim
	 *            the delim
	 * @return the list
	 */
	private List<String> parseString(String input, String delim) {
		ArrayList<String> result = new ArrayList<>();

		if (Objects.isNull(input) || Objects.isNull(delim)) {
			return result;
		}

		StringTokenizer stringTokenizer = new StringTokenizer(input, delim);
		while (stringTokenizer.hasMoreElements()) {
			result.add((String) stringTokenizer.nextElement());
		}
		return result;
	}
}
