package br.com.proway.senior.fechamentoFolha;

import java.time.LocalDateTime;

public class Folha {
	int id;
	LocalDateTime data;
	double salarioLiquido;
	double salarioBruto;
	double valorHoras;
	double valorHoraComInsalubridade;
	double horasTrabalhadas;
	double horasExtra;
	double valorHoraExtra;
	double reflexoDSR;
	double horasFalta;
	double valorBonificacao;
	double planoSaude;
	double percentualInsalubridade;
	double valorInsalubridade;
	double inss;
	double impostoDeRenda;
	double mensalidadePlanoSaude;
	double valorCooparticipacaoPlanoSaude;
	double valeTransporte = 50;
	double fator = 0.5; // 50% adicional hora extra
	double salarioMinimo = 1100;
	double salarioBase = 2500;

	public Folha(Colaborador colaborador) {
		this.horasTrabalhadas = colaborador.getPonto().getHorasTrabalhadas();
		this.horasExtra = colaborador.getPonto().getHorasExtra();
		this.horasFalta = colaborador.getPonto().getHorasFaltas();
		this.valorBonificacao = colaborador.getPonto().getValorBonificacao();
		this.percentualInsalubridade = colaborador.getPonto().getpercentualInsalubridade();
		this.mensalidadePlanoSaude = colaborador.getPonto().getMensalidadePlanoSaude();
		this.valorCooparticipacaoPlanoSaude = colaborador.getPonto().getvalorCooparticipacaoPlanoSaude();
		//this.valeTransporte = colaborador.getPonto().isValeTransporte();
	}
	
	// Set criado somente para debugar
	public void setSalarioBruto(double valor) {
		this.salarioBruto = valor;
	}
	
	public void setSalarioBase(double valor) {
		this.salarioBase = valor;
	}
	
//	public static double calculaFolhaFinal(int colabId) {
//		double horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas,
//				percentualInsalubridadeColab);
//		double valorSalarioBruto = calculaHorasTrabalhadas(quantidadeHorasTrabalhadas, horaComInsalubridade);
//		valorSalarioBruto += valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5);
//		valorSalarioBruto += adicionaBonificacao(valorBonificacaoColab);
//		double salarioDescontos = valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas)
//				+ descontaPlanoSaude(mensalidadePlanoSaudePlanoSaude, valorCoparticipacaoPlano)
//				+ calculaImpostoRenda(valorSalarioBruto) + descontoInss(valorSalarioBruto);
//		double salarioFinal = valorSalarioBruto - salarioDescontos;
//		return salarioFinal;
//	}
	
	public double calcularFolha() {
		//double baseCalculoImpostoDeRenda;
		double descontoValeTransporte;
		
		//this.salarioBruto += this.calculaValorHora(); // Ja traz insalubridade
		this.salarioBruto += this.calculaHorasTrabalhadas();
		this.salarioBruto -= this.valorHorasFaltas();
		descontoValeTransporte = this.calculaValeTransporte();
		this.salarioBruto += this.valorHorasExtras();
		this.salarioBruto += this.adicionaBonificacao();
		this.salarioBruto -= this.descontoInss();
		this.salarioBruto -= this.calculaImpostoRenda();
		this.salarioBruto -= this.descontaPlanoSaude();
		this.salarioBruto -= descontoValeTransporte;
		this.salarioLiquido = this.salarioBruto;
		
		return this.salarioLiquido;	
	}	
	/**
	 * Calcula o valor de vale transporte a ser descontado do colaborador
	 * 
	 * Chamada do metodo de Vale transporte que calcula o desconto, se o percentual
	 * aplicado de 0.06% for maior ou igual que R$ 180,00 o desconto ser� este, se for menor
	 * retorna este valor calculado, e se for informado um valor igual ou menor que 0 retorna 0.
	 * 
	 * @return valeTransporte = valor do vale transporte a ser descontado do sal�rio base.
	 */
	public double calculaValeTransporte() {
	    if(this.valeTransporte <= 0) {
	    	this.valeTransporte = 0;
		} else if ((this.salarioBase * 0.06) >= 180) {
			this.valeTransporte = 180;
		} else {
			this.valeTransporte = this.salarioBase * 0.06 ;
		}
		return this.valeTransporte;
	}
	
	/**
	 * Calcula o valor a ser pago em folha referente as horas extras
	 * 
	 * O valor retornado da multiplica��o de valorHoras e fator, vai somar com o valorHoras e depois multiplica
	 * pelas horasExtra
	 * @return valor = Retorna o valor a ser pago de horas extras.
	 */
	public double valorHorasExtras() { // Testado
		double valorHora50Porcento;
		return this.valorHoraExtra = this.horasExtra * (valorHora50Porcento = this.valorHoras + (this.valorHoras * this.fator));
	}
	
	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de sa�de, somando o valor da
	 * mensalidade com o valor de cooparticipa��o caso exista. A
	 * vari�vel planoSaude retornar� a soma das vari�veis mensalidadePlanoSaude e valorCooparticipacaoPlanoSaude.
	 * 
	 * @return planoSaude = retorna valor a ser descontado em folha, referente ao Plano de Saude.
	 */		
	public double descontaPlanoSaude() { // Tratar mensalidade Zerada
		
		if(this.mensalidadePlanoSaude >= 0) {
			if(this.valorCooparticipacaoPlanoSaude >= 0) {
				this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
			} else {
				this.valorCooparticipacaoPlanoSaude = 0;
				this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
			}
		} else {
			this.mensalidadePlanoSaude = 0;
			this.valorCooparticipacaoPlanoSaude = 0; 
			this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
		}
		
		return this.planoSaude;
					
		
	}
	
	/**
	 * Recebe o valor de bonifica��o a ser acrescido na folha do colaborador
	 * 
	 * Recebe o valor da bonifica��o que ser� aplicado posteriormente nos proventos
	 * do colaborador.
	 * 	 
	 * @return valorBonificacao = Retorna o valor de bonifica��o que ser� somado aos demais proventos
	 * na folha do colaborador
	 */
	public double adicionaBonificacao() {
		
		if(valorBonificacao > 0) {
			return this.valorBonificacao;	
		}else {
			return this.valorBonificacao = 0;	
		}
	}
	
	/**
	 * Calcula o valor de INSS a ser descontado
	 * 
	 * Realiza o c�lculo do valor de INSS a ser descontado em folha a partir do
	 * sal�rio informado. Pega a vari�vel salarioBruto e multiplica pelo valor de desconto fixado em 11%. 
	 * Retorna o valor a ser descontado.
	 * 
	 * @return inss = Retorna o valor a ser descontado em folha.
	 */
	public double descontoInss() {
		return this.inss = this.salarioBruto * 0.11;
		
	}
	
	public double descontoInss(double valorFerias) {
		return this.inss = valorFerias * 0.11;
		
	}
	
	/**
	 * Calcula o valor de Imposto de Renda a ser descontado em folha
	 * 
	 * Realiza o c�lculo do valor a ser descontado referente ao Imposto de Renda na
	 * folha do colaborador, seleciona o sal�rioBruto e multiplica pela sua faixa salarial
	 * e subtrai o valor a deduzir(exe:142,80). 				
	 * 
	 * @return impostoDeRenda = Retorna o valor que a ser descontado em folha referente ao Imposto de
	 *         Renda.
	 */
	public double calculaImpostoRenda() { //**********************
		
		if (this.salarioBruto <= 1903.98) {
			this.impostoDeRenda = 0;
		} else if (this.salarioBruto >= 1903.98 && this.salarioBruto <= 2826.65) {
			this.impostoDeRenda = (this.salarioBruto * 0.075) - 142.80;
		} else if (this.salarioBruto >= 2826.66 && this.salarioBruto <= 3751.05) {
			this.impostoDeRenda = (this.salarioBruto * 0.15) - 354.80;
		} else if (this.salarioBruto >= 3751.06 && this.salarioBruto <= 4664.68) {
			this.impostoDeRenda = (this.salarioBruto * 0.225) - 636.13;
		} else {
			this.impostoDeRenda = (this.salarioBruto * 0.275) - 869.36;
		}

		return this.impostoDeRenda;
	}
	
public double calculaImpostoRenda(double valorFerias) { //**********************
		
		if (valorFerias <= 1903.98) {
			this.impostoDeRenda = 0;
		} else if (valorFerias >= 1903.98 && valorFerias <= 2826.65) {
			this.impostoDeRenda = (valorFerias * 0.075) - 142.80;
		} else if (valorFerias >= 2826.66 && valorFerias <= 3751.05) {
			this.impostoDeRenda = (valorFerias * 0.15) - 354.80;
		} else if (valorFerias >= 3751.06 && valorFerias <= 4664.68) {
			this.impostoDeRenda = (valorFerias * 0.225) - 636.13;
		} else {
			this.impostoDeRenda = (valorFerias * 0.275) - 869.36;
		}

		return this.impostoDeRenda;
	}
	
	/**
	 * Calcula o valor da insalubridade 
	 * 
	 * Realiza o c�lculo do valor a ser implementado no sal�rio m�nimo, vai pegar a vari�vel salarioMinimo
	 * e multiplicar pela sua faixa de insalubridade.  
	 * 
	 * @return valorInsalubridade = Retorna o valor a ser somado ao sal�rio m�nimo.
	 */	
	public  double calculaInsalubridade() {
		if (this.percentualInsalubridade == 10) {
			return this.valorInsalubridade = this.salarioMinimo * 0.10;
		} else if (this.percentualInsalubridade == 20) {
			return this.valorInsalubridade = this.salarioMinimo * 0.20;
		} else if (this.percentualInsalubridade == 40) {
			return this.valorInsalubridade = this.salarioMinimo * 0.40;
		} else {
			return this.valorInsalubridade = 0;
		}
	}
	
	/**
	 * Calcula hora normal somando insalubridade.
	 * 
	 * Pega o valor do m�todo calculaInsalubridade e divide pela vari�vel horasTrabalhadas
	 *
	 * @return valorHoras = vai retornar o valor ganho de insalubridade por hora
	 */	
	// Corre��o a m�todos retundantes  de calculo de hora insalubre
	public double calculaValorHora() {  // Testado
		double valorHoraInsalubridade = (this.calculaInsalubridade() / 220);
		if(valorHoraInsalubridade < 0) {
		//return this.valorHoras;
		return this.valorHoras = this.salarioBase / 220; // 11,68181818181818
		} else {
		//return this.valorHoras = this.valorHoras + valorHoraInsalubridade;
		return  this.valorHoras = (this.salarioBase / 220) + valorHoraInsalubridade;
		}
	}
	
	
	
/**
	 * Calcula o valor inicial do sal�rio
	 * 
	 * Pega o valor do m�todo calculaValorHora passa para a vari�vel valorHoras, ap�s isso
	 * a vari�vel valor recebe a multipli��o de horasTrabalhas e valorHoras
	 * 
	 * @return valor = Retorna o valor do sal�rio inicial, considerando apenas a quantidade
	 *         horas trabalhadas e o valor da hora com insalubridade. 
	 */
	public double calculaHorasTrabalhadas() {
		
		double valorHoras = this.calculaValorHora();
		double valor = this.horasTrabalhadas * valorHoras;
		//BigDecimal teste = new BigDecimal(this.horasTrabalhadas * valorHoras);
		return valor;
	}
	
	/**
	 * Calcula o valor a ser descontado de horas faltas
	 * 
	 * Realiza o c�lculo das horas faltas a serem descontadas na folha do
	 * colaborador, recebe o valor de horasFalta e multiplica valorInsalubridade
	 * 
	 * @return valorFaltas = Retorna o valor a ser descontado na folha do colaborador referente as
	 * 	horas faltas.
	 */
	public double valorHorasFaltas() { // Testado
		double valorFaltas = this.horasFalta * this.valorHoras;
		return valorFaltas;
	}
	
	/**
	 * Calcula f�rias
	 * 
	 * 
	 */
	public double calcularFerias(int dias, int abono) {
		double valorHorasDias = (double) 220 / 30;
		double valorDia = this.calculaValorHora() * valorHorasDias;
		double valorFerias = dias * valorDia ;
		double valorFeriasUmTerco = valorFerias / 3 ;
		double valorTotalFerias = 0;
		if (abono <= 0) {
			valorTotalFerias = valorFerias + valorFeriasUmTerco;
			valorTotalFerias -= this.descontoInss(valorTotalFerias);
			valorTotalFerias -= this.calculaImpostoRenda(valorTotalFerias);
		} else {
			double valorAbono = abono * valorDia;
			double valorAbonoUmTerco = valorAbono / 3;
			valorTotalFerias = (valorFerias + valorFeriasUmTerco) + (valorAbono + valorAbonoUmTerco); 
			valorTotalFerias -= this.descontoInss(valorTotalFerias);
			valorTotalFerias -= this.calculaImpostoRenda(valorTotalFerias);
		}
		return valorTotalFerias;

	}
	
	/**
	 * Calcula o DSR 
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns par�metros passados    
	 */
	public void calculoDSR() {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		double result = (getHoraExtra() / diasUteis) * domigosFeriados;
		setReflexoDSR(result);
	}
	
	public double getReflexoDSR() {
		return this.reflexoDSR;
	}
	
	public void setReflexoDSR(double reflexoDSR) {
		this.reflexoDSR = reflexoDSR;
	}
	
	public double getHoraExtra() {
		return this.valorHoraExtra;
	}
	
//	public void setHoraExtra(double horaExtra) {
//		this.horaExtra = horaExtra;
//	}
	

}
