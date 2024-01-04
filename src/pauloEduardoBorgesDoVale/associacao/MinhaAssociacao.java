package pauloEduardoBorgesDoVale.associacao;

import java.util.ArrayList;

public class MinhaAssociacao implements InterfaceAssociacao {
	ArrayList<Associacao> associacao = new ArrayList<Associacao>();

	/*
	 * Calcula a frequ�ncia de um associado nas reuni�es ocorridas durante um
	 * determinado per�odo, retornando um n�mero entre 0 e 1 (ex: 0,6, indicando que
	 * o associado participou de 60% das reuni�es.
	 */
	public double calcularFrequencia(int numAssociado, int numAssociacao, long inicio, long fim)
			throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, ValorInvalido, FrequenciaIncompativel {
		for (Associacao a : associacao) {
			if (a.getNumero() == numAssociacao) {
					return a.calculoFrequencia(numAssociado, inicio, fim);
			}
		}
		return 0;
	}

	/*
	 * Registra a frequencia de um associado em uma reuni�o. n�o deveria registrar
	 * participacao em reunioes acontecidas antes da sua filiacao na associa��o.
	 */
	public void registrarFrequencia(int codigoAssociado, int numAssociacao, long dataReuniao)
			throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, FrequenciaJaRegistrada,
			FrequenciaIncompativel {
		int j = 0;
		for (Associacao a : associacao) {
			if (a.getNumero() == numAssociacao) {
				a.adicionarFrequencia(codigoAssociado, dataReuniao);
				j++;
			}
		}
		if (j == 1) {
			return;
		}
		throw new AssociacaoNaoExistente(numAssociacao);

	}

	/*
	 * Registra o pagamento de uma taxa, em uma associa��o, dentro uma determinada
	 * compet�ncia, para um associado. O valor a ser pago n�o pode ser menor que uma
	 * parcela, embora n�o precise ser exatamente duas parcelas. Uma parcela de
	 * R$20,00 por m�s aceita um pagamento de R$30,00, sendo uma parcela completa e
	 * um peda�o da pr�xima. Associados remidos n�o deveriam mais realizar
	 * pagamentos de taxas administrativas vigentes em datas antes da sua remiss�o,
	 * gerando exce��o de AssociadoJaRemido se houver tentativa de se pagar algo
	 * para esse caso. Caso o valor a ser pago seja menor que o m�nimo (n�o sendo o
	 * ultimo do ano!) ou gerando pagamento maior que a taxa anual, gerar exce��o de
	 * ValorInvalido. Lembrar de verificar valores negativos.
	 */
	public void registrarPagamento(int numAssociacao, String taxa, int vigencia, int numAssociado, long data,
			double valor)
			throws AssociacaoNaoExistente, AssociadoNaoExistente, AssociadoJaRemido, TaxaNaoExistente, ValorInvalido {
		int j = 0;
		for (Associacao a : associacao) {
			if (a.getNumero() == numAssociacao) {
				a.registrarPagamento(taxa, vigencia, numAssociado, data, valor);
				j++;
			}
		}
		if (j == 1) {
			return;
		}
		throw new AssociacaoNaoExistente(numAssociacao);
	}

	/*
	 * Calcula o total de pagamentos realizado por um associado, em uma associa��o,
	 * para uma taxa, que possui uma vig�ncia, dentro de um certo per�odo de tempo.
	 */
	public double somarPagamentoDeAssociado(int numAssociacao, int numAssociado, String nomeTaxa, int vigencia,
			long inicio, long fim) throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente {
		for (Associacao a : associacao) {
			if (a.getNumero() == numAssociacao) {
				try {
					return a.getTotalPagoTaxa(numAssociado, nomeTaxa, vigencia, inicio, fim);
				} catch (TaxaNaoExistente | ValorInvalido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		throw new AssociacaoNaoExistente(numAssociacao);
	}

	/* Calcula o total de taxas previstas para um dado ano, em uma associa��o. */
	public double calcularTotalDeTaxas(int numAssociacao, int vigencia)
			throws AssociacaoNaoExistente, TaxaNaoExistente {
		for (Associacao a : associacao) {
			if (a.getNumero() == numAssociacao) {
				return a.getTaxas(vigencia);
			}
		}
		throw new AssociacaoNaoExistente(numAssociacao);
	}

	/*
	 * Adiciona uma associa��o a ser gerenciada. Valida todos os campos para evitar
	 * dados n�o preenchidos.
	 */
	public void adicionar(Associacao a2) throws AssociacaoJaExistente, ValorInvalido {
		if (a2.getNome() == "" || a2.getNumero() <= 0 || a2.getNome() == null) {
			throw new ValorInvalido(a2.getNome());
		}
		for (Associacao a : associacao) {
			if (a.getNome() == a2.getNome()) {
				throw new AssociacaoJaExistente(a2.getNumero());
			}
		}
		associacao.add(a2);
	}

	/*
	 * Adiciona um associado a uma associa��o. Valida todos os campos para evitar
	 * dados n�o preenchidos.
	 */
	public void adicionar(int nAssociacao, Associado a2)
			throws ValorInvalido, AssociacaoNaoExistente, AssociadoJaExistente {
		int j = 0;
		for (Associacao a : associacao) {
			if (a.getNumero() == nAssociacao) {
				a.setAssociado(a2);
				j++;
			}
		}
		if (j == 1) {
			return;
		}
		throw new AssociacaoNaoExistente(nAssociacao);
	}

	/*
	 * Adiciona uma reuni�o a uma associa��o. Valida todos os campos para evitar
	 * dados n�o preenchidos.
	 */
	public void adicionar(int nAssociacao, Reuniao r) throws ReuniaoJaExistente, ValorInvalido, AssociacaoNaoExistente {
		int j = 0;
		for (Associacao a : associacao) {
			if (a.getNumero() == nAssociacao) {
				a.setReuniao(r);
				j++;
			}
		}
		if (j == 1) {
			return;
		}
		throw new AssociacaoNaoExistente(nAssociacao);
	}

	/*
	 * Adiciona uma taxa a uma associa��o. Valida todos os campos para evitar dados
	 * n�o preenchidos.
	 */
	public void adicionar(int nAssociacao, Taxa t) throws AssociacaoNaoExistente, TaxaJaExistente, ValorInvalido {
		int j = 0;
		for (Associacao a : associacao) {
			if (a.getNumero() == nAssociacao) {
				try {
					a.setTaxa(t);
				} catch (TaxaJaExistente | AssociadoJaRemido e) {
					e.printStackTrace();
				}
				j++;
			}
		}
		if (j == 1) {
			return;
		}
		throw new AssociacaoNaoExistente(nAssociacao);
	}
}
