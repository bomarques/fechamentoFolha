/**
 * 
 */
package br.com.proway.senior.folhadepagamento.telaInicial;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.proway.senior.folhadepagamento.telaReport.TelaReport;

/**
 * Classe inicial que seta o menu de inicializa��o
 * 
 * @author Sabrina, Vanderlei, Sarah, Lucas W e Leonardo P.
 * @since 13/04/21
 * @version 1.0
 *
 */
public class TelaInicial {

	// Constantes que simulam as permiss�es vindas do BD
	static final ArrayList<String> permissao_admin = new ArrayList<String>();
	static final ArrayList<String> permissao_gestor = new ArrayList<String>();
	static final ArrayList<String> permissao_comum = new ArrayList<String>();

	/**
	 * Metodo que inicializa o menu inicial simulando os usuarios e senhas
	 * cadastrados no BD cedendo ou n�o a permiss�o (Testes ok)
	 * 
	 * @param usuarios usuarios cadastradados
	 * @param senha    de usuarios cadastrados
	 * @return boolean para teste no JUnit e para chamada do m�todo adicionar
	 *         permiss�o e segundo verifica permiss�o
	 */
	public static boolean telaInicial(ArrayList usuarios, ArrayList senha) {
		Scanner sc = new Scanner(System.in);
		boolean retorno;
		// Verifica permiss�es de usario e senha e chama o metodo para adicionar as
		// permiss�es
		System.out.print("Digite seu usu�rio: ");
		String nome = sc.nextLine();
		if (usuarios.contains(nome)) {
			System.out.print("Digite sua senha: ");
			if (senha.contains(sc.nextLine())) {
				System.out.println("--------------------");
				System.out.print("Acesso concedido\n");
				retorno = true;
				// adicionarPermissao(usuarios);
				// System.out.println(verificaPermissao(nome));
				// mostraMenu();

			} else {
				retorno = false;
			}
		} else {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Metodos que verifica a permiss�o(Local) das constantes que foram
	 * instanciadas, assim que as permiss�es forem criadas no BD necessita melhorias
	 * cedendo ou n�o acesso as telas complementares (Testes ok)
	 * 
	 * @param usuarios cadastrados no BD
	 * @return String retorna a variavel de tipos de permiss�o
	 */
	public static String verificaPermissao(String usuario) {
		// Variavel que mostra os niveis de permiss�o
		String permissao;
		if (permissao_admin.contains(usuario)) {
			permissao = "Permiss�o de Admin";
		} else if (permissao_gestor.contains(usuario)) {
			permissao = "Permiss�o de Gestor";
		} else {
			permissao = "Permiss�o comum";
		}
		return permissao;
	}

	/**
	 * Metodo que simula as permiss�es do BD (Testes ok)
	 * 
	 * @param usuarios "Cadastrados" no banco de dados
	 * @return boolean que retorna caso a lista n�o seja vazia
	 */
	public static boolean adicionarPermissao(ArrayList<String> usuarios) {
		if (!usuarios.isEmpty()) {
			// Adicionar os usuarios as variaveis arraylist de permiss�o
			permissao_admin.add(usuarios.get(0).toString());
			permissao_gestor.add(usuarios.get(1).toString());
			permissao_comum.add(usuarios.get(2).toString());
			permissao_comum.add(usuarios.get(3).toString());
			permissao_comum.add(usuarios.get(4).toString());
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Metodo para mostrar primeiro menu e que chama o metodo para tela de
	 * report(Apenas essa, por enquanto), assim como a declara��o de parametros para
	 * teste
	 */
	public static int mostraMenu(int escolhaIdUsuario) {
		// Instacia da classe da tela de report
		TelaReport tela = new TelaReport();
		Scanner sc = new Scanner(System.in);
		// Escolha do usu�rio no menu
		System.out.print("--------------------\n");
		do {
			System.out.println("Digite a op��o desejada:");
			System.out.println("Op��o 1 - Servi�os de RH");
			System.out.println("Op��o 2 - Tela Report");
			System.out.println("Op��o 0 - Sair");
			// Para teste JUnit
			// escolhaIdUsuario = sc.nextInt();
			if (escolhaIdUsuario == 2) {
				// Chama menu de report caso a op��o 2 seja a escolhida
				// tela.mostraMenuReport(2);
				return escolhaIdUsuario;
			}
		} while (escolhaIdUsuario != 0);
		return escolhaIdUsuario;
	}

	/**
	 * Main da classe
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * // Vari�veis de entrada -- Comentadas para teste JUnit ArrayList<String>
		 * usuarios = new ArrayList<String>(); ArrayList<String> senha = new
		 * ArrayList<String>();
		 * 
		 * // Adi��o de usu�rios usuarios.add("VANDERLEI"); usuarios.add("SABRINA");
		 * usuarios.add("SARA"); usuarios.add("LEONARDO"); usuarios.add("LUCAS");
		 * 
		 * // System.out.println(usuarios);
		 * 
		 * // Adi��o de senhas
		 * 
		 * senha.add("VANDERLEI123"); senha.add("SABRINA123"); senha.add("SARA123");
		 * senha.add("LEONARDO123"); senha.add("LUCAS123"); telaInicial(usuarios,
		 * senha);
		 */
	}

}
