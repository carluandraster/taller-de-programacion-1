package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Conversor;

public class TestConversor {

	@Test
	public void testLetraNum() {
		Conversor c = new Conversor();
		try {
			Assert.assertEquals("La conversion no se hizo correctamente", c.letranum("1234.45"), "Mil doscientos treinta y cuatro pesos con 45 centavos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
