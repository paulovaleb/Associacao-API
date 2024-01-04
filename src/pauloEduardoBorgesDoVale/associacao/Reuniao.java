package pauloEduardoBorgesDoVale.associacao;

import java.util.ArrayList;

public class Reuniao {
	private String ata = "";
	private long dataReuniao = 0;
	ArrayList<Integer> vetor = new ArrayList<Integer>();
	private int vigencia;

	public String getAta() {
		return ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public void setDataReuniao(long dataReuniao) {
		this.dataReuniao = dataReuniao;
	}

	public long getDataReuniao() {
		return dataReuniao;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setFrequenciaAssociado(int codigoAssociado, long data)
			throws FrequenciaJaRegistrada, FrequenciaIncompativel {
		if (data < dataReuniao) {
			throw new FrequenciaIncompativel(data);
		}
		for (Integer v : vetor) {
			if (codigoAssociado == v) {
				throw new FrequenciaJaRegistrada(codigoAssociado);
			}
		}

		vetor.add(codigoAssociado);
	}

	public int getFrequencia(int numeroAssociado, long inicio, long fim) {
		for (Integer v : vetor) {
			if (numeroAssociado == v) {
				return 1;
				}
			}
	return 0;
		}
	

	public int getAssociado(int numeroAssociado) {
		for (Integer v : vetor)
			if (numeroAssociado == v) {
				return 1;
			}
		return 0;
	}

	public Reuniao(long data, String ata) throws ValorInvalido {
		this.dataReuniao = data;
		this.ata = ata;
		
	}

}
