package br.com.bansys.model;

public class Funcionario {

	private int id_funcionario;
	private String cpf_funcionario;
	private String nm_funcionario;
	private String sobre_funcionario;
	private int pis_funcionario;
	private String end_funcionario;
	private int tel_funcionario;
	private String funcao_funcionario;
	private double sal_funcionario;
	private double cargah_funcionario;
	private String login_funcionario;
	private String senha_funcionario;
	private String email_funcionario;
	private int fk_funcionario_agencia;

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getCpf_funcionario() {
		return cpf_funcionario;
	}

	public void setCpf_funcionario(String cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}

	public String getNm_funcionario() {
		return nm_funcionario;
	}

	public void setNm_funcionario(String nm_funcionario) {
		this.nm_funcionario = nm_funcionario;
	}

	public String getSobre_funcionario() {
		return sobre_funcionario;
	}

	public void setSobre_funcionario(String sobre_funcionario) {
		this.sobre_funcionario = sobre_funcionario;
	}

	public int getPis_funcionario() {
		return pis_funcionario;
	}

	public void setPis_funcionario(int pis_funcionario) {
		this.pis_funcionario = pis_funcionario;
	}

	public String getEnd_funcionario() {
		return end_funcionario;
	}

	public void setEnd_funcionario(String end_funcionario) {
		this.end_funcionario = end_funcionario;
	}

	public int getTel_funcionario() {
		return tel_funcionario;
	}

	public void setTel_funcionario(int tel_funcionario) {
		this.tel_funcionario = tel_funcionario;
	}

	public String getFuncao_funcionario() {
		return funcao_funcionario;
	}

	public void setFuncao_funcionario(String funcao_funcionario) {
		this.funcao_funcionario = funcao_funcionario;
	}

	public double getSal_funcionario() {
		return sal_funcionario;
	}

	public void setSal_funcionario(double sal_funcionario) {
		this.sal_funcionario = sal_funcionario;
	}

	public double getCargah_funcionario() {
		return cargah_funcionario;
	}

	public void setCargah_funcionario(double cargah_funcionario) {
		this.cargah_funcionario = cargah_funcionario;
	}

	public String getLogin_funcionario() {
		return login_funcionario;
	}

	public void setLogin_funcionario(String login_funcionario) {
		this.login_funcionario = login_funcionario;
	}

	public String getSenha_funcionario() {
		return senha_funcionario;
	}

	public void setSenha_funcionario(String senha_funcionario) {
		this.senha_funcionario = senha_funcionario;
	}

	public String getEmail_funcionario() {
		return email_funcionario;
	}

	public void setEmail_funcionario(String email_funcionario) {
		this.email_funcionario = email_funcionario;
	}

	public int getFk_funcionario_agencia() {
		return fk_funcionario_agencia;
	}

	public void setFk_funcionario_agencia(int fk_funcionario_agencia) {
		this.fk_funcionario_agencia = fk_funcionario_agencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cargah_funcionario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cpf_funcionario == null) ? 0 : cpf_funcionario.hashCode());
		result = prime * result + ((email_funcionario == null) ? 0 : email_funcionario.hashCode());
		result = prime * result + ((end_funcionario == null) ? 0 : end_funcionario.hashCode());
		result = prime * result + fk_funcionario_agencia;
		result = prime * result + ((funcao_funcionario == null) ? 0 : funcao_funcionario.hashCode());
		result = prime * result + id_funcionario;
		result = prime * result + ((login_funcionario == null) ? 0 : login_funcionario.hashCode());
		result = prime * result + ((nm_funcionario == null) ? 0 : nm_funcionario.hashCode());
		result = prime * result + pis_funcionario;
		temp = Double.doubleToLongBits(sal_funcionario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((senha_funcionario == null) ? 0 : senha_funcionario.hashCode());
		result = prime * result + ((sobre_funcionario == null) ? 0 : sobre_funcionario.hashCode());
		result = prime * result + tel_funcionario;
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
		Funcionario other = (Funcionario) obj;
		if (Double.doubleToLongBits(cargah_funcionario) != Double.doubleToLongBits(other.cargah_funcionario))
			return false;
		if (cpf_funcionario == null) {
			if (other.cpf_funcionario != null)
				return false;
		} else if (!cpf_funcionario.equals(other.cpf_funcionario))
			return false;
		if (email_funcionario == null) {
			if (other.email_funcionario != null)
				return false;
		} else if (!email_funcionario.equals(other.email_funcionario))
			return false;
		if (end_funcionario == null) {
			if (other.end_funcionario != null)
				return false;
		} else if (!end_funcionario.equals(other.end_funcionario))
			return false;
		if (fk_funcionario_agencia != other.fk_funcionario_agencia)
			return false;
		if (funcao_funcionario == null) {
			if (other.funcao_funcionario != null)
				return false;
		} else if (!funcao_funcionario.equals(other.funcao_funcionario))
			return false;
		if (id_funcionario != other.id_funcionario)
			return false;
		if (login_funcionario == null) {
			if (other.login_funcionario != null)
				return false;
		} else if (!login_funcionario.equals(other.login_funcionario))
			return false;
		if (nm_funcionario == null) {
			if (other.nm_funcionario != null)
				return false;
		} else if (!nm_funcionario.equals(other.nm_funcionario))
			return false;
		if (pis_funcionario != other.pis_funcionario)
			return false;
		if (Double.doubleToLongBits(sal_funcionario) != Double.doubleToLongBits(other.sal_funcionario))
			return false;
		if (senha_funcionario == null) {
			if (other.senha_funcionario != null)
				return false;
		} else if (!senha_funcionario.equals(other.senha_funcionario))
			return false;
		if (sobre_funcionario == null) {
			if (other.sobre_funcionario != null)
				return false;
		} else if (!sobre_funcionario.equals(other.sobre_funcionario))
			return false;
		if (tel_funcionario != other.tel_funcionario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", cpf_funcionario=" + cpf_funcionario
				+ ", nm_funcionario=" + nm_funcionario + ", sobre_funcionario=" + sobre_funcionario
				+ ", pis_funcionario=" + pis_funcionario + ", end_funcionario=" + end_funcionario + ", tel_funcionario="
				+ tel_funcionario + ", funcao_funcionario=" + funcao_funcionario + ", sal_funcionario="
				+ sal_funcionario + ", cargah_funcionario=" + cargah_funcionario + ", login_funcionario="
				+ login_funcionario + ", senha_funcionario=" + senha_funcionario + ", email_funcionario="
				+ email_funcionario + ", fk_funcionario_agencia=" + fk_funcionario_agencia + "]";
	}
}