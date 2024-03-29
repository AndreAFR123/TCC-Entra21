package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.Conta;


public class ContaDAO {
	
	private final ConexaoJDBC conexao;

	public ContaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(Conta conta) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO conta (num_conta, saldo_conta, limite_conta, tp_conta, emprestimo_conta) VALUES (?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, conta.getNum_conta());
			stmt.setDouble(2, conta.getSaldo_conta());
			stmt.setDouble(3, conta.getLimite_conta());
			stmt.setString(4, conta.getTp_conta());
			stmt.setDouble(5, conta.getEmprestimo_conta());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
		
}
	
	public int alterar(Conta conta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE conta SET Num_conta = ?, Saldo_conta = ?, Limite_conta = ?, Tp_conta = ?, Emprestimo_conta = ? WHERE idConta = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, conta.getNum_conta());
			stmt.setDouble(2, conta.getSaldo_conta());
			stmt.setDouble(3, conta.getLimite_conta());
			stmt.setString(4, conta.getTp_conta());
			stmt.setDouble(5, conta.getEmprestimo_conta());
			stmt.setInt(6, conta.getIdConta());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}
	
	public void Transferencia(double saldo_conta, int id, double saldo, int num) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE conta SET saldo_conta = saldo_conta - ? WHERE idConta = ? ";
		String sql = "UPDATE conta SET saldo_conta = saldo_conta + ? WHERE num_Conta = ?";
		
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setDouble(1, saldo_conta);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			
			PreparedStatement stmt2 = this.conexao.getConnection().prepareStatement(sql);
			stmt2.setDouble(1, saldo);
			stmt2.setInt(2, num);
			stmt2.executeUpdate();
			
			this.conexao.commit();
			
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}
	

    public int Emprestimo(double saldo_conta, double emprestimo_conta, int id) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE conta SET Saldo_conta = Saldo_conta + ?, emprestimo_conta = emprestimo_conta - ? WHERE idConta = ?";
        int linhasAfetadas = 0;
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setDouble(1, saldo_conta);
            stmt.setDouble(2, emprestimo_conta);
            stmt.setInt(3, id);
            
            linhasAfetadas = stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
        return linhasAfetadas;
    }
    public int Saque(double saldo_conta, int idConta) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE conta SET Saldo_conta = (saldo_conta - ?) WHERE idConta = ?";
        int linhasAfetadas = 0;
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setDouble(1, saldo_conta);
            stmt.setInt(2, idConta);          
            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
        return linhasAfetadas;
    }
    public int Deposito(double saldo_conta, int idConta) throws SQLException, ClassNotFoundException {
        String sqlQuery = "UPDATE conta SET Saldo_conta = (Saldo_conta + ?) WHERE idConta = ?";
        int linhasAfetadas = 0;
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setDouble(1, saldo_conta);
            stmt.setInt(2, idConta);
            
           
            stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
        return linhasAfetadas;
    }
	
	public int excluir(int idConta) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM conta WHERE idConta = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idConta);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}
	
	public Conta selecionar(int idConta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM conta WHERE idConta= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idConta);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}
	public Conta consulta(int num_conta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM conta WHERE num_conta= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1,	num_conta);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}
	
	public List<Conta> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM conta ORDER BY idConta";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Conta> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private Conta parser(ResultSet resultSet) throws SQLException {
		Conta a = new Conta();

		a.setIdConta(resultSet.getInt("idConta"));
		a.setNum_conta(resultSet.getInt("num_conta"));
		a.setSaldo_conta(resultSet.getDouble("saldo_conta"));
		a.setLimite_conta(resultSet.getDouble("Limite_conta"));
		a.setTp_conta(resultSet.getString("tp_conta"));
		a.setEmprestimo_conta(resultSet.getDouble("Emprestimo_conta"));
		
				
		return a;
	}
	
	
		
}	

