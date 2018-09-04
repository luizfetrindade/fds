package contamagica;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CadastroContaTest {
	static CadastroContasDuble cadastro;
	static BigDecimal saldo;
	static ContaMagicaDuble conta;
	
	@BeforeAll
	public static void SetUp() {
		cadastro = new CadastroContasDuble();
		saldo = new BigDecimal(10);
		conta = new ContaMagicaDuble("Teste", saldo);
		
		cadastro.insereConta(conta);
	}
	
	@Test
	public void insereContaTest() {
		cadastro.insereConta(conta);
		assertEquals(conta, cadastro.pesquisar("Teste"));
	}
	
	@Test
	public void removeContaTest() {
		cadastro.removeConta("Teste");
		assertEquals(1, cadastro.size());
	}
	
	@Test
	public void removeContaFalseTest() {
		cadastro.removeConta("XYZ");
		assertFalse(false);
	}
	
	@Test
	public void pesquisarTest() {
		cadastro.pesquisar("Teste");
		assertEquals(conta, cadastro.pesquisar("Teste"));
	} 
	
	@Test
	public void pesquisarNullTest() {
		cadastro.pesquisar("XYZ");
		assertNull(null);
	} 
}

