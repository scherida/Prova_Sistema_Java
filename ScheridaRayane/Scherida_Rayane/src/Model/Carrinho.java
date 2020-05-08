package Model;

public class Carrinho {
	private int id;
	private int idProduto;
	private float valorCarrinho;
	public Carrinho(int id, int idProduto, float valorCarrinho) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.valorCarrinho = valorCarrinho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public float getValorCarrinho() {
		return valorCarrinho;
	}
	public void setValorCarrinho(float valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}
	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", idProduto=" + idProduto + ", valorCarrinho=" + valorCarrinho + "]";
	}
}
