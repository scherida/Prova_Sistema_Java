package Interface;

import java.sql.Date;

public interface IFormaPagamento {
	//Int. adi��o de m�todos
	boolean registrarTransacao(String cpf, Date data, String formaPagamento, float valor);
	
}
