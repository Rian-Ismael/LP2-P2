package ControleAlunos;

import java.util.Objects;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 *
 */
public class Aluno {

	/**
	 * Matrícula do aluno.
	 */
	private String matricula;
	
	/**
	 * Nome do aluno.
	 */
	private String nome;
	
	/**
	 * Nome do curso do aluno.
	 */
	private String curso;
	
	/**
	 * 
	 * Constroi um aluno a partir da matrícula, nome e curso.
	 * 
	 * @param matricula Matrícula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
	 if(matricula == null) {
		throw new NullPointerException("matrícula nula");
	} else if(nome == null) {
		throw new NullPointerException("nome nulo");
	} else if(curso == null) {
		throw new NullPointerException("curso nulo");
	}
	if(matricula.equals("")) {
		throw new IllegalArgumentException("matrícula vazia");
	} if(nome.equals("")) {
		throw new IllegalArgumentException("nome vazio");
	} if (curso.equals("")){
		throw new IllegalArgumentException("curso vazio");
	}

    	this.matricula = matricula;
    	this.nome = nome;
    	this.curso = curso;
    	}
	
	/**
	 * 
	 * Recupera a matŕicula do aluno.
	 * 
	 * @return a matrícula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Metodo que cria um HashCode para o aluno a partir da matricula do mesmo.
	 * 
	 * @return o hashcode gerado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	/**
	 * Metodo que compara se dois alunos são iguais.
	 * @return true se os objeto e da classe Aluno e se tem a mesma matricula ou false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	/**
	 * 
	 * Cria a representação em String do aluno, com matrícula, nome e curso.
	 * 
	 * @return a representação em String do aluno.
	 */
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}
}