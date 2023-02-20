package lab2;
import java.util.*;

/**
 * Classe que representa o controle de notas e cálculo da média de uma
 determinada disciplina cadastrada.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Disciplina {
	
	/**
	 * disciplina define o nome da disciplina.
	 */
	private String disciplina;
	
	/**
	 * horasEstudo define as horas de estudo do aluno.
	 */
	private int horasEstudo;
	
	/**
	 * notas define um array com as notas contidas do aluno.
	 */
	private double[] notas = new double[4];
	
	/**
	 * numNotas define o número de notas do aluno.
	 */
	private int numNotas;
	
	/**
	 * pesoNotas define o peso das notas do aluno.
	 */
	private int[] pesoNotas;
	
	/**
	 * Constrói uma disciplina, o número de notas dela e sua carga horária.
	 * 
	 * @param disciplina disciplina é o nome da disciplina.
	 * @param numNotas numNotas é a quantidade de notas do aluno.
	 * @param pesoNotas pesoNotas é o peso de cada nota do aluno.
	 */
	public Disciplina(String disciplina, int numNotas, int[] pesoNotas) {
		this.disciplina = disciplina;
		this.numNotas = numNotas;
		this.pesoNotas = pesoNotas;
		this.notas = new double[numNotas];
		this.pesoNotas = pesoNotas;
	}
	

	 /**
     * Constrói uma disciplina e o número de notas.
	 * 
	 * @param disciplina disciplina é o nome da disciplina.
	 * @param numNotas numNotas é a quantidade de notas do aluno.
	 */
	public Disciplina(String disciplina, int numNotas) {
		this.numNotas = numNotas;
		this.disciplina = disciplina;
		this.notas = new double[numNotas];
		this.pesoNotas = new int[] {};
	}
	/**
	 * Constrói uma discplina.
	 * @param disciplina disciplina é o nome da disciplina.
	 */
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
		
	}

	/** 
	 * Calcula a média ponderada das notas do aluno.
	 * 
	 * @return a média ponderada das notas do aluno.
	 */
	public double calculaMediaPonderada() {
		int somaDeNotas = 0;
		int somaDePeso = 0;
		if (this.pesoNotas.length == 0) {
			return calculaMedia();
		}
		for(int i = 0; i < this.numNotas; i++) {
			somaDeNotas += this.pesoNotas[i] * this.notas[i];
			somaDePeso += this.pesoNotas[i];
		}
		return (somaDeNotas / somaDePeso);
	}

	/**
	 * Define a quantidade de horas estudadas por o aluno.
	 * 
	 * @param horasEstudadas horas estudas por o aluno.
	 */
	public void cadastraHoras(int horasEstudadas) {
		this.horasEstudo = horasEstudadas;
	}
	
	/**
	 * Cadastra a nota do aluno.
	 * 
	 * @param posicaoNota posicao nota em que a nota será inserida
	 * @param valorNota valor da nota do aluno.
	 */
	public void cadastraNota(int posicaoNota, double valorNota) {
		this.notas[posicaoNota-1] = valorNota;
	}

	/**
	 * Calcula a média das notas do aluno.
	 * 
	 * @return a média das notas.
	 */
	private double calculaMedia() {
		double media = 0.0;
		for(int i = 0; i <= notas.length-1; i++) {
			media += notas[i];
		}
		return media/this.notas.length;
	}
	
	/**
	 * Verifica se o aluno foi aprovado a partir das médias de sua nota.
	 * 
	 * @return verdadeiro se o aluno for aprovado, falso caso contrário.
	 */
	public boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Transforma os dados da disciplina.
	 * 
	 * @return O string com os dados da disciplina.
	 */
	public String toString() {
		return this.disciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
	}
}