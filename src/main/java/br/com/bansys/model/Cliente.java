package br.com.bansys.model;

public class Cliente {

	private int idcliente;
	private String cpf_cliente;
	private String nm_cliente;
	private String sobre_cliente;
	private String end_cliente;
	private int tel_cliente;
	private String login_cliente;
	private String senha_cliente;
	private String email_cliente;
	private int fk_cliente_conta;

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getSobre_cliente() {
		return sobre_cliente;
	}

	public void setSobre_cliente(String sobre_cliente) {
		this.sobre_cliente = sobre_cliente;
	}

	public String getEnd_cliente() {
		return end_cliente;
	}

	public void setEnd_cliente(String end_cliente) {
		this.end_cliente = end_cliente;
	}

	public int getTel_cliente() {
		return tel_cliente;
	}

	public void setTel_cliente(int tel_cliente) {
		this.tel_cliente = tel_cliente;
	}

	public String getLogin_cliente() {
		return login_cliente;
	}

	public void setLogin_cliente(String login_cliente) {
		this.login_cliente = login_cliente;
	}

	public String getSenha_cliente() {
		return senha_cliente;
	}

	public void setSenha_cliente(String senha_cliente) {
		this.senha_cliente = senha_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public int getFk_cliente_conta() {
		return fk_cliente_conta;
	}

	public void setFk_cliente_conta(int fk_cliente_conta) {
		this.fk_cliente_conta = fk_cliente_conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcliente;
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
		Cliente other = (Cliente) obj;
		if (idcliente != other.idcliente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", cpf_cliente=" + cpf_cliente + ", nm_cliente=" + nm_cliente
				+ ", sobre_cliente=" + sobre_cliente + ", end_cliente=" + end_cliente + ", tel_cliente=" + tel_cliente
				+ ", login_cliente=" + login_cliente + ", senha_cliente=" + senha_cliente + ", email_cliente="
				+ email_cliente + ", fk_cliente_conta=" + fk_cliente_conta + "]";
	}
	
	
	

}
