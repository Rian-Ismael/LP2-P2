package testesDocumin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Texto;
import documin.Titulo;

class testesTitulo {
	
	private Titulo titulo1;
	private Titulo titulo2;
	
	@BeforeEach
	void inicia() {
		this.titulo1 = new Titulo(3, "Documentos Texto", 1, true); // linkavel true
		this.titulo2 = new Titulo(4, "Elementos simples", 3, false); // linkavel false
	}
	
	@Test
	void testGerarRepresentacaoCompletaLinkavelTrue() {
		String saida = "1. Documentos Texto -- 1-DOCUMENTOSTEXTO";
		assertEquals(saida, this.titulo1.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepresentacaoCompletaLinkavelFalse() {
		String saida = "3. Elementos simples";
		assertEquals(saida, this.titulo2.gerarRepresentacaoCompleta());
	}
	
	@Test
	void testGerarRepresentacaoResumidaLinkavelTrue() {
		String saida = "1. Documentos";
		assertEquals(saida, this.titulo1.gerarRepresentacaoResumida());
	}
	
	@Test
	void testGerarRepresentacaoResumidaLnkavelFalse() {
		String saida = "3. Elementos simples";
		assertEquals(saida, this.titulo2.gerarRepresentacaoResumida());
	}
	
	}
