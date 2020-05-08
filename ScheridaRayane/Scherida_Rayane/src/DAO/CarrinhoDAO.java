package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import Conexao.ConexaoDB;
import Model.Produto;

public class CarrinhoDAO {

	public ArrayList<Produto> ListaProdutos() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		Connection con = ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("select idProduto, preco, `desc` from produto");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto result = new Produto();
				result.setIdProduto(rs.getInt("idProduto"));
				result.setPreco(rs.getFloat("preco"));
				result.setDesc(rs.getString("desc"));

				lista.add(result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public void addCarrinho(int idProduto, String CPF, float quantidade, int idUsuario) {
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		int idCarrinho = pegaNumCarrinho(CPF);
		int auxiliar = 0;
		float verificadorExistencia = verificaExistenciaProdutoCarrinho(idProduto, idCarrinho);

		if (idCarrinho == 0) {
			try {
				stmt = con.prepareStatement("insert into carrinho (idUsuario, valorCarrinho) values (?,?)");

				stmt.setInt(1, idUsuario);
				stmt.setInt(2, auxiliar);

				stmt.executeUpdate();

				idCarrinho = pegaNumCarrinho(CPF);

				stmt = con.prepareStatement(
						"insert into produtoCarrinho (idProduto, idCarrinho, quantidade) values (?,?,?)");

				stmt.setInt(1, idProduto);
				stmt.setInt(2, idCarrinho);
				stmt.setFloat(3, quantidade);

				stmt.executeUpdate();

				atualizaCarrinho(idCarrinho); // atualiza valor do carrinho

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {

				if (verificadorExistencia == 0) {
					stmt = con.prepareStatement(
							"insert into produtoCarrinho (idProduto, idCarrinho, quantidade) values (?,?,?)");

					stmt.setInt(1, idProduto);
					stmt.setInt(2, idCarrinho);
					stmt.setFloat(3, quantidade);

					stmt.executeUpdate();

					atualizaCarrinho(idCarrinho); // atualiza valor do carrinho
				} else {

					stmt = con.prepareStatement(
							"update produtoCarrinho set quantidade = ? where idProduto = ? and idCarrinho = ?");

					stmt.setFloat(1, verificadorExistencia + quantidade);
					stmt.setInt(2, idProduto);
					stmt.setInt(3, idCarrinho);

					stmt.executeUpdate();

					atualizaCarrinho(idCarrinho);// atualiza valor no carrinho

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteCarrinho(String CPF) {// pega data da venda atual (hoje)
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("insert into carrinho (idUsuario, valorCarrinho) values (?,?)");

			stmt.setString(1, CPF);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int pegaNumCarrinho(String CPF) {// verifica se há algum carrinho ja criado
		Connection con = ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int numCarrinho = 0;

		try {
			stmt = con.prepareStatement(
					"select c.id id from carrinho c, pessoa p where c.idUsuario = p.idPessoa and p.cpf = ?");
			stmt.setString(1, CPF);
			rs = stmt.executeQuery();

			if (!rs.equals(null)) {
				while (rs.next()) {
					numCarrinho = rs.getInt("id");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numCarrinho;
	}

	public void atualizaCarrinho(int idCarrinho) {
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"update carrinho set valorCarrinho = (select sum(p.preco*pc.quantidade) from produto p, produtocarrinho pc where p.idProduto = pc.idProduto and pc.idCarrinho = ?) where id = ?");

			stmt.setInt(1, idCarrinho);
			stmt.setInt(2, idCarrinho);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public float verificaExistenciaProdutoCarrinho(int idProduto, int idCarrinho) {
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		float quantidade = 0;

		try {

			stmt = con
					.prepareStatement("select quantidade from produtocarrinho where idProduto = ? and idCarrinho = ?");

			stmt.setInt(1, idProduto);
			stmt.setInt(2, idCarrinho);

			rs = stmt.executeQuery();

			while (rs.next()) {
				quantidade = rs.getFloat("quantidade");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quantidade;
	}

	public void atualizaCarrinhoPagamento(float valorPago, String CPF) {
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;

		int idCarrinho = pegaNumCarrinho(CPF);
		try {
			stmt = con.prepareStatement(
					"update carrinho set valorCarrinho = (select sum(p.preco*pc.quantidade)-? from produto p, produtocarrinho pc where p.idProduto = pc.idProduto and pc.idCarrinho = ?) where id = ?");

			stmt.setFloat(1, valorPago);
			stmt.setInt(2, idCarrinho);
			stmt.setInt(3, idCarrinho);

			stmt.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PagamentoDAO pdao = new PagamentoDAO();
		pdao.formaPagamento(valorPago, CPF, "Debito"); // atualizar string

	}
	
	public float pegaValorTotalCarrinho(String CPF) {
		Connection con = ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		float valorCarrinho = 0;

		try {
			stmt = con.prepareStatement(
					"select c.valorCarrinho from carrinho c, pessoa p where c.idUsuario = p.idPessoa and p.cpf = ?");
			stmt.setString(1, CPF);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				valorCarrinho = rs.getFloat("valorCarrinho");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valorCarrinho;
	}

}
