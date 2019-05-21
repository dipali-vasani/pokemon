package com.pokemon.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>ObjectUtilsTest</code> contains tests for the class
 * <code>{@link ObjectUtils}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class ObjectUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateName_1() throws Exception {
		String name = "";

		boolean result = ObjectUtils.validateName(name);

		assertEquals(true, result);
	}

	@Test
	public void testValidateObject_1() throws Exception {
		Object object = new Object();

		boolean result = ObjectUtils.validateObject(object);

		assertEquals(true, result);
	}

	@Test
	public void testValidateString_1() throws Exception {
		String name = "";

		boolean result = ObjectUtils.validateString(name);

		assertEquals(false, result);
	}

	@Test
	public void testValidateString_2() throws Exception {
		String name = "hello";

		boolean result = ObjectUtils.validateString(name);

		assertEquals(true, result);
	}

}