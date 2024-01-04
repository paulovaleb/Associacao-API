package pauloEduardoBorgesDoVale.associacao;

public class AssociacaoJaExistente extends Exception {
public AssociacaoJaExistente(int numAssociacao) {
	super("Associação de número "+numAssociacao+" já existe.");
}
}
