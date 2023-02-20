package documin;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Documento {
	
	/**
	 * Coleção de atalhos.
	 */
	private List<Atalho> atalhos;

	/**
	 * Boolean que verifica se o documento é atalho.
	 */
	private boolean souAtalho;
	
	/**
	 * título do documento.
	 */
	private String titulo; 
	
	/**
	 * quantidade de elementos suportados no documento.
	 */
	private int tamanho; 
	
	/**
	 * Coleção de elementos.
	 */
	private List<Elemento> elementosDoc;

	/**
	 * 
	 * Constroi um documento a partir do título e tamanho.
	 * 
	 * @param titulo título do documento.
	 * @param tamanho tamanho do documento. 
	 */
	public Documento(String titulo, int tamanho) {
		if(tamanho <= 0 ) {
			throw new IllegalArgumentException("tamanho inválido");
		}
		if(titulo.equals("") || verificaEspaco(titulo)) {
			throw new IllegalArgumentException("Titulo vazio ou contendo somente espaços");
		}
		this.tamanho = tamanho; 
		this.titulo = titulo;
		this.elementosDoc = new ArrayList<Elemento>();
		this.atalhos = new ArrayList<Atalho>();
	}
	
	/**
	 * Constroi um documento a partir do título.
	 * 
	 * @param titulo título do documento.
	 */
	public Documento(String titulo) {
		this.tamanho = -1;
		if(titulo.equals("") || verificaEspaco(titulo)) {
			throw new IllegalArgumentException("Titulo vazio ou contendo somente espaços");
		}
		this.titulo = titulo;
		this.elementosDoc = new ArrayList<Elemento>();
		this.atalhos = new ArrayList<Atalho>();
	}
	
	/**
	 * 
	 * Método que verifica se o título do documento é composta somente de espaços.
	 * 
	 * @param titulo título do documento.
	 * 
	 * @return true caso seja composta somente de espaços, do contrário false.
	 */
	private boolean verificaEspaco(String titulo) {
		String tituloSemEspaco = titulo.replace(" ", ""); 
		if(tituloSemEspaco.equals("")) {
			return true;
		} else { 
			return false;
		}	
	}
	 
	/**
	 * 
	 * Método que adiciona um elemento na coleção de elementos.
	 * 
	 * @param elemento elemento a ser adicionado na coleção.
	 * 
	 * @return a posição do elemento adicionado.
	 */
	public int adicionarElemento(Elemento elemento) {
		if(this.elementosDoc.size() < this.tamanho) {
			this.elementosDoc.add(elemento);
		} else if (this.elementosDoc.size() == this.tamanho) {
			return -2; // Coleção de Elementos do Documento já preenchido.
		} else if(this.tamanho == -1) {
			this.elementosDoc.add(elemento);
		}
		return this.elementosDoc.size()-1;
		
	}

	/**
	 * 
	 * Método que verifica se o elemento a ser analisado existe.
	 * 
	 * @param elementoPosicao posição do possível elemento a ser verificado.
	 * 
	 * @return true caso o elemento exista, false do contrário.
	 */
	private boolean existeElemento(int elementoPosicao)  { 
		if((elementoPosicao > this.elementosDoc.size()-1 || elementoPosicao < 0)) {
			return false;
		}
		Elemento comparador = this.elementosDoc.get(elementoPosicao);
		return this.elementosDoc.contains(comparador);
	}
	 
	/**
	 * 
	 * Método que valida a posição na coleção de elementos.
	 * 
	 * @param elementoPosicao posição do elemento a ser verificado.
	 * 
	 * @return true caso a posição seja válida, false do contrário.
	 */
	private boolean validadorTamanho(int elementoPosicao) {
		boolean saida = false;
		if(elementoPosicao >= 0 && elementoPosicao < this.elementosDoc.size()) {
			saida = true;
		}
		return saida;
	}

	/**
	 * 
	 * Método que apaga um elemento a partir da posição do elemento.
	 * 
	 * @param elementoPosicao posição onde se encontra o elemento a ser apagado.
	 * 
	 * @return true caso o elemento foi apagado, false do contrário.
	 */
	public boolean apagarElemento(int elementoPosicao) {
		if(existeElemento(elementoPosicao) || (elementoPosicao < this.elementosDoc.size() && elementoPosicao >= 0)) {
			this.elementosDoc.remove(elementoPosicao);
			return true; // apagou o elemento.
		
	}  else { 
		return false; // não apagou o elemento / não existe
		}
	}	
	
	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento vizinho
	 mais próximo do início do documento. Caso o elemento esteja no na primeira posição, ele não é afetado.
	 * 
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizado com sucesso.
	 */
	public boolean moverElementoPosicaoAcima(int elementoPosicao) {
		boolean saida = false;
		if(elementoPosicao == 0) {
			saida = false;
		} else if (validadorTamanho(elementoPosicao)) {
			this.elementosDoc.get(elementoPosicao-1);
			Collections.swap(elementosDoc, elementoPosicao, elementoPosicao-1);
			saida = true;
		}
		return saida;
	}
	
	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento mais próximo do final do documento.
	 Caso o elementO esteja no final do documento, ele não é afetado.
	 * 
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizada com sucesso.
	 */
	public boolean moverElementoPosicaoAbaixo(int elementoPosicao) {
		boolean saida = false;
		if(elementoPosicao == this.elementosDoc.size()-1) {
			saida = false;
		} else if (validadorTamanho(elementoPosicao)) {
			this.elementosDoc.get(elementoPosicao);
			Collections.swap(elementosDoc, elementoPosicao, elementoPosicao+1);
			saida = true;
		}
		return saida;
	}
	
	/**
	 * 
	 * Método que cria uma exibição do documento em Array.
	 * 
	 * @return a exibição do documento em um array de String.
	 */
	public String[] exibirDocumento() {
		String[] documentoImpresso = new String[this.elementosDoc.size()];
		
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(i == this.elementosDoc.size()-1) {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoCompleta();
			} else {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoCompleta() + "\n";
			}
			
		}
		
		return documentoImpresso;
		
	}
	
	/**
	 * 
	 * Método que conta a quantidade de elementos na coleção de elementos.
	 * 
	 * @return a quantidade de elementos na coleção de elementos,
	 */
	public int contarElemento() {
		return this.elementosDoc.size();
	}
	
	/**
	 * 
	 * Método que cria a representação completa de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param elementoPosicao posição do elemento a ser gerado a representação completa.
	 * 
	 * @return uma representação completa de um elemento.
	 */
	public String pegarRepresentacaoCompleta(int elementoPosicao) {
		Elemento elemento = this.elementosDoc.get(elementoPosicao);
		return elemento.gerarRepresentacaoCompleta(); 
	}
	
	/**
	 * 
	 * Método que cria a representação resumida de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param elementoPosicao posição do elemento a ser gerado a representação resumida.
	 * 
	 * @return uma representação resumida de um elemento.
	 */
	public String pegarRepresentacaoResumida(int elementoPosicao) {
//		System.out.println(this.elementosDoc.get(elementoPosicao).gerarRepresentacaoResumida());
		Elemento elemento = this.elementosDoc.get(elementoPosicao);
		return elemento.gerarRepresentacaoResumida();
	}
	
	/**
	 * Método que cria um hashCode para o documento.
	 * 
	 * @return hashCode gerado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	/**
	 * Método que compara se dois objetos são iguais.
	 * 
	 * @return true se os objetos são iguais, false do contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}

	/**
	 * 
	 * Método que cria visão completa do documento.
	 * 
	 * @return a representação em array de String da visão completa.
	 */
	public String[] criarVisaoCompleta() { 
		String[] documentoImpresso = new String[this.elementosDoc.size()];
		
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(i == this.elementosDoc.size()-1) {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoCompleta();
			} else {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoCompleta() + "\n";
			}
			
		}
		return documentoImpresso;
	}
	
	/**
	 * 
	 * Método que cria visão resumida do document.
	 * 
	 * @return a representação em array de String da visão resumida.
	 */
	public String[] criarVisaoResumida() {
		String[] documentoImpresso = new String[this.elementosDoc.size()];
		
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(i == this.elementosDoc.size()-1) {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoResumida();
			} else {
				documentoImpresso[i] = this.elementosDoc.get(i).gerarRepresentacaoResumida() + "\n";
			}
			
		}
		return documentoImpresso;
	}
	
	private int contadorPrioritario(int prioridade) {
		Integer qt = 0;
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(this.elementosDoc.get(i).getPrioridade() >= prioridade) {
				qt++;
			}
		}
		return qt;
	}
	
	/**
	 * 
	 * Método que cria visão prioritaria do documento.
	 * 
	 * @param prioridadeAdotada prioridade a ser adotada para filtrar elementos.
	 * 
	 * @return a representação em array de String da visão prioritaria.
	 */
	public String[] criarVisaoPrioritaria(int prioridadeAdotada) {
		String[] documentoImpresso = new String[contadorPrioritario(prioridadeAdotada)];
		int j = 0;
		for(int i = 0; i < this.elementosDoc.size(); i++) { 
			boolean verifica = this.elementosDoc.get(i).getPrioridade() >= prioridadeAdotada;
				if((j == contadorPrioritario(prioridadeAdotada)-1) && verifica) {
					documentoImpresso[j] = this.elementosDoc.get(i).gerarRepresentacaoCompleta();
					j++;
				} else if(verifica && j < contadorPrioritario(prioridadeAdotada)) {
					documentoImpresso[j] = this.elementosDoc.get(i).gerarRepresentacaoCompleta() + "\n";
					j++;
				}
		}
		return documentoImpresso;
	}
	
	private int contadorTitulo() {
		Integer qt = 0;
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(this.elementosDoc.get(i) instanceof Titulo) {
				qt++;
			}
		}
		return qt;
	}
	
	/**
	 * 
	 * Método que cria visão titulo do documento.
	 * 
	 * @return a representação em array de String da visão titulo.
	 */
	public String[] criarVisaoTitulo() {
		String[] documentoImpresso = new String[contadorTitulo()];
		int j = 0;
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			if(this.elementosDoc.get(i) instanceof Titulo) {
				if(i == this.elementosDoc.size()-1) {
					documentoImpresso[j] = this.elementosDoc.get(i).gerarRepresentacaoResumida();
					j++;
				} else {
					documentoImpresso[j] = this.elementosDoc.get(i).gerarRepresentacaoResumida() + "\n";
					j++;
				}
			}
			
		}
		return documentoImpresso;
	}
	
	/**
	 * 
	 * Método que calcula a média da prioridade
	 * 
	 * @return Inteiro representando a media das prioridades.
	 */
	public int mediaPrioridade() {
		int media = 0;
		for(int i = 0; i < this.elementosDoc.size(); i++) {
			media += this.elementosDoc.get(i).getPrioridade();
		}
		if(this.elementosDoc.size() == 0) {
			return media;
		}
		return media/this.elementosDoc.size();
	}
	
	/**
	 * 
	 * Método que verifica se o documento tem atalho.
	 * 
	 * @return true caso já tenha atalho, false do contrário.
	 */
	public boolean temAtalhos() {
		return this.atalhos.size() > 0;
	}
	
	/**
	 * Método que altera o estado do atributo souAtalho.
	 */
	public void setSouAtalho() {
		this.souAtalho = true;
	}
	
	/**
	 * 
	 * Recupera o souAtalho do documento.
	 * 
	 * @return true caso seja atalho, false do contrário.
	 */
	public boolean getSouAtalho() {
		return this.souAtalho;
	}
	
	/**
	 * 
	 * Recupera um atalho.
	 * 
	 * @param id posição do atalho.
	 * 
	 * @return o atalho.
	 */
	public Atalho getAtalho(int id) {
		return this.atalhos.get(id);
	}
	
	/**
	 * 
	 * Recupera o título do documento.
	 * 
	 * @return o título em representação String.
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * 
	 * Adiciona um atalho na coleção de atalhos.
	 * 
	 * @param atalho atalho a ser adicionado.
	 * 
	 * @return a posição do atalho.
	 */
	public int addAtalho(Atalho atalho) {
		this.atalhos.add(atalho);
		return this.atalhos.size()-1;
	}
	
	/**
	 * 
	 * Método que filtra a coleção de Elementos com prioridade 4 e 5.
	 * 
	 * @return um arraylist com elementos de prioridade 4 e 5.
	 */
	public ArrayList<Elemento> getElementosPrioritarios() {
		ArrayList<Elemento> elementosPrioritarios = new ArrayList<>();
		for(Elemento elemento : this.elementosDoc) {
			if(elemento.getPrioridade() >= 4) {
				elementosPrioritarios.add(elemento);
			}
		}
		return elementosPrioritarios;
	}
}
