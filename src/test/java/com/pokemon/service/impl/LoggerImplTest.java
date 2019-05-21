package com.pokemon.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>LoggerImplTest</code> contains tests for the class
 * <code>{@link LoggerImpl}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class LoggerImplTest {

	@Test
	public void testGetLoggerImpl_1() throws Exception {
		LoggerImpl loggerImpl = LoggerImpl.getLoggerImpl();
		LoggerImpl loggerImpl_new = LoggerImpl.getLoggerImpl();
		LoggerImpl loggerImpl_two = LoggerImpl.getLoggerImpl();
		assertEquals(loggerImpl_new, loggerImpl);
		assertEquals(loggerImpl_new, loggerImpl_two);
	}

}