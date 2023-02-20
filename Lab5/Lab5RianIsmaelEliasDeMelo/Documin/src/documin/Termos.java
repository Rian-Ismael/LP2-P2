package documin;

import java.util.Arrays;
import java.util.Map;

import java.util.HashMap;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Termos extends ElementoAbstract {

	/**
	 * propriedades propriedades armazena os valores do termo em um HashMap.
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * valorArray valor do termo em formato array.
	 */
	private String[] valorArray;
	
	/**
	 * 
	 * Constroi um termo a partir do valor, prioridade, separador e ordem.
	 * 
	 * @param valor valor do termo.
	 * @param prioridade prioridade do termo.
	 * @param separador separador do termo.
	 * @param ordem ordem que irá ordenar o valor do termo.
	 */
	public Termos(String valor, int prioridade, String separador, String ordem) {
		super(prioridade, valor);
		this.valorArray = super.getValor().trim().replaceAll(" ", "").split(separador);
		this.propriedades.put("separador", separador); 
		this.propriedades.put("ordem", ordem);
	}
	
	/**
	 * Método que gera a representação completa do termo.
	 * 
	 * @return uma representação completa em String do termo.
	 */
	public String gerarRepresentacaoCompleta() {
		ordenador();
		String valores = "-";
		for(int i = 0; i < quantidadeDeTermos(); i++) {
			if(i == quantidadeDeTermos()-1) {
				valores += this.valorArray[i];
				
			} else {
				valores += this.valorArray[i] + ", ";
	}
}
		
		return  "Total termos: " + quantidadeDeTermos() + "\n" + valores;
	
	}
	
	/**
	 * Método que gera a representação resumida do termo.
	 * 
	 * @return uma representação resumida em String do texto.
	 */
	public String gerarRepresentacaoResumida() {
		ordenador();
		String separador = this.propriedades.get("separador");
		String valores = "";
		for(int i = 0; i < quantidadeDeTermos(); i++) {
			if(i == quantidadeDeTermos()-1) {
				valores += this.valorArray[i];
			} else {
			valores += this.valorArray[i] + " " + separador + " ";
			}
		}
		return valores;
	} 
	
	/**
	 * 
	 * Método que conta a quantidade de termos do valor.
	 * 
	 * @return retorna a quantidade de termos em inteiro.
	 */
	private int quantidadeDeTermos() {
		String separador = this.propriedades.get("separador");
		int quantidadeDeTermos = super.getValor().split(separador).length;
		return quantidadeDeTermos;

	}
	
	
	/**
	 * Método que ordena o valor de acordo com a ordem especificada para o termo.
	 */
	public void ordenador() {
		String ordem = this.propriedades.get("ordem");
		if(ordem.equals("TAMANHO")) { 
			 Arrays.sort(this.valorArray, new TermosOrdenaTamanho());
		} else if(ordem.equals("ALFABÉTICA")) {
			 Arrays.sort(this.valorArray, new TermosOrdenaAlfabetico());
		} 
	}
}
