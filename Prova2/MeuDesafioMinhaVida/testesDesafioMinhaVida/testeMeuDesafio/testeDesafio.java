package testeMeuDesafio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioMinhaVida.Acao;
import desafioMinhaVida.DesafioInterface;
import desafioMinhaVida.DesafioPessoal;

class testeDesafio {
	
	private DesafioPessoal desafio1;
	private DesafioPessoal desafio2;
	private DesafioPessoal desafio3;
	private Acao acao1;
	private Acao acao2;
	private Acao acao3;
	
	@BeforeEach
	void testDesafio() {
		this.desafio1 = new DesafioPessoal("30min de academia por uma semana");
		this.desafio2 = new DesafioPessoal("30 dias sem açúcar", "Ficar sem ingerir açúcar por 30 dias");
		this.desafio3 = new DesafioPessoal("30min de academia por uma semana");
		this.acao1 = new Acao("14/12/2022", 44, desafio1);
		this.acao2 = new Acao("14/12/2022", 52, desafio1);
		this.acao3 = new Acao("14/12/2022", 44, desafio1);
	}
	
	@Test
	void testContaDesafio() {
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(90);
		assertEquals(1, desafio1.getExecucoes());
	}
	
	@Test
	void testContaDesafioLimite() {
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(90);
		acao2.adicionaProgresso();
		acao2.adicionaProgresso(90);

		assertEquals(2, desafio1.getExecucoes());
	}
	
	@Test
	void testGetTitulo() {
		String saida = "30min de academia por uma semana";
		assertEquals(saida, this.desafio1.getTitulo());
	}
	
	@Test
	void testCalculo() {
		int saida = 10;
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(90);
		assertEquals(saida, this.desafio1.getNivel());
		
		
	}
	

	@Test
	void testExibirDesafio() {
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(90);
		String saida = "Título: 30min de academia por uma semana (pessoal)\n1 execuções";
		assertEquals(saida, this.desafio1.exibirDesafio());
	}
	
	@Test
	void testEqualsFalse() {
		assertFalse(this.acao1.equals(this.acao2));
	}
	
	@Test
	void testEqualsTrue() {
		assertTrue(this.desafio1.equals(this.desafio3));
	}
}
