package br.com.proway.senior.folhadepagamento.testsTelaInicial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.folhadepagamento.telaInicial.TelaInicial;
import br.com.proway.senior.folhadepagamento.telaReport.TelaReport;

public class TelaInicialTest {

	//Teste menu inicial da classe TelaInicial
	@Test
	public void telaInicialTest() {
		// Setando variaveis de teste
		ArrayList<String> usuarios = new ArrayList<String>();
		ArrayList<String> senha = new ArrayList<String>();
		senha.add("SABRINA123");
		usuarios.add("SABRINA");

		// Verificação
		assertTrue(TelaInicial.telaInicial(usuarios, senha));
	}

	//Teste de adicão de permissões(Baseado em uma implemnetação com dados previamente instalado.
	@Test
	public void adicionarPermissaoTest() {
		// Variáveis de entrada
		ArrayList<String> usuarios = new ArrayList<String>();

		// Adição de usuários
		usuarios.add("VANDERLEI");
		usuarios.add("SABRINA");
		usuarios.add("SARA");
		usuarios.add("LEONARDO");
		usuarios.add("LUCAS");

		assertTrue(TelaInicial.adicionarPermissao(usuarios));
	}

	//Teste do primeiro menu, apenas confirmando que a solicitação do usuário seja dois para
	//chamar a segunda tela de Report
	@Test
	public void mostraMenuTest() {
		assertEquals(2, TelaInicial.mostraMenu(2));
	}

	//Testa segundo menu, baseado na solicitação de mostraMenuTest(), confirmando a ação e "enviando um email" para RH com o topico
	/**
	 * @deprecated Depende do metodo adicionarPermissaoTest() para ser executado, correndo risco de erros
	 */
	@Test
	public void mostraMenuReportTest() {

		TelaReport tela = new TelaReport();

		String assuntoEmail1 = "Sugestão";
		String assuntoEmail2 = "Reclamação";
		String assuntoEmail3 = "Solicitação";
		String assuntoEmail4 = "Dúvidas";

		assertEquals("Sugestão", tela.mostraMenuReport(1));

	}
	
	   /**
		 * @deprecated Depende do metodo adicionarPermissaoTest() para ser executado, correndo risco de erros
		 */
		  @Test 
		  public void verificaPermissaoTest() { 
		  String permissao1 = "Permissão de Admin";
		  String permissao2 = "Permissão de Gestor"; 
		  String permissao3 = "Permissão comum";
		  
		  TelaInicial.verificaPermissao("SABRINA"); 
		  }

	
	/*
	 * Depende de outros metodos adicionarPermissaoTest() para ser executado, correndo risco de erros
	 * 
	 * @Test public void verificaPermissaoTest() { // Setando variaveis de teste
	 * String permissao1 = "Permissão de Admin"; String permissao2 =
	 * "Permissão de Gestor"; String permissao3 = "Permissão comum";
	 * 
	 * // Verficação assertEquals("Permissão de Gestor",
	 * TelaInicial.verificaPermissao("SABRINA")); }
	 */

}
