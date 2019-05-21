package com.pokemon.model;

import java.io.Serializable;

/**
 * The Class Pokemon.
 * 
 * @author dipali
 * @since 05/17/2019
 */
public class Pokemon implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3341996802819054255L;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new pokemon.
	 */
	public Pokemon() {

	}

	/**
	 * Instantiates a new pokemon.
	 *
	 * @param name
	 *            the name
	 */
	public Pokemon(String name) {
		super();
		this.name = name;
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
}
