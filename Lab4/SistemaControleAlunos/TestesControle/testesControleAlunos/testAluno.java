package testesControleAlunos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;

class testAluno {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	
	@BeforeEach
	void preparaAlunos() {
		this.aluno1 = new Aluno("121", "Sandra", "Enfermagem");
		this.aluno2 = new Aluno("131", "Miguel", "Artes");
		this.aluno3 = new Aluno("141", "Davi", "Pedagogia");
		this.aluno4 = new Aluno("121", "MiguelFake", "Artes");
	}
	
	@Test
	void testMatriculaVazio() {
		String esperado = "matrícula vazia";
		try {
			new Aluno("", "Miguel", "Artes");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testMatriculaNula() {
		String esperado = "matrícula nula";
		try {
			new Aluno(null, "Miguel", "Artes");
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testNomeVazio() {
		String esperado = "nome vazio";
		try {
			new Aluno("121", "", "Enfermagem");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testNomeNula() {
		String esperado = "nome nulo";
		try {
			new Aluno("121", null, "Artes");
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCursoVazio() {
		String esperado = "curso vazio";
		try {
			new Aluno("121", "Sandra", "");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testCursoNula() {
		String esperado = "curso nulo";
		try {
			new Aluno("121", "Sandra", null);
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}


	@Test
	void testToString() {
		assertEquals("Aluno: 131 - Miguel - Artes", aluno2.toString());
	}

	@Test
	void testEqualsTrue() {
		assertTrue(this.aluno1.equals(this.aluno4));
	}
	
	@Test
	void testEqualsFalse() {
		assertFalse(this.aluno1.equals(this.aluno3));
	}
	
	@Test
	void testGetMatricula() {
		assertEquals("141", this.aluno3.getMatricula());
	}
}
