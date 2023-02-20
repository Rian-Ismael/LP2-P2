package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 
 * Classe que controla as operações de documento,
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class DocumentoController {
	
	/**
	 * documentos documentos armazena os documentos cadastrados em um Map.
	 */
	private Map<String, Documento> documentos; 
	
	/**
	 * Coleção de visões.
	 */
	private List<String[]> visoes;
	
	/**
	 * Constroi um controlador de documentos.
	 */
	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}
	
	/**
	 * Método que cria e adiciona um documento que há somente título.
	 * 
	 * @param titulo título do documento.
	 * 
	 * @return true caso o documento tenha sido criado e inserido no Map de documentos,
	 falso caso contrário.
	 */
	public boolean adicionaDocumento(String titulo) {
		if(!verificaExistenciaDocumento(titulo)) {
		this.documentos.put(titulo, new Documento(titulo)); 
		//this.documentosCadastrados += 1;
		return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 * Método que cria e adiciona um documento que há título e tamanho.
	 * 
	 * @param titulo título do documento.
	 * @param tamanho tamanho do documento.
	 * 
	 * @return true caso o documento tenha sido criado e inserido no Map de documentos,
	 falso caso contrário.
	 */
	public boolean adicionaDocumento(String titulo, int tamanho) {
		if(!verificaExistenciaDocumento(titulo) && tamanho > 0) {
		this.documentos.put(titulo, new Documento(titulo));
		//this.documentosCadastrados += 1;
		return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Método que lança a exceção NoSuchElementException caso o título não exista no Map
	 de documentos.
	 * 
	 * @param titulo título do documento a ser analisado.
	 */
	private void lancaNoSuchElementException(String titulo) {
		if(!(verificaExistenciaDocumento(titulo))) { 
			throw new NoSuchElementException("Título não existe");
		}
	}
	
	/**
	 * 
	 * Método que verifica se já existe um documento.
	 * 
	 * @param titulo título do documento a ser analisado.
	 * 
	 * @return true caso o documento exista, falso caso não exista.
	 */
	private boolean verificaExistenciaDocumento(String titulo) {
		return this.documentos.containsKey(titulo);
	}
	
	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento vizinho
	 mais próximo do início do documento. Caso o elemento esteja no na primeira posição, ele não é afetado.
	 * 
	 * @param titulo título do documento a ser trocado os elementos.
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizado com sucesso.
	 */
	public boolean moverParaCima(String titulo, int elementoPosicao) {
		lancaNoSuchElementException(titulo);
		return this.documentos.get(titulo).moverElementoPosicaoAcima(elementoPosicao);
	}
	
	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento mais próximo do final do documento.
	 Caso o elementO esteja no final do documento, ele não é afetado.
	 * 
	 * @param titulo título do documento a ser trocado os elementos.
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizada com sucesso.
	 */
	public boolean moverParaBaixo(String titulo, int elementoPosicao) {
		lancaNoSuchElementException(titulo);
		return this.documentos.get(titulo).moverElementoPosicaoAbaixo(elementoPosicao);
	}
	
	/**
	 * 
	 * Método que cria uma exibição do documento em Array.
	 * 
	 * @param titulo título a ser criado a exibição.
	 * 
	 * @return a exibição do documento em um array de String.
	 */
	public String[] exibirDocumento(String titulo) {
		lancaNoSuchElementException(titulo);
		return this.documentos.get(titulo).exibirDocumento();
	}
	
	/**
	 * 
	 * Método que cria a representação resumida de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param titulo título a ser tomado o elemento para gerar a representação resumida.
	 * @param elementoPosicao posição do elemento a ser gerado a representação resumida.
	 * 
	 * @return uma representação resumida de um elemento.
	 */
	public String pegarRepresentacaoResumida(String titulo, int elementoPosicao) {
		lancaNoSuchElementException(titulo);
		Documento documento = this.documentos.get(titulo);
		return documento.pegarRepresentacaoResumida(elementoPosicao);
	}
	
	/**
	 * 
	 * Método que cria a representação completa de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param titulo título a ser tomado o elemento para gerar a representação completa.
	 * @param elementoPosicao posição do elemento a ser gerado a representação completa.
	 * 
	 * @return uma representação completa de um elemento.
	 */
	public String pegarRepresentacaoCompleta(String titulo, int elementoPosicao) {
		lancaNoSuchElementException(titulo);
		Documento documento = this.documentos.get(titulo);
		return documento.pegarRepresentacaoCompleta(elementoPosicao);
	}
	
	/**
	 * 
	 * Método que remove um documento a partir do título do documento.
	 * 
	 * @param titulo título do documento a ser removido.
	 */
	public void removerDocumento(String titulo) {
		lancaNoSuchElementException(titulo);
		this.documentos.remove(titulo);
	}
	
	/**
	 * 
	 * Método que conta a quantidade de documentos inseridos no Map de documentos.
	 * 
	 * @return a quantidade de documentos no Map em inteiro.
	 */
	public int getQtDocumentos() {
		return this.documentos.size();
	}
	
	/**
	 * 
	 * Método que apaga um elemento de um documento a partir do título do documento e
	 a posição do elemento que irá ser apagado.
	 * 
	 * @param titulo título do documento analisado.
	 * @param elementoPosicao posição do elemento que irá recuperar o elemento para ser apagado.
	 * 
	 * @return true caso o elemento tenha sido apagado com sucesso, false do contrário.
	 */
	public boolean apagarElemento(String titulo, int elementoPosicao) {
		lancaNoSuchElementException(titulo);
		return this.documentos.get(titulo).apagarElemento(elementoPosicao);
	}
	
	/**
	 * 
	 * Método que cria um elemento lista a partir do título do documento a ser inserido o elemento,
	 prioridade do elemento, separador e o caractere da lista.
	 * 
	 * @param titulo título do documento a ser inserido a lista.
	 * @param valorLista valor da lista.
	 * @param prioridade prioridade da lista.
	 * @param separador separador da lista.
	 * @param charLista caractere da lista.
	 * 
	 * @return a posição do elemento cadastrado.
	 */
	public int criarLista(String titulo, String valorLista, int prioridade, String separador, String charLista) {
		lancaNoSuchElementException(titulo);
		return documentos.get(titulo).adicionarElemento(new Lista(prioridade, charLista, separador, valorLista));
	}

	/**
	 * 
	 * Método que cria um elemento texto a partir do título do documento a ser inserido o elemento,
	 prioridade do elemento e valor.
	 * 
	 * @param titulo título do documento a ser inserido o texto.
	 * @param valor valor do texto.
	 * @param prioridade prioridade do texxto.
	 * 
	 * @return a posição do elemento cadastrado.
	 */
	public int criarTexto(String titulo, String valor, int prioridade){
		lancaNoSuchElementException(titulo);
		return documentos.get(titulo).adicionarElemento(new Texto(prioridade, valor));
	}

	/**
	 * 
	 * Método que cria um termo a partir do título do documento a ser inserido o elemento,
	 valor do texto, prioridade, separador e ordem a ser ordenado o termo.
	 * 
	 * @param titulo título do documento a ser inserido o termo.
	 * @param valorTermos valor do termo.
	 * @param prioridade prioridade do termo.
	 * @param separador separador do termo.
	 * @param ordem ordem do termo.
	 * 
	 * @return a posição do elemento cadastrado.
	 */
	public int criarTermos(String titulo, String valorTermos, int prioridade, String separador, String ordem) {
		lancaNoSuchElementException(titulo);
		return documentos.get(titulo).adicionarElemento(new Termos(valorTermos, prioridade, separador, ordem));
	}
	
	/**
	 * 
	 * Método que cria um título a partir do título do documento a ser inserido o elemento,
	 valor do título, prioridade, nivel e linkável.
	 * 
	 * @param titulo título do documento a ser inserido o título.
	 * @param valor valor do título.
	 * @param prioridade prioridade do título.
	 * @param nivel nível do título.
	 * @param linkavel linkável do título, valor booleano.
	 * 
	 * @return a posição do elemento cadastrado.
	 */
	public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
		lancaNoSuchElementException(titulo);
		return documentos.get(titulo).adicionarElemento(new Titulo(nivel, valor, prioridade, linkavel));
	}
	
    /**
     * 
     * Método que cria a visão a partir do título.
     * 
     * @param tituloDoc título a ser criado a visão completa.
     * 
     * @return a posição da visão criada.
     */
	public int criarVisaoCompleta(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		 this.visoes.add(this.documentos.get(tituloDoc).criarVisaoCompleta());
		 return this.visoes.size()-1;
	}
	
    /**
     * 
     * Método que cria a visão a partir do título.
     * 
     * @param tituloDoc título a ser criado a visão resumida.
     * 
     * @return a posição da visão criada.
     */
	public int criarVisaoResumida(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoResumida());
		return this.visoes.size()-1;
	}
	
    /**
     * 
     * Método que cria a visão a partir do título.
     * 
     * @param tituloDoc título a ser criado a visão prioritaria.
     * @param prioridade prioridade adotada para criar a visao
     * 
     * @return a posição da visão criada.
     */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		lancaNoSuchElementException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoPrioritaria(prioridade));
		return this.visoes.size()-1;
	}
	
    /**
     * 
     * Método que cria a visão a partir do título.
     * 
     * @param tituloDoc título a ser criado a visão prioritaria.
     * 
     * @return a posição da visão criada.
     */
	public int criarVisaoTitulo(String tituloDoc) {
		lancaNoSuchElementException(tituloDoc);
		this.visoes.add(this.documentos.get(tituloDoc).criarVisaoTitulo());
		return this.visoes.size()-1;	
	}
	
    /**
     * 
     * Método que cria um atalho a partir do título e título referenciado.
     * 
     * @param tituloDoc título a receber o atalho.
     * @param tituloDocReferenciado título referenciado.
     * 
     * @return a posição do atalho criado.
     */
	public int criarAtalho(String titulo, String tituloReferenciado) {
		lancaNoSuchElementException(titulo);
		lancaNoSuchElementException(tituloReferenciado);
		Documento tituloDoc = this.documentos.get(titulo);
		Documento tituloRefenc = this.documentos.get(tituloReferenciado);
		int posicao = -1;
		if((!tituloRefenc.temAtalhos() && !tituloDoc.getSouAtalho())) {
			
			int prioridade = tituloRefenc.mediaPrioridade();
			String tituloDoDocRef = tituloRefenc.getTitulo();
			ArrayList<Elemento> elementosPrioritariosRef = tituloRefenc.getElementosPrioritarios();
			
			Atalho atalho = new Atalho(prioridade, tituloDoDocRef, elementosPrioritariosRef);
			posicao = tituloDoc.addAtalho(atalho);
			tituloRefenc.setSouAtalho();
			
		} else {
			throw new IllegalStateException();
		}
		
		return posicao;
	}
	
    /**
     * 
     * Método que exibe a visão criada a partir do Id da visão.
     * 
     * @param visaoId posição da visao na coleção.
     * 
     * @return a visão em representação de array de String.
     */
	public String[] exibirVisao(int visaoId) {
		int tamanho = this.visoes.size()-1; 
		if(visaoId <= tamanho && visaoId >= 0) {
			return this.visoes.get(visaoId);
		}
		String[] saida = {"Visão não existente"};
		return saida;
	}
	
	/**
	 * 
	 * Recupera o documento.
	 * 
	 * @param titulo titulo do documento a ser recuperado.
	 * 
	 * @return o documento.
	 */
	public Documento getDocumento(String titulo) {
		return this.documentos.get(titulo);
	}
}