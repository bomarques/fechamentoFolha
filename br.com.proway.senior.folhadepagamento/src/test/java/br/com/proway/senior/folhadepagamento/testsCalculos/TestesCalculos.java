package br.com.proway.senior.folhadepagamento.testsCalculos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.folhadepagamento.calculos.Calculos;

public class TestesCalculos {

	static double valorReferenciaEvento = 15.00;
	static double valorSalarioInicial;
	static double valorSalarioFinal;
	static double valorDiferencaSalario;
	static double valorInsalubridade = 220.00;
	static double valorMinimo = 1100.00;
	static int colabId = 101;
	static String nomeColab = "Maria";
	static double quantidadeHorasTrabalhadas = 220;
	static double valorHoraColab = 12.81;
	static boolean possuiInsalubridade = true;
	static double quantidadeHorasExtrasColab = 15;
	static double percentualInsalubridadeColab = 20;
	static double quantidadeHorasFaltas = 20;
	static double valorMensalidadePlanoSaude = 100.00;
	static double valorCoparticipacaoPlano = 236.25;
	static double valorBonificacaoColab = 250.00;
	static double valorHoraComInsalubridade = 13.81;
	static String stringTesteImprime = "Cadastro: 101\n" + "Nome: Maria" + "\n\n" + "Valor bruto: 3288.2000000000003\n"
			+ "Valor horas extras (+): R$ 0.0\n" + "Valor bonificações (+): R$ 250.0" + "\n\n"
			+ "Valor horas faltas (-): R$ 0.0\n" + "Valor plano de saúde (-): R$ 336.25\n"
			+ "Valor INSS (-): R$ 361.70200000000006\n" + "Valor IR (-): R$ 138.43\n"
			+ "Valor total descontos (-): R$ 836.3820000000001" + "\n\n" + "Valor líquido: R$ 2451.818";

	// Testes cadastros de eventos
	@Test
	public void testCadastroEvento1() {
		int idEvento = 503;
		String descricaoEvento = "Horas faltas";
		String tipoEvento = "Descontos";
		String tipoReferenciaEvento = "Horas";
		double valorReferenciaEvento = 13;
		String mensagem = Calculos.cadastroEvento(idEvento, descricaoEvento, tipoEvento, tipoReferenciaEvento,
				valorReferenciaEvento);
		assertEquals(mensagem, "Evento cadastrado com sucesso.");
	}

	@Test
	public void testCadastroEvento2() {
		int idEvento = 509;
		String descricaoEvento = "Horas extras";
		String tipoEvento = "Adicionais";
		String tipoReferenciaEvento = "Horas";
		double valorReferenciaEvento = 15;
		String mensagem = Calculos.cadastroEvento(idEvento, descricaoEvento, tipoEvento, tipoReferenciaEvento,
				valorReferenciaEvento);
		assertNotEquals(mensagem, "Evento não cadastrado");
	}

	// Testes método INSS
	@Test
	public void testCalculaINSS1() {
		double valorSalario = 3000;
		double resultado = Calculos.descontoInss(valorSalario);
		assertEquals(resultado, 330, 0);
	}

	@Test
	public void testCalculaINSS2() {
		double valorSalario = 2420.50;
		double resultado = Calculos.descontoInss(valorSalario);
		assertEquals(resultado, 266.20, 0.10);
	}

	// Teste folha
	@Test
	public void testFolhaFinal1() {
		double resultado = Calculos.calculaFolhaFinal(colabId);
		assertEquals(resultado, 2451.80, 0.10);
	}

	@Test
	public void testFolhaFinal2() {
		double resultado = Calculos.calculaFolhaFinal(colabId);
		assertFalse(resultado == 0);
	}

	@Test
	public void testFolhaFinal3() {
		double resultado = Calculos.calculaFolhaFinal(colabId);
		assertTrue(resultado > 0);
	}

	// Teste horas faltas
	@Test
	public void testCalculaHorasFaltas1() {
		double resultado = Calculos.valorHorasFaltas(valorHoraComInsalubridade, quantidadeHorasFaltas);
		assertEquals(resultado, 276.20, 0);
	}

	@Test
	public void testCalculaHorasFaltas2() {
		double resultado = Calculos.valorHorasFaltas(valorHoraComInsalubridade, quantidadeHorasFaltas);
		assertNotEquals(resultado, 333, 0);
	}

	// Teste método bonificação
	@Test
	public void testBonificacao() {
		double resultado = Calculos.adicionaBonificacao(250);
		assertEquals(resultado, 250, 0);
		assertEquals(resultado, valorBonificacaoColab, 0);
	}

	
	// Teste método imprime folha
	@Test public void testImprimeFolha() { 
	String resultado = Calculos.imprimeFolha(colabId); 
	assertEquals(resultado, stringTesteImprime); 
	}
	 

	@Test
	public void testeValorHorasExtras() {
		double valorDiferencaSalario = Calculos.valorHorasExtras(10.00, 8, 0.50);
		assertEquals(valorDiferencaSalario, 120, 0);
	}

	@Test
	public void testeCalculaHorasTrabalhadas() {
		double valorSalarioInicial = Calculos.calculaHorasTrabalhadas(40, 10);
		assertEquals(valorSalarioInicial, 400, 0);
	}

	@Test
	public void testaDescontoPlanoSaude() {
		double valorMensalidade = 80;
		double valorCoparticipacao = 100;
		double resultado = Calculos.descontaPlanoSaude(valorMensalidade, valorCoparticipacao);

		assertEquals(resultado, 180, 0.10);
	}

	@Test
	public void testaDescontoImpostoRenda() {
		double salarioBruto = 2500;
		double resultado = Calculos.calculaImpostoRenda(salarioBruto);

		assertEquals(resultado, 44.70, 0.10);
	}

	@Test
	public void testaValorInsalubridade10() {
		double percentual = 10;
		double resultado = Calculos.valorInsalubridade(percentual);

		assertEquals(resultado, 0, 110.10);
	}

	@Test
	public void testaValorInsalubridade20() {
		double percentual = 20;
		double resultado = Calculos.valorInsalubridade(percentual);

		assertEquals(resultado, 220, 0.10);
	}

	@Test
	public void testaValorInsalubridade40() {
		double percentual = 40;
		double resultado = Calculos.valorInsalubridade(percentual);

		assertEquals(resultado, 440, 0.10);
	}

	@Test
	public void testaValorInsalubridadeDiferente() {
		double percentual = 5;
		double resultado = Calculos.valorInsalubridade(percentual);

		assertEquals(resultado, 0, 0.10);
	}

	@Test
	public void testeCalculaHoraComInsalubridade() {
		double resultado = Calculos.calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas,
				percentualInsalubridadeColab);
		assertEquals(resultado, 8.50, 10);
	}

}
