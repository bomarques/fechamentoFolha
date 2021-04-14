/**
 * 
 */
package br.com.proway.senior.folhadepagamento.telaReport;

import java.util.Scanner;

/**
 * Classe que mostra o menu de report
 * 
 * @author Sabrina, Vanderlei, Sarah, Lucas W e Leonardo P.
 * @since 13/04/21
 * @version 1.0
 *
 */
public class TelaReport {
String corpoEmail, assuntoEmail;
	/**
	 * Metodo que tem o escopo do menu report
	 * 
	 * @param escolhaIdUsuario variavel que possui a escolha do usuario do menu um
	 *                         para a entrada no menu report
	 * @return String retorna o assunto do email para teste no JUnit
	 */
	public String mostraMenuReport(int escolhaIdUsuario) {
		// Variaveis com assunto do menu
		

		// Variaveis para a entrada de dados com int e String
		Scanner entradaString = new Scanner(System.in);
		Scanner entradaInt = new Scanner(System.in);

		// Acoes do menu
		do {
			System.out.println("--------------------\n");
			System.out.println("Digite a op��o desejada:");
			System.out.println("Op��o 1 - Sugest�o");
			System.out.println("Op��o 2 - Reclama��o");
			System.out.println("Op��o 3 - Solicita��o");
			System.out.println("Op��o 4 - D�vidas");
			System.out.println("Op��o 0 - Sair");

			// Escolha das op��es
			//escolhaIdUsuario = entradaInt.nextInt();
			switch (escolhaIdUsuario) {
			case 1:
				System.out.println("Digite suas observa��es e d� enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Sugest�o";

			case 2:
				System.out.println("Digite suas observa��es e d� enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Reclama��o";
			case 3:
				System.out.println("Digite suas observa��es e d� enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Solicita��o";
			case 4:
				System.out.println("Digite suas observa��es e d� enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "D�vidas";
			case 0:
				System.exit(0);
			}

		} while (escolhaIdUsuario != 0);
		//Retorna o assunto de e-mail confirmando a solicita��o, para implmenta��es futuras, essa tela vai enviar um e-mail confirmando a 
		//A solicita�ao do usu�rio
		return assuntoEmail;

	}

}
