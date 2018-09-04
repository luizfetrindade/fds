package contamagica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
	private BigDecimal valor;
	private Categorias categoria;
	private ContaMagica conta;
	private CadastroContas cadastro;
	
	public Banco() {
		cadastro = new CadastroContas();
	}

	public void criarConta(ContaMagica novaConta) {
		cadastro.insereConta(novaConta);
	}
	
	public boolean contaExiste(String nomeCliente) {
		if(cadastro.pesquisar(nomeCliente)!=null) return true;
		else return false;
	}

	public void depositar(String nomeCliente, BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) >= 0) {
		conta = cadastro.pesquisar(nomeCliente);
		conta.deposito(valor);
		}
		else throw new IllegalArgumentException("Valor inválido.");
	}
	
	public Categorias status(String nomeCliente) {
		Categorias status = cadastro.pesquisar(nomeCliente).getStatus();
		return status;
	}

	public void sacar(String nomeCliente, BigDecimal valor) {
		conta = cadastro.pesquisar(nomeCliente);
		BigDecimal saldoAtual = conta.getSaldo();
		if (valor.compareTo(saldoAtual) <= 0) {
		conta.retirada(valor);
		} 
		else throw new IllegalArgumentException("Saldo insuficiente.");
	}

	public BigDecimal consultarSaldo(String nomeCliente) {
		conta = cadastro.pesquisar(nomeCliente);
		return conta.getSaldo();
	}

	public void encerrarConta(String nomeCliente) {
			cadastro.removeConta(nomeCliente);
	}

	public void menuInicial() {
		System.out.println("MENU\nSeu Banco \nEscolha as opções a seguir:");
		System.out.println("1 - Criar uma conta\n" + "2 - Acessar minha conta\n" + "0 - Sair");
	}

	public void menuMinhaConta() {
		System.out.println("MENU\nSeu Banco \nEscolha as opções a seguir:");
		System.out.println("3 - Saldo\n" + "4 - Sacar\n" + "5 - Depositar\n" + "6 - Encerrar conta\n" + "0 - Sair");
	}

}