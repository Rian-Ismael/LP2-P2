package desafioMinhaVida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesafioController {

	private List<DesafioInterface> desafios;
	private Map<Integer, Acao> acoes;
	
	public DesafioController() {
		this.desafios = new ArrayList<>();
		this.acoes = new HashMap<>();
	} 
	
	public int cadastaDesafioPessoal(String titulo) {
		DesafioInterface desafio = new DesafioPessoal(titulo);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	
	public int cadastaDesafioPessoal(String titulo, String descricao) {
		DesafioInterface desafio = new DesafioPessoal(titulo, descricao);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	
	public int cadastaDesafioMaterial(String titulo, double investido) {
		DesafioInterface desafio = new DesafioMaterial(titulo, investido);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	
	public int cadastaDesafioMaterial(String titulo, String descricao, double investido) {
		DesafioInterface desafio = new DesafioMaterial(titulo, descricao, investido);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	
	public int cadastaDesafioSocial(String titulo) {
		DesafioInterface desafio = new DesafioSocial(titulo);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	
	public int cadastaDesafioSocial(String titulo, String descricao) {
		DesafioInterface desafio = new DesafioSocial(titulo, descricao);
		if(!(verificaDesafioRegistrado(desafio))) {
			this.desafios.add(desafio);
			return desafios.size();
		} else {
			return -1;
		} 
	}
	 
	
	
	public String exibirDesafio(int posicao) {
		return this.desafios.get(posicao - 1).exibirDesafio();
	}
	
	public void adicionaProgresso(int progresso, int codigo) {
		this.acoes.get(codigo).adicionaProgresso(progresso);
	} // esse codigo é da ação.
	
	
	public void adicionaProgresso(int codigo) {
		this.acoes.get(codigo).adicionaProgresso();
	} // esse codigo é da ação.
	
	public void cadastraAcao(String data, int codigo, int id) {
		DesafioInterface desafioPassado = this.desafios.get(id - 1); // id é a posicao do Desafio.
		this.acoes.put(codigo, new Acao(data, codigo, desafioPassado));
	}
	
	private boolean verificaDesafioRegistrado(DesafioInterface desafio) {
		return this.desafios.contains(desafio);
	}
	
	
	public String listarAcaoesPorOrdemDeProgresso() {
		List<Acao> list = new ArrayList<>(this.acoes.values());
		Collections.sort(list, new ComparatorProgresso());
		String saida = "";
		for(int i = 0; i <= list.size()-1; i++) {
			saida += list.get(i).toString() + "\n";
		}
		return saida;
	}
}
