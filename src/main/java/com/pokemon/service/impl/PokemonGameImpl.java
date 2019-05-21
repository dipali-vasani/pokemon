package com.pokemon.service.impl;

import static com.pokemon.util.Constants.LOGGER;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;

import com.pokemon.model.Attack;
import com.pokemon.model.Level;
import com.pokemon.model.Pokemon;
import com.pokemon.model.Trainer;
import com.pokemon.service.ConsoleService;
import com.pokemon.service.Game;
import com.pokemon.util.ApplicationProperties;
import com.pokemon.util.Constants;
import com.pokemon.util.TerminationUtility;

/**
 * The Class PokemonGameImpl.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class PokemonGameImpl implements Game {

	/** The Constant NEW_LINE. */
	private static final String NEW_LINE = "";

	/** The Constant WORD_SEPERATOR. */
	private static final String WORD_SEPERATOR = ">>";

	/** The input service. */
	private final ConsoleService inputService = ConsoleServiceImpl.getConsoleServiceImpl();

	/** The application properties. */
	private ApplicationProperties applicationProperties = ApplicationProperties.getApplicationProperties();

	private SecureRandom rand = new SecureRandom();

	/** The no of opponents. */
	private Integer noOfOpponents = 0;

	/** The trainer. */
	private Trainer trainer;

	/**
	 * Instantiates a new pokemon game impl.
	 *
	 * @param noOfOpponents
	 *            the no of opponents
	 */
	public PokemonGameImpl(Integer noOfOpponents) {
		this.noOfOpponents = noOfOpponents;
	}

	/**
	 * Sets the trainer.
	 *
	 * @param trainer
	 *            the new trainer
	 */
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * Display menu on the console.
	 */
	@Override
	public void showMenu() {
		LOGGER.log(Constants.LINE_SEPERATOR);
		LOGGER.log("Select your action ");
		LOGGER.log("1. Build/Create an Trainer");
		LOGGER.log("2. Explore ");
		LOGGER.log("3. Fight");
		LOGGER.log("4. Save");
		LOGGER.log("5. Quit");
		LOGGER.log(Constants.LINE_SEPERATOR);

		String select = inputService.next();

		switch (select) {
		case "1":
			create();
			showMenu();
			break;
		case "2":
			explore();
			showMenu();
			break;
		case "3":
			fight();
			showMenu();
			break;
		case "4":
			save();
			showMenu();
			break;
		case "5":
			quitGame();
			break;
		default:
			LOGGER.log("OH NO! Your choise is still not implemented... Please try again ");
			showMenu();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.Game#quitGame()
	 */
	@Override
	public void quitGame() {
		LOGGER.log("Press Y to save the current trainer");
		String select = inputService.next();
		if (select.equalsIgnoreCase("Y")) {
			this.trainer.save();
		}
		TerminationUtility.exit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.Game#save()
	 */
	@Override
	public void save() {
		if (Objects.nonNull(this.trainer)) {
			this.trainer.save();
		} else {
			LOGGER.log("Null trainer cant be saved");
		}
	}

	/**
	 * Check trainer created.
	 */
	private void checkTrainerCreated() {
		if (Objects.isNull(trainer)) {
			LOGGER.log("Trainer needs to be created before performing the Action");
			create();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.Game#create()
	 */
	@Override
	public void create() {
		this.trainer = Trainer.setupTrainer();
		LOGGER.log("Your trainer " + this.trainer.getName() + " is ready ");
		if (trainer.getPokemon().getName() == null && trainer.getPokemon().getName().isEmpty()) { // if not saved
			LOGGER.log("Select your Pokemon ");
			List<String> listPokemon = applicationProperties.listPokemon();
			for (int i = 0; i < listPokemon.size(); i++) {
				LOGGER.logAppend(i + WORD_SEPERATOR + listPokemon.get(i) + "  ");
			}
			try {
				Integer input = Integer.parseInt(inputService.next());
				String pokemon = listPokemon.get(input);
				trainer.setCurrentLevel(applicationProperties.listLevels().get(0));
				trainer.getPokemon().setName(pokemon);
				trainer.setOpponents(applicationProperties.listOpponents(pokemon));
				Level level = new Level();
				level.setAttacks(applicationProperties.listAttacksByLevel(trainer.getCurrentLevel(), pokemon));
				trainer.setLevel(level);
			} catch (NumberFormatException e) {
				LOGGER.log("Invalid Attack. Please select again");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.Game#fight()
	 */
	@Override
	public void fight() {
		checkTrainerCreated();
		if (this.trainer.getNoOfFights().equals(this.noOfOpponents)) {
			LOGGER.logInstructions("You have already won over all your opponent pokemons");
			return;
		}
		LOGGER.logInstructions("There will be fight between " + this.trainer.getPokemon().getName() + " and "
				+ this.trainer.getCurrentOpponent().getName());
		selectAndValidateAttacks();
		setExperience();
	}

	/**
	 * Sets the experience.
	 */
	private void setExperience() {
		Pokemon destory = this.trainer.destroyOpponent();
		if (Objects.nonNull(destory)) {
			LOGGER.logInstructions(
					this.trainer.getPokemon().getName() + " just killed opponent pokemon: " + destory.getName());
		}

		Integer currentExp = this.trainer.getNoOfFights();
		this.trainer.setNoOfFights(++currentExp);

		if (currentExp.equals(this.noOfOpponents)) {
			LOGGER.logInstructions(Constants.LINE_SEPERATOR);
			LOGGER.logInstructions("ANNNNNDDDD... The winner is..... " + this.trainer.getPokemon().getName());
			LOGGER.logInstructions(Constants.LINE_SEPERATOR);
			return;
		}

		if (this.trainer.getNoOfFights() == (Constants.FIGHTS_IN_LEVEL * this.trainer.getCurrentLevel())) {
			LOGGER.logInstructions(Constants.LINE_SEPERATOR);
			Integer nextLevel = this.trainer.getCurrentLevel() + 1;
			this.trainer.advanceToNextLevel();
			LOGGER.logInstructions("Congratulations! You are promoted to Level " + nextLevel);
		}
	}

	/**
	 * Calculate points.
	 *
	 * @param index
	 *            the index
	 */
	private void calculatePoints(Integer index) {
		// Using Random value to calculate attack of computer
		String currentOpponent = this.trainer.getCurrentOpponent().getName();
		String pokemon = this.trainer.getPokemon().getName();
		List<Attack> opponentattacks = applicationProperties.listAttacksByLevel(this.trainer.getCurrentLevel(),
				currentOpponent);
		Integer listedattacksize = opponentattacks.size();
		Integer opponentAttackIndex = rand.nextInt(listedattacksize);
		Integer attackscore = 0;
		try {
			attackscore = this.trainer.getLevel().getAttackPointsByIndex(index)
					- opponentattacks.get(opponentAttackIndex).getPoints();
			this.trainer.setScore(this.trainer.getScore() + attackscore);
		} catch (Exception e) {
			TerminationUtility.exitWithErrorLog(
					"Invalid stage" + this.trainer.getCurrentLevel() + "selected while fetching score");
		}

		String currentOpponentAttack = currentOpponent + "'s " + opponentattacks.get(opponentAttackIndex).getName();

		if (this.trainer.isDead()) {
			LOGGER.log(Constants.LINE_SEPERATOR);
			TerminationUtility.exitWithErrorLog("GAME OVER");
		}
		if (attackscore < 0) {
			LOGGER.log("Oh no! " + pokemon + " lost " + attackscore + " points due to " + currentOpponentAttack + ".");
		} else {
			if (attackscore == 0) {
				LOGGER.log("Awww " + currentOpponentAttack + " beaten" + pokemon + " 0 score for this attack. ");
			} else {
				LOGGER.log("Yay it's a piece of cake for " + pokemon + ", it won " + attackscore + " points over "
						+ currentOpponentAttack + ".");
			}
		}
		LOGGER.log("Total Points remain : " + this.trainer.getScore());
		// A function to add bounties for various points can be written
	}

	/**
	 * Select and validate attacks.
	 */
	private void selectAndValidateAttacks() {
		Trainer currentTrainer = this.trainer;

		List<Attack> attacks = currentTrainer.getLevel().getAttacks();

		LOGGER.logInstructions("You can choose " + Constants.ATTACKS_IN_FIGHT + " attacks");
		LOGGER.logInstructions("Enter number associated with the attack to proceed");

		int index = 0;
		for (int i = 0; i < attacks.size(); i++) {
			LOGGER.logAppend(index++ + WORD_SEPERATOR + attacks.get(i).getName() + "  ");
		}

		LOGGER.log(NEW_LINE);

		int attacksSelected = 0;

		while (attacksSelected < Constants.ATTACKS_IN_FIGHT) {
			LOGGER.logInstructions("Please select your next attack");
			String input = inputService.next();
			Integer currentAttack = 0;
			Integer allowedattacks = this.trainer.getLevel().getAttacks().size();

			try {
				currentAttack = Integer.parseInt(input);
				if (currentAttack >= 0 && currentAttack < allowedattacks) {
					calculatePoints(currentAttack);
					attacksSelected++;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				LOGGER.logError("uh-oh that is not the attack from the list. Please try again");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.Game#explore()
	 */
	@Override
	public void explore() {
		checkTrainerCreated();
		LOGGER.logInstructions("-------Trainer Profile-------");
		LOGGER.logInstructions("Name: " + this.trainer.getName());
		LOGGER.logInstructions("Pokemon: " + this.trainer.getPokemon().getName());
		LOGGER.logInstructions("Level: " + this.trainer.getCurrentLevel());
		LOGGER.logInstructions("No of Fights: " + this.trainer.getNoOfFights());
		LOGGER.logInstructions(Constants.LINE_SEPERATOR);

		if (this.trainer.getNoOfFights().equals(this.noOfOpponents)) {
			LOGGER.logInstructions("You have already won over all your opponent pokemons");
			showMenu();
			return;
		}

		LOGGER.logInstructions("Your Pokemon's attacks : ");
		this.trainer.getLevel().getAttacks()
				.forEach(attack -> LOGGER.logAppend(WORD_SEPERATOR + attack.getName() + "  "));
		LOGGER.logInstructions(NEW_LINE);
		LOGGER.logInstructions("Your opponents are : ");
		this.trainer.getOpponents().forEach(e -> LOGGER.logAppend(WORD_SEPERATOR + e.getName() + "  "));
		LOGGER.logInstructions(NEW_LINE);
	}
}
