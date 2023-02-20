package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Lista;

class testesLista {
	
	private Lista lista1;
	private Lista lista2;
	

	@BeforeEach
	void inicia() {
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.lista2 = new Lista(2, "Teste | termos | Aleatórios", "|", "-");
	}
	
	@Test
	void testGerarRepresentacaoCompleta() {
		String saida = "- Exemplo\n" +
					   "- de uma lista\n" +
					   "- de 3 termos";
		assertEquals(saida, this.lista1.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepresentacaoResumida() {
		String saida = "Exemplo / de uma lista / de 3 termos";
		assertEquals(saida, this.lista1.gerarRepresentacaoResumida());
	}

}
