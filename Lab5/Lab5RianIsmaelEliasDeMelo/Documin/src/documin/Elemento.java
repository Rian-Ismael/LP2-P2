package documin;

/**
 * 
 * Interface elemento.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public interface Elemento {
	
	/**
	 * 
	 * Método genérico que gera a representação completa de um elemento.
	 * 
	 * @return a representação completa em String do elemento.
	 */
	public String gerarRepresentacaoCompleta();
	
	/**
	 * Método genérico que gera a representação resumida de um elemento.
	 * 
	 * @return a representação resumida em String do elemento.
	 */
	public String gerarRepresentacaoResumida();
	
	/**
	 * 
	 * Método genérico que recupera a prioridade do elemento.
	 * 
	 * @return a prioridade em inteiro.
	 */
	public int getPrioridade();
	
	/**
	 * Método genérico que recupera o valor do elemento.
	 * 
	 * @return o valor em String.
	 */
	public String getValor();
}
