package pauloEduardoBorgesDoVale.associacao;

public class Pagamento {
	private int numAssociado;
	private long data;
	private double resto;
	private double pago;
	private double valorPago;
	private double valorAtual;
	private double parcelasAtual;

	public void setValorPago(double valorPago) {
		this.valorPago += valorPago;
	}

	public void setNumAssociado(int numAssociado) {
		this.numAssociado = numAssociado;
	}

	public void setResto(double resto) {
		this.resto = resto;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
	public void setValorAtualSubtrair(double valorAtual) {
		this.valorAtual -= valorAtual;
	}

	public void setData(long data) {
		this.data = data;
	}

	public void setParcelasAtual(double parcelasAtual) {
		this.parcelasAtual = parcelasAtual;
	}
	public void setParcelasAtualSubtracao(double parcelasAtual) {
		this.parcelasAtual -= parcelasAtual;
	}
	public double getParcelasAtual() {
		return parcelasAtual;
	}

	public double getValorPago() {
		return valorPago;
	}

	public double getValorAtual() {
		return valorAtual;
	}

	public int getNumAssociado() {
		return numAssociado;
	}

	public long getData() {
		return data;
	}

	public double getResto() {
		return resto;
	}

	public double getPago() {
		return pago;
	}

}
