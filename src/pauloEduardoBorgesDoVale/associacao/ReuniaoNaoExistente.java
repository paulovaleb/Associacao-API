package pauloEduardoBorgesDoVale.associacao;

public class ReuniaoNaoExistente extends Exception {
public ReuniaoNaoExistente(long dataReuniao) {
	super("A reuni�o de data "+dataReuniao+" n�o existe");
}
}
