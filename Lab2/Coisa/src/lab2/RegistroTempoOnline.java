package lab2;

/**
 * Classe que representa as informacões sobre a quantidade de horas de internet dedicada a uma 
 determinada disciplina remota.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class RegistroTempoOnline {
	
	/**
	 * disciplina define o nome da disciplina
	 */
	private String disciplina;
	
	/**
	 * horasNecessarias define as horas em que o aluno deve dedicar a disciplina.
	 */
	private int horasNecessaria = 120;
	
	/**
	 * horasEstudads define as horas em que o aluno estudou.
	 */
	private int horasEstudadas;

	/**
	 * Constrói um registro de horas dedicadas a disciplina e o nome da disciplina.
	 * 
	 * @param disciplina o nome da disciplina
	 * @param horas as horas a ser dedicada.
	 */
	public RegistroTempoOnline(String disciplina, int horas) {
		this.disciplina = disciplina;
		this.horasNecessaria = horas;
	}
	
	/**
	 * Constrói um registro da disciplina.
	 * 
	 * @param disciplina o nome da disciplina
	 */
	public RegistroTempoOnline(String disciplina) {
		this.disciplina = disciplina;
	}
	
	/**
	 * Adiciona horas estudadas ao registro do aluno.
	 * 
	 * @param horas horas estudadas.
	 */
	public void adicionaTempoOnline(int horas) {
		this.horasEstudadas += horas;
	}
	
	/**
	 * Verifica se atingiu o tempo estabelecido à disciplina.
	 * 
	 * @return verdadeiro se já atingiu o tempo estabelecido de estudos
	 da disciplina.
	 */
	public boolean atingiuMetaTempoOnline() {
		if(this.horasEstudadas >= this.horasNecessaria) {
			return true;
			
		} else {
			return false;
		}
	}
	
	/**
	 * Converte os dados do registro de tempo online em uma String.
	 * 
	 * @return O string com os dados do registro de tempo online da
	 disciplina.
	 * 
	 */
	public String toString() {
		return this.disciplina + " " + this.horasEstudadas + "/" + this.horasNecessaria;
	}
}