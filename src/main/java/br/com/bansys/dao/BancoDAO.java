package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.Banco;


public class BancoDAO {

	private final ConexaoJDBC conexao;

	public BancoDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(Banco banco) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "INSERT INTO banco (nm_banco) VALUES (?) ";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, banco.getNm_banco());
            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
        return id;
    }

	public int alterar(Banco banco) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE banco SET nm_banco = ? WHERE idBanco = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, banco.getNm_banco());
			stmt.setInt(2, banco.getIdBanco());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int idBanco) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM banco WHERE idBanco = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idBanco);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Banco selecionar(int idBanco) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM banco WHERE idBanco= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idBanco);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Banco> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM banco ORDER BY idBanco";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Banco> bancos = new ArrayList<>();

			while (rs.next()) {
				bancos.add(parser(rs));
			}

			return bancos;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Banco parser(ResultSet resultSet) throws SQLException {
		Banco b = new Banco();

		b.setIdBanco(resultSet.getInt("idBanco"));
		b.setNm_banco(resultSet.getString("nm_banco"));
		

		return b;
	}
}

