package lulaSistema;

// import java.util.ArrayList;
// Arrays.asList(yourArray).contains(yourValue) -- array

// arraylist.contains("elemento") -- contains para array

// ArrayList<String> frutas = new ArrayList<>();
// frutas.contains("Tangerina")

public class Comitiva {
	
	private int idIdentificador;
	private String descricao;
	private int numPessoas;
	private int telefone;
	private boolean passou;

	public Comitiva(int idIdentificador, String descricao, int numPessoas, int telefone) {
		this.idIdentificador = idIdentificador;
		this.descricao = descricao;
		this.numPessoas = numPessoas;
		this.telefone = telefone;
	}

	public int getIdIdentificador() {
		return idIdentificador;
	}
	
	public String toString() {
		return "ID: " + this.idIdentificador + "\n" + "Comitiva: " + this.descricao + "\n" +
				"Integrantes: " + this.numPessoas + "\n" + "Contato: " +this.telefone;
	}

	public int getNumPessoas() {
		return numPessoas;
	}

	public void setPassou(boolean passou) {
		this.passou = passou;
	}
	
}