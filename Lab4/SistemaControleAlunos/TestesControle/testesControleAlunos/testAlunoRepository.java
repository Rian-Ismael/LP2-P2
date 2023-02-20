package testesControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import ControleAlunos.AlunosRepository;
class testAlunoRepository {
	
	private AlunosRepository repositorio1;
	
	@BeforeEach
	void preparaAlunoRepositorio() {
		this.repositorio1 = new AlunosRepository();
		this.repositorio1.cadastraAluno("121", "Sandra", "Enfermagem");
		this.repositorio1.cadastraAluno("131", "Miguel", "Artes");
		this.repositorio1.cadastraAluno("141", "Davi", "Pedagogia");
		this.repositorio1.cadastraAluno("121", "MiguelFake", "Artes");
	}
	
	@Test
	void testConsultarAlunoExiste() {
		assertTrue(this.repositorio1.consultaAlunos("121"));
	}
	
	@Test
	void testConsultarAlunoNaoExistee() {
		assertFalse(this.repositorio1.consultaAlunos("122"));

	}

	@Test
	void testCadastraAlunoMatriculaNaoRepetida() {
		assertTrue(this.repositorio1.cadastraAluno("111", "SrCadastrado", "Cadastrando"));
	}
	
	@Test
	void testCadastraAlunoMatriculaRepetida() {
		this.repositorio1.cadastraAluno("111", "SrCadastrado", "Cadastrando");
		assertFalse(this.repositorio1.cadastraAluno("111", "SrCadastrado", "Cadastrando"));

	}

	@Test
	void testGetAluno() {
		String esperada = "Aluno: 131 - Miguel - Artes";
		assertEquals(esperada, this.repositorio1.getAluno("131").toString());
	}
	
	@Test
	void testGetAlunoNull() {
		String esperada = null;
		assertEquals(esperada, this.repositorio1.getAluno("454"));
	}

}
