package documin;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Titulo extends ElementoAbstract {
	
	/**
	 * propriedades propriedades armazena os valores do título em um HashMap. 
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * Constroi um título a partir da prioridade, valor, nivel e linkavel do mesmo.
	 * 
	 * @param prioridade prioridade do título.
	 * @param valor valor do título.
	 * @param nivel nível do título;
	 * @param linkavel linkável do título
	 */
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		String nivelString = String.valueOf(nivel);
		this.propriedades.put("nivel", nivelString);
		String linkavelString = String.valueOf(linkavel);
		this.propriedades.put("linkavel", linkavelString);
	} 
	  
	/**
	 * Método que gera a representação completa do título, analisando o linkável do título, caso seja true
	 gera uma representação diferente e outra distinta para linkavel false.
	 * 
	 * @return uma representação completa em String do título.
	 */
	public String gerarRepresentacaoCompleta() {
		String linkavel = this.propriedades.get("linkavel");
		String nivel = this.propriedades.get("nivel");
		if(linkavel.equals("true")) {
		return nivel + ". " + super.getValor() + " -- " + nivel + "-" + super.getValor().replace(" ", "").toUpperCase(); // NÃO TIRAR REPLACE
		} else {
			return nivel + ". " + super.getValor();
		}
	}

	/**
	 * Método que gera a representação resumida do título.
	 * 
	 * @return uma representação resumida em String do título.
	 */
	public String gerarRepresentacaoResumida() {
		String linkavel = this.propriedades.get("linkavel");
		String nivel = this.propriedades.get("nivel");
		if(linkavel.equals("true")) {
		String primeiraPalavra = super.getValor().split(" ")[0];
		return nivel + ". " + primeiraPalavra;
		} else {
			return nivel + ". " + super.getValor(); 
		}
	}


}
