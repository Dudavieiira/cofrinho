package cofrinho;

public class Real extends Moeda {
	
	public Real(double valorInicial) {
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Real - " + valor);
		
	}

	@Override
	public double converter() {
		return this.valor;
		
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}
		
		Real objetoReal = (Real) objeto;
		
		if (this.valor != objetoReal.valor) { //Se o this.valor é diferente da do objeto de real ele retorna falso, se não ele retorna verdadeiro
			return false;
		}
		
		return true; //Se os valores forem iguais
	}
	

}
