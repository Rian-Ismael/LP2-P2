package agenda;

import java.util.Objects;

/**
 * 
 * Classe que representa contato.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Contato {
	
		/**
		 * nome do contato.
		 */
		private String nome;
		
		/**
		 * sobrenome do contato.
		 */
		private String sobrenome;
		
		/**
		 * telefone do contato.
		 */
		private String telefone;
		
		/**
		 * estado de favorito do contato.
		 */
		private boolean favorito;
		
	public Contato(String nome, String sobrenome, String telefone) {
		 this.nome = nome;
		 this.sobrenome = sobrenome;
		 this.telefone = telefone;
		 this.favorito = false; 
	}
	
	/**
	 * 
	 * Favorita um contato, possuindo como base a troca de valor do boolean para true.
	 * 
	 */
	public void favoritar() {
		this.favorito = true;
	}
	/**
	 * 
	 * Desfavorita um contato, possuindo como base a troca de valor do boolean para false.
	 * 
	 */
	public void desfavoritar() {
		this.favorito = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	/**
	 * 
	 * Cria a representação em String do contato.
	 * 
	 * @return retorna a representação em String do nome, sobrenome e telefone do contato e, se o contato
	 for favorito, retorna junto a um coração.
	 */
	public String toString() {
		if (favorito) {
			return "❤️ " + this.nome + " " + this.sobrenome + "\n" + this.telefone;
		}
		return this.nome + " " + this.sobrenome + "\n" + this.telefone;
	}
	
	/**
	 * 
	 * Recupera o nome do contato.
	 * 
	 * @return o nome do contato.
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * 
	 * Recupera o estado atual do contato.
	 * 
	 * @return o valor do contato em boolean.
	 */
	public boolean getFavorito() {
		return favorito;
	}

	/**
	 * 
	 * Recupera o sobrenome do contato.
	 * 
	 * @return o sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
}