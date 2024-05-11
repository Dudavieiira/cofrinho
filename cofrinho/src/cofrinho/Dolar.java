package cofrinho;

public class Dolar extends Moeda {
	
	public Dolar(double valorInicial) {
		this.valor = valorInicial;
	}
	@Override
	public void info() {
		System.out.println("Dolar - " + valor);
		
	}
	@Override
	public double converter() {
		return this.valor * 5.03;
	}
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}
		
		Dolar objetoDolar = (Dolar) objeto;
		
		if (this.valor != objetoDolar.valor) { //se o this.valor é diferente da do objeto de real ele retorna falso
			return false;
		}
		
		return true; //Se os valores forem iguais retorna verdadeiro
	}
	

}
