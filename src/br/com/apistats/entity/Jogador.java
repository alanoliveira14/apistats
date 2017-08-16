package br.com.apistats.entity;

import java.sql.Date;

public class Jogador {
	private int idJogador;
	private String nome;
	private String nomeCamisa;	
	private String clube;
	private String posicao;
	private String dataNascimento;
	private String altura;
	private String peso;
	private String imgOficial;
	private String imgPerfil;
	private String peFavorito;
	private String nacionalidade;
	private int codClube;
	private int codPais;
	private int codPosicao;
	private int ativo;	
	
	public int getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCamisa() {
		return nomeCamisa;
	}
	public void setNomeCamisa(String nomeCamisa) {
		this.nomeCamisa = nomeCamisa;
	}
	public String getClube() {
		return clube;
	}
	public void setClube(String clube) {
		this.clube = clube;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getImgOficial() {
		return imgOficial;
	}
	public void setImgOficial(String imgOficial) {
		this.imgOficial = imgOficial;
	}
	public String getImgPerfil() {
		return imgPerfil;
	}
	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}
	public String getPeFavorito() {
		return peFavorito;
	}
	public void setPeFavorito(String peFavorito) {
		this.peFavorito = peFavorito;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getCodPais() {
		return codPais;
	}
	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}
	public int getCodPosicao() {
		return codPosicao;
	}
	public void setCodPosicao(int codPosicao) {
		this.codPosicao = codPosicao;
	}
	public int getCodClube() {
		return codClube;
	}
	public void setCodClube(int codClube) {
		this.codClube = codClube;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
}
