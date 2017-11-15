package br.com.apistats.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apistats.database.GenericDAO;
import br.com.apistats.entity.Jogador;
import br.com.apistats.exceptions.DadoImportanteInvalidoException;
import br.com.apistats.exceptions.RegistroNaoEncontradoException;

public class JogadorModel extends GenericDAO{

    public JogadorModel() throws SQLException {
    }
    
    public List<Jogador> getJogadores() throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codJogador, nome, apelido,  c.alcunha, po.nomePosicao, pePredom, dataNascimento, altura, peso, j.imagem, imgPerfil, p.pais from jogador j inner join pais p inner join posicao po inner join clube c where j.codPais = p.codPais and j.codPosicao = po.codPosicao and j.codClube = c.codClube;";		
		ResultSet rs;
		
		rs = super.executeResultSet(sql);
			
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		while (rs.next()) {
			Jogador jogador = new Jogador();
			jogador.setIdJogador(rs.getInt(1));
			jogador.setNome(rs.getString(2));
			jogador.setNomeCamisa(rs.getString(3));
			jogador.setClube(rs.getString(4));
			jogador.setPosicao(rs.getString(5));
			jogador.setPeFavorito(rs.getString(6));
			jogador.setDataNascimento(rs.getString(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogador.setNacionalidade(rs.getString(12));
			jogadores.add(jogador);			
		} 
		
		rs.close();
		return jogadores;
		
	}

	public void inserir(Jogador jogador) throws SQLException {

		String sql = "INSERT INTO jogador (nome, apelido, pePredom, dataNascimento, altura, peso, imagem, imgPerfil, codClube, codPais, codPosicao, ativo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1);";
		
		try{
			super.executeQuery(sql,
					jogador.getNome(),
					jogador.getNomeCamisa(),
					jogador.getPeFavorito(),
					jogador.getDataNascimento(),
					jogador.getAltura(),
					jogador.getPeso(),
					jogador.getImgOficial(),
					jogador.getImgPerfil(),
					jogador.getCodClube(),
					jogador.getCodPais(),
					jogador.getCodPosicao()
					
			);
			Exception e = null;
		}
		catch(Exception e){
			throw new RuntimeException("Erro ao criar o produto! " + e.getMessage());
		}	
	}
	
	public Jogador getJogadorById(Integer idJogador) throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codJogador, nome, apelido,  c.alcunha, po.nomePosicao, pePredom, dataNascimento, altura, peso, j.imagem, imgPerfil, p.pais from jogador j inner join pais p inner join posicao po inner join clube c where j.codPais = p.codPais and j.codPosicao = po.codPosicao and j.codClube = c.codClube and j.codJogador = ?;";		
		ResultSet rs;
		
		rs = super.executeResultSet(sql, idJogador);
			
		Jogador jogador = new Jogador();
		
		if (rs.next()) {
			jogador.setIdJogador(rs.getInt(1));
			jogador.setNome(rs.getString(2));
			jogador.setNomeCamisa(rs.getString(3));
			jogador.setClube(rs.getString(4));
			jogador.setPosicao(rs.getString(5));
			jogador.setPeFavorito(rs.getString(6));
			jogador.setDataNascimento(rs.getString(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogador.setNacionalidade(rs.getString(12));
			rs.close();
		} else {
			rs.close();
			throw new RegistroNaoEncontradoException("Plano não encontrado!");
		}
		
		return jogador;
		
	}
	
	public void atualizar(Jogador jogador) throws SQLException {

		String sql = "update jogador set nome = ? , apelido = ?, pePredom = ?, dataNascimento = ?, altura = ?, peso = ?, imagem = ?, imgPerfil = ?, codClube = ?, codPais = ?, codPosicao = ?, ativo = ? where codJogador = ?;";
		
		try{
			super.executeQuery(sql,
					jogador.getNome(),
					jogador.getNomeCamisa(),
					jogador.getPeFavorito(),
					jogador.getDataNascimento(),
					jogador.getAltura(),
					jogador.getPeso(),
					jogador.getImgOficial(),
					jogador.getImgPerfil(),
					jogador.getCodClube(),
					jogador.getCodPais(),
					jogador.getCodPosicao(),
					jogador.getAtivo(),
					jogador.getIdJogador()
			);
		}
		catch(Exception e){
			throw new RuntimeException("Erro ao atualizar jogador! " + e.getMessage());
		}
		
	}	
	
    public List<Jogador> getGoleiros() throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codJogador, nome, apelido, clube.alcunha, posicao.nomePosicao, pepredom, dataNascimento, altura, peso, jogador.imagem, jogador.imgPerfil, pais.pais, clube.imagem from jogador inner join posicao inner join clube inner join pais where jogador.codPais = pais.codPais and jogador.codPosicao = 1 and posicao.codPosicao = jogador.codPosicao and jogador.codClube = clube.codClube order by jogador.codPosicao asc, apelido asc;";		
		ResultSet rs;
		
		rs = super.executeResultSet(sql);
			
		List<Jogador> goleiros = new ArrayList<Jogador>();
		
		while (rs.next()) {
			Jogador jogador = new Jogador();
			jogador.setIdJogador(rs.getInt(1));
			jogador.setNome(rs.getString(2));
			jogador.setNomeCamisa(rs.getString(3));
			jogador.setClube(rs.getString(4));
			jogador.setPosicao(rs.getString(5));
			jogador.setPeFavorito(rs.getString(6));
			jogador.setDataNascimento(rs.getString(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogador.setNacionalidade(rs.getString(12));
			jogador.setImgClube(rs.getString(13));
			goleiros.add(jogador);			
		} 
		
		rs.close();
		return goleiros;
		
	}

    public List<Jogador> getDefensores() throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codJogador, nome, apelido, clube.alcunha, posicao.nomePosicao, pepredom, dataNascimento, altura, peso, jogador.imagem, jogador.imgPerfil, pais.pais, clube.imagem from jogador inner join posicao inner join clube inner join pais where jogador.codPais = pais.codPais and jogador.codPosicao between 2 and 4 and posicao.codPosicao = jogador.codPosicao and jogador.codClube = clube.codClube order by jogador.codPosicao asc, apelido asc;";		
		ResultSet rs;
		
		rs = super.executeResultSet(sql);
			
		List<Jogador> defensores = new ArrayList<Jogador>();
		
		while (rs.next()) {
			Jogador jogador = new Jogador();
			jogador.setIdJogador(rs.getInt(1));
			jogador.setNome(rs.getString(2));
			jogador.setNomeCamisa(rs.getString(3));
			jogador.setClube(rs.getString(4));
			jogador.setPosicao(rs.getString(5));
			jogador.setPeFavorito(rs.getString(6));
			jogador.setDataNascimento(rs.getString(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogador.setNacionalidade(rs.getString(12));
			jogador.setImgClube(rs.getString(13));
			defensores.add(jogador);			
		} 
		
		rs.close();
		return defensores;
		
	}

public List<Jogador> getMeias() throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codJogador, nome, apelido, clube.alcunha, posicao.nomePosicao, pepredom, dataNascimento, altura, peso, jogador.imagem, jogador.imgPerfil, pais.pais, clube.imagem from jogador inner join posicao inner join clube inner join pais where jogador.codPais = pais.codPais and jogador.codPosicao between 5 and 10 and posicao.codPosicao = jogador.codPosicao and jogador.codClube = clube.codClube order by jogador.codPosicao asc, apelido asc;";		
		ResultSet rs;
		
		rs = super.executeResultSet(sql);
			
		List<Jogador> meias = new ArrayList<Jogador>();
		
		while (rs.next()) {
			Jogador jogador = new Jogador();
			jogador.setIdJogador(rs.getInt(1));
			jogador.setNome(rs.getString(2));
			jogador.setNomeCamisa(rs.getString(3));
			jogador.setClube(rs.getString(4));
			jogador.setPosicao(rs.getString(5));
			jogador.setPeFavorito(rs.getString(6));
			jogador.setDataNascimento(rs.getString(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogador.setNacionalidade(rs.getString(12));
			jogador.setImgClube(rs.getString(13));
			meias.add(jogador);			
		} 
		
		rs.close();
		return meias;
		
	}
    
public List<Jogador> getAtacantes() throws SQLException, RegistroNaoEncontradoException {
	
	String sql = "select codJogador, nome, apelido, clube.alcunha, posicao.nomePosicao, pepredom, dataNascimento, altura, peso, jogador.imagem, jogador.imgPerfil, pais.pais, clube.imagem from jogador inner join posicao inner join clube inner join pais where jogador.codPais = pais.codPais and jogador.codPosicao > 10 and posicao.codPosicao = jogador.codPosicao and jogador.codClube = clube.codClube order by jogador.codPosicao asc, apelido asc;";		
	ResultSet rs;
	
	rs = super.executeResultSet(sql);
		
	List<Jogador> atacantes = new ArrayList<Jogador>();
	
	while (rs.next()) {
		Jogador jogador = new Jogador();
		jogador.setIdJogador(rs.getInt(1));
		jogador.setNome(rs.getString(2));
		jogador.setNomeCamisa(rs.getString(3));
		jogador.setClube(rs.getString(4));
		jogador.setPosicao(rs.getString(5));
		jogador.setPeFavorito(rs.getString(6));
		jogador.setDataNascimento(rs.getString(7));
		jogador.setAltura(rs.getString(8));
		jogador.setPeso(rs.getString(9));
		jogador.setImgOficial(rs.getString(10));
		jogador.setImgPerfil(rs.getString(11));
		jogador.setNacionalidade(rs.getString(12));
		jogador.setImgClube(rs.getString(13));
		atacantes.add(jogador);			
	} 
	
	rs.close();
	return atacantes;
	
}

	@Override
	public String getDefaultSelect() {
		// TODO Auto-generated method stub
		return null;
	}
}
