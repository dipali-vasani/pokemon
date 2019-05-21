package com.pokemon.util;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ObjectUtils.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class ObjectUtils {

	/**
	 * Instantiates a new object utils.
	 */
	private ObjectUtils() {

	}

	/**
	 * Validate string.
	 *
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	static boolean validateString(String name) {
		return !(Objects.isNull(name) || name.isEmpty());
	}

	/**
	 * Validate object.
	 *
	 * @param object
	 *            the object
	 * @return true, if successful
	 */
	public static boolean validateObject(Object object) {
		return !Objects.isNull(object);
	}

	/**
	 * Validate name.
	 *
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	public static boolean validateName(String name) {
		String regx = "^[a-zA-Z\\s]*$";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}
}
