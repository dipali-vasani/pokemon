package com.pokemon.model;

import java.io.Serializable;

/**
 * Model for Attacks for the Pokemon.
 *
 * @author dipali
 * @since 05/17/2019
 */
public class Attack implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3831428219227863505L;

	/** The name. */
	private String name;

	/** The points. */
	private Integer points;

	/**
	 * Instantiates a new attacks.
	 *
	 * @param name
	 *            the name
	 * @param points
	 *            the points
	 */
	public Attack(String name, Integer points) {
		super();
		this.name = name;
		this.points = points;
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
	 * Gets the points.
	 *
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points
	 *            the new points
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attacks [name=" + name + ", points=" + points + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Attack other = (Attack) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points)) {
			return false;
		}
		return true;
	}
}
