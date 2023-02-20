package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import documin.Texto;
class testesTexto {
		
	private Texto texto1;
	private Texto texto2; 
	
	@BeforeEach
	void inicia() {
		this.texto1 = new Texto(3, "Exemplo de texto");
		this.texto2 = new Texto(4, "Exemplo 2 de texto");
	}
	
	@Test
	void testGerarRepresentacaoCompleta() {
		String esperado = "Exemplo de texto";
		assertEquals(esperado, texto1.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepreentacaoResumida() {
		String esperado = "Exemplo 2 de texto";
		assertEquals(esperado, texto2.gerarRepresentacaoResumida());
	}
}
