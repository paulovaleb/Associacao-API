package pauloEduardoBorgesDoVale.associacao; 
public class AssociadoNaoExistente extends Exception{
	public AssociadoNaoExistente(int numAssociado) {
		super("O associado de n�mero " + numAssociado+ " n�o existe");
	}
}
