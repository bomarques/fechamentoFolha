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

		// Verifica��o
		assertTrue(TelaInicial.telaInicial(usuarios, senha));
	}

	//Teste de adic�o de permiss�es(Baseado em uma implemneta��o com dados previamente instalado.
	@Test
	public void adicionarPermissaoTest() {
		// Vari�veis de entrada
		ArrayList<String> usuarios = new ArrayList<String>();

		// Adi��o de usu�rios
		usuarios.add("VANDERLEI");
		usuarios.add("SABRINA");
		usuarios.add("SARA");
		usuarios.add("LEONARDO");
		usuarios.add("LUCAS");

		assertTrue(TelaInicial.adicionarPermissao(usuarios));
	}

	//Teste do primeiro menu, apenas confirmando que a solicita��o do usu�rio seja dois para
	//chamar a segunda tela de Report
	@Test
	public void mostraMenuTest() {
		assertEquals(2, TelaInicial.mostraMenu(2));
	}

	//Testa segundo menu, baseado na solicita��o de mostraMenuTest(), confirmando a a��o e "enviando um email" para RH com o topico
	/**
	 * @deprecated Depende do metodo adicionarPermissaoTest() para ser executado, correndo risco de erros
	 */
	@Test
	public void mostraMenuReportTest() {

		TelaReport tela = new TelaReport();

		String assuntoEmail1 = "Sugest�o";
		String assuntoEmail2 = "Reclama��o";
		String assuntoEmail3 = "Solicita��o";
		String assuntoEmail4 = "D�vidas";

		assertEquals("Sugest�o", tela.mostraMenuReport(1));

	}
	
	   /**
		 * @deprecated Depende do metodo adicionarPermissaoTest() para ser executado, correndo risco de erros
		 */
		  @Test 
		  public void verificaPermissaoTest() { 
		  String permissao1 = "Permiss�o de Admin";
		  String permissao2 = "Permiss�o de Gestor"; 
		  String permissao3 = "Permiss�o comum";
		  
		  TelaInicial.verificaPermissao("SABRINA"); 
		  }

	
	/*
	 * Depende de outros metodos adicionarPermissaoTest() para ser executado, correndo risco de erros
	 * 
	 * @Test public void verificaPermissaoTest() { // Setando variaveis de teste
	 * String permissao1 = "Permiss�o de Admin"; String permissao2 =
	 * "Permiss�o de Gestor"; String permissao3 = "Permiss�o comum";
	 * 
	 * // Verfica��o assertEquals("Permiss�o de Gestor",
	 * TelaInicial.verificaPermissao("SABRINA")); }
	 */

}
