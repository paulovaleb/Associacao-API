package pauloEduardoBorgesDoVale.associacao;

public class AssociacaoNaoExistente extends Exception {
		
	public AssociacaoNaoExistente(int numeroAssociacao) {
			super("A associacao de n�mero "+numeroAssociacao+" n�o existe");
	
		}
	}
