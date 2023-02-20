package ControleAlunos;

/**
 * 
 * Controle de cadastro de grupo e alunos
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class SistemaControleAlunos {

	/**
	 * Repositório de grupos.
	 */
    private GrupoRepository grupos;
    
    /**
     * Repositório de alunos.
     */
    private AlunosRepository alunos;
    
    /**
     * Inicializa repositório de grupos e alunos.
     */
    public SistemaControleAlunos() {
    	this.grupos = new GrupoRepository();
    	this.alunos = new AlunosRepository();
    }
    /**
     * 
     * Cadastra o aluno a partir da matricula, nome e curso.
     * 
     * @param matricula Matricula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     * @return a situação do cadastro do aluno, se foi cadastrado ou não.
     */
    public String cadastraAluno(String matricula, String nome, String curso) {
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
   
     else if (!(this.alunos.cadastraAluno(matricula, nome, curso))){
    	return "MATRÍCULA JÁ CADASTRADA!";
    } else {
   		return "CADASTRO REALIZADO!";
    } 
}
    
    /**
     * 
     * Consulta um aluno a partir da matrícula.
     * 
     * @param matricula Matricula do aluno.
     * @return o aluno consultado, cajo não esteja cadastrado, retorna uma String notificando.
     */
    public String consultaAluno(String matricula) {
    	if(!(alunos.consultaAlunos(matricula))) {
    		return "ALUNO NÃO CADASTRADO";
    	}
    	return this.alunos.getAluno(matricula).toString();
    }
    
    /**
     * 
     * Adiciona um aluno em um grupo em específico.
     * 
     * @param tema Tema do grupo a ser inserido o aluno.
     * @param matricula Matricula do aluno a ser inserido ao grupo.
     * @return a situação de cadastro do aluno.
     */
    public String adicionaAlunoGrupo(String tema, String matricula) {
    	Grupo grupoDeEstudo = grupos.getGrupo(tema);
    	Aluno aluno = alunos.getAluno(matricula);
    	if(grupoDeEstudo == null) {
    		return "GRUPO NÃO CADASTRADO";
    	} else if (aluno == null) {
    		return "ALUNO NÃO CADASTRADO";
    	} else if (grupoDeEstudo.getcontroleTamanho() == grupoDeEstudo.getTamanho()) {
    		return "GRUPO CHEIO!";
    	}  else {
    		grupoDeEstudo.adicionaAlunoGrupo(aluno);
    		return "ALUNO ALOCADO";
    	}
    }
    
    /**
     * 
     * Cadastra um grupo a partir do tema e tamanho.
     * 
     * @param tema Tema do grupo a ser criado.
     * @param tamanho Tamanho do grupo a ser definido.
     * @return a situação de cadastro do grupo.
     */
    public String cadastraGrupo(String tema, int tamanho) {
    	if (tema == null) {
    		throw new NullPointerException("tema nulo");
    	} 
    	if (tema.equals("")) {
    		throw new IllegalArgumentException("tema vazio");
    	}
    	if (tamanho < 0) {
    		throw new IndexOutOfBoundsException("tamanho inválido");
    	}
    	
    	if(grupos.cadastraGrupo(tema, tamanho)) {
    		return "CADASTRO REALIZADO"; 
    	}
    	return "GRUPO JÁ CADASTRADO";
    }
   
    /**
     * 
     * Cadastra um grupo a partir do tema.
     * 
     * @param tema Tema do grupo a ser criado.
     * @return a situação de cadastro do grupo.
     */
    public String cadastraGrupo(String tema) {
       	if (tema == null) {
    		throw new NullPointerException("tema nulo");
    	} 
    	if (tema.equals("")) {
    		throw new IllegalArgumentException("tema vazio");
    	} 
    	
    	if(grupos.cadastraGrupo(tema)) {
    		return "CADASTRO REALIZADO"; 
    	}
    	return "GRUPO JÁ CADASTRADO";
    }
   
    
    /**
     * 
     * Verifica se um aluno em específico faz parte de um grupo em específico, 
     a partir do tema do grupo e da matrícula do aluno.
     * 
     * @param tema Tema do grupo a ser verificado a existência do aluno.
     * @param matricula Matricula do aluno a ser analisado.
     * @return a situação de pertencimento do aluno no grupo.
     */
    public String alunoFazParteGrupo(String tema, String matricula) {
    	Aluno alunoAnalisado = alunos.getAluno(matricula);
    	if(grupos.getGrupo(tema) == null) {
    		return "GRUPO NÃO CADASTRADO";
    	} else if (!(grupos.getGrupo(tema).checaAlunoGrupo(alunoAnalisado)))
    		return "ALUNO NÃO PERTENCE AO GRUPO";
    	
		return "ALUNO PERTENCE AO GRUPO";
    }
    
    /**
     * 
     * Imprime os grupos em que o aluno está inserido.
     * 
     * @param matricula Matrícula do aluno a ser analisada.
     * @return os grupos que o aluno está inserido.
     */
    public String imprimeAlunoGrupos(String matricula) {
    	Aluno aluno = alunos.getAluno(matricula);
    	return grupos.imprimeGruposAlunos(aluno);
    }


}