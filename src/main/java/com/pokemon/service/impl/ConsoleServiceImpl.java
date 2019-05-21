package com.pokemon.service.impl;

import java.util.Objects;
import java.util.Scanner;

import com.pokemon.service.ConsoleService;

/**
 * Singleton Class ConsoleServiceImpl.
 * 
 * @author Dipali
 * @since 05/17/2019
 */
public class ConsoleServiceImpl implements ConsoleService {

	/** The console service impl. */
	private static ConsoleServiceImpl consoleServiceImpl = null;

	/** The scanner. */
	private final Scanner scanner;

	/**
	 * Instantiates a new console service impl.
	 */
	private ConsoleServiceImpl() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * static method to return the singleton instance of the ConsoleServiceImpl.
	 *
	 * @return ConsoleServiceImpl
	 */
	public static ConsoleServiceImpl getConsoleServiceImpl() {
		if (Objects.isNull(consoleServiceImpl)) {
			synchronized (ConsoleServiceImpl.class) {
				if (Objects.isNull(consoleServiceImpl)) {
					consoleServiceImpl = new ConsoleServiceImpl();
				}
			}
		}

		return consoleServiceImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.ConsoleService#next()
	 */
	@Override
	public String next() {
		return scanner.next();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pokemon.service.ConsoleService#nextLine()
	 */
	@Override
	public String nextLine() {
		return scanner.nextLine();
	}

}
