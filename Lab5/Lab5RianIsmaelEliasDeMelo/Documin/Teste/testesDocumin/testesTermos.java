package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Termos;

class testesTermos {

	private Termos termo1;
	private Termos termo2;
	private Termos termo3;
	
	@BeforeEach
	void inicia() {
		this.termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.termo2 = new Termos("Teste / termos / Aleatórios", 2, "/", "NENHUM");
		this.termo3 = new Termos("oi / Teste / termos / Aleatórios / Diferenciador", 4, "/", "TAMANHO");
	}

	@Test 
	void testGerarRepresentacaoCompletaAlfabética() {
		String saida = "Total termos: 3\n-Aleatórios, termos, Teste";
//		System.out.println(termo1.teste());
		assertEquals(saida, this.termo1.gerarRepresentacaoCompleta());
	}
	
	@Test 
	void testGerarRepresentacaoResumidaAlfabética() {
		String saida = "Aleatórios / termos / Teste";
		assertEquals(saida, this.termo1.gerarRepresentacaoResumida());
	}
	
	@Test
	void testGerarRepresentacaoCompletaTamanho() {
		String saida = "Total termos: 5\n-Diferenciador, Aleatórios, termos, Teste, oi";
		assertEquals(saida, termo3.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepresentacaoResumidaTamanho() {
		String saida = "Diferenciador / Aleatórios / termos / Teste / oi";
		assertEquals(saida, termo3.gerarRepresentacaoResumida());
	}
	
	@Test
	void testGerarRepresentacaoCompletaNenhuma() {
		String saida = "Total termos: 3\n-Teste, termos, Aleatórios";
		assertEquals(saida, termo2.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepresentacaoResumidaNenhuma() {
		String saida = "Teste / termos / Aleatórios";
		assertEquals(saida, termo2.gerarRepresentacaoResumida());
	}
}