package contamagica;

import java.util.ArrayList;

public class CadastroContas {
	private ArrayList<ContaMagica> lista;
	
	public CadastroContas() {
		lista = new ArrayList<>();
	}
	
	public void insereConta(ContaMagica conta) {
		lista.add(conta);
	}
	
	public void removeConta(String nome) {
        lista.removeIf((x -> x.getNomeCliente().equals(nome)));
	}
	
	public ContaMagica pesquisar(String nome) {
		ContaMagica result = lista.stream()
		.filter(x -> nome.equals(x.getNomeCliente()))
		.findAny()
		.orElse(null);
		return result;
	}
}
