package contamagica;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContaMagicaTest {
	static ContaMagicaDuble target;
	static BigDecimal valor = new BigDecimal(1);
	
	@Test
	public void depositarTest(){
		target = new ContaMagicaDuble("Fulano", valor);
		target.deposito(new BigDecimal("10"));
	assertEquals(new BigDecimal("11"), target.getSaldo());
	}

	@Test
	public void retirarTest(){
		target = new ContaMagicaDuble("Fulano", valor);
		target.retirada(new BigDecimal("1"));
	assertEquals(new BigDecimal(0),target.getSaldo());
	}


}