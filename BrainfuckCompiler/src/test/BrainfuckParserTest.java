package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BrainfuckParser;


public class BrainfuckParserTest {

	@Test
	public void testCorrect() {
		assertTrue(new BrainfuckParser("+-fdsf[]").check());
		assertTrue(new BrainfuckParser("fhsduf[gfghf[hgfh]]fds").check());
		assertTrue(new BrainfuckParser("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.+++.").check());
	}
	
	@Test
	public void testIncorrect() {
		assertFalse(new BrainfuckParser("+-fdsf[").check());
		assertFalse(new BrainfuckParser("]").check());
		assertFalse(new BrainfuckParser("jdfis]fsdf[fdsf").check());
	}

}
