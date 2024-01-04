package pauloEduardoBorgesDoVale.associacao;

public class AssociadoRemido extends Associado {
	private long dataRemição = 0;

	public long dataRemicao() {
		return dataRemição;
	}

	public AssociadoRemido(int numeroAssociado, String nome, String telefone, long nascimento, long dataAssociação,
			long dataRemição) throws ValorInvalido {

		super(numeroAssociado, nome, telefone, nascimento, dataAssociação);
		this.dataRemição = dataRemição;
	}
}
