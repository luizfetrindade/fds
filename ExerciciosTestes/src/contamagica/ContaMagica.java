package contamagica;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaMagica {
	private String nome;
	private BigDecimal saldo;
	private Categorias status;
	
	 public ContaMagica(String nome, BigDecimal saldo) {
		 this.nome = nome;
		 this.saldo = saldo;
	 }
	 public String getNomeCliente() {
		 return nome;
	 }
	 public BigDecimal getSaldo() {
		 return saldo;
	 }
	 public Categorias getStatus() {
		 BigDecimal silver = new BigDecimal(49999);
		 BigDecimal gold = new BigDecimal(50000);
		 BigDecimal platinum = new BigDecimal(200000);
		 if (saldo.compareTo(platinum)>=0) {
			 return Categorias.Platinum;
		 }
		 if (saldo.compareTo(gold)>=0) {
			 return Categorias.Gold;
		 }
		 if (saldo.compareTo(silver)<=0) {
			 return Categorias.Silver;
		 }
		 return null;
	 }
	 
	 public void deposito(BigDecimal valor) {
		 BigDecimal goldPercent = new BigDecimal("0.01");
		 BigDecimal platinumPercent = new BigDecimal("0.025");
		 if(getStatus()==Categorias.Gold) {
			 valor.multiply(goldPercent);
			 this.saldo = saldo.add(valor);
		 }
		 if (getStatus()==Categorias.Platinum) {
			 valor.multiply(platinumPercent);
			 this.saldo = saldo.add(valor);
		 }
		 else
			 this.saldo = saldo.add(valor);
	 }
	 
	 public void retirada(BigDecimal valor) {
		 this.saldo = saldo.subtract(valor);
	 }
	 
	 public String toString() {
		 return "Conta de " + getNomeCliente() + ". Status: " + getStatus() + ". Saldo R$" + getSaldo(); 
	 }
	 
	}

