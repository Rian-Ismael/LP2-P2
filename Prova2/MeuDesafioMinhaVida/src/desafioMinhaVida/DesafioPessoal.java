package desafioMinhaVida;

import java.util.Objects;
// base
public class DesafioPessoal implements DesafioInterface {
	
	private String tipo;
	private String titulo;
	private String descricao;
	private int execucoes;
	private int nivelSatisfacao;
	
	public DesafioPessoal(String titulo) {
		this.titulo = titulo;
		this.tipo = "pessoal";
	}

	public DesafioPessoal(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = "pessoal";
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
		DesafioPessoal other = (DesafioPessoal) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	public int calculoSatisfacao() {
		return 0;
		
	}

	@Override
	public void acrescentaSatisfazao() {
		this.nivelSatisfacao += 10;
		
	}
	
	
}
