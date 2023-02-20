package lulasSistemaTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lulaSistema.Comitiva;
import lulaSistema.LULASistema;

class ComitivaTeste {
	
	private LULASistema lulaAux1;
	private Comitiva comitivaAux1;

	@BeforeEach
	void preparaComitiva() {
		this.lulaAux1 = new LULASistema();
		this.comitivaAux1 = new Comitiva(2, "Palestrantes aprovados", 5, 97418562);
		lulaAux1.cadastraComitiva(2, "Palestrantes aprovados", 5, 97418562);
	}

	@Test
	void testComitiva() {
		try {
			lulaAux1.cadastraComitiva(-1, "Congresso", 11, 47816987);
		} catch (IndexOutOfBoundsException ioe) {
			
		}
	}

	@Test
	void testGetIdIdentificador() {
		assertEquals(2, comitivaAux1.getIdIdentificador());
	}

	@Test
	void testToString() {
		String esperado = 
			      "ID: 2\n"
				+ "Comitiva: Palestrantes aprovados\n"
				+ "Integrantes: 5\n"
				+ "Contato: 97418562";
		assertEquals(esperado, lulaAux1.exibeComitiva(2));
	}

}
