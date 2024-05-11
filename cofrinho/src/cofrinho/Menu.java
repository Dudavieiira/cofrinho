package cofrinho;

import java.util.Scanner;

public class Menu {
	private Scanner sc; //leitura de entrada do usuário
	private Cofrinho cofrinho;
	
	public Menu() {
		sc = new Scanner(System.in); //Inicializa a leitura do objeto
		cofrinho = new Cofrinho(); //Inicializa o cofrinho vazio
	}
	
	public void exibirMenu() { //Exibe o menu principal com as opções 
		System.out.println("COFRINHO");
		System.out.println("1- Adicionar moeda:");
		System.out.println("2- Remover moeda:");
		System.out.println("3- Listar moedas:");
		System.out.println("4- Valor total convertido para real:");
		System.out.println("8- Encerrar.");
		
		String opcaoEscolhida  = sc.next(); //Realiza a leitura da opção escolhida pelo usuário
		
		switch(opcaoEscolhida) { //Verifica e realiza a opção escolhida pelo usuário
			case "8":
				System.out.println("Sistema Finalizado.");
				break;
			
			case "1": 
				exibirMenuAdicionarMoedas(); //Metódo para adição de moedas
				exibirMenu(); //Retorna ao menu principal
				break;
				
			case "2":
				exibirSubMenuRemoverMoedas(); //Metódo para remoção de moedas
				exibirMenu();
				break;
				
			case "3":
				cofrinho.listagemMoedas(); //Exibe a lista de moedas
				exibirMenu();
				break;
			
			case "4":
				double valorTotalConvertido = cofrinho.totalConvertido(); //Realiza o calculo do valor total convertido para reral
				String valorTotalConvertidoTexto = String.format("%.2f", valorTotalConvertido); //Indica que o valor deve ser formatado com duas casas decimais
				valorTotalConvertidoTexto = valorTotalConvertidoTexto.replace(".", ","); //Troca o ponto por virgula nos decimais
				System.out.println("O valor total convertido para real é: " + valorTotalConvertidoTexto);
				exibirMenu(); //Retorna ao menu principal
				break;
				
			default:
				System.out.println("Opção inválida.");//Caso o usuário selecione uma opção que não existe
				exibirMenu();
				break;
		}
		
	}
	
	private void exibirMenuAdicionarMoedas() { //Menu de adicionar moedas
		
		System.out.println("Escolha a moeda:");
		System.out.println("1- Real");
		System.out.println("2- Dólar");
		System.out.println("3- Euro");
		
		int opcaoMoedaSelecionada = sc.nextInt(); //Lê a opção de moeda selecionada pelo usuário
		System.out.println("Você selecionou a moeda: " + opcaoMoedaSelecionada);
		
		System.out.println("Digite o valor:");
	
		String valorMoeda = sc.next();
		valorMoeda = valorMoeda.replace(",", ".");//Substitui a vírgula por ponto
		System.out.println("O valor da moeda é: " + valorMoeda);
		double valorMoedaFinal = Double.parseDouble(valorMoeda);
		
		Moeda moeda = null;
		if(opcaoMoedaSelecionada == 1) {//Verifica a opção selecionada e cria o objeto correspondente
		    moeda = new Real(valorMoedaFinal);
		} else if (opcaoMoedaSelecionada == 2) {
			moeda = new Dolar(valorMoedaFinal);				
		} else if (opcaoMoedaSelecionada == 3) {
			moeda = new Euro(valorMoedaFinal);					
		} else {
			System.out.println("Essa moeda não existe!");
			exibirMenu();//Retorna ao menu principal
		}
		cofrinho.adicionar(moeda);//Adiciona a moeda no cofrinho
		System.out.println("Moeda adicionada com Sucesso.");
		}
	
private void exibirSubMenuRemoverMoedas() { //Menu para remover moedas
		
		System.out.println("Escolha a moeda:");
		System.out.println("1- Real");
		System.out.println("2- Dólar");
		System.out.println("3- Euro");
		
		int opcaoMoedaSelecionada = sc.nextInt(); //Salva o valor em uma string
		System.out.println("Você selecionou a moeda: " + opcaoMoedaSelecionada);
		
		System.out.println("Digite o valor:");
		String valorMoeda = sc.next();// LÊ o valor como String
		
		valorMoeda = valorMoeda.replace(",", "."); //Troca a vírgula por ponto nas casas decimais//
		System.out.println("O valor da moeda é: " + valorMoeda);
		double valorMoedaFinal = Double.parseDouble(valorMoeda);
		
		Moeda moeda = null;
		if(opcaoMoedaSelecionada == 1) {
		    moeda = new Real(valorMoedaFinal);
		} else if (opcaoMoedaSelecionada == 2) {
			moeda = new Dolar(valorMoedaFinal);				
		} else if (opcaoMoedaSelecionada == 3) {
			moeda = new Euro(valorMoedaFinal);					
		} else {
			System.out.println("Essa moeda não existe!");
			exibirMenu();//Retorna ao menu principal
		}
		
		if(cofrinho.remove(moeda)) {
			System.out.println("Remoção concluída.");
			System.out.println("-------------------");
		} else {
			System.out.println("Não existe nenhuma moeda com esse valor.");
		}
	}

}
