package testesControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ControleAlunos.GrupoRepository;
import ControleAlunos.Grupo;
import ControleAlunos.SistemaControleAlunos;

class testGrupoRepository {
	
	private GrupoRepository repositorio;
	private SistemaControleAlunos sistema;
	
	@BeforeEach
	void preparaGrupoRepositorio() {
		this.repositorio = new GrupoRepository();
		this.sistema = new SistemaControleAlunos();
		this.sistema.cadastraAluno("131", "Miguel", "Artes");
		this.sistema.cadastraGrupo("Listas", 10);
		this.sistema.cadastraGrupo("Programação OO", 10);
		this.sistema.adicionaAlunoGrupo("Listas", "131");
		this.sistema.adicionaAlunoGrupo("Programação OO", "131");
	}
	


	@Test
	void testCadastraGrupoComTemaTamanhoNaoCadastrado() {
		assertTrue(this.repositorio.cadastraGrupo("P2", 5));
	}
	
	@Test
	void testCadastraGrupoComTemaTamanhoCadastrado() {
		this.repositorio.cadastraGrupo("P2", 5);
		assertFalse(this.repositorio.cadastraGrupo("P2", 5));

	}

	@Test
	void testCadastraGrupoTemaNaoCadastrado() {
		assertTrue(this.repositorio.cadastraGrupo("P2"));
	}
	
	@Test
	void testCadastraGrupoTemaCadastrado() {
		this.repositorio.cadastraGrupo("P2");
		assertFalse(this.repositorio.cadastraGrupo("P2"));

	}

	@Test
	void testGetGrupo() {
	this.repositorio.cadastraGrupo("P2");
	String esperado = "- P2 0/Tamanho indefinido";
	Grupo grupo = this.repositorio.getGrupo("P2");
	assertEquals(esperado, grupo.toString());
	}
	
	@Test
	void testGetGrupoNull() {
	String esperado = null;
	Grupo grupo = this.repositorio.getGrupo("LP2");
	assertEquals(esperado, grupo);
	}
	
	@Test
	void testImprimeGrupos() {
		String esperado = "Grupos:\n"
		+ "- Programação OO 1/10\n" + 
		  "- Listas 1/10\n";

		assertEquals(esperado, this.sistema.imprimeAlunoGrupos("131"));
	}
	
	@Test
	void testImprimeGrupoSemAlunoCadastradoEmGrupo() {
		String esperado = "Grupos:\n";
		assertEquals(esperado, this.sistema.imprimeAlunoGrupos("141"));
	}
}
