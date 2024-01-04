package pauloEduardoBorgesDoVale.associacao;

public class TaxaJaExistente extends Exception{
public TaxaJaExistente (String nome) {
      super("A taxa "+nome+" já existe");
}
}
