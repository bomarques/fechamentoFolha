package br.com.proway.senior.folhadepagamento.calculos;

/**
 * @author Sarah, Lucas W, Leonardo P, Sabrina e Vanderlei.
 */

public class Calculos {

	static int idEvento = 505;
	static String descricaoEvento = "Horas Extras 50%";
	static String tipoEvento = "Adicionais";
	static String tipoReferenciaEvento = "Horas";
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
	static double quantidadeHorasExtrasColab = 0;
	static double percentualInsalubridadeColab = 20;
	static double quantidadeHorasFaltas = 0;
	static double valorMensalidadePlanoSaude = 100.00;
	static double valorCoparticipacaoPlano = 236.25;
	static double valorBonificacaoColab = 250.00;
	
	
	/**
	 * Criar evento para folha
	 * 
	 * Realiza o cadastro de um evento para a folha de pagamento e retorna uma mensagem de sucesso.
	 * 
	 * @param idEvento int número de identificação do evento
	 * @param descricaoEvento String descrição/nome do evento
	 * @param tipoEvento String define o tipo de evento (demonstrativo, descontos, proventos ou adicionais)
	 * @param tipoReferenciaEvento String define o tipo da referência (horas, quantidade, valor ou percentual)
	 * @param valorReferenciaEvento double define o valor da referência
	 * @return mensagem de sucesso
	 */
	public static String cadastroEvento(int idEvento, String descricaoEvento, String tipoEvento, String tipoReferenciaEvento, 
			double valorReferenciaEvento) {
		int setIdEvento = idEvento;
		String setDescricaoEvento = descricaoEvento;
		String setTipoEvento = tipoEvento;
		String setTipoReferenciaEvento = tipoReferenciaEvento;
		double setValorReferenciaEvento = valorReferenciaEvento;
		String mensagem = "Evento cadastrado com sucesso.";
		return mensagem;
	}

	
	/**
	 * Retorna o valor da folha total do colaborador
	 * A partir da identificação do colaborador (colabId), calcula-se o valor da hora com insalubridade que 
	 * é o resultado das informações do valor hora, quantidade de horas e o percentual de insalubridade.
	 * O valor do salario Bruto será o calculo das horas trabalhadas com e sem insalubridade.
	 * É possivel adicionar horas extras e bonificação.
	 * A variavel "salarioDescontos" recebe o calculo das faltas (em horas), o desconto do plano de saude
	 * o imposto de renda, INSS e o Vale transporte.
	 * @param colabId
	 * @return salarioFinal
	 */
	public static double calculaFolhaFinal(int colabId) {
		double horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas, percentualInsalubridadeColab);
		double valorSalarioBruto = calculaHorasTrabalhadas(quantidadeHorasTrabalhadas, horaComInsalubridade);
		valorSalarioBruto += valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5);
		valorSalarioBruto += adicionaBonificacao(valorBonificacaoColab);
		double salarioDescontos = valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas)
				+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano) + calculaImpostoRenda(valorSalarioBruto)
				+ descontoInss(valorSalarioBruto);
		double salarioFinal = valorSalarioBruto - salarioDescontos;
		return salarioFinal;
	}

	
	/**
	 * Método para "imprimir" a folha do colaborador
	 * Metodo ira imprimir as seguintes informações:
	 * Cadastro com Id do colaborador e seu nome;
	 * Valor Bruto com horas extras discriminadas e bonificações
	 * Total dos Descontos discriminados são o valor das horas falta, plano de saude, INSS, IR;
	 * Ao final trará discriminado o valor liquido que é o resultado da variáve salarioFinal
	 * @param colabId
	 */
	public static String imprimeFolha(int colabId) {
		String folhaGravada;
		double horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab, quantidadeHorasTrabalhadas, percentualInsalubridadeColab);
		double valorSalarioBruto = calculaHorasTrabalhadas(quantidadeHorasTrabalhadas, horaComInsalubridade) 
				+ valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5) + adicionaBonificacao(valorBonificacaoColab);
		double salarioDescontos = valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas)
				+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano) + calculaImpostoRenda(valorSalarioBruto)
				+ descontoInss(valorSalarioBruto);
		double salarioFinal = valorSalarioBruto - salarioDescontos;
		folhaGravada = "Cadastro: " + colabId + "\n" + "Nome: " + nomeColab + "\n \n" + "Valor bruto: " + valorSalarioBruto + "\n" + ("Valor horas extras (+): R$ " 
		+ valorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade, 0.5) + "\n" + "Valor bonificações (+): R$ " + adicionaBonificacao(valorBonificacaoColab)
		+ "\n \n" + "Valor horas faltas (-): R$ " + valorHorasFaltas(horaComInsalubridade, quantidadeHorasFaltas) + "\n" + "Valor plano de saúde (-): R$ "
		+ descontaPlanoSaude(valorMensalidadePlanoSaude, valorCoparticipacaoPlano) + "\n" + "Valor INSS (-): R$ " + descontoInss(valorSalarioBruto)
		+ "\n" + "Valor IR (-): R$ " + calculaImpostoRenda(valorSalarioBruto) + "\n" + "Valor total descontos (-): R$ " + salarioDescontos + "\n \n" + "Valor líquido: R$ " 
		+ salarioFinal);
		System.out.println(folhaGravada);
		System.out.println(folhaGravada.length());
		return folhaGravada.toString();
	}

	//
	/**
	 * Metodo para Calcular insalubridade
	 * Este metodo recebera diferentes percentuais( 10%, 20% ou 40%) de insalubridade para ao final retornar 
	 * o valor com base na multiplicação pelo Salario Minimo
	 * @param percentual
	 * @return
	 */
	public static double valorInsalubridade(double percentual) {
		if (percentual == 10) {
			return valorInsalubridade = valorMinimo * 0.10;
		} else if (percentual == 20) {
			return valorInsalubridade = valorMinimo * 0.20;
		} else if (percentual == 40) {
			return valorInsalubridade = valorMinimo * 0.40;
		} else {
			return valorInsalubridade = 0;
		}
	}

	//
	/**
	 * Calcula o valor inicial do salário
	 * 
	 * Realiza o cálculo do valor inicial do salário considerando a quantidade de horas trabalhadas vezes
	 * valor da hora com insalubridade do colaborador. O valor retornado é base para construir o salário bruto
	 * do colaborador e realizar os demais cálculos para o fechamento.
	 * 
	 * @param quantidadeHorasTrabalhadas double Quantidade horas trabalhadas no mês conforme escala do colaborador.
	 * @param valorHoraComInsalubridade double Valor da hora do colaborador já acrescido da insalubridade.
	 * @return Retorna o valor do salário inicial, considerando apenas a quantidade horas trabalhadas e o valor da 
	 * hora com insalubridade. Demais proventos será acrescentados no cálculo final da folha.
	 */
	public static double calculaHorasTrabalhadas(double quantidadeHorasTrabalhadas, double valorHoraComInsalubridade) {
		double valorSalarioInicial = quantidadeHorasTrabalhadas * valorHoraComInsalubridade;
		return valorSalarioInicial;
	}
	
	
	/** 
	 * Calcula hora normal somando insalubridade.
	 * 
	 * Realiza calculo para somar valor hora de insalubridade junto a hora normal.
	 * Recebe três parâmetros: 1º valorHoraColab, 2º quantidadeHorasTrabalhadas, 3º percentualInsalubridade.
	 * Atraves do percentualInsalubridade receberemos o valorInsalubridade calculado sobre o salario mínimo.
	 * Caso o valor seja 10, 20 ou 40, a variavel valorHoraComInsalubridade recebe valorHora + (valorInsalubridade / quantidadeHorasTrabalhadas),
	 * retornando o valorHoraComInsalubridade.
	 * Caso seja um valor diferente, valorInsalubridade recebera 0, e valorHora multiplicara quantidadeHorasTrabalhadas retornando o valorHora
	 *
	 * @param valorHora double
	 * @param quantidadeHorasTrabalhadas double
	 * @param percentualInsalubridade double
	 * @return
	 */
	public static double calculaHoraComInsalubridade(double valorHora, double quantidadeHorasTrabalhadas, double percentualInsalubridade) {
		double valorHoraComInsalubridade = 0;
		double valorInsalubridade = valorInsalubridade(percentualInsalubridade);
		if (valorInsalubridade > 0) {
			valorHoraComInsalubridade = valorHora + (valorInsalubridade / quantidadeHorasTrabalhadas);
		} else if (valorInsalubridade == 0) {
			valorSalarioInicial = valorHora * quantidadeHorasTrabalhadas;
		}
		return valorHoraComInsalubridade;
	}

	
	/**
	 * Calcula o valor a ser pago em folha referente as horas extras
	 * 
	 * Realiza o cálculo da diferença salarial a ser adicionada referente as horas
	 * extras realizadas pelo colaborador. Considera o valor da hora já acrescido de 
	 * insalubridade multiplicado pela quantidade de horas extras e somando o fator 
	 * devido (50%, 70% e ou conforme necessidade). 
	 *  
	 * @param horaComInsalubridade double Valor da hora do colaborador já acrescido da 
	 * insalubridade.
	 * @param quantidadeHrsExtras double Quantidade de horas extras realizadas.
	 * @param fator Percentual a ser acrescido sobre a hora extra.
	 * @return Retorna o valor a ser pago de horas extras.
	 */
	public static double valorHorasExtras(double horaComInsalubridade, double quantidadeHrsExtras, double fator) {
		double valorHrsExtras = quantidadeHrsExtras * horaComInsalubridade;
		valorDiferencaSalario = valorHrsExtras + (valorHrsExtras * fator);
		return valorDiferencaSalario;
	}

	
	/**
	 * Calcula o valor a ser descontado de horas faltas
	 * 
	 * Realiza o cálculo das horas faltas a serem descontadas na folha do colaborador,
	 * recebe o valor da hora acrescido da insalubridade (se houver) e multiplica
	 * pela quantidade de horas faltas informadas.
	 * 
	 * @param horaComInsalubridade double Valor da hora do colaborador acrescido da insalubridade.
	 * @param quantidadeHrsFaltas double Quantidade de horas faltas.
	 * @return Retorna o valor a ser descontado na folha do colaborador referente as horas faltas.
	 */
	public static double valorHorasFaltas(double horaComInsalubridade, double quantidadeHrsFaltas) {
		double valorHorasFaltas = quantidadeHrsFaltas * horaComInsalubridade;
		valorDiferencaSalario = valorHorasFaltas;
		return valorDiferencaSalario;
	}

	
	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de saude, repassando o 1º parâmetro como valor de mensalidade,
	 * e o 2º parâmetro o valor de cooparticipacao caso exista. A variavel totalDescontoPlanoSaude
	 * retornara a soma dos dois parâmetros.
	 * 
	 * @param valorMensalidade double do colaborador
	 * @param valorCoparticipacao double adicional do colaborador
	 * @return retorna valor a ser descontado em folha, referente ao Plano de Saude
	 */
	public static double descontaPlanoSaude(double valorMensalidade, double valorCoparticipacao) {
		double totalDescontoPlanoSaude = valorMensalidade + valorCoparticipacao;
		return totalDescontoPlanoSaude;
	}
	
	
	/**
	 * Calcula o valor de Imposto de Renda a ser descontado em folha
	 * 
	 * Realiza o cálculo do valor a ser descontado referente ao Imposto de
	 * Renda na folha do colaborador, a partir do salário bruto do colaborador.
	 * 
	 * @param valorSalarioBruto double Valor do salário bruto do colaborador, 
	 * inluindo os demais proventos como horas extras e bonificação.
	 * @return Retorna o valor que a ser descontado em folha referente ao
	 * Imposto de Renda.
	 */
	public static double calculaImpostoRenda(double valorSalarioBruto) {
		double resultado;
		
		if(valorSalarioBruto <= 1903.98) {
			resultado = 0;
		}else if(valorSalarioBruto >= 1903.98 && valorSalarioBruto <= 2826.65) {
			resultado = (valorSalarioBruto * 0.075) - 142.80;
		} else if(valorSalarioBruto >= 2826.66 && valorSalarioBruto <= 3751.05) {
			resultado = (valorSalarioBruto * 0.15) - 354.80;
		} else if(valorSalarioBruto >= 3751.06 && valorSalarioBruto <= 4664.68) {
			resultado = (valorSalarioBruto * 0.225) - 636.13;
		} else {
			resultado = (valorSalarioBruto * 0.275) - 869.36;
		}
		
		return resultado;
	}
	
	
	/**
	 * Recebe o valor de bonificação a ser acrescido na folha do colaborador
	 * 
	 * Recebe o valor da bonificação que será aplicado posteriormente nos
	 * proventos do colaborador.
	 * 
	 * @param valorBonificacao double Valor que o colaborador receberá de bonificação
	 * @return Retorna o valor de bonificação que será somado aos demais proventos na 
	 * folha do colaborador
	 */
	 public static double adicionaBonificacao(double valorBonificacao) { 
		 return valorBonificacao; 
	}
	 
	 
	 /**
	  * Calcula o valor de INSS a ser descontado
	  * 
	  * Realiza o cálculo do valor de INSS a ser descontado em folha
	  * a partir do salário informado. Valor de desconto fixado em 11%.
	  * Retorna o valor a ser descontado.
	  * 
	  * @param valorSalarioBruto double Salário bruto do colaborador, 
	  * inluindo os demais proventos como horas extras e bonificação.
	  * @return Retorna o valor a ser descontado em folha.
	  */
	 public static double descontoInss(double valorSalarioBruto) {
		double calculaInss = valorSalarioBruto * 0.11;
		return calculaInss;

	}
	 
	 
	/**
	 * Calcula o valor de vale transporte a ser descontado do colaborador
	 * 
	 * Chamada do metodo de Vale transporte que calcula o desconto, se o percentual
	 * aplicado de 0.06% for maior que R$ 180,00 o desconto será este, se for menor
	 * retorna este valor calculado. Falta ser incluído no cálculo final da folha.
	 * 
	 * @param valetransporte
	 * @return valetransporte
	 */
	public static double calculaValeTransporte(double valeTransporte, double valorSalarioBruto) {
		if ((0.06 * valorSalarioBruto) >= 180) {
			System.out.println("O desconto de Vale Transporte sera de : R$ " + valeTransporte);
		} else
			System.out.println("O desconto de Vale Transporte sera de : R$ " + (0.06 * valorSalarioBruto));
		return valeTransporte;
	}
	 
	 
	public static void main(String[] args) {

		// Chamando os métodos
		//System.out.println("R$ " + calculaHoraComInsalubridade(9.50, 220, 40));
		//System.out.println("R$ " + valorHorasExtras(9.50, 15, 0.5));
		//System.out.println("R$ " + calculaFolhaFinal(101));
		imprimeFolha(101);
		//System.out.println(cadastroEvento(idEvento, descricaoEvento, tipoEvento, tipoReferenciaEvento, valorReferenciaEvento));
	}

}
