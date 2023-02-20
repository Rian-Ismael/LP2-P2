package lulasSistemaTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lulaSistema.LULASistema;

class LulaTeste {
	private LULASistema lulaS;
	
	@BeforeEach
	void preparador() {
		this.lulaS = new LULASistema();
		lulaS.cadastraComitiva(0, "Alunos Concluintes do IFPB", 10, 99565678);
		lulaS.cadastraComitiva(1, "Concluintes UEPB", 50, 97845216);
		lulaS.cadastraLocal("CG", "Bloco integrado", "1111");
		lulaS.cadastraLocal("CN", "Departamento de Sistemas e Computação", "1120");
		
	} 


	@Test
	void testCadastraComitivaLimiteInferior() {
		try {
			lulaS.cadastraComitiva(-1, "Formacao", 5, 991776359);
			fail("Deveria lancar IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException iobe) {			
		}
	}
	
	@Test
	void testCadastraComitivaLimiteSuperior() {
		try {
			lulaS.cadastraComitiva(101, "Concluintes", 20, 991774852);
			fail("Deveria lancar IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException iobe) {
			
			
		}
	}
	
	@Test
	void testCadastradoComitiva() {
		String esperado = "Comitiva cadastrada.";
		assertEquals(esperado, lulaS.cadastraComitiva(10, "Estudantes do Núcleo de Apoio de Psicologia", 7, 99992000));
	}
	
	@Test
	void testCadastraLocalSucesso() {
		String esperado = "Local cadastrado.";
		assertEquals(esperado, lulaS.cadastraLocal("BG", "Formatura", "4857"));
		
	}
	@Test
	void testLocalJaCadastrado() {
		String esperado = "Local já foi cadastrado.";
		assertEquals(esperado, lulaS.cadastraLocal("CN", "Departamento de Sistemas e Computação", "1120"));
	}
		
	@Test 
	void testLocalLimiteSuperior() {
		String esperado = "Você atingiu o limite de cadastro de locais.";
		LULASistema lulaAux1 = new LULASistema();
		lulaAux1.setControleIndice(100);
		assertEquals(esperado, lulaAux1.cadastraLocal("CD", "Aprov", "1874"));
		
	}
	
	@Test
	void testComitivaJaCadastrada() {
		String esperado = "Comitiva já foi cadastrada.";
		assertEquals(esperado, lulaS.cadastraComitiva(0, "Alunos Concluintes do IFPB", 10, 935565678));
			
	}
	

	@Test
	void testExibeComitiva() {
		String esperado = 
			      "ID: 0\n"
				+ "Comitiva: Alunos Concluintes do IFPB\n"
				+ "Integrantes: 10\n"
				+ "Contato: 99565678";
		assertEquals(esperado, lulaS.exibeComitiva(0));
	}

	@Test
	void testExibeLocal() {
		String esperado = "CN - Departamento de Sistemas e Computação - 1120";
		assertEquals(esperado, lulaS.exibeLocal("CN"));

	}
	
	@Test
	void testGetIndice() {
		LULASistema lulaAux2 = new LULASistema();
		lulaAux2.cadastraLocal("CJ", "Centro juridico", "1874");
		lulaAux2.cadastraLocal("LP", "Laboratório Prog.", "4795");
		assertEquals(2, lulaAux2.getControleIndice());
	}
	
	@Test
	void testExibeComitivas() {
		String esperado = 
			      "ID: 0\n"
				+ "Comitiva: Alunos Concluintes do IFPB\n"
				+ "Integrantes: 10\n"
				+ "Contato: 99565678\n"
				+  "ID: 1\n"
				+ "Comitiva: Concluintes UEPB\n"
				+ "Integrantes: 50\n"
				+ "Contato: 97845216\n";
		assertEquals(esperado, lulaS.exibeComitivas());
	}
	
	@Test
	void testExibeLocais() {
		String esperado = "CG - Bloco integrado - 1111\n" + "CN - Departamento de Sistemas e Computação - 1120\n";
		assertEquals(esperado, lulaS.exibeLocais());
	}

}
