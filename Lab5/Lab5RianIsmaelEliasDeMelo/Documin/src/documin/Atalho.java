package documin;

import java.util.List;

/**
 * 
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Atalho extends ElementoAbstract {
	
	/**
	 * Coleção de elementos prioritário.
	 */
	private List<Elemento> elementos;
	
	/**
	 * 
	 * Constroi um atalho a partir da media de prioridade, valor do documento referenciado e elementos com prioridade 
	 4 e 5.
	 * 
	 * @param prioridade media da prioridade.
	 * @param valor valor do documento referenciado.
	 * @param elementos coleção de elementos filtrados.
	 */
	public Atalho(int prioridade, String valor, List<Elemento> elementos) {
		super(prioridade, valor);
		this.elementos = elementos;
	}
 
	/**
	 * Método que gera a representação completa de elementos com prioridade 4 e 5.
	 */
	@Override
	public String gerarRepresentacaoCompleta() {

		String saida = "";
		for(int i = 0; i < this.elementos.size(); i++) {
			if(i == this.elementos.size()-1) {
				saida += this.elementos.get(i).gerarRepresentacaoCompleta();
			} else {
				saida += this.elementos.get(i).gerarRepresentacaoCompleta() + "\n";
			}
		}
		
		return saida;
	}

	/**
	 * Método que gera a representação resumida de elementos com prioridade 4 e 5.
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String saida = "";
		for(int i = 0; i < this.elementos.size(); i++) {
			if(i == this.elementos.size()-1) {
				saida += this.elementos.get(i).gerarRepresentacaoResumida();
			} else {
				saida += this.elementos.get(i).gerarRepresentacaoResumida() + "\n";
			}
		}
		
		return saida;
	}	
}
