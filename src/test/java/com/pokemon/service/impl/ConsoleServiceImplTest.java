package com.pokemon.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>ConsoleServiceImplTest</code> contains tests for the class
 * <code>{@link ConsoleServiceImpl}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsoleServiceImplTest {

	@Test
	public void testGetConsoleServiceImpl_1() throws Exception {
		ConsoleServiceImpl consoleServiceImpl = ConsoleServiceImpl.getConsoleServiceImpl();
		ConsoleServiceImpl consoleServiceImpl_new = ConsoleServiceImpl.getConsoleServiceImpl();
		ConsoleServiceImpl consoleServiceImpl_two = ConsoleServiceImpl.getConsoleServiceImpl();
		assertEquals(consoleServiceImpl_new, consoleServiceImpl);
		assertEquals(consoleServiceImpl_new, consoleServiceImpl_two);
	}
}