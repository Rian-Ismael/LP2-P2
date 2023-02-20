package lulasSistemaTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lulaSistema.LULASistema;
import lulaSistema.Local;

class RegistraTeste {
	
	
	private Local local1;
	@BeforeEach
	void preparaLocal() {
		this.local1 = new Local("MA", "Mdrid", "4781");
	}
	
	@Test
	void testToString() {
	}

	@Test
	void testAdicionaVisita() {
		fail("Not yet implemented");
	}

	@Test
	void testQtPessoasTotal() {
		fail("Not yet implemented");
	}

	@Test
	void testListaVisita() {
		fail("Not yet implemented");
	}

}
