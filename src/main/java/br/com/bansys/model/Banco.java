package br.com.bansys.model;

public class Banco {

	private int idBanco;
	private String nm_banco;

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNm_banco() {
		return nm_banco;
	}

	public void setNm_banco(String nm_banco) {
		this.nm_banco = nm_banco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBanco;
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
		Banco other = (Banco) obj;
		if (idBanco != other.idBanco)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Banco [idBanco=" + idBanco + ", nm_banco=" + nm_banco + "]";
	}

}
