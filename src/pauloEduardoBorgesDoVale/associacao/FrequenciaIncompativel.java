package pauloEduardoBorgesDoVale.associacao;

public class FrequenciaIncompativel extends Exception {
public FrequenciaIncompativel(long data) {
	super("A frequ�ncia "+data+" � incompativel");
}
}
