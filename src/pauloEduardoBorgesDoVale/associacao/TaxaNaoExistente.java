package pauloEduardoBorgesDoVale.associacao;

public class TaxaNaoExistente extends Exception {
	public TaxaNaoExistente(long data) {
		super("A taxa " + data + " não existe.");
	}
}
