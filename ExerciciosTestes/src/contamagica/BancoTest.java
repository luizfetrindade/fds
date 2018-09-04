package contamagica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {
	static BancoDuble banco;
	static BigDecimal valor;
	static ContaMagicaDuble conta;

	@BeforeAll
	public static void setUp() {
		banco = new BancoDuble();
		valor = new BigDecimal("10");
		conta = new ContaMagicaDuble("Fulano", valor);
		banco.criarConta(conta);
	}
	
	@AfterEach
	public void afterTest() {
		banco.encerrarConta("Fulano");
		conta = new ContaMagicaDuble("Fulano", valor);
		banco.criarConta(conta);
	}
	
	@Test
	public void criarContaTest() {
		banco.criarConta(conta);
		assertTrue(true);
	}

	@Test
	public void contaExisteTest() {
		banco.contaExiste("Fulano");
		assertTrue(true);
	}

	@Test
	public void depositarTest() {
		banco.depositar("Fulano", valor);
		BigDecimal valorTeste = new BigDecimal("20");

		assertEquals(valorTeste, banco.consultarSaldo("Fulano"));
	}

	@Test
	public void depositarExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			BigDecimal valor = new BigDecimal("-1");
			banco.depositar("Fulano", valor);
		});
	}

	@Test
	public void statusSilverTest() {
		banco.depositar("Fulano", valor);
		assertEquals(Categorias.Silver, banco.status("Fulano"));
	}

	@Test
	public void statusGoldTest() {
		BigDecimal valorGold = new BigDecimal("50000");
		banco.depositar("Fulano", valorGold);

		assertEquals(Categorias.Gold, banco.status("Fulano"));
	}

	@Test
	public void statusPlatinumTest() {
		BigDecimal valorPlatinum = new BigDecimal("200000");
		banco.depositar("Fulano", valorPlatinum);

		assertEquals(Categorias.Platinum, banco.status("Fulano"));
	}

	@Test
	public void sacarTest() {
		BigDecimal valorTeste = new BigDecimal("5");
		banco.sacar("Fulano", valorTeste);

		assertEquals(valorTeste, banco.consultarSaldo("Fulano"));
	}

	@Test
	public void sacarExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			BigDecimal valorTeste = new BigDecimal("20");
			banco.sacar("Fulano", valorTeste);
		});
	}

	@Test
	public void consultarSaldoTest() {
		BigDecimal valorTeste = new BigDecimal("10");

		assertEquals(valorTeste, conta.getSaldo());
	}

	@Test
	public void encerrarContaTest() {
		banco.encerrarConta("Fulano");

		assertEquals(false, banco.contaExiste("Fulano"));
	}
}