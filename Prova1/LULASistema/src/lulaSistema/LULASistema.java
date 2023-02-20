package lulaSistema;


/**
 * 
 * Classe principal, gerencia o cadastro de comitivas e locais.
 * 
 * @author Rian Ismael Elias de Melo - 121210197;
 *
 */
public class LULASistema {
	private static final int TAMANHO_LOCAL = 100;
	private static final int TAMANHO_COMITIVA = 100;
	private Local[] locais;
	private Comitiva[] comitivas;
	private int controleIndice;
	private int controleVisitas;

	public LULASistema() {
		this.locais = new Local[TAMANHO_LOCAL];
		this.comitivas = new Comitiva[TAMANHO_COMITIVA];
	}
	public String cadastraLocal(String idTextualLocal, String nome, String ramal) {
		if (controleIndice >= 100) {
			return "Você atingiu o limite de cadastro de locais.";
		}
		
		if (!verificaIdLocal(idTextualLocal)) {
			this.locais[controleIndice++] = new Local(idTextualLocal, nome, ramal);
			return "Local cadastrado.";
			
		} else {
			return "Local já foi cadastrado.";
		}
	}
	
	public String cadastraComitiva(int idNumeralComitiva, String descricao, int numPessoas, int telefone) {
		if (idNumeralComitiva >= 100 || idNumeralComitiva < 0) {
			throw new IndexOutOfBoundsException("Posição inválida.");
		}
		
		if(!verificaIdComitiva(idNumeralComitiva)) {
			this.comitivas[idNumeralComitiva] = new Comitiva(idNumeralComitiva, descricao, numPessoas, telefone);
			return "Comitiva cadastrada.";
		} else {
			return "Comitiva já foi cadastrada.";
		}
	}
	
	private boolean verificaIdComitiva(int id) {
		for(int i = 0; i < this.comitivas.length; i++) {
			if (comitivas[i] != null && comitivas[i].getIdIdentificador() == id) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaIdLocal(String id) {
		for(int i = 0; i < this.locais.length; i++) {
			if (locais[i] != null && (locais[i].getIdTextual()).equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public String exibeComitiva(int id) {
		return comitivas[id].toString();
	}
	
	private int getIndexLocal(String id) {
		for(int i = 0; i < locais.length; i++) {
			if(locais[i] != null && locais[i].getIdTextual().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public String exibeLocais() {
		String saida = "";
		for(int i = 0; i < controleIndice; i++) {
			if(locais[i] != null) {
			saida += locais[i] + "\n";
			}
		}
		return saida;
	}
	
	public String exibeComitivas() {
		String saida = "";
		for (int i = 0; i < comitivas.length; i++) {
			if (comitivas[i] != null) {
				saida += comitivas[i] + "\n";
			}
		}
		return saida;
	}
	
	public String exibeLocal(String id) {
		int i = getIndexLocal(id);
		return locais[i].toString();
		
	}
	public int getControleIndice() {
		return controleIndice;
	}
	public void setControleIndice(int controleIndice) {
		this.controleIndice = controleIndice;
	}
	
	public Comitiva getComitiva(int idNumeralComitiva) {
		return comitivas[idNumeralComitiva];
	}
	
	public void registraLocalVisita(int idNumeralComitiva, String idTextual) {
		int idx = getIndexLocal(idTextual);
		locais[idx].adicionaVisita(getComitiva(idNumeralComitiva));
	}
	
	
	

}
	
