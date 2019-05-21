package com.pokemon.model;

import static com.pokemon.util.Constants.LOGGER;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.pokemon.service.ConsoleService;
import com.pokemon.service.impl.ConsoleServiceImpl;
import com.pokemon.util.ApplicationProperties;
import com.pokemon.util.FileReadWriteUtility;
import com.pokemon.util.ObjectUtils;

/**
 * The Class Trainer.
 * 
 * @author dipali
 * @since 05/17/2019
 */
public class Trainer implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7265806659143222789L;

	/** The input service. */
	private static transient ConsoleService inputService = ConsoleServiceImpl.getConsoleServiceImpl();

	/** The properties. */
	private transient ApplicationProperties properties = ApplicationProperties.getApplicationProperties();

	/** The name. */
	private String name;

	/** The no of fights. */
	private Integer noOfFights;

	/** The score. */
	private Integer score;

	/** The pokemon. */
	private Pokemon pokemon;

	/** The opponents. */
	private List<Pokemon> opponents;

	/** The level. */
	private Level level;

	/** The current level. */
	private Integer currentLevel;

	/**
	 * Constructor for class based on name.
	 *
	 * @param name
	 *            name of the Trainer
	 */
	public Trainer(String name) {
		this.noOfFights = 0;
		this.score = 200;
		this.name = name;
		this.pokemon = new Pokemon();
		this.setLevel(new Level());
	}

	/**
	 * Save.
	 */
	public void save() {
		FileReadWriteUtility.writeToStorage(this);
	}

	/**
	 * Setup trainer.
	 *
	 * @return the trainer
	 */
	public static Trainer setupTrainer() {
		boolean nameValidated = false;
		String trainerName = null;
		while (!nameValidated) {
			LOGGER.log("Enter trainer name ");
			trainerName = inputService.next();
			nameValidated = ObjectUtils.validateName(trainerName);
			if (!nameValidated) {
				LOGGER.logError("Opps! Trainer name can only contain Characters and Space.");
				LOGGER.logError("Please re-enter the name");
			}
		}

		Trainer existingTrainer = FileReadWriteUtility.readFromStorage(trainerName);
		if (ObjectUtils.validateObject(existingTrainer)) {
			return existingTrainer;
		} else {
			return new Trainer(trainerName);
		}
	}

	/**
	 * Destroy opponent.
	 *
	 * @return the pokemon
	 */
	public Pokemon destroyOpponent() {
		if (Objects.nonNull(this.getOpponents())) {
			return this.getOpponents().remove(0);
		}
		return null;
	}

	/**
	 * Advance to next level.
	 */
	public void advanceToNextLevel() {
		try {
			this.currentLevel = currentLevel + 1;
			/*
			 * commented to restrict update of opponent list, if we have different set of
			 * opponents for different level.. uncomment
			 */
			// this.setOpponents(properties.listOpponents(pokemon.getName()));
			this.level.setAttacks(properties.listAttacksByLevel(this.currentLevel, pokemon.getName()));
		} catch (Exception e) {
			LOGGER.log("Stage" + this.currentLevel + " does not exits");
		}
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the no of fights.
	 *
	 * @return the no of fights
	 */
	public Integer getNoOfFights() {
		return noOfFights;
	}

	/**
	 * Sets the no of fights.
	 *
	 * @param noOfFights
	 *            the new no of fights
	 */
	public void setNoOfFights(Integer noOfFights) {
		this.noOfFights = noOfFights;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * Gets the pokemon.
	 *
	 * @return the pokemon
	 */
	public Pokemon getPokemon() {
		return pokemon;
	}

	/**
	 * Sets the pokemon.
	 *
	 * @param pokemon
	 *            the new pokemon
	 */
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	/**
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead() {
		return score <= 0;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Gets the current level.
	 *
	 * @return the current level
	 */
	public Integer getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Sets the current level.
	 *
	 * @param currentLevel
	 *            the new current level
	 */
	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Gets the current opponent.
	 *
	 * @return the current opponent
	 */
	public Pokemon getCurrentOpponent() {
		return opponents.get(0);
	}

	/**
	 * Gets the opponents.
	 *
	 * @return the opponents
	 */
	public List<Pokemon> getOpponents() {
		return opponents;
	}

	/**
	 * Sets the opponents.
	 *
	 * @param opponents
	 *            the new opponents
	 */
	public void setOpponents(List<Pokemon> opponents) {
		this.opponents = opponents;
	}

}
