package pauloEduardoBorgesDoVale.associacao;

import java.util.ArrayList;

public class Taxa {
	private String nome;
	private int parcelas;
	private int vigencia;
	private double valorInicial;
	private boolean administrativa;
	private long inicio;
	ArrayList<Pagamento> pago = new ArrayList<Pagamento>();

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public void setValor(double valor1) {
		this.valorInicial = valor1;
	}

	public double valorPorParcela() {
		return valorInicial / parcelas;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public void setAdministrativa(boolean administrativa) {
		this.administrativa = administrativa;
	}

	public long getInicio() {
		return vigencia;
	}

	public int getFim() {
		return vigencia;
	}

	public int getVigencia() {
		return vigencia;
	}

	public int getParcelas() {
		return parcelas;
	}

	public double getValor() {
		return valorInicial;
	}

	public boolean getAdministrativa() {
		return administrativa;
	}

	public String getNome() {
		return nome;
	}

	public double getPagamentos(int numAssociado, int vigencia) {
		double pagado = 0;
		for (Pagamento p : pago) {
			if (p.getNumAssociado() == numAssociado && this.vigencia == vigencia) {
				pagado += p.getValorPago();
			}
		}
		return pagado;
	}

	public Pagamento getPagador(int numAssociado) throws ValorInvalido {
		for (Pagamento p : pago) {
			if (p.getNumAssociado() == numAssociado) {
				return p;
			}
		}
		return null;
	}

	public void setPagamento(int numAssociado, long data) throws ValorInvalido {
		Pagamento p = new Pagamento();
		p.setNumAssociado(numAssociado);
		p.setData(data);
		p.setResto(0);
		p.setParcelasAtual(parcelas);
		p.setValorAtual(valorInicial);
		if (getPagador(numAssociado) == null) {
			pago.add(p);
		}
		return;
	}

	public void pagarTaxa(int numAssociado, double valor, long data) throws ValorInvalido {
		setPagamento(numAssociado, data);
		valor = valor + getPagador(numAssociado).getResto();
		if (valorPorParcela() > valor && parcelas > 1) {
			throw new ValorInvalido("Pagamento de número menor do que o valor da parcela antes da parcela final");
		}
		if (getPagador(numAssociado).getParcelasAtual() > 0) {// maior do q 0
			if (getPagador(numAssociado).getValorAtual() > 0) {
				if (getPagador(numAssociado).getParcelasAtual() == 1) {
					getPagador(numAssociado).setValorPago(getPagador(numAssociado).getValorPago() + valor);
					getPagador(numAssociado).setValorAtual(0);
					getPagador(numAssociado).setResto(0);
					getPagador(numAssociado).setParcelasAtualSubtracao(0);

				}
				if (valor % valorPorParcela() == 0) {
					getPagador(numAssociado).setValorPago(valor);
					getPagador(numAssociado).setValorAtualSubtrair(valor);
					getPagador(numAssociado).setResto(0);
					getPagador(numAssociado).setParcelasAtualSubtracao(1);
				}
				if (valor % valorPorParcela() > 0) {
					getPagador(numAssociado).setResto(valor % valorPorParcela());
					getPagador(numAssociado).setValorAtual(
							getPagador(numAssociado).getValorAtual() - (valor - getPagador(numAssociado).getResto()));
					getPagador(numAssociado).setValorPago(valor);
					getPagador(numAssociado).setParcelasAtualSubtracao(1);
				}

			}
		}

	}

	public Taxa(String nome, int vigencia, double valor, int parcelas, boolean administrativa) throws ValorInvalido {
		this.nome = nome;
		this.vigencia = vigencia;
		this.parcelas = parcelas;
		this.valorInicial = valor;
		this.administrativa = administrativa;
	}

}
