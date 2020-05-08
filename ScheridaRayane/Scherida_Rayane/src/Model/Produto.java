package Model;

public class Produto {
	private int idProduto;
	private float preco;
	private String desc;
	
	public Produto() {
		
	}
	
	public Produto(int idProduto, float preco, String desc) {
		super();
		this.idProduto = idProduto;
		this.preco = preco;
		this.desc = desc;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", preco=" + preco + ", desc=" + desc + "]";
	}
	
	
	
}
