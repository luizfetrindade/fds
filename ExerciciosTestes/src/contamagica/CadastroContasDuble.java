package contamagica;

import java.util.ArrayList;

public class CadastroContasDuble extends CadastroContas {
	private ArrayList<ContaMagicaDuble> lista;
	
	public CadastroContasDuble() {
		lista = new ArrayList<>();
	}
	
	public int size() {
		int size;
		return size = lista.size();
	}
	
	public void insereConta(ContaMagicaDuble conta) {
		lista.add(conta);
	}
	
	public boolean removeConta(String nome) {
		for (int i=0; i<lista.size(); i++) {
			if (nome.equals(lista.get(i).getNomeCliente())) {
				lista.remove(lista.get(i));
				return true;
			}
		} return false;
	}
	
	public ContaMagicaDuble pesquisar(String nome) {
		ContaMagicaDuble x;
		for (int i=0; i<lista.size(); i++) {
			if (nome.equals(lista.get(i).getNomeCliente())) {
				return x=lista.get(i);
			}
		}return null;
	}
}
