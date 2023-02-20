package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Documento;
import documin.Lista;
import documin.Termos;
import documin.Texto;
import documin.Titulo;

class testesDocumentoVisao {

	private Documento documento1;
	private Documento documento2;
	private Lista lista1; 
	private Termos termo1;
	private Texto texto1;
	private Titulo titulo1;
	private Titulo titulo2;

	
	@BeforeEach
	void inicia() {
		
		this.documento1 = new Documento("Teste");
		
		this.lista1 = new Lista(4, "Exemplo / de uma lista / de 3 termos", "/", "-");
		this.documento1.adicionarElemento(lista1);

		this.termo1 = new Termos("Teste / termos / Aleatórios", 3, "/", "ALFABÉTICA");
		this.documento1.adicionarElemento(termo1);

		this.texto1 = new Texto(3, "Exemplo de texto");
		this.documento1.adicionarElemento(texto1);
		
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, true); // linkavel true
		this.documento1.adicionarElemento(titulo1);
		this.titulo2 = new Titulo(4, "Texto p/ Documento", 2, false); // linkavel false
		this.documento1.adicionarElemento(titulo2);
	}

	@Test
	void testVisaoCompleta() {
		String saida2 = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", Total termos: 3\n"
				+ "-Aleatórios, termos, Teste\n"
				+ ", Exemplo de texto\n"
				+ ", 1. Documentos Texto -- 1-DOCUMENTOSTEXTO\n"
				+ ", 2. Texto p/ Documento]";
		assertEquals(saida2, Arrays.toString(this.documento1.criarVisaoCompleta()));
	}

	@Test
	void testVisaoResumida() {
		this.documento1.criarVisaoResumida();
		String saida2 = "[Exemplo / de uma lista / de 3 termos\n"
				+ ", Aleatórios / termos / Teste\n"
				+ ", Exemplo de texto\n"
				+ ", 1. Documentos\n"
				+ ", 2. Texto p/ Documento]";
		assertEquals(saida2, Arrays.toString(this.documento1.criarVisaoResumida()));
	}

	@Test
	void testVisaoPrioritaria() {
		String saida2 = "[- Exemplo\n"
				+ "- de uma lista\n"
				+ "- de 3 termos\n"
				+ ", 2. Texto p/ Documento]";
		assertEquals(saida2, Arrays.toString(this.documento1.criarVisaoPrioritaria(4)));
	} 

	@Test
	void testVisaoTitulo() {
		String saida2 = "[1. Documentos\n"
				+ ", 2. Texto p/ Documento]";
		assertEquals(saida2, Arrays.toString(this.documento1.criarVisaoTitulo()));
	}
}
