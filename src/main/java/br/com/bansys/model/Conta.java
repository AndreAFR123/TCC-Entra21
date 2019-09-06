package br.com.bansys.model;

public class Conta {

			
		private int idConta;
		private int num_conta;
		private double saldo_conta;
		private double limite_conta;
		private String tp_conta;
		private double emprestimo_conta;
		
		
		public int getIdConta() {
			return idConta;
		}
		public void setIdConta(int idConta) {
			this.idConta = idConta;
		}
		public int getNum_conta() {
			return num_conta;
		}
		public void setNum_conta(int num_conta) {
			this.num_conta = num_conta;
		}
		public double getSaldo_conta() {
			return saldo_conta;
		}
		public void setSaldo_conta(double saldo_conta) {
			this.saldo_conta = saldo_conta;
		}
		public double getLimite_conta() {
			return limite_conta;
		}
		public void setLimite_conta(double limite_conta) {
			this.limite_conta = limite_conta;
		}
		public String getTp_conta() {
			return tp_conta;
		}
		public void setTp_conta(String tp_conta) {
			this.tp_conta = tp_conta;
		}
		public double getEmprestimo_conta() {
			return emprestimo_conta;
		}
		public void setEmprestimo_conta(double emprestimo_conta) {
			this.emprestimo_conta = emprestimo_conta;
		}
		
				
		@Override
		public String toString() {
			return "Conta [idConta=" + idConta + ", num_conta=" + num_conta + ", saldo_conta=" + saldo_conta
					+ ", limite_conta=" + limite_conta + ", tp_conta=" + tp_conta + ", emprestimo_conta="
					+ emprestimo_conta + "]";
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idConta;
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
			Conta other = (Conta) obj;
			if (idConta != other.idConta)
				return false;
			return true;
		}
		
		
		
		
		
		
		
		

	

}
