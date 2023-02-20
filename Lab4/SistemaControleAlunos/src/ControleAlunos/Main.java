package ControleAlunos;
import java.util.Scanner;


/**
 * 
 * Interface com menus texto para manipular o controle de alunos.
 * 
 * @author Rian Ismael Elias de Melo - 121210197.
 *
 */
public class Main {
	public static void main(String[] args) {
		SistemaControleAlunos controleDeAlunos = new SistemaControleAlunos();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controleDeAlunos, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do usuário.
	 * 
	 * @param scanner para captura da opção do usuário.
	 * @return o comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println( "\n(C)adastrar Aluno\n" + 
							"(E)xibir Aluno\n" +
							"(N)ovo Grupo\n" +
							"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
							"(O)lhaí quais Grupos o Aluno Tá.\n" +
						    "(S)im, quero Fechar o Programa!" + "\n" +
							"Opção> ");
		
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param controleDeAlunos Sistema de controle de alunos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controleDeAlunos, scanner);
			break;
		case "E":
			consultaAluno(controleDeAlunos, scanner);
			break;
		case "N":
			cadastraGrupo(controleDeAlunos, scanner);
			break;
		case "A":
			adicionaAlunoGrupo(controleDeAlunos, scanner);
			break;
		case "O":
			imprimeAlunoGrupos(controleDeAlunos, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * 
	 * Método que cria um aluno a partir da matrícula, nome e curso.
	 * 
	 * @param controleDeAlunos sistema de controle de alunos.
	 * @param scanner Scanner para capturar matrícula, nome e curso do aluno.
	 */
	public static void cadastraAluno(SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Curso: ");
		String curso = scanner.nextLine();
		
		System.out.println(controleDeAlunos.cadastraAluno(matricula, nome, curso));

	}
	
	/**
	 * 
	 * Método que consulta um aluno a partir da matrícula.
	 * 
	 * @param controleDeAlunos sistema de controle de alunos.
	 * @param scanner Scanner para capturar a matrícula.
	 */
	public static void consultaAluno(SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(controleDeAlunos.consultaAluno(matricula));
		
	}
	
	/**
	 * 
	 * Método que cria um grupo a partir do nome do tema do grupo e seu tamanho (opcional).
	 * 
	 * @param controleDeAlunos sistema de controle de alunos.
	 * @param scanner Scanner para capturar o tema do grupo e o tamanho.
	 */
	public static void cadastraGrupo(SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		System.out.println("Grupo: ");		
		String grupo = scanner.nextLine();
		
		System.out.println("Tamanho: ");
		String tamanho = scanner.nextLine();
		
		if(tamanho.equals("")) {
			System.out.println(controleDeAlunos.cadastraGrupo(grupo));
		} else {
			int tamanhoInt = Integer.parseInt(tamanho);
			System.out.println(controleDeAlunos.cadastraGrupo(grupo, tamanhoInt));
		}
		}
	
	/**
	 * 
	 * Método que adiciona um aluno em um grupo em específico.
	 * 
	 * @param controleDeAlunos sistema de controle de alunos.
	 * @param scanner scanner para averiguar se será alocado ou verificado a pertinência de um aluno
	 em um grupo e capturar dados para criação do grupo ou para fazer a verificação do aluno em um grupo.
	 */
	public static void adicionaAlunoGrupo(SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		System.out.println("(A)locar Aluno no Grupo ou Verificar (P)ertinência a Grupos? ");
		String AlocaOuVerificaPertinencia = scanner.nextLine().toUpperCase();
		if (AlocaOuVerificaPertinencia.equals("A")) {
			System.out.println("Matricula: "); 
			String matricula = scanner.nextLine();
			
			System.out.println("Grupo: ");		
			String grupo = scanner.nextLine().toLowerCase();
			
			System.out.println(controleDeAlunos.adicionaAlunoGrupo(grupo, matricula));
			
		} else if (AlocaOuVerificaPertinencia.equals("P")) {
			System.out.println("Grupo: ");
			String grupo = scanner.nextLine().toLowerCase();
			
			System.out.println("Aluno: ");
			String aluno = scanner.nextLine();
			
			System.out.println(controleDeAlunos.alunoFazParteGrupo(grupo, aluno));
		}
		
		
	}
	
	/**
	 * 
	 * Método que imprime os grupos em que um aluno está.
	 * 
	 * @param controleDeAlunos sistema de controle de alunos.
	 * @param scanner Scanner para capturar o aluno que será impreso seus grupos.
	 */
	public static void imprimeAlunoGrupos(SistemaControleAlunos controleDeAlunos, Scanner scanner) {
		System.out.println("Aluno: ");
		String matricula = scanner.nextLine(); 
		
		System.out.println(controleDeAlunos.imprimeAlunoGrupos(matricula));
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
	
}