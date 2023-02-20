package lab2;

public class CoisaBonus {
	public static void main(String[] args) {
		registrarDescanso();
		System.out.println("-----");
		controlarDisciplina();
		System.out.println("-----");
		registroResumos();
	}
		
private static void controlarDisciplina() {
	    Disciplina lab2 = new Disciplina("LP2", 2, new int[] {2, 3});
	    lab2.cadastraNota(1, 5.0);
	    lab2.cadastraNota(2, 10.0);
	    System.out.println("Média ponderada: ");
	    System.out.println(lab2.calculaMediaPonderada());
	    Disciplina prog2 = new Disciplina("PROG2", 3);
	    prog2.cadastraNota(1, 5);
	    prog2.cadastraNota(2, 25);
	    prog2.cadastraNota(3, 6);
	    System.out.println("Média ponderada: ");
	    System.out.println(prog2.calculaMediaPonderada());
	}
	
private static void registroResumos() {
    	RegistroResumos resumosTeste = new RegistroResumos(2); // 2 resumos
	    resumosTeste.adiciona("d", "Testando teste");
	    resumosTeste.adiciona("a", "Ainda Testando o teste");
	    resumosTeste.adiciona("c", "testando ainda sendo testado");

	    String[] resumoTestado = resumosTeste.pegaResumos();
	    for (int i = 0; i < resumosTeste.conta(); i++) {
	        System.out.println(resumoTestado[i]);
	    }
	    System.out.println();
	    System.out.println("Resumos: ");
	    System.out.println(resumosTeste.imprimeResumos());
	    System.out.println(resumosTeste.temResumo("a"));
	    System.out.println(resumosTeste.temResumo("d"));
	    
	    System.out.println("Resumos que foram encontrados através da chave: ");
	    System.out.println(resumosTeste.busca("testando"));
}

private static void registrarDescanso() {
	    Descanso descanso = new Descanso();
	    descanso.definirEmoji("<(^_^<)");
	    System.out.println(descanso.getStatusGeral());
	    descanso.defineHorasDescanso(26);
	    descanso.defineNumeroSemanas(1);
	    System.out.println(descanso.getStatusGeral());
	    descanso.defineHorasDescanso(52);
	    descanso.defineNumeroSemanas(2);
	    descanso.definirEmoji("*_*");
	    System.out.println(descanso.getStatusGeral());
	    descanso.defineHorasDescanso(26);
	    descanso.defineNumeroSemanas(1);
	    System.out.println(descanso.getStatusGeral());
	}
}