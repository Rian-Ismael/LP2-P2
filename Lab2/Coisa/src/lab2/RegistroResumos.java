package lab2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe cria um registro de resumos a partir do tema e resumo registrados.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class RegistroResumos {
	
    /**
     * Posicao no array. mantém o controle de reset do array. Quando atingindo
     o máximo estabelecido para resumos, define posicao para 0 e insere a partir desta posicao no array, ou seja,
     do início do array, substituindo o presente naquela posicao.
     */
	private int posicao = 0;
	
	/**
	 * Array dos temas adicionados no Registro de Resumos. Armazena somente 
	 os temas dos resumos.
	 */
	private String[] temas;
	
	/**
	 * Array dos Resumos e Temas inseridos no Registro de Resumos.
	 Armazena o tema e sequentemente o resumo do tema em um mesmo índice.
	 */
	private String[] temasEresumos;

	/**
	 * Constrói um Registro de Resumos a partir da quantidade de resumos 
	 que será estabelecida para ser preenchida.
	 * 
	 * @param quantidadeResumos Quantidade de resumos estabelecida.
	 */
	public RegistroResumos(int quantidadeResumos) {
		this.temas = new String[quantidadeResumos];
		this.temasEresumos = new String[quantidadeResumos];
	}

    /**
     * Verifica se chegou no limite estabelecido para o tamanho do resumo,
     caso chegue, comeca a inserir novamente no início do array.
     */
	private void verificaLimiteArray() {
		if (this.posicao == this.temas.length) {
			this.posicao = 0;
		}
	}
	
	/**
	 * Conta quantas vezes foi inserido um resumo no array.
	 */
	private void contadorPosicao() {
		this.posicao += 1;
	}
	
    /**
     * Registra o tema e resumo em um array que armazena tema e resumo em um mesmo
     índice.
     * 
     * @param tema tema a ser inserido no array tema.
     * @param resumo resumo a ser inserido no array resumo e temas.
     */
	public void adiciona(String tema, String resumo) {
		verificaLimiteArray();
		this.temas[this.posicao] = tema;
		this.temasEresumos[this.posicao] = tema + ": " + resumo;
		contadorPosicao();
	}
	
	/**
	 * Retorna temas e resumos.
	 * 
	 * @return um array com os temas e resumos inseridos.
	 */
	public String[] pegaResumos() {
		return this.temasEresumos;
	}
	
	/**
	 * Conta a quantidade de resumos armazenados.
	 * 
	 * @return a quantidade de resumos armazenados. Quantos resumos foram
	 * armazenados no array.
	 */
	public int conta() {
		int quantidadeValores = 0;
		for(int i = 0; i <= this.temas.length-1; i++) {
			if (temas[i] == null) {
				break;
			} else {
				quantidadeValores++;
			}
		}
		return quantidadeValores;
	}
	
	/**
	 * Realiza a formatacao para String, organizando com espacamento e "|"
	 entre os temas.
	 * 
	 * @return a representacao em String dos temas, mais a quantidade de resumos.
	 */
	public String imprimeResumos() {
		String temas = "";
		for (int i = 0; i <= conta()-1; i++) {
			if(i < conta()-1) {
			temas += this.temas[i] + " | ";
		} else {
			temas += this.temas[i];
			}
		}
		return ("- " + conta() + " resumo(s) cadastrado(s)" + "\n" + "- " + temas);
	}
	
	/**
	 * Verifica se um determinado tema está armazenado no array de temas.
	 * 
	 * @param tema tema a ser verificado se está no array. 
	 do contrário é falso, nao existe no array temas.
	 * 
	 * @return se há o tema ou nao no array de temas.
	 **/
	public boolean temResumo(String tema) {
		for (int i = 0; i <= conta()-1; i++) {
			if(temas[i].toLowerCase().equals(tema.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * Método verificador, método de pesquisa que busca sobre os resumos cadastrados.
	 * 
	 * @param chave a chave verificadora, usada para verificar se há
	 uma palavra que confere com a chave e, caso o tenha, armazena o tema
	 que há a palavra em um ArrayList.
	 * 
	 * @return array contendo os temas que foram encontrados a partir
	 * da palavra chave.
	 */
	public ArrayList<String> busca(String chave) {
		ArrayList<String> encontrados = new ArrayList<String>();
		for(int i = 0; i <= conta()-1; i++) {
			String resumo = temasEresumos[i];
			String[] separado = resumo.split(" ");
			
			for(int j = 0; j <= separado.length-1; j++) {
				String palavra = separado[j].toLowerCase();
				if( j > 0 && palavra.equals(chave.toLowerCase())) {
					encontrados.add(temas[i]);
				}
			}
		}
		Collections.sort(encontrados);
		return encontrados;
	}	
}