package pauloEduardoBorgesDoVale.associacao;

public class ReuniaoNaoExistente extends Exception {
public ReuniaoNaoExistente(long dataReuniao) {
	super("A reunião de data "+dataReuniao+" não existe");
}
}
