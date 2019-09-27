package br.com.bansys.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bansys.data.ConexaoJDBC;
import br.com.bansys.model.Cliente;


public class ClienteDAO {

	private final ConexaoJDBC conexao;

	public ClienteDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}

	public Long inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO cliente (cpf_cliente, nm_cliente, sobre_cliente, end_cliente, tel_cliente, login_cliente, senha_cliente, email_cliente, fk_cliente_conta ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		
		
		
		
				try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, cliente.getCpf_cliente());
			stmt.setString(2, cliente.getNm_cliente());
			stmt.setString(3, cliente.getSobre_cliente());
			stmt.setString(4, cliente.getEnd_cliente());
			stmt.setInt(5, cliente.getTel_cliente());
			stmt.setString(6, cliente.getLogin_cliente());
			stmt.setString(7, cliente.getSenha_cliente());
			stmt.setString(8, cliente.getEmail_cliente());
			stmt.setInt(9, cliente.getFk_cliente_conta());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE cliente SET cpf_cliente = ?, nm_cliente = ?, sobre_cliente = ?, end_cliente = ?, tel_cliente = ? , login_cliente = ?, senha_cliente = ?, email_cliente = ?, fk_cliente_conta = ? WHERE idcliente = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, cliente.getCpf_cliente());
			stmt.setString(2, cliente.getNm_cliente());
			stmt.setString(3, cliente.getSobre_cliente());
			stmt.setString(4, cliente.getEnd_cliente());
			stmt.setInt(5, cliente.getTel_cliente());
			stmt.setString(6, cliente.getLogin_cliente());
			stmt.setString(7, cliente.getSenha_cliente());
			stmt.setString(8, cliente.getEmail_cliente());
			stmt.setInt(9, cliente.getFk_cliente_conta());
			stmt.setInt(10, cliente.getIdcliente());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int idCliente) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM cliente WHERE idcliente = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idCliente);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Cliente selecionar(int idCliente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM cliente WHERE idcliente= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}
	public Cliente consultar(int num_conta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM cliente INNER JOIN conta ON idConta = fk_cliente_conta WHERE num_conta = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, num_conta);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Cliente> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM cliente ORDER BY idcliente";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> clientes = new ArrayList<>();

			while (rs.next()) {
				clientes.add(parser(rs));
			}

			return clientes;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Cliente parser(ResultSet resultSet) throws SQLException {
		Cliente c = new Cliente();
		

		c.setIdcliente(resultSet.getInt("idcliente"));
		c.setNm_cliente(resultSet.getString("nm_cliente"));
		c.setCpf_cliente(resultSet.getString("cpf_cliente"));
		c.setSobre_cliente(resultSet.getString("sobre_cliente"));
		c.setEnd_cliente(resultSet.getString("end_cliente"));
		c.setTel_cliente(resultSet.getInt("tel_cliente"));
		c.setLogin_cliente(resultSet.getString("login_cliente"));
		c.setSenha_cliente(resultSet.getString("senha_cliente"));
		c.setEmail_cliente(resultSet.getString("email_cliente"));
		c.setFk_cliente_conta(resultSet.getInt("fk_cliente_conta"));

		return c;
	}
}


