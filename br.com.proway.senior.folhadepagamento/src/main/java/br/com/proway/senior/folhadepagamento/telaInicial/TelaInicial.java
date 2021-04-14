/**
 * 
 */
package br.com.proway.senior.folhadepagamento.telaInicial;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.proway.senior.folhadepagamento.telaReport.TelaReport;

/**
 * Classe inicial que seta o menu de inicialização
 * 
 * @author Sabrina, Vanderlei, Sarah, Lucas W e Leonardo P.
 * @since 13/04/21
 * @version 1.0
 *
 */
public class TelaInicial {

	// Constantes que simulam as permissões vindas do BD
	static final ArrayList<String> permissao_admin = new ArrayList<String>();
	static final ArrayList<String> permissao_gestor = new ArrayList<String>();
	static final ArrayList<String> permissao_comum = new ArrayList<String>();

	/**
	 * Metodo que inicializa o menu inicial simulando os usuarios e senhas
	 * cadastrados no BD cedendo ou não a permissão (Testes ok)
	 * 
	 * @param usuarios usuarios cadastradados
	 * @param senha    de usuarios cadastrados
	 * @return boolean para teste no JUnit e para chamada do método adicionar
	 *         permissão e segundo verifica permissão
	 */
	public static boolean telaInicial(ArrayList usuarios, ArrayList senha) {
		Scanner sc = new Scanner(System.in);
		boolean retorno;
		// Verifica permissões de usario e senha e chama o metodo para adicionar as
		// permissões
		System.out.print("Digite seu usuário: ");
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
	 * Metodos que verifica a permissão(Local) das constantes que foram
	 * instanciadas, assim que as permissões forem criadas no BD necessita melhorias
	 * cedendo ou não acesso as telas complementares (Testes ok)
	 * 
	 * @param usuarios cadastrados no BD
	 * @return String retorna a variavel de tipos de permissão
	 */
	public static String verificaPermissao(String usuario) {
		// Variavel que mostra os niveis de permissão
		String permissao;
		if (permissao_admin.contains(usuario)) {
			permissao = "Permissão de Admin";
		} else if (permissao_gestor.contains(usuario)) {
			permissao = "Permissão de Gestor";
		} else {
			permissao = "Permissão comum";
		}
		return permissao;
	}

	/**
	 * Metodo que simula as permissões do BD (Testes ok)
	 * 
	 * @param usuarios "Cadastrados" no banco de dados
	 * @return boolean que retorna caso a lista não seja vazia
	 */
	public static boolean adicionarPermissao(ArrayList<String> usuarios) {
		if (!usuarios.isEmpty()) {
			// Adicionar os usuarios as variaveis arraylist de permissão
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
	 * report(Apenas essa, por enquanto), assim como a declaração de parametros para
	 * teste
	 */
	public static int mostraMenu(int escolhaIdUsuario) {
		// Instacia da classe da tela de report
		TelaReport tela = new TelaReport();
		Scanner sc = new Scanner(System.in);
		// Escolha do usuário no menu
		System.out.print("--------------------\n");
		do {
			System.out.println("Digite a opção desejada:");
			System.out.println("Opção 1 - Serviços de RH");
			System.out.println("Opção 2 - Tela Report");
			System.out.println("Opção 0 - Sair");
			// Para teste JUnit
			// escolhaIdUsuario = sc.nextInt();
			if (escolhaIdUsuario == 2) {
				// Chama menu de report caso a opção 2 seja a escolhida
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
		 * // Variáveis de entrada -- Comentadas para teste JUnit ArrayList<String>
		 * usuarios = new ArrayList<String>(); ArrayList<String> senha = new
		 * ArrayList<String>();
		 * 
		 * // Adição de usuários usuarios.add("VANDERLEI"); usuarios.add("SABRINA");
		 * usuarios.add("SARA"); usuarios.add("LEONARDO"); usuarios.add("LUCAS");
		 * 
		 * // System.out.println(usuarios);
		 * 
		 * // Adição de senhas
		 * 
		 * senha.add("VANDERLEI123"); senha.add("SABRINA123"); senha.add("SARA123");
		 * senha.add("LEONARDO123"); senha.add("LUCAS123"); telaInicial(usuarios,
		 * senha);
		 */
	}

}
