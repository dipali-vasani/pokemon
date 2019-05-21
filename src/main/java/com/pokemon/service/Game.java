package com.pokemon.service;

/**
 * Game interface to be implemented for any new Game.
 *
 * @author Dipali
 * @since 05/17/2019
 */
public interface Game {

	/**
	 * Method to display menu on the console.
	 */
	void showMenu();

	/**
	 * Method to create new character.
	 */
	void create();

	/**
	 * Method to explore more about pokemon.
	 */
	void explore();

	/**
	 * Method to fight with rival pokemon.
	 */
	void fight();

	/**
	 * Method to save the state of the Game.
	 */
	void save();

	/**
	 * Quit game.
	 */
	/*
	 * Method to quit the application
	 */
	void quitGame();

}
