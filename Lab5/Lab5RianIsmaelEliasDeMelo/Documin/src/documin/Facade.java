package documin;

/**
 * 
 * Classe que controla o sistema.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Facade {

	/**
	 * Inicia o controlador de documentos.
	 */
    private DocumentoController documentoController;
 
    /**
     * Constroi o facade que inicializa a classe DocumentoController.
     */
    public Facade() { 
        this.documentoController = new DocumentoController();
    }

    /**
     * 
     * Método que cria um documento a partir do título.
     * 
     * @param titulo título do documento.
     * 
     * @return true caso o documento foi criado com sucesso, false do contrário.
     */
    public boolean criarDocumento(String titulo) {
    	boolean cadastro =  this.documentoController.adicionaDocumento(titulo);
        if(cadastro) {
        	return true;
        } else { 
        	return false;
        }
    }
    
    /**
     * 
     * Método que cria um documento a partir do título e tamanho.
     * 
     * @param titulo título do documento.
     * @param tamanhoMaximo tamanho máximo de elementos suportados no documento.
     * 
     * @return true caso o documento foi criado com sucesso, false do contrário.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
    	boolean cadastro =  this.documentoController.adicionaDocumento(titulo, tamanhoMaximo);
        if(cadastro) {
        	return true; // cadastrado.
        } else { 
        	return false; // não cadastrado.
        }
    }
    
	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento mais próximo do final do documento.
	 Caso o elementO esteja no final do documento, ele não é afetado.
	 * 
	 * @param tituloDoc título do documento a ser trocado os elementos.
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizada com sucesso.
	 */
    public boolean moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }

	/**
	 * 
	 * Método que troca a posição do elemento com a do elemento vizinho
	 mais próximo do início do documento. Caso o elemento esteja no na primeira posição, ele não é afetado.
	 * 
	 * @param tituloDoc título do documento a ser trocado os elementos.
	 * @param elementoPosicao posição do elemento a ser trocado.
	 * 
	 * @return true caso a troca seja realizada com sucesso, false caso não tenha sido realizado com sucesso.
	 */
    public boolean moverParaCima(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }

	/**
	 * 
	 * Método que cria a representação resumida de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param tituloDoc título a ser tomado o elemento para gerar a representação resumida.
	 * @param elementoPosicao posição do elemento a ser gerado a representação resumida.
	 * 
	 * @return uma representação resumida de um elemento.
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
	}
	
	/**
	 * 
	 * Método que cria a representação completa de um elemento, pegando o título do documento
	 onde está os elementos e a posição deste elemento que irá ser criado a representação.
	 * 
	 * @param tituloDoc título a ser tomado o elemento para gerar a representação completa.
	 * @param elementoPosicao posição do elemento a ser gerado a representação completa.
	 * 
	 * @return uma representação completa de um elemento.
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
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
    	return this.documentoController.exibirDocumento(titulo);
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
    	return this.documentoController.apagarElemento(titulo, elementoPosicao);
    }
    
	/**
	 * 
	 * Método que remove um documento a partir do título do documento.
	 * 
	 * @param titulo título do documento a ser removido.
	 */
    public void removerDocumento(String titulo) {
    	this.documentoController.removerDocumento(titulo);
    }
    
    /**
     * 
     * Método que cria um texto a partir do título do documento a ser inserido o elemento,
     valor do texto e prioridade.
     * 
     * @param tituloDoc título do documento a ser inserido o texto.
     * @param valor valor do texto.
     * @param prioridade prioridade do texto.
     * 
     * @return a posição do elemento cadastrado.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
    }
    
    /**
     * 
     * Método que cria um título a partir do título do documento a ser inserido o elemento,
     valor do título, prioridade, nível e linkável.
     * 
     * @param tituloDoc título do documento a ser inserido o título.
     * @param valor valor do título.
     * @param prioridade prioridade do título.
     * @param nivel nível do título.
     * @param linkavel linkável do título, valor booleano.
     * 
     * @return a posição do elemento cadastrado.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
    
    /**
     * 
     * Método que cria um elemento lista a partir do título do documento a ser inserido o elemento,
	 prioridade do elemento, separador e o caractere da lista.
     * 
     * @param tituloDoc título do documento a ser inserido a lista.
     * @param valorLista valor da lista.
     * @param prioridade prioridade da lista.
     * @param separador separador da lista
     * @param charLista caractere da lista.
     * 
     * @return a posição do elemento cadastrado.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
    /**
     * 
     * Método que cria um elemento termo a partir do título do documento a ser inserido o elemento,
     prioridade do elemento, valor do termo, prioridade, separador e ordem.
     * 
     * @param tituloDoc título do documento a ser inserido o termo.
     * @param valorTermos valor do termo.
     * @param prioridade prioridade do termo.
     * @param separador separador do termo.
     * @param ordem ordem do termo.
     * 
     * @return a posição do elemento cadastrado.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
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
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    		return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
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
    	return this.documentoController.criarVisaoCompleta(tituloDoc);
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
    	return this.documentoController.criarVisaoResumida(tituloDoc);
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
    	return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
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
    	return this.documentoController.criarVisaoTitulo(tituloDoc);
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
    	return this.documentoController.exibirVisao(visaoId);
    }
}
