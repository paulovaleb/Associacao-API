package pauloEduardoBorgesDoVale.associacao;

public class AssociacaoJaExistente extends Exception {
public AssociacaoJaExistente(int numAssociacao) {
	super("Associa��o de n�mero "+numAssociacao+" j� existe.");
}
}
