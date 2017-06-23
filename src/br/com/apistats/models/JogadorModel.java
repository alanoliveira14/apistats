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
		
		String sql = "select * from jogador;";		
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
			jogador.setDataNascimento(rs.getDate(7));
			jogador.setAltura(rs.getString(8));
			jogador.setPeso(rs.getString(9));
			jogador.setImgOficial(rs.getString(10));
			jogador.setImgPerfil(rs.getString(11));
			jogadores.add(jogador);			
		} 
		
		rs.close();
		return jogadores;
		
	}

	@Override
	public String getDefaultSelect() {
		// TODO Auto-generated method stub
		return null;
	}
}
