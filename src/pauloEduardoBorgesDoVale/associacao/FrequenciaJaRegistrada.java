package pauloEduardoBorgesDoVale.associacao;

public class FrequenciaJaRegistrada extends Exception{
public FrequenciaJaRegistrada (int codigoAssociado) {
	super("A frequ�ncia "+codigoAssociado+" j� foi registrada");
}
}
