package testesDocumin;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Documento;
import documin.Lista;
import documin.Termos;
import documin.Texto;
import documin.Titulo;

class testesDocumento {

	private Documento documento1;
	private Documento documento2;
	private Documento documento3;
	private Lista lista1; 
	private Termos termo1;
	private Texto texto1;
	private Titulo titulo1;
	
	private Termos termo2;
	
	@BeforeEach
	void inicia() {
		
		this.documento1 = new Documento("Teste");
		this.documento2 = new Documento("Teste2", 2);
		this.documento3 = new Documento("Teste");
		
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento1.adicionarElemento(lista1);
		
		this.termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.documento1.adicionarElemento(termo1);
		
		this.texto1 = new Texto(3, "Exemplo de texto");
		this.documento1.adicionarElemento(texto1);
		
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, true); // linkavel true
		this.documento1.adicionarElemento(titulo1);
		
		this.termo2 = new Termos("Teste / termos / Aleatórios", 3, "/", "TAMANHO");
		this.documento2.adicionarElemento(termo2);
		
	}
	
	
	@Test
	void testLimiteTamanho() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		assertEquals(1, posicao); // Coleção ainda aceitava Elemento
		
		this.texto1 = new Texto(3, "Exemplo de texto");
		int posicao2 = this.documento2.adicionarElemento(texto1); // Coleção não aceita mais elementos, já está preenchido, deve retornar -2
		assertEquals(-2, posicao2);
	}
	
	@Test
	void testApagaElemento() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		assertEquals(1, posicao); // Coleção ainda aceitava Elemento/ adicionei mais um, não aceita mais
		
		this.documento2.apagarElemento(1); // possui 2 espaços, removi 1, aceita mais um elemento.
		
		this.texto1 = new Texto(3, "Exemplo de texto");
		int posicao2 = this.documento2.adicionarElemento(texto1);
		assertEquals(1,posicao2); // elemento adicionado, não suporta mais elementos.
	}
	
	@Test
	void testApagaElementoNaoExistente() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		assertEquals(1, posicao); // Coleção ainda aceitava Elemento/ adicionei mais um, não aceita mais
		
		this.documento2.apagarElemento(1); // possui 2 espaços, removi 1, aceita mais um elemento.
		boolean saida = this.documento2.apagarElemento(1); // não existe mais tal elemento
		assertFalse(saida);

	}
	
	
	
	@Test
	void testMoverElementoUmaPosicaoAcima() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		boolean saida = this.documento2.moverElementoPosicaoAcima(posicao);
		assertTrue(saida);
	}
	
	@Test
	void testMoverElementoUmaPosicaoAcimaLimiteInferior() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		boolean saida = this.documento2.moverElementoPosicaoAcima(0);
		assertFalse(saida);
	}
	
	@Test
	void testMoverElementoUmaPosicaoAbaixo() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		
		boolean saida = this.documento2.moverElementoPosicaoAbaixo(0); //primeiro documento
		
		assertTrue(saida);
	}
	
	@Test
	void testMoverElementoUmaPosicaoAbaixoLimiteSuperior() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, false); // linkavel false
		int posicao = this.documento2.adicionarElemento(titulo1);
		boolean saida = this.documento2.moverElementoPosicaoAbaixo(posicao);
		assertFalse(saida);
	}
	
	@Test
	void testExibirDocumento() {
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento2.adicionarElemento(lista1);
		String saida = "[Total termos: 3\n" 
				+ "-Aleatórios, termos, Teste\n"
				+ ", - Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos"
				+ "]";
		assertEquals(saida, Arrays.toString(this.documento2.exibirDocumento()));
	}
	
	@Test
	void testQuantidadeDeElementosCadastrados(){
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento2.adicionarElemento(lista1);
		assertEquals(2, this.documento2.contarElemento());
	}
	
	@Test
	void testGerarRepresentacaoCompletaDeUmElemento() {
		String saida = "Total termos: 3\n" +
				"-Aleatórios, termos, Teste";
		assertEquals(saida, this.documento2.pegarRepresentacaoCompleta(0)); // 0 é o primeiro elemento
	}
	
	@Test
	void testGerarRepresentacaoResumidaDeUmElemento() {
		String saida = "Aleatórios / termos / Teste";
		assertEquals(saida, this.documento2.pegarRepresentacaoResumida(0)); // 0 é o primeiro elemento
	}
	
	
	@Test
	void testTituloVazio() {
		String saida = "Titulo vazio ou contendo somente espaços";
		try {
			new Documento("");
			fail("não deveria ter aparecido esta mensagem");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	}
	
	@Test
	void testTamanhoInvalido() {
		String saida = "tamanho inválido";
		try {
			new Documento("teste", -1);
			fail("não deveria ter aparecido esta mensagem");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	}
	
	@Test
	void testTituloVazioComTamanho() {
		String saida = "Titulo vazio ou contendo somente espaços";
		try {
			new Documento("", 10);
			fail("não deveria ter aparecido esta mensagem");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage()); 
		}
	}
	
	@Test
	void testTituloEspacoComTamanho() {
		String saida = "Titulo vazio ou contendo somente espaços";
		try {
			new Documento("   ", 10);
			fail("não deveria ter aparecido esta mensagem");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	} 

	
	@Test
	void testTituloEspacos() {
		String saida = "Titulo vazio ou contendo somente espaços";
		try {
			new Documento("   ");
			fail("não deveria ter aparecido esta mensagem");
		} catch (IllegalArgumentException iae) {
			assertEquals(saida, iae.getMessage());
		}
	}
	
	@Test
	void testDocumentoEqualsTrue() {
		assertTrue(documento1.equals(documento3));
	}

	@Test
	void testDocumentoEqualsFalse() {
		assertFalse(documento3.equals(documento2));
	}
}
