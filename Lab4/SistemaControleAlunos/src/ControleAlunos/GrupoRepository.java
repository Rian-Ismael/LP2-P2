package ControleAlunos;

import java.util.HashMap;

/**
 * 
 * Repositório de grupos.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class GrupoRepository {

	/**
	 *  HashMap em que armazena os grupos a serem criados.
	 */
    private HashMap<String, Grupo> grupos;

    /** 
     * 
     * Constroi um HashMap de grupos.
     * 
     */
    public GrupoRepository() {
    	this.grupos = new HashMap<>();
    }
    
    /**
     * 
     * Cadastra um grupo a partir do tema e tamanho.
     * 
     * @param tema Tema do grupo a ser criado.
     * @param tamanho Tamanho do grupo, quantidade de alunos que podem entrar.
     * @return um boolean confirmando se o grupo foi inserido no HashMap, caso seja retorna True, do contrário False.
     */
    public boolean cadastraGrupo(String tema, int tamanho) {

    	if(!(verificaSeTemOGrupo(tema.toLowerCase()))) {
    		this.grupos.put(tema.toLowerCase(), new Grupo(tema, tamanho));
    		return true;
    		//"Grupo criado.";
    	} 
    	
    	return false;
    	// "Grupo já criado.";
    }
    
    /**
     * 
     * Cadastra um grupo a partir do tema.
     * 
     * @param tema Tema do grupo a ser criado.
     * @return um boolean confirmando se o grupo foi inserido no HashMap, caso seja retorna True, do contrário False.
     */
    public boolean cadastraGrupo(String tema) {
    	if(!(verificaSeTemOGrupo(tema.toLowerCase()))) { 
    		this.grupos.put(tema.toLowerCase(), new Grupo(tema));
    		return true;
    		//"Grupo criado.";
    	}
    	
    	return false;
    	// "Grupo já criado.";
    }

    /**
     * 
     * Verifica se um grupo existe no Map de grupos.
     * 
     * @param tema Tema do grupo (key).
     * @return true caso exista o tema do grupo, do contrário falso.
     */
    private boolean verificaSeTemOGrupo(String tema) {
    	return this.grupos.containsKey(tema.toLowerCase());
    }
 
    /**
     * 
     * Recupera o grupo.
     * 
     * @param tema Tema do grupo a ser recuperado.
     * @return o grupo caso exista no Map de grupos, do contrário retorna null.
     */
    public Grupo getGrupo(String tema) {
    	if(verificaSeTemOGrupo(tema.toLowerCase())) {
    		return this.grupos.get(tema.toLowerCase());
    	}
    	return null;
 
    }

    /**
     * 
     * Imprime os grupos em que um aluno está inserido.
     * 
     * @param aluno Aluno a ser analisado para ser imprenso os grupos os quais estão inserido.
     * @return  os grupos em formato String.
     */
    public String imprimeGruposAlunos(Aluno aluno) {
    	String grupos = "Grupos:\n";
    	 
    	for(String tema : this.grupos.keySet()) {
    		Grupo grupo = this.grupos.get(tema.toLowerCase());
    		boolean checa = grupo.checaAlunoGrupo(aluno);
    		if(checa) {
    			grupos += grupo.toString() + "\n";
    		} 
    		
    	}
    	return grupos;
    }
}