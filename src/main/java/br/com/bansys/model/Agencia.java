package br.com.bansys.model;

import br.com.bansys.model.Agencia;

public class Agencia {
	private int id_agencia;
	private String nm_agencia;
	private int num_agencia;
	private int tel_agencia;
	private String end_agencia;
	private int fk_agencia_banco;

	
	
	
	public int getId_agencia() {
		return id_agencia;
	}
	public void setId_agencia(int id_agencia) {
		this.id_agencia = id_agencia;
	}
	public String getNm_agencia() {
		return nm_agencia;
	}
	public void setNm_agencia(String nm_agencia) {
		this.nm_agencia = nm_agencia;
	}
	public int getNum_agencia() {
		return num_agencia;
	}
	public void setNum_agencia(int num_agencia) {
		this.num_agencia = num_agencia;
	}
	public int getTel_agencia() {
		return tel_agencia;
	}
	public void setTel_agencia(int tel_agencia) {
		this.tel_agencia = tel_agencia;
	}
	public String getEnd_agencia() {
		return end_agencia;
	}
	public void setEnd_agencia(String end_agencia) {
		this.end_agencia = end_agencia;
	}	
	public int getFk_agencia_banco() {
		return fk_agencia_banco;
	}
	public void setFk_agencia_banco(int fk_agencia_banco) {
		this.fk_agencia_banco = fk_agencia_banco;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Agencia [id_agencia=" + id_agencia + ", nm_agencia=" + nm_agencia + ", num_agencia=" + num_agencia
				+ ", tel_agencia=" + tel_agencia + ", end_agencia=" + end_agencia + ", fk_agencia_banco="
				+ fk_agencia_banco + "]";
	}




	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_agencia == null) ? 0 : end_agencia.hashCode());
		result = prime * result + fk_agencia_banco;
		result = prime * result + id_agencia;
		result = prime * result + ((nm_agencia == null) ? 0 : nm_agencia.hashCode());
		result = prime * result + num_agencia;
		result = prime * result + tel_agencia;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if (end_agencia == null) {
			if (other.end_agencia != null)
				return false;
		} else if (!end_agencia.equals(other.end_agencia))
			return false;
		if (fk_agencia_banco != other.fk_agencia_banco)
			return false;
		if (id_agencia != other.id_agencia)
			return false;
		if (nm_agencia == null) {
			if (other.nm_agencia != null)
				return false;
		} else if (!nm_agencia.equals(other.nm_agencia))
			return false;
		if (num_agencia != other.num_agencia)
			return false;
		if (tel_agencia != other.tel_agencia)
			return false;
		return true;
	}
	
}