package pauloEduardoBorgesDoVale.associacao;

public class AssociadoJaExistente extends Exception{
public AssociadoJaExistente(int numeroAssociado){
	super("O associado de numero "+numeroAssociado+" j� foi inserido");
}
}
