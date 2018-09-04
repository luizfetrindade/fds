package contamagica;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		BigDecimal value = new BigDecimal(1);
		ContaMagica conta1 = new ContaMagica("Pedro", value);
		ContaMagica conta2 = new ContaMagica("Maria", value);
		ContaMagica conta3 = new ContaMagica("Jose", value);

		Banco banco = new Banco();
		banco.criarConta(conta1);
		banco.criarConta(conta2);
		banco.criarConta(conta3);

		Scanner in = new Scanner(System.in);
		int option = 0;

		banco.menuInicial();
		option = in.nextInt();

		while (option != 0) {

			if (option == 1) {
				System.out.println("Criar uma conta == Digite seu nome:");
				String name = in.nextLine();
				name = in.next();
				ContaMagica contaNova = new ContaMagica(name, value);
				banco.criarConta(contaNova);

				System.out.println("Olá, " + name);
				System.out.println("Seu saldo inicial é R$" + conta1.getSaldo() + ". Categoria"+ conta1.getStatus() +"\n");

				banco.menuInicial();
				option = in.nextInt();
			}

			else if (option == 2) {
				System.out.println("Acessar minha conta == Digite seu nome:");
				String nomeCliente = in.nextLine();
				nomeCliente = in.next();
				
				System.out.println("\nOlá " + nomeCliente + "\n");

				while (option !=0) {
					if (banco.contaExiste(nomeCliente)==false) {
						System.out.println("Conta não encontrada");
					}else
					banco.menuMinhaConta();
					option = in.nextInt();
					
					switch (option) {
					case 0:
						System.out.println("Sair");
						break;

					case 3:
						BigDecimal saldo;
						saldo = banco.consultarSaldo(nomeCliente);
						Categorias status = banco.status(nomeCliente);
						System.out.println("Seu saldo é R$" + saldo + "\nSua categoria é " + status +"\n" );
						break;

					case 4:
						System.out.println("Digite o valor do saque:");
						BigDecimal saque = in.nextBigDecimal();
						banco.sacar(nomeCliente, saque);
						System.out.println("Sucesso. Retire seu dinheiro...\n");
						break;

					case 5:
						System.out.println("Digite o valor do depósito:");
						BigDecimal valor1 = in.nextBigDecimal();
						banco.depositar(nomeCliente, valor1);
						System.out.println("Sucesso.\n");
						break;

					case 6:
						System.out.println("Encerrar conta de " + nomeCliente + "?\nDigite SIM para confirmar "
								+ "== Digite 0 para cancelar");
						String resposta = in.nextLine();
						resposta = in.next();
						if (resposta.equalsIgnoreCase("SIM")) {
							banco.encerrarConta(nomeCliente);
							System.out.println("Conta encerrada com sucesso.\n");
							option = 0;
							break;
						} else
							System.out.println("Ação cancelada.\n");
						break;
						
					default:
						System.out.println("Opção não encontrada. Tente novamente.\n");
						break;
					}
				}
			}
		}
		System.out.println("||| Acesso encerrado |||");
	}
}
