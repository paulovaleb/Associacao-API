package pauloEduardoBorgesDoVale.associacao;

import java.util.ArrayList;

public class Associacao {
	private String telefone = "";
	private String nome = "";
	private int numero = 0;
	ArrayList<Associado> associado = new ArrayList<Associado>();
	ArrayList<Reuniao> reuniao = new ArrayList<Reuniao>();
	ArrayList<Taxa> taxa = new ArrayList<Taxa>();

	public String getTelefone(String telefone) {
		return telefone;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setReuniao(Reuniao r) throws ReuniaoJaExistente, ValorInvalido {
		for (Reuniao re : reuniao) {
			System.out.println(r.getAta());
			if (r.getAta() == re.getAta()) {
				throw new ReuniaoJaExistente(r.getAta());
			}
		}
		if (r.getAta() == "" || r.getAta() == null || r.getDataReuniao() <= 0) {
			throw new ValorInvalido(r.getAta());
		}
		reuniao.add(r);
	}

	public void setAssociado(Associado a) throws AssociadoJaExistente, ValorInvalido {
		for (Associado asso : associado) {
			if (a == asso) {
				throw new AssociadoJaExistente(a.getNumeroAssociado());
			}
		}
		if (a.getNome() == "" || a.getNome() == null || a.getNumeroAssociado() <= 0 || a.getTelefone() == ""
				|| a.getTelefone() == null || a.getDataAssociacao() <= 0 || a.getNascimento() <= 0) {
			throw new ValorInvalido(a.getNome());
		}
		associado.add(a);
	}

	public void setTaxa(Taxa t) throws TaxaJaExistente, AssociadoJaRemido, ValorInvalido {
		for (Taxa t1 : taxa) {System.out.println(" MMMMMaaaadona"+t.getNome()+" "+ t1.getNome()+" "+t.getVigencia()+" "+t1.getVigencia());
			if (t.getNome() == t1.getNome()&&t.getVigencia()==t1.getVigencia()) {
				throw new TaxaJaExistente(t.getNome());
			}
		}
		if (t.getNome() == "" || t.getNome() == null || t.getValor() <= 0 || t.getVigencia() <= 0
				|| t.getParcelas() <= 0) {
			throw new ValorInvalido(t.getNome());
		}
		taxa.add(t);
	}

	public Associado getAssociado(int numAssociado) throws AssociadoNaoExistente {
		for (Associado a : associado) {
			if (a.getNumeroAssociado() == numAssociado) {
				return a;
			}
		}
		throw new AssociadoNaoExistente(numAssociado);
	}

	public void adicionarFrequencia(int codigoAssociado, long dataReuniao)
			throws FrequenciaJaRegistrada, ReuniaoNaoExistente, AssociadoNaoExistente, FrequenciaIncompativel {
		for (Reuniao r : reuniao) {
			if (r.getAssociado(codigoAssociado) == 1) {
				throw new FrequenciaJaRegistrada(codigoAssociado);
			}
		}
		getReuniao(dataReuniao).setFrequenciaAssociado(codigoAssociado, dataReuniao);
	}

	public Reuniao getReuniao(long dataReuniao) throws ReuniaoNaoExistente {
		for (Reuniao r : reuniao) {
			if (r.getDataReuniao() == dataReuniao) {
				return r;
			}
		}
		throw new ReuniaoNaoExistente(dataReuniao);
	}

	public double calculoFrequencia(int numAssociado, long inicio, long fim)
			throws ValorInvalido, FrequenciaIncompativel, ReuniaoNaoExistente, AssociadoNaoExistente {
		double frequencia = 0, i = 0, j = 0;
		for (Reuniao r : reuniao) {
			i++;
			if (r.getFrequencia(numAssociado, inicio, fim) == 1) {
				frequencia++;
			}
		}
		for (Associado a : associado) {
			if (a.getNumeroAssociado() == numAssociado) {
				j++;
			}
		}
		if (j == 0) {
			throw new AssociadoNaoExistente(numAssociado);
		}
		if (i == 0) {
			throw new FrequenciaIncompativel(inicio);
		}
		if (i == 0) {
			throw new ReuniaoNaoExistente(inicio);
		}

		double freq = (frequencia / i);
		return freq;
	}

	public void registrarPagamento(String taxa, int vigencia, int numAssociado, long data, double valor)
			throws AssociadoNaoExistente, TaxaNaoExistente, ValorInvalido, AssociadoJaRemido {
		if (getAssociado(numAssociado) instanceof AssociadoRemido) {
			if (getTaxa(taxa, vigencia).getAdministrativa() == true
					&& ((AssociadoRemido) getAssociado(numAssociado)).dataRemicao() >= vigencia) {
				throw new AssociadoJaRemido(getAssociado(numAssociado).getNome());
			}
		}
		if(getAssociado(numAssociado) instanceof AssociadoRemido) {System.out.println("hello gays"+ ((AssociadoRemido) getAssociado(numAssociado)).dataRemicao()+" "+ vigencia+" "+ getTaxa(taxa, vigencia).getAdministrativa());}
		getTaxa(taxa, vigencia).pagarTaxa(numAssociado, valor, data);
	}

	public Taxa getTaxa(String nome, int vigencia) throws TaxaNaoExistente {
		for (Taxa taxa : taxa) {
			if (taxa.getNome() == nome && taxa.getVigencia() == vigencia) {
				return taxa;
			}
		}
		throw new TaxaNaoExistente(vigencia);
	}

	public double getTaxas(int vigencia) {
		double taxas = 0;
		for (Taxa t : taxa) {
			if (t.getVigencia() == vigencia) {
				taxas += t.getValor();
			}
		}
		return taxas;
	}

	public double getTotalPagoTaxa(int numAssociado, String nomeTaxa, int vigencia, long inicio, long fim)
			throws TaxaNaoExistente, ValorInvalido, AssociadoNaoExistente {
		for (Taxa t : taxa) {

			if (getAssociado(numAssociado) instanceof AssociadoRemido && t.getAdministrativa() == true
					&& ((AssociadoRemido) getAssociado(numAssociado)).dataRemicao() >= vigencia) {
				return 0;
			}
			if (t.getPagador(numAssociado).getNumAssociado() == numAssociado && nomeTaxa == t.getNome()) {
				return t.getPagamentos(numAssociado, vigencia);
			}
		}
		throw new ValorInvalido(String.valueOf(numAssociado));
	}

	public Associacao(int numeroAssociacao, String nome) throws ValorInvalido {
		this.numero = numeroAssociacao;
		this.nome = nome;
	}
}