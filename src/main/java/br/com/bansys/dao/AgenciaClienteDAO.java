package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.AgenciaCliente;

public class AgenciaClienteDAO {

	private final ConexaoJDBC conexao;

	public AgenciaClienteDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(AgenciaCliente agencia_cliente) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO agencia_cliente (fk_agencia, fk_cliente) VALUES (?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, agencia_cliente.getFk_agencia());
			stmt.setInt(2, agencia_cliente.getFk_cliente());
			stmt.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(AgenciaCliente agencia_cliente, int fk_agencia, int fk_cliente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE agencia_cliente SET fk_agencia = ?, fk_cliente = ? WHERE fk_agencia = ? and fk_cliente = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, agencia_cliente.getFk_agencia());
			stmt.setInt(2, agencia_cliente.getFk_cliente());
			stmt.setInt(3, fk_agencia);
			stmt.setInt(4, fk_cliente);

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int fk_agencia, int fk_cliente) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM agencia_cliente WHERE fk_agencia = ? and fk_cliente= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, fk_agencia);
			stmt.setInt(2, fk_cliente);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public AgenciaCliente selecionar(int fk_agencia) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia WHERE fk_agencia= ? and fk_cliente= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, fk_agencia);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<AgenciaCliente> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia_cliente ORDER BY fk_agencia";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<AgenciaCliente> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}

	private AgenciaCliente parser(ResultSet resultSet) throws SQLException {
		AgenciaCliente a = new AgenciaCliente();

		a.setFk_agencia(resultSet.getInt("fk_agencia"));
		a.setFk_cliente(resultSet.getInt("fk_cliente"));
		

		return a;
	}
}


