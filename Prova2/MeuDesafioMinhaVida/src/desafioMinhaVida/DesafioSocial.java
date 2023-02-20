package desafioMinhaVida;

import java.util.Objects;

public class DesafioSocial implements DesafioInterface {
	
	private String tipo;
	private String titulo;
	private String descricao;
	private int execucoes;
	private int nivelSatisfacao;
	private int pessoas;
	
	public DesafioSocial(String titulo) {
		this.titulo = titulo;
		this.tipo = "social";
	}
	
	public DesafioSocial(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = "social";
	}
	
	public void contaDesafio() {
		this.execucoes++;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public int getNivel() {
		return this.nivelSatisfacao;
	}
	
	public String exibirDesafio() {
		return "Título: " + this.titulo + " (" + this.tipo +")" + "\n" + this.execucoes + " execuções";
			
	}

	public int getExecucoes() {
		return this.execucoes;
	}



	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DesafioSocial other = (DesafioSocial) obj;
		return Objects.equals(titulo, other.titulo);
	}

	public int calculoSatisfacao() {
		return 0;
	
	}

	@Override
	public void acrescentaSatisfazao() {
		if(this.pessoas >= 10 && this.pessoas <= 50) {
			this.nivelSatisfacao += 20;
		}
		else if (this.pessoas >= 51 && this.pessoas <= 100) {
			this.nivelSatisfacao += 50;
		} else if (this.pessoas > 100) {
			this.nivelSatisfacao += this.pessoas;
		}
		
	}

}
