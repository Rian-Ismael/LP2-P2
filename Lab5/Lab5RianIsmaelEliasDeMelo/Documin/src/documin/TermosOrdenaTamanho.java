package documin;

import java.util.Comparator;

/**
 * 
 *
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class TermosOrdenaTamanho implements Comparator<String>{

	/**
	 * Ordena o elemento Termo a partir do tamanho da palavra.
	 * 
	 * @param o1 objeto um.
	 * @param o2 objeto dois.
	 */
	@Override 
	public int compare(String o1, String o2) {
		return o2.length() - o1.length();
	}
}