package ControleAlunos;
import java.util.HashSet;
import java.util.Objects;

/**
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Grupo {
	
	/**
	 * Tema do grupo.
	 */
    private String tema;
    
    /**
     * Tamanho do grupo.
     */
    private int tamanho;
    
    /**
     * Verificador da existência de tamanho definido no grupo,
     True caso não foi definido um tamanho ao grupo, False se foi definido.
     */
    private boolean tamanhoIndefinido;

    /**
     * HashSet onde armazena os alunos.
     */
    private HashSet<Aluno> alunos;

    
    /**
     * 
     * Constroi um grupo com tema e tamanho indefinido.
     * 
     * @param tema Tema do grupo a ser criado.
     */
    public Grupo(String tema) {
    	if (tema == null) {
    		throw new NullPointerException("tema nulo");
    	} 
    	if (tema.equals("")) {
    		throw new IllegalArgumentException("tema vazio");
    	} 
    	
    	this.alunos =  new HashSet<>();
    	this.tamanho = Integer.MAX_VALUE;
    	this.tamanhoIndefinido = true;
    	this.tema = tema;
    }
    
    
    /**
     * 
     * Constroi um grupo com tema e tamanho definido.
     * 
     * @param tema Tema do grupo a ser criado.
     * @param tamanho Tamanho do grupo a ser definido.
     */
    public Grupo(String tema, int tamanho) {
    	
    	if (tema == null) {
    		throw new NullPointerException("tema nulo");
    	} 
    	if (tema.equals("")) {
    		throw new IllegalArgumentException("tema vazio");
    	}
    	if (tamanho < 0) {
    		throw new IndexOutOfBoundsException("tamanho inválido");
    	}
    	
    	this.alunos =  new HashSet<>();
    	this.tamanhoIndefinido = false;
    	this.tema = tema;
    	this.tamanho = tamanho;
    }

    /**
     * 
     * Adiciona um aluno ao grupo a partir do Objeto Aluno.
     * 
     * @param aluno Aluno a ser inserido no grupo.
     * @return true caso o aluno foi inserido no grupo, do contrário, não foi.
     */
    public boolean adicionaAlunoGrupo(Aluno aluno) {
    	boolean retorno = false;
    	if(this.tamanhoIndefinido) {
    		this.alunos.add(aluno);
    		retorno = true;
    		
    	} else if(this.alunos.size() < this.tamanho){
    		this.alunos.add(aluno);
    		retorno = true;
    	}
    	return retorno;
    }

    /**
     * 
     * Verifica se um aluno existe em um grupo.
     * 
     * @param aluno Aluno a ser analisado a existência no grupo.
     * @return true caso o aluno exista no grupo, do contrário, não existe.
     */
    public boolean checaAlunoGrupo(Aluno aluno) {
    	return this.alunos.contains(aluno);
    }
    
    /**
     * 
     * Recupera o tamanho definido para o grupo.
     * 
     * @return o tamanho do grupo.
     */
    public int getTamanho() {
    	return this.tamanho;
    }
    
    /**
     * 
     * Recupera o tema do grupo.
     * 
     * @return o tema do grupo.
     */
    public String getTema() {
    	return this.tema;
    }
   
    /**
     * 
     * Recupera quantos alunos foram inseridos no grupo.
     * 
     * @return a quantidade de alunos do grupo.
     */
    public int getcontroleTamanho() {
    	return alunos.size();
    }

	/**
	 * Metodo que cria um HashCode para o grupo.
	 * @return o hashcode gerado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tema); 
	}
	
	/**
	 * Metodo que comparar se dois grupos sao iguais.
	 * @return true se os grupos tem a mesma classe e mesmo nome ou false se nao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(tema, other.tema);
	}
	/**
	 * Cria a representação em String de Grupo.
	 * 
	 * @return a representação em string do tema, quantidade de pessoas inseridas
	 e se foi definido um tamanho para o grupo retorna este tamanho junto.
	 */
	public String toString() {
		return "- " + this.tema + " " + alunos.size() + "/" + (this.tamanhoIndefinido ? "Tamanho indefinido" : this.tamanho);
	}

}