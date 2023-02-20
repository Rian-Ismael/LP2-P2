package desafioMinhaVida;

import java.util.Objects;

public class Acao {
	
	private String data;
	private int codigo;
	private DesafioInterface desafio;
	private int progresso;
	
	public Acao(String data, int codigo, DesafioInterface desafio) {
		this.data = data;
		this.codigo = codigo; 
		this.desafio = desafio;
	}
	
	public void adicionaProgresso(int progresso) {
	    if(this.progresso != 100){
	        if((this.progresso + progresso) >= 100) {
	            this.progresso = 100;
	            desafio.contaDesafio();
	            desafio.acrescentaSatisfazao();
	        }  else {
	            this.progresso += progresso;
	        }  
	    }
	} 

	
	public void adicionaProgresso() {
		if(this.progresso != 100) {
		 if ((this.progresso + 10) >= 100) {
			this.progresso = 100;
			desafio.contaDesafio();
			desafio.acrescentaSatisfazao();
			
	} else {
		this.progresso += 10;
		}
		}
}
	
	public int getProgresso() {
		return this.progresso;
	}
	
	public String toString() {
		return "Acao " + this.codigo + " - " + this.data + " - " +
				this.desafio.getTitulo() + " - Progresso " + this.progresso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		return codigo == other.codigo;
	}
	
}
