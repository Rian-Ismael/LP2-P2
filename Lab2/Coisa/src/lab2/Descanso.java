package lab2;

/** 
 * Classe representa o acompanhamento de descanso do aluno no controle
 Institucional da Situacao Acadêmica. Organiza seu tempo de uso de internet
 nas disciplinas.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Descanso {
	/**
	 * horas Define quantas horas o aluno descansou.
	 */
	private int horas;
	/**
	 * emoji define a expressao atual do aluno.
	 */
	private String emoji = "";
	/**
	 * semanas expressa o tempo em que o aluno descansa e estuda.
	 */
	private int semanas;
	/**
	 * condicao expressa a condicao atual do aluno.
	 */
	private String condicao = "cansado";
	
	/** 
	 * Constrói um registro de descanso de um aluno.
	 * 
	 */
	public Descanso() {
	}
	
	/**
	* Define as horas descansadas.
	* 
	* @param horas horas descansadas do aluno
	* 
	*/
	public void defineHorasDescanso(int horas) {
	        this.horas = horas;
	        String condicaoAntes = this.condicao;
	        verificaEstado();
	        if (!this.condicao.equals(condicaoAntes)) {
	        	this.emoji = "";
	        }
	    }
	
	/**
	 * Define o numero de semanas que foi submetido para estudo e descansar.
	 * 
	 * @param semanas definida para descanso e estudo.
	 */
	public void defineNumeroSemanas(int semanas) {
	        this.semanas = semanas;
	        String condicaoAntes = this.condicao;
	        verificaEstado();
	        
	        if(!(this.condicao.equals(condicaoAntes))) {
	        	this.emoji = "";
	             }
	    }
	
	/**
	 * Verifica o estado atual do aluno, se está cansado ou descansado.
	 */
	private void verificaEstado() {
        if(horas >= 26 && semanas == 1) {
            this.condicao = "descansado";

        } else {
            this.condicao = "cansado";
        }
    }
	
	/**
	 * Define a última sensacao de sentimento do aluno.
	 * 
	 * @param emoji emoji expressa estado de saúde geral do aluno.
	 */
	public void definirEmoji(String emoji) {
		this.emoji = " - ";
		this.emoji += emoji;
	}
	
	/**
	 * Relatório de condicao do aluno e o emoji que expressa seu estado de saúde.
	 * 
	 * @return a representacao em String do estado atual do aluno.
	 */
	public String getStatusGeral() {
		return this.condicao + this.emoji;
	}
}