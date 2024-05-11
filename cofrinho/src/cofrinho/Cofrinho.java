package cofrinho;

import java.util.ArrayList;

public class Cofrinho {
	private ArrayList<Moeda> listaMoedas; //lista privada onde vai ser armazenado as moedas//
	
	public Cofrinho() { // A lista sera iniciada vazia
		this.listaMoedas = new ArrayList<>();
	}
	
	public void adicionar(Moeda moeda) { //Adiciona moedas na lista
		this.listaMoedas.add(moeda);
	}
	
	public boolean remove(Moeda moeda) { //Remove as moedas da lista
		return this.listaMoedas.remove(moeda);
	}
	public void listagemMoedas() {
		if (this.listaMoedas.isEmpty()) { //Verifica se o cofrinho esta vazio
			System.out.println("Seu cofrinho está vazio!");
			return;
		}
		for (Moeda moeda: this.listaMoedas){ //O método info()lista a informação de cada moeda
			moeda.info();
		}
	}

	public double totalConvertido() {
		if (this.listaMoedas.isEmpty()) {// Se o cofrinho estiver vazio vai retornar 0
		return 0;
		}
		
		double valorAcumulado = 0; //Armazena o valor convertido
		
		for (Moeda moeda: this.listaMoedas){
			valorAcumulado = valorAcumulado + moeda.converter();
		}
		
		return valorAcumulado; //Retorna o valor total acumulado após a conversão das moedas
	}
}
