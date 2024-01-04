package pauloEduardoBorgesDoVale.associacao;

public class Associado {
	private int numeroAssociado = 0;
	private String nome = "";
	private String telefone = "";
	private long nascimento = 0;
	private long dataAssociacao = 0;
	private int nAssociacao;
	public void setNAssociacao(int nAssociacao) {
		this.nAssociacao = nAssociacao;
	}
	public int getNumeroAssociado() {
		return numeroAssociado;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public long getNascimento() {
		return nascimento;
	}

	public long getDataAssociacao() {
		return dataAssociacao;
	}

/*	public void setTaxa(Taxa taxa) throws TaxaJaExistente {
		for (int i = 0; i < tTam; i++) {
			if (taxa.getNome() == t[i].getNome() && taxa.getVigencia() == t[i].getVigencia()) {
				throw new TaxaJaExistente(taxa.getNome());
			}
		}
		t[tTam++] = taxa;	
	}

	public Taxa getTaxa(String nome, long vigencia) throws TaxaNaoExistente {
		for (int i = 0; i < tTam; i++) {
		if (t[i].getVigencia() == vigencia && t[i].getNome() == nome) {System.out.println(t[i]);
				return t[i];
			}
		}
		throw new TaxaNaoExistente(vigencia);
	}

	public double getTotalPagoTaxa(long inicio, long fim) throws TaxaNaoExistente {
		double total = 0;
		for (int i = 0; i < tTam; i++) {
		  total = t[i].getValorPago();
		}
		return total;
	}

	public double getTodasOsValoresTaxa() {
		double valor = 0;
		for (int i = 0; i < tTam; i++) {
			valor = t[i].getValor();
		}
		return valor;
	}
*/
	public Associado(int numeroAssociado, String nome, String telefone, long dataAssociacao, long nascimento)
			throws ValorInvalido {
		super();
		this.numeroAssociado = numeroAssociado;
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.dataAssociacao = dataAssociacao;

	}
}
