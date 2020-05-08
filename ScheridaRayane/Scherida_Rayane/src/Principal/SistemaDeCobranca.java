package Principal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.CarrinhoDAO;
import Model.Carteira;
import Model.Credito;
import Model.DebitoEmConta;
import Model.Pessoa;
import Model.Produto;
import DAO.PagamentoDAO;

/*
 * Nome: Scherida Rayane de Souza - 1908665
 */
public class SistemaDeCobranca {
	static ArrayList<Pessoa> usuarioLogado = new ArrayList<Pessoa>(); //recebe o usuÃ¡rio logado no sistema.
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("=========== Sistema de Cobrança: ===========");		
		
		Login ldao = new Login();
		
		usuarioLogado = ldao.inicio();
		CarrinhoDAO cdao = new CarrinhoDAO();
		ArrayList<Produto> produtos = cdao.ListaProdutos();
		
		System.out.println("----------- Lista dos produtos: -----------");
		
		for (Produto produto : produtos) {
			System.out.println("ID: " + produto.getIdProduto());
            System.out.println("Nome: " + produto.getDesc());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("-----------------------");
        }
		System.out.println("=============================================");
		
		limpaTela();
		
		int escolha;
		do {	
			
		System.out.println("Escolha o seu produto:");
		escolha = s.nextInt();
			if(escolha >= 1 && escolha <= 6) { //Adiciona produtos no carrinho
				String cpfUsuarioLogado = usuarioLogado.get(0).getCPF();
				int idUsuarioLogado = usuarioLogado.get(0).getId();
				cdao.addCarrinho(escolha, cpfUsuarioLogado, 1, idUsuarioLogado);
			}else {
				System.out.println("Esse produto não existe, tente novamente!");
			}
			
		}while(escolha != 0);	
		
		
		limpaTela();
		System.out.println("O valor total é de: " + cdao.pegaValorTotalCarrinho(usuarioLogado.get(0).getCPF()));
		
		//case pagamento para passar a string da operÃ§Ã£o "Credito","Debito","Saldo"
		System.out.println("=============================================");
		System.out.println("Formas de pagamento");
		System.out.println("1 - Credito");
		System.out.println("2 - Debito");
		System.out.println("3 - Carteira Digital");
		System.out.println("=============================================");
		System.out.println("Informe o tipo de pagamento:");
		String pagamento;
	
		switch(s.nextInt()) {
			case 1:
				System.out.println("Informe o nome do titular:");
				String nomeTitular = s.nextLine();
				System.out.println("Informe o número do seu CCV:");
				String ccv = s.nextLine();
				System.out.println("Data de validade do cartão:");
				String validadeCartao = s.nextLine();
				System.out.println("Informe o número de cartão:");
				String numCartao = s.nextLine();
				Credito credito = new Credito(usuarioLogado.get(0).getCPF(), cdao.pegaValorTotalCarrinho(usuarioLogado.get(0).getCPF()), numCartao, ccv, nomeTitular, validadeCartao);
				
				java.util.Date dateUtil = new java.util.Date(); 
	            java.sql.Date dateSql = new java.sql.Date (dateUtil.getTime());
				
				boolean success = credito.pagar(dateSql, cdao.pegaValorTotalCarrinho(usuarioLogado.get(0).getCPF()));
				
				if (success) {
					System.out.println("Salvo");
					break;
				}
				System.out.println("Erro");
				
				break;
			case 2:
				System.out.println("Informe o nome do titular:");
				String titular = s.nextLine();
				System.out.println("Informe o número do seu CCV:");
				String numCcv = s.nextLine();
				System.out.println("Informe a bandeira:");
				String band = s.nextLine();
				System.out.println("Data de validade do cartão:");
				String valCartao = s.nextLine();
				System.out.println("Informe o número de cartão:");
				int numeroCartao = s.nextInt();
				System.out.println("Informe o código de segurança:");
				int codSeguranca = s.nextInt();
				
				DebitoEmConta debitoConta = new DebitoEmConta();
				
				success = debitoConta.pagar(debitoConta, debitoConta, numeroCartao);
				
				if (success) {
					System.out.println("Salvo");
					break;
				}
				System.out.println("Erro");
				
				break;
			case 3: 
				System.out.println("Informe o seu id:");
				int id = s.nextInt();
				System.out.println("Informe o seu e-mail:");
				String email = s.nextLine();
				System.out.println("Informe o seu saldo:");
				float saldo = s.nextFloat();
				
				//dateUtil = new java.util.Date(); 
	            //dateSql = new java.sql.Date (dateUtil.getTime());
	            
				//Carteira carteira = new Carteira(id, saldo, email);
			
				//success = carteira.pagar()
				
				//if (success) {
					System.out.println("Salvo");
					break;
				//}
				//System.out.println("Erro");
				
			default:
             System.out.println("Tente novamente!");
             break;
		}
		
	}
	
	public static void limpaTela() {  
		System.out.println(); 
	}
	
	
}
