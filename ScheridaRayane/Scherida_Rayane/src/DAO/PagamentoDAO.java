package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.ConexaoDB;
import Model.Produto;

public class PagamentoDAO {

	public boolean formaPagamento(float valorTotal, String CPF, String formaPagamento) {
		Connection con = Conexao.ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Date dataVenda = null;

		try {
			stmt = con.prepareStatement("select sysdate() dataVenda from dual");
			
			rs = stmt.executeQuery();

			while (rs.next()) {				
				dataVenda = rs.getDate("dataVenda");
			}
			stmt = con.prepareStatement("insert into compra (valorTotal, CPF, dataVenda, formaPagamento) values (?,?,?,?)");

			stmt.setFloat(1, valorTotal);
			stmt.setString(2, CPF);
			stmt.setDate(3, dataVenda);
			stmt.setString(4, formaPagamento);
			
			stmt.executeUpdate();
			
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	
		}
	}

}
