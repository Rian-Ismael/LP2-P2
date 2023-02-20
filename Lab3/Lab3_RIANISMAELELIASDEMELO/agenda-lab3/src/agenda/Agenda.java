package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posiCões. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Array de contatos.
	 */
	private Contato[] contatos;
	
	/**
	 * Array dos contatos favoritos.
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * 
	 * Verifica se hA o mesmo nome e sobrenome passados como parâmetro no array de contatos.
	 * 
	 * @param nome nome do contato.
	 * @param sobrenome sobrenome do contato
	 * @return True se existe o nome e sobrenome passados como parâmetro no array de contatos, caso contrArio retorna falso se nAo existe o nome.
	 */
	private boolean verificaContato(String nome, String sobrenome) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * Exibe um contato em específico, passando a posiCAo deste no array de contatos.
	 * 
	 * @param posicao posicao solicitada a ser exibida.
	 * @return O contato solicitado em String.
	 */
	public String exibeContato(int posicao) {
		return contatos[posicao - 1].toString();
	}

	/**
	 * 
	 * Verifica se a posiCAo do contato no array é null, caso seja retorna falso, ao contrArio retorna true notificando
	 que nAo é null naquela posiCAo.
	 * 
	 * @param posicao posicao no array de contatos.
	 * @return True caso a posiCAo solicitada nAo é null, do contrArio retorna false se é null.
	 */
	public boolean verificaExistencia(int posicao) {
		if (contatos[posicao - 1] != null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Lista os contatos existentes do array de contatos.
	 * 
	 * @return RepresentaCAo em String dos contatos existentes no array de contatos.
	 */
	public String listaContato() {
		String saida = "\n";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				saida += i + 1 + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
			}
		}
		return saida;
	}

	/**
	 * Cadastra um contato em uma posiCAo e, caso seja cadastro outro contato na mesma posiCAo
	 ele é sobrescrito.
	 *
	 * @param posicao   posicao do contato.
	 * @param nome      nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @param telefone  telefone do contato.
	 * @return Estado de cadastro do contato. 
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        if (posicao <= 0 ||  posicao > 100) {
            throw new IndexOutOfBoundsException("POSICAO INVALIDA");

        } else if ((telefone.equals("") || nome.equals(""))) {
            throw new IllegalArgumentException("CONTATO INVALIDO");

        } else if (verificaContato(nome, sobrenome)) {
        	throw new IllegalArgumentException("CONTATO JA CADASTRADO");
        } else {
        	
          this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
          return "CONTATO CADASTRADO";
    }
	}

	/**
	 * 
	 * Lista os contatos favoritos do array de favoritos.
	 * 
	 * @return RepresentaCAo em String dos contatos favoritos existentes no array de favoritos.
	 */
	public String listaFavoritos() {
		String saida = "\n";
		for (int i = 0; i < this.favoritos.length; i++) {
			if (favoritos[i] != null) {
				saida += i + 1 + " - " + favoritos[i].getNome() + " " + favoritos[i].getSobrenome() + "\n";
			}
		}
		return saida;
	}
	
	/**
	 * 
	 * Adiciona um contato ao favorito, possuindo como parâmetro a posiCAo do contato de array de contatos a
	 ser inserida no array de favoritos e onde irA ser inserida  no array de favoritos.
	 * 
	 * @param contatoPosicao posicao do contato a ser favoritada.
	 * @param favoritoPosicao posicao no array de favoritos a ser inserida o contato.
	 * @return Estado atual de cadastro do contato.
	 **/
	public void adicionaFavorito(int contatoPosicao, int favoritoPosicao) {	
			if (favoritoPosicao <= 0 || favoritoPosicao > 10) {
				throw new IndexOutOfBoundsException("POSICAO INVALIDA DE FAVORITO");
			}
			else if(contatoPosicao <= 0 || contatoPosicao > 100) {
				throw new IndexOutOfBoundsException("POSICAO INVALIDA DE CONTATO");				
			}
			if (contatos[contatoPosicao - 1] == null) {
				throw new NullPointerException("POSICAO INEXISTENTE");

			}
			if(this.favoritos[favoritoPosicao - 1] != null) {
				this.favoritos[favoritoPosicao - 1].desfavoritar();
			}
			
			this.favoritos[favoritoPosicao - 1] = contatos[contatoPosicao - 1];
			contatos[contatoPosicao - 1].favoritar();
			
		}

	/**
	 * 
	 * Remove um contato do array de favoritos.
	 * 
	 * @param posicao posicao a ser removida de favoritos.
	 * @return Estado do cadastro de contato favorito.
	 */
	public String removeFavorito(int posicao) {
		if(posicao > 10 || posicao <= 0) {
			throw new IndexOutOfBoundsException("POSICAO INVALIDA");
		}
		
		else if(this.favoritos[posicao - 1] == null) {
			throw new IllegalArgumentException("CONTATO NAO EXISTENTE");
		}
		this.favoritos[posicao-1].desfavoritar();
		this.favoritos[posicao-1] = null;
		
		return "CONTATO REMOVIDO";
	}
}