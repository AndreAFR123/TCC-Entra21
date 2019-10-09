package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.Funcionario;

public class FuncionarioDAO {

	private final ConexaoJDBC conexao;

	public FuncionarioDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO funcionario (cpf_funcionario, nm_funcionario, sobre_funcionario, pis_funcionario, end_funcionario, "
				+ "tel_funcionario, funcao_funcionario, sal_funcionario, cargah_funcionario, login_funcionario, senha_funcionario, email_funcionario, "
				+ "fk_funcionario_agencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, funcionario.getCpf_funcionario());
			stmt.setString(2, funcionario.getNm_funcionario());
			stmt.setString(3, funcionario.getSobre_funcionario());
			stmt.setString(4, funcionario.getPis_funcionario());
			stmt.setString(5, funcionario.getEnd_funcionario());
			stmt.setInt(6, funcionario.getTel_funcionario());
			stmt.setString(7, funcionario.getFuncao_funcionario());
			stmt.setDouble(8, funcionario.getSal_funcionario());
			stmt.setDouble(9, funcionario.getCargah_funcionario());
			stmt.setString(10, funcionario.getLogin_funcionario());
			stmt.setString(11, funcionario.getSenha_funcionario());
			stmt.setString(12, funcionario.getEmail_funcionario());
			stmt.setInt(13, funcionario.getFk_funcionario_agencia());

			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE funcionario SET cpf_funcionario = ?, nm_funcionario = ?, sobre_funcionario = ?, pis_funcionario = ?, end_funcionario = ?,"
				+ "tel_funcionario = ?, funcao_funcionario = ?, sal_funcionario = ?, cargah_funcionario = ?, login_funcionario = ?, "
				+ "senha_funcionario = ?, email_funcionario = ?, fk_funcionario_agencia = ? WHERE id_funcionario = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, funcionario.getCpf_funcionario());
			stmt.setString(2, funcionario.getNm_funcionario());
			stmt.setString(3, funcionario.getSobre_funcionario());
			stmt.setString(4, funcionario.getPis_funcionario());
			stmt.setString(5, funcionario.getEnd_funcionario());
			stmt.setInt(6, funcionario.getTel_funcionario());
			stmt.setString(7, funcionario.getFuncao_funcionario());
			stmt.setDouble(8, funcionario.getSal_funcionario());
			stmt.setDouble(9, funcionario.getCargah_funcionario());
			stmt.setString(10, funcionario.getLogin_funcionario());
			stmt.setString(11, funcionario.getSenha_funcionario());
			stmt.setString(12, funcionario.getEmail_funcionario());
			stmt.setInt(13, funcionario.getFk_funcionario_agencia());
			stmt.setInt(14, funcionario.getId_funcionario());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int id) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM funcionario WHERE id_funcionario = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Funcionario selecionar(int id) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE id_funcionario= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Funcionario> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario ORDER BY id_funcionario";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Funcionario> funcionario = new ArrayList<>();

			while (rs.next()) {
				funcionario.add(parser(rs));
			}

			return funcionario;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Funcionario parser(ResultSet resultSet) throws SQLException {
		Funcionario f = new Funcionario();
		
		f.setId_funcionario(resultSet.getInt("id_funcionario"));
		f.setCpf_funcionario(resultSet.getString("cpf_funcionario"));
		f.setNm_funcionario(resultSet.getString("nm_funcionario"));
		f.setSobre_funcionario(resultSet.getString("sobre_funcionario"));
		f.setPis_funcionario(resultSet.getString("pis_funcionario"));
		f.setEnd_funcionario(resultSet.getString("end_funcionario"));
		f.setTel_funcionario(resultSet.getInt("tel_funcionario"));
		f.setFuncao_funcionario(resultSet.getString("funcao_funcionario"));
		f.setSal_funcionario(resultSet.getDouble("sal_funcionario"));
		f.setCargah_funcionario(resultSet.getDouble("cargah_funcionario"));
		f.setLogin_funcionario(resultSet.getString("login_funcionario"));
		f.setSenha_funcionario(resultSet.getString("senha_funcionario"));
		f.setEmail_funcionario(resultSet.getString("email_funcionario"));
		f.setFk_funcionario_agencia(resultSet.getInt("fk_funcionario_agencia"));

		return f;
	}
}
