package Interface;

import java.sql.Date;

public interface IFormaPagamento {
	//Int. adição de métodos
	boolean registrarTransacao(String cpf, Date data, String formaPagamento, float valor);
	
}
