package test;

import org.junit.Test;

import modelo.Conversor;

public class TestConversor {

	@Test
	public void testLetraNum() {
		Conversor c = new Conversor();
		try {
			c.letranum("1234.45");
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}
}
