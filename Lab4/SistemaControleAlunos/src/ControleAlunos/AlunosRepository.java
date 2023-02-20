package ControleAlunos;
import java.util.*;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class AlunosRepository {

	/**
	 * HashMap em que armazena os alunos a serem criados.
	 */
    private HashMap<String, Aluno> alunos;
    
    /**
     * Constroi um HashMap de alunos.
     */
    public AlunosRepository() {
    	this.alunos = new HashMap<>();
    }

    /**
     * 
     * Verifica se o aluno existe a partir da matrícula.
     * 
     * @param matricula Matrícula do aluno.
     * @return true caso o aluno exista, do contrário o aluno não existe.
     */
    public boolean consultaAlunos(String matricula) {
    	if(verificaAluno(matricula)) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     * Verifica se o aluno existe em alunos.
     * 
     * @param matricula Matrícula do aluno.
     * @return true caso o aluno exista, do contrário False.
     */
    private boolean verificaAluno(String matricula) {
    	return this.alunos.containsKey(matricula);
	}

    /**
     * 
     * Cadastra um aluno a partir da matricula, nome e curso.
     * 
     * @param matricula Matrícula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     * @return true caso a matrícula foi cadastrada, do contrário a matrícula não foi cadastrada.
     */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		boolean retorno = false;
    	if(verificaAluno(matricula)) {
    		retorno = false;
    		// "Matrícula já cadastrada";
    	} else {
    		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
    		retorno =  true;
    		// "Matricula cadastrada";
    	}
    	return retorno;
    }
	
	/**
	 * 
	 * Recupera um aluno a partir da matrícula.
	 * 
	 * @param matricula Matrícula do aluno.
	 * @return o aluno caso exista, do contrário retorna null.
	 */
    public Aluno getAluno(String matricula) {
    	if(verificaAluno(matricula)) {
    	return this.alunos.get(matricula);

    	}
    	return null;
    }
}