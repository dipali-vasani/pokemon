package com.pokemon.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class <code>TerminationUtilityTest</code> contains tests for the class
 * <code>{@link TerminationUtility}</code>.
 *
 * @author dvasani
 * @version $Revision: 1.0 $
 */
@RunWith(MockitoJUnitRunner.class)
public class TerminationUtilityTest {

	private SecurityManager securityManager;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		securityManager = System.getSecurityManager();
		System.setSecurityManager(new NoExitSecurityManager());
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() {
		System.setOut(System.out);
		System.setErr(System.err);
		System.setSecurityManager(securityManager);
	}

	@Test
	public void testExit_1() throws Exception {
		try {
			TerminationUtility.exit();
		} catch (ExitException ignored) {
		}

	}

	@Test
	public void testExitWithErrorLog_1() throws Exception {
		try {
			String log = "";
			TerminationUtility.exitWithErrorLog(log);
		} catch (ExitException ignored) {
		}

	}

	@Test
	public void testRun_1() throws Exception {
		TerminationUtility fixture = new TerminationUtility();
		fixture.run();

	}

	protected static class ExitException extends SecurityException {
		private static final long serialVersionUID = -1982617086752946683L;
		public final int status;

		public ExitException(int status) {
			super("Can not terminate on test");
			this.status = status;
		}
	}

	private static class NoExitSecurityManager extends SecurityManager {
		@Override
		public void checkPermission(Permission perm) {
			// allow anything.
		}

		@Override
		public void checkPermission(Permission perm, Object context) {
			// allow anything.
		}

		@Override
		public void checkExit(int status) {
			super.checkExit(status);
			throw new ExitException(status);
		}
	}

}