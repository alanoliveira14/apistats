package br.com.apistats.entity;

public class Clube {
	private int codClube;
	private String NomeCompleto;
	private String alcunha;
	private String sigla;
	private String imagem;
	private int codTecnico;
	private String tecnico;
	private int codPais;
	private String pais;
	private String dataFundacao;
	private int vitoria;
	private int derrota;
	private int empate;
	
	public int getCodClube() {
		return codClube;
	}
	public void setCodClube(int codClube) {
		this.codClube = codClube;
	}
	public String getNomeCompleto() {
		return NomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}
	public String getAlcunha() {
		return alcunha;
	}
	public void setAlcunha(String alcunha) {
		this.alcunha = alcunha;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getCodTecnico() {
		return codTecnico;
	}
	public void setCodTecnico(int codTecnico) {
		this.codTecnico = codTecnico;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public int getCodPais() {
		return codPais;
	}
	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public int getVitoria() {
		return vitoria;
	}
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}
	public int getDerrota() {
		return derrota;
	}
	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}
	public int getEmpate() {
		return empate;
	}
	public void setEmpate(int empate) {
		this.empate = empate;
	}
	
}
