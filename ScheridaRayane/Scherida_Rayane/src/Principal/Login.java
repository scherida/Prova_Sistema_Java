package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.LoginDAO;
import Model.Pessoa;

/*
 * Nome: Scherida Rayane de Souza - 1908665
 */
public class Login {

	public ArrayList<Pessoa> inicio() {
		Scanner scan = new Scanner (System.in);
		System.out.println ("Usuário: "); 
		//String usuario = scan.nextLine();
		System.out.println ("Senha: "); 
		//String senha = scan.nextLine();
		
		LoginDAO cdao = new LoginDAO();
		return cdao.Login("MMATA", "1234");
	}

}
