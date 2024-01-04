package pauloEduardoBorgesDoVale.associacao;

public class AssociadoJaExistente extends Exception{
public AssociadoJaExistente(int numeroAssociado){
	super("O associado de numero "+numeroAssociado+" já foi inserido");
}
}
