package desafioMinhaVida;

import java.util.Objects;

public class DesafioMaterial implements DesafioInterface {
	
	private String tipo;
	private String titulo;
	private String descricao;
	private int execucoes;
	private int nivelSatisfacao;
	private double investido;
	
	
	public DesafioMaterial(String titulo, double investido) {
		this.titulo = titulo;
		this.tipo = "material";
		this.investido = investido;
	}
	
	public DesafioMaterial(String titulo, String descricao, double investido) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.investido = investido;
		this.tipo = "material";
	}
	
	public void acrescentaSatisfazao() {
		this.nivelSatisfacao += (this.investido / 100);
	}
	
	public int getNivel() {
		return this.nivelSatisfacao;
	}
	
	public void contaDesafio() {
		this.execucoes++;
	}

	public String getTitulo() {
	return titulo;
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
		DesafioMaterial other = (DesafioMaterial) obj;
		return Objects.equals(titulo, other.titulo);
	}

	public int calculoSatisfacao() {
		return 0;
	
	}

}
