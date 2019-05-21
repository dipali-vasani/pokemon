package com.pokemon.model;

import java.io.Serializable;
import java.util.List;

/**
 * Model for Level of the Game.
 *
 * @author dipali
 * @since 05/17/2019
 */
public class Level implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8062711046269988405L;
	
	/** The attacks. */
	private List<Attack> attacks;
	
	/** The number. */
	private int number;

	/**
	 * Gets the attacks.
	 *
	 * @return the attacks
	 */
	public List<Attack> getAttacks() {
		return attacks;
	}

	/**
	 * Sets the attacks.
	 *
	 * @param attacks the new attacks
	 */
	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	/**
	 * Gets the attack points by index.
	 *
	 * @param index the index
	 * @return the attack points by index
	 */
	public Integer getAttackPointsByIndex(int index) {
		return this.attacks.get(index).getPoints();
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

}