package documin;

/**
 * 
 * Abstração de elemento.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public abstract class ElementoAbstract implements Elemento {
	
	/**
	 * prioridade prioridade abstract.
	 */
	private int prioridade;
	
	/**
	 * valor valor abstract.
	 */
	private String valor;

	/**
	 * 
	 * Constroi um Elemento Abstract a partir da prioridade e valor.
	 * 
	 * @param prioridade prioridade abstract.
	 * @param valor valor abstract.
	 */
	public ElementoAbstract(int prioridade, String valor) {
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	/**
	 * Método abstract que gera a representação completa de um elemento.
	 * 
	 * @return a representação completa em String do elemento.
	 */
	public abstract String gerarRepresentacaoCompleta();
	
	/**
	 * Método abstract que gera a representação resumida de um elemento.
	 * 
	 * @return a representação resumida em String do elemento.
	 */
	public abstract String gerarRepresentacaoResumida();
	
	/**
	 * Recupera a prioridade.
	 * 
	 * @return a prioridade em inteiro.
	 */
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Recupera o valor.
	 * 
	 * @return o valor em String.
	 */
	public String getValor() {
		return this.valor;
	}
}
