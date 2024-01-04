package pauloEduardoBorgesDoVale.associacao;

public class AssociadoRemido extends Associado {
	private long dataRemi��o = 0;

	public long dataRemicao() {
		return dataRemi��o;
	}

	public AssociadoRemido(int numeroAssociado, String nome, String telefone, long nascimento, long dataAssocia��o,
			long dataRemi��o) throws ValorInvalido {

		super(numeroAssociado, nome, telefone, nascimento, dataAssocia��o);
		this.dataRemi��o = dataRemi��o;
	}
}
