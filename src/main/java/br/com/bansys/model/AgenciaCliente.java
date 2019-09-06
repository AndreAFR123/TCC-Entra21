package br.com.bansys.model;

import br.com.bansys.model.AgenciaCliente;

public class AgenciaCliente {
	private int fk_agencia;
	private int fk_cliente;
	
	public int getFk_agencia() {
		return fk_agencia;
	}
	
	public void setFk_agencia(int fk_agencia) {
		this.fk_agencia = fk_agencia;
	}
	
	public int getFk_cliente() {
		return fk_cliente;
	}
	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}

	@Override
	public String toString() {
		return "AgenciaCliente [fk_agencia=" + fk_agencia + ", fk_cliente=" + fk_cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fk_agencia;
		result = prime * result + fk_cliente;
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
		AgenciaCliente other = (AgenciaCliente) obj;
		if (fk_agencia != other.fk_agencia)
			return false;
		if (fk_cliente != other.fk_cliente)
			return false;
		return true;
	}

}
