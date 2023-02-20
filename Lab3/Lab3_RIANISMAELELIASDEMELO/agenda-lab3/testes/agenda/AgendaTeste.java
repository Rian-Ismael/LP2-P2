package agenda;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import agenda.Contato;
import agenda.Agenda;

class AgendaTeste {
	
	private Agenda agenda = new Agenda();
	private Agenda agenda1;
	private Agenda agenda2;
	private Agenda agenda3;
	private Agenda agenda4;
	private Agenda agenda5;
	
	
	@BeforeEach 
	void PreparaAgenda() {
	     this.agenda.cadastraContato(2, "Mateus", "Pedro", "78945-7845");
	     this.agenda.cadastraContato(1, "Jose", "Riem", "84265-8428");
	     this.agenda.cadastraContato(6, "Livia", "Lidil", "78466-4157");
	 
	}
	
	@BeforeEach
	public void initAgendas() {
	     this.agenda1 = new Agenda();
	     this.agenda2 = new Agenda();
	     this.agenda3 = new Agenda();
	     this.agenda4 = new Agenda();
	     this.agenda5 = new Agenda();
	     agenda1.cadastraContato(1, "Silva", "Ricardo", "19818-4785");
	     agenda2.cadastraContato(1, "Ismael", "Melo", "11788-8181");
	     agenda2.cadastraContato(2, "Ismael", "Elias", "91181-1818");
	     agenda2.cadastraContato(3, "Lili", "Vidal", "75428-8746");
	     agenda3.cadastraContato(1, "Junior", "Pereira", "15151-4646");
	     agenda3.cadastraContato(2, "Lopes", "Ferreiro", "78945-6123");
	     agenda3.cadastraContato(3, "Torres", "Remos", "74125-3698");
	     agenda4.cadastraContato(1, "Tirulipa", "Tiririca", "18184-7845");
	     agenda4.cadastraContato(2, "Lipa", "Tirica", "87484-7825");
	     agenda4.cadastraContato(3, "Kiu", "Lea", "88795-1478");
	     agenda5.cadastraContato(1, "picapau", "pereira", "83395-1478");
	     agenda5.cadastraContato(2, "caverna", "Dragao", "83195-1478");
	}

	
	@Test
	void testNomeJaCadastrado() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Yeepp", "Uhull", "78941-2548");
		try {
			agenda.cadastraContato(1, "Yeepp", "Uhull", "78941-2548");
			fail("Não deveria ter cadastrado");
		} catch(IllegalArgumentException iae) {
		}
	}
	
	@Test
	void testNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> agenda1.cadastraContato(1, "", "Ismael", "991776351"));
	}
	
	@Test
	void testLimiteInferior() {
		try {
			agenda1.cadastraContato(-1, "Rian", "Ismael", "991776351");
			fail("Deveria ter lançado IndexOutOf");
			} catch (IndexOutOfBoundsException ioe) {
				
		}
	}
	
	
	@Test
	void testLimiteSuperior() {
		
		try {
			agenda1.cadastraContato(101, "Rian", "Ismael", "991776351");
			fail("");
		} catch (IndexOutOfBoundsException ioe) {
			
		}
	}
	
	@Test
	void testTelefoneVazio() {
		try {
			agenda1.cadastraContato(1, "Rian", "Ismael", "");
			fail("Deve lançar IllegalArgument"); 
		} catch(IllegalArgumentException iae) {
		}			
	}

	@Test
	void testExibeContato() {
		String esperado = "Ismael Elias\n" + "91181-1818";
		assertEquals(esperado, agenda2.exibeContato(2));
	}
	
	@Test
	void testExibeContatoFavorito() {
		String esperado = "❤️ Ismael Melo\n" + "11788-8181";
		agenda2.adicionaFavorito(1, 1);
		assertEquals(esperado, agenda2.exibeContato(1));
	}

	@Test
	void testVerificaExistenciaFalse() {
		assertFalse(agenda1.verificaExistencia(3));
	}
	
	@Test
	void testVerificaExistenciaTrue() {
		assertTrue(agenda2.verificaExistencia(2));
	}

	@Test
	void testListaContatoUmContato() {
		String esperado = "\n1 - Silva Ricardo\n";
		assertEquals(esperado, agenda1.listaContato());
	}
	
	@Test
	void testListaContatoTresContatos() {
		String esperado = "\n1 - Ismael Melo\n" + "2 - Ismael Elias\n" + "3 - Lili Vidal\n";
		assertEquals(esperado, agenda2.listaContato());
		}


	@Test
	void testListaFavoritos() {
		agenda3.adicionaFavorito(1, 1);
		agenda3.adicionaFavorito(2, 3);
		String esperado = "\n1 - Junior Pereira\n" + "3 - Lopes Ferreiro\n";
		assertEquals(esperado, agenda3.listaFavoritos());
	}

	@Test
	void testAdicionaFavorito() {
		agenda2.adicionaFavorito(1, 1);
		String esperado = "\n1 - Ismael Melo\n";
		assertEquals(esperado, agenda2.listaFavoritos());
	}
	
	@Test
	void testFavoritoRemocao() {
		agenda.adicionaFavorito(2, 3);
		// remocao de um contato favorito.
		String expectativa = "❤️ Mateus Pedro\n" + "78945-7845";
		assertEquals(expectativa, agenda.exibeContato(2));
		
		agenda.removeFavorito(3);
		
		expectativa = "Mateus Pedro\n" + "78945-7845";
		assertEquals(expectativa, agenda.exibeContato(2));
		
		// posicao invalida superior
		try {
			agenda.removeFavorito(11);
			fail("Deve lançar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe) {
				
		}
		
		// posicao invalida inferior.
		
		try {
			agenda.removeFavorito(-1);
			fail("Deveria lancar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe){
		}
		}		
		// remocao de um favorito em uma posicao sem contato favoritado.
	
	@Test
	void ContatoNaoExistente() {
		try {
			agenda4.removeFavorito(10);
			fail("Deveria lancar IllegalArgumentException");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void adicionaFavoritoPosicaoFavoritoLimiteInferior() {
		try {
			agenda5.adicionaFavorito(1, -1);
			fail("Deveria lancar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe) {
		}
	}
	
	@Test
	void adicionaFavoritoPosicaoFavoritoLimiteSuperior() {
		try {
			agenda5.adicionaFavorito(2, 11);
			fail("Deveria lancar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe) {
		}
	}
	
	@Test
	void adicionaFavoritoPosicaoContatoLimiteInferior() {
		try {
			agenda5.adicionaFavorito(-1, 10);
			fail("Deveria lancar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe) {
		}
	}
	
	@Test
	void adicionaFavoritoPosicaoContatoLimiteSuperior() {
		try {
			agenda5.adicionaFavorito(101, 10);
			fail("Deveria lancar IndexOutOf");
		} catch (IndexOutOfBoundsException ioe) {
		}
	}
	
	@Test
	void adicionaFavoritoPosicaoContatoNull() {
		try {
			agenda5.adicionaFavorito(10, 10);
			fail("Deveria lancar NullPointerException");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void adicionaContatoPosicaoContatoNull() {
		try {
			agenda5.adicionaFavorito(5, 10);
			fail("Deveria lancar NullPointerException");
		} catch (NullPointerException npe) {
		}
	}
	
	
	@Test
	void testPosicaoInvalidaFavorito() {
		try { 
			agenda5.adicionaFavorito(-1, 1);
			fail("Deveria ter lançado IllegalArgumentsException");
		} catch(IndexOutOfBoundsException ioe) {
		}
		
	}
	}
