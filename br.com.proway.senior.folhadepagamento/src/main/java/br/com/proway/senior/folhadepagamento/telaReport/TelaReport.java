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
			System.out.println("Digite a opção desejada:");
			System.out.println("Opção 1 - Sugestão");
			System.out.println("Opção 2 - Reclamação");
			System.out.println("Opção 3 - Solicitação");
			System.out.println("Opção 4 - Dúvidas");
			System.out.println("Opção 0 - Sair");

			// Escolha das opções
			//escolhaIdUsuario = entradaInt.nextInt();
			switch (escolhaIdUsuario) {
			case 1:
				System.out.println("Digite suas observações e dê enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Sugestão";

			case 2:
				System.out.println("Digite suas observações e dê enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Reclamação";
			case 3:
				System.out.println("Digite suas observações e dê enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Solicitação";
			case 4:
				System.out.println("Digite suas observações e dê enter:");
				corpoEmail = entradaString.nextLine();
				System.out.println("Obrigada!!!!\n");
				return this.assuntoEmail = "Dúvidas";
			case 0:
				System.exit(0);
			}

		} while (escolhaIdUsuario != 0);
		//Retorna o assunto de e-mail confirmando a solicitação, para implmentações futuras, essa tela vai enviar um e-mail confirmando a 
		//A solicitaçao do usuário
		return assuntoEmail;

	}

}
