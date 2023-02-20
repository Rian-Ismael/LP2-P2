package agenda;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import agenda.Contato;
import agenda.Agenda; 

class ContatoTest {
	private Agenda agenda = new Agenda();
	private Contato contatoAux1;
	private Contato contatoAux2;
	private Contato contatoAux3;
	
	@BeforeEach 
	void PreparaAgenda() {
	     this.agenda.cadastraContato(2, "Mateus", "Pedro", "78945-7845");
	     this.agenda.cadastraContato(1, "Jose", "Riem", "84265-8428");
	     this.agenda.cadastraContato(6, "Livia", "Lidil", "78466-4157");
	 
	}
	
	@BeforeEach 
	void initContato() {
	     this.contatoAux1 = new Contato("Ismael", "Melo", "11788-8181");
	     this.contatoAux2 = new Contato("Ismael", "Elias", "91181-1818");
	     this.contatoAux3 = new Contato("Ismael", "Elias", "91181-1818");
	}
	
	
	@Test
	void testCadastroContatoDois() {
		agenda.cadastraContato(4, "Pedro", "Riem", "84265-8428");
		try {
			agenda.cadastraContato(4, "Pedro", "Riem", "84265-8428");
			fail("Não deveria cadastrar");
		} catch (IllegalArgumentException iae) {
		}
}
	@Test
	void testCadastraContatoTres() {
		String esperado = "CONTATO CADASTRADO";
		assertEquals(esperado, agenda.cadastraContato(8, "Sabrina", "Pereira", "18187-9481"));
	}


	@Test
	void testFavoritar() {
		Contato contatoUm = new Contato("Elias", "Ismael", "991776351");
		contatoUm.desfavoritar();
		assertFalse(contatoUm.getFavorito());
	}

	@Test
	void testDesfavoritar() {
		Contato contatoUm = new Contato("Elias", "Ismael", "991776351");
		contatoUm.favoritar();
		assertTrue(contatoUm.getFavorito());	
		}

	@Test
	void testEqualsObject() {
		assertTrue(this.contatoAux2.equals(this.contatoAux3));
	}
	
	@Test
	void testEqualsObjectFalse() {
		assertFalse(this.contatoAux1.equals(this.contatoAux2));
	}
	
	@Test
	void testToString() {
		String esperado = "Ismael" + " " + "Melo\n" + "11788-8181";
		assertEquals(esperado, contatoAux1.toString());
	}

	@Test
	void testGetNome() {
		assertEquals("Ismael", contatoAux1.getNome());
	}
	
	@Test
	void testExibeContatoFavorito() {
		agenda.adicionaFavorito(2, 3);
		String esperado = "❤️ Mateus Pedro\n" + "78945-7845";
		assertEquals(esperado, agenda.exibeContato(2));
	}

	@Test
	void testGetFavorito() {
		Contato contatoUm = new Contato("Elias", "Ismael", "991776351");
		assertFalse(contatoUm.getFavorito());
	}

	@Test
	void testGetSobrenome() {
		assertEquals("Melo", contatoAux1.getSobrenome());
	}
	
}

