package testesControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ControleAlunos.Aluno;
import ControleAlunos.Grupo;
class testGrupo {

	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;
	private Grupo grupo4;
	private Aluno aluno1;
	private Aluno aluno2;

	
	@BeforeEach
	void preparaGruposAluno() {
		this.grupo1 = new Grupo("Listas", 10);
		this.grupo2 = new Grupo("Programação", 2);
		this.grupo3 = new Grupo("LP2");
		this.grupo4 = new Grupo("LP2", 10);
		this.aluno1 = new Aluno("131", "Miguel", "Artes");
		this.aluno2 = new Aluno("141", "Davi", "Pedagogia");
	}
	
	@Test
	void testGrupoSemRestricaoTemaVazio() {
		String esperado = "tema vazio";
		try {
			new Grupo("");
		} catch (IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testGrupoSemRestricaoTemaNull() {
		String esperado = "tema nulo";
		try {
			new Grupo(null);
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testGrupoComRestricaoTemaVazio() {
		String esperado = "tema vazio";
		try {
			new Grupo("", 5);
		} catch (IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testGrupocomRestricaoTemaNulo() {
		String esperado = "tema nulo";
		try {
			new Grupo(null, 5);
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testGrupoComRestricaoValidacaoDeTamanho() {
		String esperado = "tamanho inválido";
		try {
			new Grupo("P2", -1);
		} catch(IndexOutOfBoundsException iobe) {
			assertEquals(esperado, iobe.getMessage());
		}
	}
	
	@Test
	void testToStringComGrupoRestrito() {
		String esperado = "- Listas 1/10";
		this.grupo1.adicionaAlunoGrupo(this.aluno1);
		assertEquals(esperado, grupo1.toString());
	}
	
	@Test
	void testToStringComGrupoSemRestricao() {
		String esperado = "- LP2 1/Tamanho indefinido";
		this.grupo3.adicionaAlunoGrupo(this.aluno2);
		assertEquals(esperado, grupo3.toString());
	}
	
	@Test
	void testLimiteGrupoComRestricao() {
		Grupo grupoAux = new Grupo("IC", 1);
		grupoAux.adicionaAlunoGrupo(aluno1);
		assertFalse(grupoAux.adicionaAlunoGrupo(aluno2));
	}
	
	@Test
	void testGetTema() {
		assertEquals("LP2", grupo3.getTema());
	}
	
	@Test
	void testGetControleTamanho() {
		Grupo grupoAux = new Grupo("IC", 3);
		grupoAux.adicionaAlunoGrupo(aluno1);
		grupoAux.adicionaAlunoGrupo(aluno2);
		assertEquals(2, grupoAux.getcontroleTamanho());
	}
	
	@Test
	void testGetTamanhoCriado() {
		Grupo grupoAux = new Grupo("IC", 10);
		assertEquals(10, grupoAux.getTamanho());
	}
	
	@Test
	void testChecaAlunoEmGrupo() {
		Grupo grupoAux = new Grupo("IC", 10);
		grupoAux.adicionaAlunoGrupo(aluno1);
		assertTrue(grupoAux.checaAlunoGrupo(aluno1));
		assertFalse(grupoAux.checaAlunoGrupo(aluno2));
	}
	
	@Test
	void testEqualsTrue() {
		assertTrue(this.grupo3.equals(this.grupo4));
	}
	
	@Test
	void testequalsFalse() {
		assertFalse(this.grupo2.equals(grupo1));
	}
}
