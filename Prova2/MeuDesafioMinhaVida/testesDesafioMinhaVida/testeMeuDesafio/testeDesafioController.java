package testeMeuDesafio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioMinhaVida.Acao;
import desafioMinhaVida.DesafioController;

class testeDesafioController {
	
	private DesafioController controller;
	
	@BeforeEach
	void testDesafio() {
		this.controller = new DesafioController();
		this.controller.cadastaDesafioPessoal("30 dias sem açúcar");
		this.controller.cadastaDesafioPessoal("30min de academia por uma semana");
		this.controller.cadastaDesafioPessoal("Test saida I");
		
		this.controller.cadastraAcao("14/12/2022", 44, 1);
		
		this.controller.cadastraAcao("14/12/2022", 47, 1);
		
		this.controller.cadastraAcao("14/12/2022", 52, 2);
		
	}

	@Test 
	void testListarAcaoPorOrdemProgresso() {
		this.controller.adicionaProgresso(10, 52);
		this.controller.adicionaProgresso(5, 44);
		this.controller.adicionaProgresso(60, 47);
		String saida = "Acao 44 - 14/12/2022 - 30 dias sem açúcar - Progresso 5\n" +
				"Acao 52 - 14/12/2022 - 30min de academia por uma semana - Progresso 10\n" +
				"Acao 47 - 14/12/2022 - 30 dias sem açúcar - Progresso 60\n";
		assertEquals(saida, this.controller.listarAcaoesPorOrdemDeProgresso());
	} 
	
	@Test
	void testCadastraDesafioPessoalNaoCastrado() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioPessoal("Test saida 3"));
	}
	
	@Test
	void testCadastraDesafioPessoalNaoCadastradoComDescricao() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioPessoal("Test saida 3", "teste"));
	}
	
	@Test
	void testCadastraDesafioSocialNaoCadastradoComDescricao() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioSocial("Test saida 3", "teste"));
	}
	
	@Test
	void testCadastraDesafioSocialNaoCadastradoSemDescricao() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioSocial("Test saida 3"));
	}
	
	
	@Test
	void testCadastraDesafioMaterialNaoCadastradoComDescricao() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioMaterial("Test saida 3", "teste", 5000.00));
	}
	
	@Test
	void testCadastraDesafioMaterialNaoCadastradoSemDescricao() {
		int saida = 4;
		assertEquals(saida, this.controller.cadastaDesafioMaterial("Test saida 3", 5000.00));
	}
	
	@Test
	void testCadastraDesafioJaCadastraComDescricao() {
	assertEquals(-1, this.controller.cadastaDesafioPessoal("Test saida I"));
	}
	
	@Test
	void testExibirDesafio() {
		this.controller.adicionaProgresso(99, 44);
		String saida = "Título: 30 dias sem açúcar (pessoal)" + "\n" + "0 execuções";
		assertEquals(saida, this.controller.exibirDesafio(1));
	}
	
	
	@Test
	void testAdicionaProgressoResultaUmaExecucao() {
		this.controller.adicionaProgresso(101, 44);
		this.controller.adicionaProgresso(44);
		String saida = "Título: 30 dias sem açúcar (pessoal)" + "\n" + "1 execuções";
		assertEquals(saida, this.controller.exibirDesafio(1));
	}
	
	@Test
	void testAdicionaProgressoResulta0Execucao() {
		this.controller.adicionaProgresso(1, 52);
		this.controller.adicionaProgresso(44);
		String saida = "Título: 30min de academia por uma semana (pessoal)" + "\n" + "0 execuções";
		assertEquals(saida, this.controller.exibirDesafio(2));
	}
	
	@Test
	void testCadastraAcao() {
		this.controller.cadastraAcao("14/12/2022", 60, 2);
	}
	
	@Test
	void testCadastraDesafiopessoalJaCadastrado() {
		this.controller.cadastaDesafioPessoal("30min de academia por uma semana");
		assertEquals(-1, this.controller.cadastaDesafioPessoal("30min de academia por uma semana"));
	}
	
	@Test
	void testCadastraSocialDesafioJaCadastrado() {
		this.controller.cadastaDesafioSocial("30min de academia por uma semana");
		assertEquals(-1, this.controller.cadastaDesafioSocial("30min de academia por uma semana"));
	}
	
	@Test
	void testCadastraDesafioMaterialJaCadastrado() {
		this.controller.cadastaDesafioMaterial("30min de academia por uma semana", 5000.00);
		assertEquals(-1, this.controller.cadastaDesafioMaterial("30min de academia por uma semana", 5000.00));
	}
	
	@Test
	void testCadastraDesafiopessoalComDescricaoJaCadastrado() {
		this.controller.cadastaDesafioPessoal("30min de academia por uma semana", "teste");
		assertEquals(-1, this.controller.cadastaDesafioPessoal("30min de academia por uma semana", "teste"));
	}
	
	@Test
	void testCadastraDesafiopessoalJaCadastradoSocialJaCadastrado() {
		this.controller.cadastaDesafioSocial("30min de academia por uma semana", "teste");
		assertEquals(-1, this.controller.cadastaDesafioSocial("30min de academia por uma semana", "teste"));
	}
	
	
	@Test
	void testCadastraDesafiopessoalJaCadastradoMaterialJaCadastrado() {
		this.controller.cadastaDesafioMaterial("30min de academia por uma semana", "teste", 5000.00);
		assertEquals(-1, this.controller.cadastaDesafioMaterial("30min de academia por uma semana", "teste", 5000.00));
	}

}
