package pauloEduardoBorgesDoVale.associacao; 
public class AssociadoNaoExistente extends Exception{
	public AssociadoNaoExistente(int numAssociado) {
		super("O associado de número " + numAssociado+ " não existe");
	}
}
