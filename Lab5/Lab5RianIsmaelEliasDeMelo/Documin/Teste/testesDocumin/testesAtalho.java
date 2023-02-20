package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Atalho;
import documin.Documento;
import documin.DocumentoController;
 
class testesAtalho {
	
	private DocumentoController controller;
	
	@BeforeEach
	void inicia() {
		this.controller = new DocumentoController();
		this.controller.adicionaDocumento("Teste");
		this.controller.adicionaDocumento("Teste2");
		this.controller.adicionaDocumento("Teste3");
		this.controller.adicionaDocumento("Teste4", 4);
		this.controller.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.controller.criarTexto("Teste2", "Exemplo de texto", 4);
		this.controller.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");

	}
	
	@Test
	void testGetTituloReferenciada() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documento documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		assertEquals("Teste2", atalho.getValor());
	}

	@Test
	void testMediaPrioridade() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documento documento = this.controller.getDocumento("Teste2");
		int media = documento.mediaPrioridade(); 
		assertEquals(3, documento.mediaPrioridade());
	}
	
	@Test
	void testRepresentacaoCompleta() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documento documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		String saida = "- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ "Exemplo de texto";
		assertEquals(saida, atalho.gerarRepresentacaoCompleta());
	}
	
	@Test 
	void testRepresentacaoResumida() {
		this.controller.criarAtalho("Teste", "Teste2");
		Documento documento = this.controller.getDocumento("Teste");
		Atalho atalho = documento.getAtalho(0);
		String saida = "Exemplo / de uma lista / de 3 termos\n"
				+ "Exemplo de texto";
		assertEquals(saida, atalho.gerarRepresentacaoResumida());
	}
	
	@Test
	void criaAtalhos() {
		assertEquals(0, this.controller.criarAtalho("Teste", "Teste2"));
		assertEquals(1, this.controller.criarAtalho("Teste", "Teste3"));
	}
	
	@Test
	void criaAtalhoExceptionJaEhAtalho2() {
		this.controller.criarAtalho("Teste", "Teste2");
		try {
			this.controller.criarAtalho("Teste2", "Teste3");
		} catch (IllegalStateException ise) {
			
		}
	}
	
	@Test
	void criaAtalhoExceptionTemAtalhoArmazenado() {
		this.controller.criarAtalho("Teste", "Teste2");
		try {
			this.controller.criarAtalho("Teste3", "Teste");
		} catch (IllegalStateException ise) {
			
		}
	}
	
	
	

}
