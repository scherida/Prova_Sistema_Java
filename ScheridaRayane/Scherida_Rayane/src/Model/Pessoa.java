package Model;

public class Pessoa {
	private int id;
	private String usuario;
	private String Senha;
	private String nome;
	private String CPF;
	private String endereco;
	public Pessoa(int id, String usuario, String senha, String nome, String cPF, String endereco) {
		super();
		this.id = id;
		this.usuario = usuario;
		Senha = senha;
		this.nome = nome;
		CPF = cPF;
		this.endereco = endereco;
	}
	public Pessoa() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", usuario=" + usuario + ", Senha=" + Senha + ", nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + "]";
	}
}
