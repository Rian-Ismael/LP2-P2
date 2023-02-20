package testeMeuDesafio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioMinhaVida.Acao;
import desafioMinhaVida.DesafioMaterial;

class testDesafioMaterial {
	
	private DesafioMaterial desafio1;
	private DesafioMaterial desafio2; 
	private Acao acao1;
	private Acao acao2;
	private Acao acao3;
	
	@BeforeEach
	void testDesafio() {
		this.desafio1 = new DesafioMaterial("30min de academia por uma semana", 5000.00);
		this.desafio2 = new DesafioMaterial("30 dias sem açúcar", "Ficar sem ingerir açúcar por 30 dias", 5000.00);
		this.acao1 = new Acao("14/12/2022", 44, desafio1);
		this.acao2 = new Acao("14/12/2022", 52, desafio1);
		this.acao3 = new Acao("14/12/2022", 44, desafio1);
	}

	@Test
	void testExibirDesafio() {
		acao1.adicionaProgresso(90);
		acao1.adicionaProgresso();
		acao1.adicionaProgresso();
		String saida = "Título: 30min de academia por uma semana (material)\n1 execuções";
		System.out.println();
		System.out.println(desafio1.exibirDesafio());
		assertEquals(saida, desafio1.exibirDesafio());
	}
	
	@Test
	void testExibirDesafioZeroExecucoes() {
		String saida = "Título: 30min de academia por uma semana (material)\n0 execuções";
		assertEquals(saida, desafio1.exibirDesafio());
	}
	
	@Test
	void testGetProgresso() {
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(2);
		assertEquals(12, acao1.getProgresso());
	}
	
	@Test
	void testCalculo() {
		int saida = 50;
		acao1.adicionaProgresso();
		acao1.adicionaProgresso(90);
		assertEquals(saida, this.desafio1.getNivel());
	}
	
	
	@Test
	void testEqualsFalse() {
		assertFalse(this.acao1.equals(this.acao2));
	}
	
	@Test
	void testEqualsTrue() {
		assertTrue(this.acao1.equals(this.acao3));
	}

	@Test
	void testtoString() {
		acao1.adicionaProgresso(20);
		acao1.adicionaProgresso();
		String saida = "Acao 44 - 14/12/2022 - 30min de academia por uma semana - Progresso 30";
		assertEquals(saida, acao1.toString());
	}
	
}

