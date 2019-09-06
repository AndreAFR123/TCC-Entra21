package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.Agencia;

public class AgenciaDAO {

	private final ConexaoJDBC conexao;

	public AgenciaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(Agencia agencia) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO agencia (nm_agencia, num_agencia, tel_agencia, end_agencia, fk_agencia_banco) VALUES (?, ?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, agencia.getNm_agencia());
			stmt.setInt(2, agencia.getNum_agencia());
			stmt.setInt(3, agencia.getTel_agencia());
			stmt.setString(4, agencia.getEnd_agencia());
			stmt.setInt(5, agencia.getFk_agencia_banco());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Agencia agencia) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE agencia SET num_agencia = ?, nm_agencia = ?, tel_agencia = ?, end_agencia = ?, fk_agencia_banco = ? WHERE id_agencia = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, agencia.getNum_agencia());
			stmt.setString(2, agencia.getNm_agencia());
			stmt.setInt(3, agencia.getTel_agencia());
			stmt.setString(4, agencia.getEnd_agencia());
			stmt.setInt(5, agencia.getFk_agencia_banco());
			stmt.setInt(6, agencia.getId_agencia());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int id_agencia) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM agencia WHERE id_agencia = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, id_agencia);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Agencia selecionar(int id_agencia) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia WHERE id_agencia= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, id_agencia);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Agencia> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia ORDER BY id_agencia";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Agencia> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Agencia parser(ResultSet resultSet) throws SQLException {
		Agencia a = new Agencia();

		a.setId_agencia(resultSet.getInt("id_agencia"));
		a.setNm_agencia(resultSet.getString("nm_agencia"));
		a.setNum_agencia(resultSet.getInt("num_agencia"));
		a.setTel_agencia(resultSet.getInt("tel_agencia"));
		a.setEnd_agencia(resultSet.getString("end_agencia"));
		a.setFk_agencia_banco(resultSet.getInt("fk_agencia_banco"));

		return a;
	}
}
