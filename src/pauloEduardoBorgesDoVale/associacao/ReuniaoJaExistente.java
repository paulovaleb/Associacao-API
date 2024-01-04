package pauloEduardoBorgesDoVale.associacao;

public class ReuniaoJaExistente extends Exception {
	public ReuniaoJaExistente(String nome) {
		super("A reunião " + nome + " já existe");
	}
}
