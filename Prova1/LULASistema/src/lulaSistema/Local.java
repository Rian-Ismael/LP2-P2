package lulaSistema;

import java.util.Objects;

public class Local {
	private Comitiva[] visitas;
	private String idTextual;
	private String ramal;
	private String local;
	private int controleVisitas;

	public Local(String idTextual, String local, String ramal) {
		this.idTextual = idTextual;
		this.ramal = ramal;
		this.local = local;
		this.visitas = new Comitiva[100];
		this.controleVisitas = 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(idTextual, other.idTextual);
	}

	public String toString() {
		return this.idTextual + " - " + this.local + " - " + this.ramal;
	}

	public String getIdTextual() {
		return idTextual;
	}
	
	public void adicionaVisita(Comitiva comitiva) {
		this.visitas[controleVisitas++] = comitiva;
	}
	
	public int qtPessoasTotal() {
		int totalPessoas = 0;
		for(int i = 0; i < visitas.length; i++) {
			if (visitas != null) {
				totalPessoas += visitas[i].getNumPessoas();
			}
		}
		return totalPessoas;
	}
	
	public String listaVisita(int idComitiva) {
		return visitas[idComitiva].toString();
		
	}
}
