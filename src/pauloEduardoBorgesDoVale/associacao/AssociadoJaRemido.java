package pauloEduardoBorgesDoVale.associacao;

public class AssociadoJaRemido extends Exception {
		public AssociadoJaRemido (String nome) {
			super("O associado " + nome + " ja foi remido.");
		}
}
