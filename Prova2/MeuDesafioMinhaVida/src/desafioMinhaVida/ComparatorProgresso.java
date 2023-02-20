package desafioMinhaVida;

import java.util.Comparator;

public class ComparatorProgresso implements Comparator<Acao>{

	@Override
	public int compare(Acao o1, Acao o2) {
		return o1.getProgresso() - o2.getProgresso();
	}
	
}
