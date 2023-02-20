package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Documento;
import documin.DocumentoController;
import documin.Lista;
import documin.Termos;
import documin.Texto;
import documin.Titulo;

class testesController {

	
	private DocumentoController controller1;
	private Documento documento1;
	private Documento documento2;
	private Lista lista1;
	private Termos termo1;
	private Texto texto1;
	private Titulo titulo1;
	private Termos termo2;
	
	@BeforeEach
	void inicia() {
		
		this.controller1 = new DocumentoController();
		this.controller1.adicionaDocumento("Teste");
		this.controller1.adicionaDocumento("Teste2", 2);
		this.controller1.adicionaDocumento("Teste3");
		
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
//		this.documento1.adicionarElemento(lista1);
//		this.controller1.criarLista("Test2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		
		this.termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
//		this.documento1.adicionarElemento(termo1);
//		this.controller1.criarTermos("Test2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		
		
		this.texto1 = new Texto(3, "Exemplo de texto");
//		this.documento1.adicionarElemento(texto1);
//		this.controller1.criarTexto("Test2", "Exemplo de texto", 3);
		
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, true); // linkavel true
//		this.documento1.adicionarElemento(titulo1);
//		this.controller1.criarTitulo("Test2", "Documentos Texto", 3, 1, true);
		
//		this.termo2 = new Termos(3, "Teste / termos / Aleatórios", "/", "TAMANHO");
//		this.documento2.adicionarElemento(termo2);
		
	}
	
	@Test
	void testConstrutor() { 
		this.controller1.adicionaDocumento("Teste");
		this.controller1.adicionaDocumento("Test2", 2);
	}
	
	@Test
	void testCriarListaDocumento() { // 
		this.controller1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		String saida = "- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTermosDocumento() {
		this.controller1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		String saida = "Total termos: 3\n"
				+ "-Aleatórios, termos, Teste";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTextoDocumento() {
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "Exemplo de texto";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTituloDocumento() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "3. Documentos Texto -- 3-DOCUMENTOSTEXTO";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testAdicionarElementoJaCadastrado() {
		assertFalse(this.controller1.adicionaDocumento("Teste"));
		assertFalse(this.controller1.adicionaDocumento("Teste2", 2));
	}
	
	@Test
	void testMoverParaCimaLimiteInferior() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaCima("Teste2", 0);
		assertFalse(saida);
	}
	
	@Test
	void testMoverParaCima() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaCima("Teste2", 1);
		assertTrue(saida);
	}
	
	@Test
	void testMoverParaBaixoLimiteSuperior() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaBaixo("Teste2", 1);
		assertFalse(saida);
	}
	
	@Test
	void testMoverParaBaixoLimite() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		boolean saida = this.controller1.moverParaBaixo("Teste2", 0);
		assertTrue(saida);
	}
	
	@Test
	void testApagaElemento() {
		this.controller1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		assertTrue(this.controller1.apagarElemento("Teste2", 2));
		assertFalse(this.controller1.apagarElemento("Teste2", 2)); // Elemento já não existe mais
	}
	
	@Test
	void testApagaDocumento() {
		assertEquals(2, this.controller1.getQtDocumentos());
		this.controller1.removerDocumento("Teste2");
		assertEquals(1, this.controller1.getQtDocumentos());
	}
	
	@Test
	void testPegarRepresentacaoCompleta() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "3. Documentos Texto -- 3-DOCUMENTOSTEXTO";
		assertEquals(saida, this.controller1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "3. Documentos";
		assertEquals(saida, this.controller1.pegarRepresentacaoResumida("Teste2", 0));
	}
	
	@Test 
	void testExibirDocumento() {
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[3. Documentos Texto -- 3-DOCUMENTOSTEXTO\n"
				+ ", Exemplo de texto]";
		assertEquals(saida, Arrays.toString(this.controller1.exibirDocumento("Teste2")));
	}
	
	
	
	@Test
	void testCriarListaDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.controller1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTermosDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.controller1.criarTermos("Test2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTextoDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.controller1.criarTexto("Test2", "Exemplo de texto", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.controller1.criarTitulo("Test2", "Documentos Texto", 3, 1, true);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}

	@Test
	void testMoverParaBaixoTituloDocumentoNaoExistente() { 
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		String saida = "Título não existe";
		try {
			this.controller1.moverParaBaixo("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testMoverParaCimaTituloDocumentoNaoExistente() { 
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		String saida = "Título não existe";
		try {
			this.controller1.moverParaCima("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoCompletaTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.pegarRepresentacaoCompleta("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoResumidaTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.pegarRepresentacaoResumida("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}	
	
	@Test
	void testExibirDocumentoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.exibirDocumento("Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	
	@Test
	void testApagarElementoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.apagarElemento("Test", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.criarAtalho("Test", "Teste");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocReferenciadoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		this.controller1.criarTitulo("Teste", "Documentos Texto", 3, 1, true);
		try {
			this.controller1.criarAtalho("Teste", "Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarVisaoCompleta() { 
		this.controller1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos"); // COMPLETA
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Exemplo de texto]";
		this.controller1.criarVisaoCompleta("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	 
	@Test
	void testCriarVisaoCompletaException() {
		String saida = "Título não existe";
		try {
			this.controller1.criarVisaoCompleta("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test 
	void testCriarVisaoResumida() { 
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		this.controller1.criarLista("Teste2", "/", 4, "-", "Exemplo / de uma lista / de 3 termos");
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "[Exemplo de texto\n"
				+ ", Exemplo / de uma lista / de 3 termos\n"
				+ ", 3. Documentos]";
		this.controller1.criarVisaoResumida("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoResumidaException() {
		String saida = "Título não existe";
		try {
			this.controller1.criarVisaoResumida("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test
	void criaAtalhoExceptionJaEhAtalho2() {
		this.controller1.criarAtalho("Teste", "Teste2");
		try {
			this.controller1.criarAtalho("Teste2", "Teste3");
		} catch (IllegalStateException ise) {
		}
	}
	
	@Test
	void criaAtalhoExceptionTemAtalhoArmazenado() {
		this.controller1.criarAtalho("Teste", "Teste2");
		try {
			this.controller1.criarAtalho("Teste3", "Teste");
		} catch (IllegalStateException ise) {
		}
	}
	
	
	@Test
	void testCriarVisaoPrioritaria() {
		this.controller1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.controller1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Exemplo de texto]";
		this.controller1.criarVisaoPrioritaria("Teste2", 3);
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoPrioritariaException() {
		String saida = "Título não existe";
		try {
			this.controller1.criarVisaoPrioritaria("Test2", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}

	
	@Test
	void testCriarVisaoTitulo() {
		this.controller1.criarTitulo("Teste2", "Teste p/ Documento", 3, 1, true);
		this.controller1.criarTitulo("Teste2", "Documentos Texto", 4, 0, false);	
		String saida = "[3. Teste\n"
				+ ", 4. Documentos Texto]";
		this.controller1.criarVisaoTitulo("Teste2");
		assertEquals(saida, Arrays.toString(this.controller1.exibirVisao(0)));
	}

	@Test
	void testCriarVisaoTituloException() {
		String saida = "Título não existe"; 
		try {
			this.controller1.criarVisaoTitulo("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	
	
	
}
