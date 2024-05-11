package cofrinho;

	public class Euro extends Moeda {
		
		public Euro(double valorInicial) {
			this.valor = valorInicial;
		}
		@Override
		public void info() {
			System.out.println("Euro - " + valor);
			
		}
		@Override
		public double converter() {
			return this.valor * 5.43;
		}
		
		public boolean equals(Object objeto) {
			if (this.getClass() != objeto.getClass()) {
				return false;
			}
			
			Euro objetoEuro = (Euro) objeto;
			
			if (this.valor != objetoEuro.valor) { //se o this.valor é diferente da do objeto de real ele retorna falso, se não ele retorna verdadeiro
				return false;
			}
			
			return true; //se os valores forem iguais
		}
		
		

}
