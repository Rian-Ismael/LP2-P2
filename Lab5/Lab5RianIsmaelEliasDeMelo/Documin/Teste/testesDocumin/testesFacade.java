package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Atalho;
import documin.Documento;
import documin.DocumentoController;
import documin.Facade;
import documin.Lista;
import documin.Termos;
import documin.Texto;
import documin.Titulo;

class testesFacade {

	private Facade facade1;

	@BeforeEach
	void inicia() {
		this.facade1 = new Facade();
		
	}
	
	@Test
	void testCriarDocumento() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarDocumento("Teste");
	}
	
	@Test
	void testCriarDocumentoJaCadastrado() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarDocumento("Teste");
		assertFalse(this.facade1.criarDocumento("Teste2", 2));
		assertFalse(this.facade1.criarDocumento("Teste"));
	}
	
	@Test
	void testCriarTexto() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "Exemplo de texto";
		assertEquals(saida, this.facade1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarLista() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		String saida = "- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos";
		assertEquals(saida, this.facade1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testCriarTermo() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		String saida = "Total termos: 3\n"
				+ "-Aleatórios, termos, Teste";
		assertEquals(saida, this.facade1.pegarRepresentacaoCompleta("Teste2", 0));
	} 
	
	@Test
	void testCriarTitulo() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "3. Documentos Texto -- 3-DOCUMENTOSTEXTO";
		assertEquals(saida,  this.facade1.pegarRepresentacaoCompleta("Teste2", 0));
	}
	
	@Test
	void testMoverParaBaixo() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarTexto("Teste2", "Exemplo de texto", 3);
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		boolean saida = this.facade1.moverParaBaixo("Teste2", 0); // troca com o elemento posterior a ele
		assertTrue(saida);
		boolean saida2 = this.facade1.moverParaBaixo("Teste2", 1); // como foi cadastrado 2 elementos, não há posterior ao último
		assertFalse(saida2);
	}
	
	@Test
	void testMoverParaCima() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarTexto("Teste2", "Exemplo de texto", 3);
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		boolean saida = this.facade1.moverParaCima("Teste2", 1); // move o elemento, já que há um anterior a ele
		assertTrue(saida);
		boolean saida2 = this.facade1.moverParaCima("Teste2", 0); // já é a posição inicial
		assertFalse(saida2);
	}
	
	@Test
	void testPegarRepresentacaoCompleta() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		String saida = "Total termos: 3\n"
				+ "-Aleatórios, termos, Teste";
		assertEquals(saida, this.facade1.pegarRepresentacaoCompleta("Teste2", 1));
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		String saida = "Aleatórios / termos / Teste";
		assertEquals(saida, this.facade1.pegarRepresentacaoResumida("Teste2", 1));
	}
	
	@Test
	void testRemoverElemento() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "-");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		assertTrue(this.facade1.apagarElemento("Teste2", 0)); // apagou o primeiro elemento
		assertTrue(this.facade1.apagarElemento("Teste2", 0)); // o segundo elemento passa a ser o primeiro, por isso posição 0 novamente
		assertFalse(this.facade1.apagarElemento("Teste2", 0)); // não existe mais nenhum elemento a ser apagado
	}
	
	@Test
	void testCriarListaDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTermosDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarTermos("Test2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTextoDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarTexto("Test2", "Exemplo de texto", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarTitulo("Test2", "Documentos Texto", 3, 1, true);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testRemoverDocumento() {
		this.facade1.criarDocumento("Teste2", 2);
		this.facade1.criarDocumento("Teste");
		this.facade1.removerDocumento("Teste");
		try {
			this.facade1.removerDocumento("Teste");
			fail("Não deveria aparecer esta mensagem, pois titulo não existe mais");
		} catch (NoSuchElementException nse) {
			assertEquals("Título não existe", nse.getMessage());
		}
	}
	
	@Test
	void testCriarVisaoCompletaException() {
		String saida = "Título não existe";
		try {
			this.facade1.criarVisaoCompleta("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test
	void testCriarVisaoTituloException() {
		String saida = "Título não existe"; 
		try {
			this.facade1.criarVisaoTitulo("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarVisaoResumidaException() {
		String saida = "Título não existe";
		try {
			this.facade1.criarVisaoResumida("Test2");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
	}
	}
	
	@Test
	void testCriarVisaoPrioritariaException() {
		String saida = "Título não existe";
		try {
			this.facade1.criarVisaoPrioritaria("Test2", 3);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void criaAtalhoExceptionJaEhAtalho2() {
		this.facade1.criarDocumento("Teste");
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarDocumento("Teste3");
		this.facade1.criarAtalho("Teste", "Teste2");
		try {
			this.facade1.criarAtalho("Teste2", "Teste3");
		} catch (IllegalStateException ise) {
		}
	}
	
	@Test
	void criaAtalhoExceptionTemAtalhoArmazenado() {
		this.facade1.criarDocumento("Teste");
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarDocumento("Teste3");
		this.facade1.criarAtalho("Teste", "Teste2");
		try {
			this.facade1.criarAtalho("Teste3", "Teste");
		} catch (IllegalStateException ise) {
		}
	}
	 
	@Test
	void testMoverParaBaixoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.moverParaBaixo("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testMoverParaCimaTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.moverParaCima("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoCompletaTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.pegarRepresentacaoCompleta("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoResumidaTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.pegarRepresentacaoResumida("Test2", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}	
	
	@Test
	void testExibirDocumentoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.exibirDocumento("Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	
	@Test
	void testApagarElementoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.apagarElemento("Test", 0);
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarAtalho("Test", "Teste");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testCriarAtalhoDocReferenciadoTituloDocumentoNaoExistente() { 
		String saida = "Título não existe";
		try {
			this.facade1.criarAtalho("Teste", "Test");
		} catch (NoSuchElementException nse) {
			assertEquals(saida, nse.getMessage());
		}
	}
	
	@Test
	void testExibirDocumento() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "Exemplo / de uma lista / de 3 termos", 4, "/", "/");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.facade1.criarTexto("Teste2", "Exemplo de texto", 3);
		String saida = "[Exemplo / de uma lista / de 3 termos /\n"
				+ ", Total termos: 3\n"
				+ "-Aleatórios, termos, Teste\n"
				+ ", Exemplo de texto]";
		assertEquals(saida, Arrays.toString(this.facade1.exibirDocumento("Teste2")));
	}
	
	@Test
	void testCriarVisaoCompleta() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Total termos: 3\n"
				+ "-Aleatórios, termos, Teste]";
		this.facade1.criarVisaoCompleta("Teste2"); 
		assertEquals(saida, Arrays.toString(this.facade1.exibirVisao(0)));
	}
	
	@Test 
	void testCriarVisaoResumida() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		
		String saida = "[Exemplo / de uma lista / de 3 termos\n"
				+ ", Aleatórios / termos / Teste]";
		this.facade1.criarVisaoResumida("Teste2"); 
		assertEquals(saida, Arrays.toString(this.facade1.exibirVisao(0)));
	}
	
	@Test 
	void testCriarVisaoPrioritaria() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 4, "/", "ALFABÉTICA");
		
		String saida = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Total termos: 3\n"
				+ "-Aleatórios, termos, Teste]";
		this.facade1.criarVisaoPrioritaria("Teste2", 4); 
		assertEquals(saida, Arrays.toString(this.facade1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoTitulo() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 4, "/", "ALFABÉTICA");
		
		String saida = "[]";
		this.facade1.criarVisaoTitulo("Teste2"); 
		assertEquals(saida, Arrays.toString(this.facade1.exibirVisao(0)));
	}
	
	@Test
	void testCriarVisaoTituloExistente() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 4, "/", "ALFABÉTICA");
		this.facade1.criarTitulo("Teste2", "Documentos Texto", 3, 1, true);
		String saida = "[3. Documentos]";
		this.facade1.criarVisaoTitulo("Teste2"); 
		assertEquals(saida, Arrays.toString(this.facade1.exibirVisao(0)));
	} 
	
	@Test
	void testCriarAtalho() {
		this.facade1.criarDocumento("Teste2");
		this.facade1.criarLista("Teste2", "-", 4, "/", "Exemplo / de uma lista / de 3 termos");
		this.facade1.criarTermos("Teste2", "Teste / termos / Aleatórios", 4, "/", "ALFABÉTICA");

		this.facade1.criarDocumento("Teste");
		this.facade1.criarAtalho("Teste", "Teste2");
	}
}
