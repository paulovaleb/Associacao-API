package pauloEduardoBorgesDoVale.associacao;

public class ReuniaoJaExistente extends Exception {
	public ReuniaoJaExistente(String nome) {
		super("A reuni�o " + nome + " j� existe");
	}
}
