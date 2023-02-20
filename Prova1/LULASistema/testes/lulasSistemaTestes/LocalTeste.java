package lulasSistemaTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lulaSistema.Local;
import lulaSistema.LULASistema;

class LocalTeste {
	Local local1;
	LULASistema lulaAux1;
	
	@BeforeEach
	void preparaLocal() {
		this.local1 = new Local("MA", "Mdrid", "4781");
		this.lulaAux1 = new LULASistema();
	}


	@Test
	void testEqualsObject() {
		Local localAux1 = new Local("GR", "Granada", "7894");
		Local localAux2 = new Local("ML", "Malaga", "4825");
		Local localAux3 = new Local("GR", "Alhambra", "8494");
		assertTrue(localAux1.equals(localAux3));
		assertFalse(localAux2.equals(localAux3));
	}

	@Test
	void testToString() {
		String esperado = "MA - Mdrid - 4781";
		lulaAux1.cadastraLocal("MA", "Mdrid", "4781");
		assertEquals(esperado, lulaAux1.exibeLocal("MA"));
	}

	@Test
	void testGetIdTextual() {
		assertEquals("MA", local1.getIdTextual());
	}

}
