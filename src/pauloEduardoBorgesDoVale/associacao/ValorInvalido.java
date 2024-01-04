package pauloEduardoBorgesDoVale.associacao;

public class ValorInvalido extends Exception {
		public ValorInvalido(String nome) {
			super("A variavel "+nome+" obtem valor nulo");
		}
	}
