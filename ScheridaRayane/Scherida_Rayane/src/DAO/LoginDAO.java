package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexao.ConexaoDB;
import Model.Pessoa;

public class LoginDAO {

	public ArrayList<Pessoa> Login(String Usuario, String Senha) {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		Connection con = ConexaoDB.getConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("select idPessoa, CPF, Nome, Usuario, Senha, Endereco from pessoa where usuario = ? and senha = ?");
			
			
			stmt.setString(1, Usuario);
			stmt.setString(2, Senha);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa result = new Pessoa();
				result.setId(rs.getInt("IdPessoa"));				
				result.setCPF(rs.getString("CPF"));
				result.setNome(rs.getString("Nome"));
				result.setUsuario(rs.getString("Usuario"));
				result.setSenha(rs.getString("Senha"));
				result.setEndereco(rs.getString("Endereco"));
				
				lista.add(result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
