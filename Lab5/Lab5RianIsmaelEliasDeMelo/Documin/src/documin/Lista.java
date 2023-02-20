package documin;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Lista extends ElementoAbstract {
	
	/**
	 * propriedades propriedades armazena os valores da lista em um HashMap. 
	 */
	private Map<String, String> propriedades = new HashMap<String, String>();
	
	/**
	 * 
	 * Constroi uma lista a partir da prioridade, valor, separador e caractere da lista.
	 * 
	 * @param prioridade prioridade da lista.
	 * @param valor valor da lista.
	 * @param separador separador da lista.
	 * @param charLista charLista da lista.
	 */
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(prioridade, valor);
		this.propriedades.put("charLista", charLista);
		this.propriedades.put("separador", separador);
	} 
	
	/**
	 * 
	 * Método que gera a representação completa da lista.
	 * 
	 * @return uma representação completa em String da lista.
	 */
	public String gerarRepresentacaoCompleta() {
		String separador = this.propriedades.get("separador");
		String charLista = this.propriedades.get("charLista");
		
		String[] fraseSeparada = super.getValor().split(" " + separador + " ");

		String representacao = "";
		for(int i = 0; i < fraseSeparada.length; i++) {
			if(i == fraseSeparada.length-1) {
				representacao += (charLista + " " + fraseSeparada[i]);
			} else { 
				representacao += (charLista + " " + fraseSeparada[i]) + "\n";
			}
		}

		return representacao;
	}
	 
	/**
	 * Método que gera a representação resumida da lista.
	 * 
	 * @return uma representação resumida em String da lista.
	 */ 
	public String gerarRepresentacaoResumida() {
		String separador = this.propriedades.get("separador");
		String[] fraseSeparada = super.getValor().split(" " + separador + " ");
		String representacao = ""; 
		
		for(int i = 0; i < fraseSeparada.length; i++) {
			
			if(i < fraseSeparada.length-1) {
				representacao += fraseSeparada[i] + " " + separador + " ";
				
		} else { 
			representacao += fraseSeparada[i];
		}
	}
		return representacao;
}

}
