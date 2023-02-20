package testesControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ControleAlunos.SistemaControleAlunos;

import org.junit.jupiter.api.Test;

class testSistema {
	
	private SistemaControleAlunos sistema = new SistemaControleAlunos();
	private SistemaControleAlunos sistemaAux = new SistemaControleAlunos();
	
	@BeforeEach
	void preparaSistema() { 
		this.sistema.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.sistema.cadastraAluno("200", "Lili Camposh", "Computação");
		this.sistema.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.sistema.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
	}
	
	@Test
	void testSistemaControleAlunos() {
		SistemaControleAlunos sistemaAux = new SistemaControleAlunos();
		sistemaAux.cadastraAluno("000", "Aluno aux", "Auxiliador");

	}
	
	@Test
	void testCadastraGrupoSemRestricao() {
		String esperado = "CADASTRO REALIZADO"; 
		assertEquals(esperado, this.sistema.cadastraGrupo("Programação OO"));
	}
	
	@Test
	void testCadastraGrupoComRestricao() {
		String esperado = "CADASTRO REALIZADO";  
		assertEquals(esperado, this.sistema.cadastraGrupo("Listas", 10));
	}
	
	@Test //////////////////////////
	void testCadastraGrupoComNomeExistente() {
		String esperado = "GRUPO JÁ CADASTRADO";
		this.sistema.cadastraGrupo("Listas", 10);
		assertEquals(esperado, this.sistema.cadastraGrupo("Listas"));
	}
	
	@Test
	void testCadastraGrupoComNomeExistenteComRestricao() {
		this.sistema.cadastraGrupo("Listas", 10);
		String esperado = "GRUPO JÁ CADASTRADO";
		assertEquals(esperado, this.sistema.cadastraGrupo("Listas", 10));
	}

	
	@Test
	void testAlocarAlunoAGrupo() {
		this.sistema.cadastraGrupo("Programação OO");
		String esperado = "ALUNO ALOCADO";
		assertEquals(esperado, this.sistema.adicionaAlunoGrupo("Programação OO", "200"));
		assertEquals(esperado, this.sistema.adicionaAlunoGrupo("Programação OO", "202"));
		}
	
	@Test
	void testAlunoJaAlocadoEmGrupo() {
		this.sistema.cadastraGrupo("Programação OO");
		String esperado = "ALUNO ALOCADO";
		this.sistema.adicionaAlunoGrupo("Programação OO", "202");
		this.sistema.adicionaAlunoGrupo("Programação OO", "200");
		assertEquals(esperado, this.sistema.adicionaAlunoGrupo("Programação OO", "200"));
	}
	
	@Test
	void testAlocarAlunoNaoExistente() {
		this.sistema.cadastraGrupo("Programação OO");
		String esperado = "ALUNO NÃO CADASTRADO";
		assertEquals(esperado, this.sistema.adicionaAlunoGrupo("Programação OO", "100"));
	}
	
	@Test
	void testAlocarAlunoRestricaoDeUmaPessoa() {
		this.sistema.cadastraGrupo("Listas", 1);
		String esperado1 = "ALUNO ALOCADO";
		assertEquals(esperado1, this.sistema.adicionaAlunoGrupo("Listas", "250"));
		
		String esperado2 = "GRUPO CHEIO!";
		assertEquals(esperado2, this.sistema.adicionaAlunoGrupo("Listas", "202"));
	}
	
	@Test
	void testPertinenciaEmGrupo() {
		this.sistema.cadastraGrupo("Listas");
		this.sistema.adicionaAlunoGrupo("Listas", "250");
		String esperado1 = "ALUNO PERTENCE AO GRUPO";
		assertEquals(esperado1, this.sistema.alunoFazParteGrupo("Listas", "250"));
		
		String esperado2 = "ALUNO NÃO PERTENCE AO GRUPO";
		assertEquals(esperado2, this.sistema.alunoFazParteGrupo("Listas", "100"));
	}
	
	@Test /////////
	void testAlocarAlunoEmGrupoNaoCadastrado() {
		String esperado = "GRUPO NÃO CADASTRADO";
		assertEquals(esperado, this.sistema.adicionaAlunoGrupo("Anatomia", "200"));
	}
	 
	@Test
	void testVerificaAlunoEmGrupoNaoExistente() {
		this.sistema.alunoFazParteGrupo("Anatomia", "200");
	}
	
	@Test
	void testPertinenciaEmGrupoNaoCadastrado() {
		this.sistema.cadastraGrupo("Programação OO");
		String esperado = "ALUNO NÃO PERTENCE AO GRUPO";
		assertEquals(esperado, this.sistema.alunoFazParteGrupo("Programação OO", "100"));
	}
	
	@Test
	void testExibirGruposDeAlunoSemGrupos() {
		String esperado = "Grupos:\n";
		assertEquals(esperado, this.sistema.imprimeAlunoGrupos("202"));
	}
	
	
	@Test
	void imprimeAlunoGrupos() {
		String esperado = "Grupos:\n"
		+ "- Programação OO 1/10\n" + 
		  "- Listas 1/10\n";
		
		this.sistema.cadastraGrupo("Listas", 10);
		this.sistema.cadastraGrupo("Programação OO", 10);
		
		this.sistema.adicionaAlunoGrupo("Listas", "250");
		this.sistema.adicionaAlunoGrupo("Programação OO", "250");
		assertEquals(esperado, this.sistema.imprimeAlunoGrupos("250"));
	} 
	
	
	@Test
	void testConsultaAluno() {
		String esperado = "Aluno: 250 - Gabriel Reyes - Computação";
		assertEquals(esperado, this.sistema.consultaAluno("250"));
	}
	
	@Test
	void testConsultaAlunoNaoCadastrado() {
		String esperado = "ALUNO NÃO CADASTRADO";
		assertEquals(esperado, this.sistema.consultaAluno("100"));
	}
	
	
	@Test 
	void cadastraAlunoComMatriculaJaCadastrada() {
		this.sistema.cadastraAluno("202", "Angela Ziegler", "Medicina");
		String esperado = "MATRÍCULA JÁ CADASTRADA!";
		assertEquals(esperado, this.sistema.cadastraAluno("202", "Angela Ziegler", "Medicina"));
	}
	
	@Test
	void cadastraAlunoComMatriculaVazia() {
		String esperado = "matrícula vazia";
		
		try {
		this.sistema.cadastraAluno("", "Angela Ziegler", "Medicina");
		
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());		
		}
	}
	
	@Test
	void cadastraAlunoComNomeVazio() {
		String esperado = "nome vazio";
		
		try {
		this.sistema.cadastraAluno("202", "", "Medicina");
		
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());		
		}
	}
	
	@Test
	void cadastraAlunoComCursoVazio() {
		String esperado = "curso vazio";
		
		try {
			
		this.sistema.cadastraAluno("202", "Angela Ziegler", "");
		
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());		
		}
	}
	
	@Test
	void testCadastraGrupoSemRestricaoValorVazio() {
		try {
			this.sistema.cadastraGrupo("");
			
		} catch(IllegalArgumentException iae) {
			assertEquals("tema vazio", iae.getMessage());		
			}
	}
	@Test
	void testCadastraGrupoSemRestricaoValorNull() {
		try {
			this.sistema.cadastraGrupo(null);
			System.out.println(this.sistema.cadastraGrupo(null));
		} catch (NullPointerException npe) {
			assertEquals("tema nulo", npe.getMessage());
		} 
	}
	
	@Test
	void testCadastraAlunoMatriculaNula() {
		String esperado = "matrícula nula";
		try {
			this.sistema.cadastraAluno(null, "Lili Camposh", "Computação");
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCadastraAlunoNomeNulo() {
		String esperado = "nome nulo";
		try {
			this.sistema.cadastraAluno("200", null, "Computação");
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCadastraAlunoCursoNulo() {
		String esperado = "curso nulo";
		try {
			this.sistema.cadastraAluno("200", "Lili Camposh", null);
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCadastraGrupoComRestricaoTemaVazio() {
		String esperado = "tema vazio";
		try {
			this.sistema.cadastraGrupo("", 0);
		} catch (IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testCadastraGrupoComRestricaoTemaNulo() {
		String esperado = "tema nulo";
		try {
			this.sistema.cadastraGrupo(null, 0);
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCadastraGrupoSemRestricaoTemaVazio() {
		String esperado = "tema vazio";
		try {
			this.sistema.cadastraGrupo("");
		} catch (IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testCadastraGrupoSemRestricaoTemaNulo() {
		String esperado = "tema nulo";
		try {
			this.sistema.cadastraGrupo(null);
		} catch (NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testCadastraGrupoComRestricaoTamanhoInvalido() {
		String esperado = "tamanho inválido";
		try {
			this.sistema.cadastraGrupo("P2", -1);
		} catch (IndexOutOfBoundsException ioebe) {
			assertEquals(esperado, ioebe.getMessage());
		}
	}
	
}
