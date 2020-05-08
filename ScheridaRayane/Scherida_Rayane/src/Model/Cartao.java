package Model;

public class Cartao {
	private String brandeira;
	private String numCartao;
	private String CCV;
	private String dataValidade;
	private boolean tipoCartao;
	private String nomeTitular;
	public Cartao(String brandeira, String numCartao, String cCV, String dataValidade, boolean tipoCartao,
			String nomeTitular) {
		super();
		this.brandeira = brandeira;
		this.numCartao = numCartao;
		CCV = cCV;
		this.dataValidade = dataValidade;
		this.tipoCartao = tipoCartao;
		this.nomeTitular = nomeTitular;
	}
	public String getBrandeira() {
		return brandeira;
	}
	public void setBrandeira(String brandeira) {
		this.brandeira = brandeira;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getCCV() {
		return CCV;
	}
	public void setCCV(String cCV) {
		CCV = cCV;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public boolean isTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(boolean tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	@Override
	public String toString() {
		return "Cartao [brandeira=" + brandeira + ", numCartao=" + numCartao + ", CCV=" + CCV + ", dataValidade="
				+ dataValidade + ", tipoCartao=" + tipoCartao + ", nomeTitular=" + nomeTitular + "]";
	}
	
}
