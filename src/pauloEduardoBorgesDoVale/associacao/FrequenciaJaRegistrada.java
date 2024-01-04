package pauloEduardoBorgesDoVale.associacao;

public class FrequenciaJaRegistrada extends Exception{
public FrequenciaJaRegistrada (int codigoAssociado) {
	super("A frequência "+codigoAssociado+" já foi registrada");
}
}
