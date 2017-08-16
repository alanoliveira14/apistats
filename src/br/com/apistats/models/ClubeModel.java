package br.com.apistats.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apistats.database.GenericDAO;
import br.com.apistats.entity.Clube;
import br.com.apistats.exceptions.DadoImportanteInvalidoException;
import br.com.apistats.exceptions.RegistroNaoEncontradoException;

public class ClubeModel extends GenericDAO{
	
	public List<Clube> getClubes() throws SQLException, RegistroNaoEncontradoException {
		
		String sql = "select codClube, nomeCompleto, alcunha, sigla, imagem, tecnico.nome, pais, dataFundacao, vitoria, derrota, empate from clube inner join tecnico inner join pais where clube.codTecnico = tecnico.codTecnico and clube.codPais = pais.codPais;";		
		ResultSet rs;

		rs = super.executeResultSet(sql);
		
		List<Clube> clubes = new ArrayList<Clube>();
		while (rs.next()){
			Clube clube = new Clube();
			clube.setCodClube(rs.getInt(1));
			clube.setNomeCompleto(rs.getString(2));
			clube.setAlcunha(rs.getString(3));
			clube.setSigla(rs.getString(4));
			clube.setImagem(rs.getString(5));
			clube.setTecnico(rs.getString(6));
			clube.setPais(rs.getString(7));
			clube.setDataFundacao(rs.getString(8));
			clube.setVitoria(rs.getInt(9));
			clube.setDerrota(rs.getInt(10));
			clube.setEmpate(rs.getInt(11));
			clubes.add(clube);
		}
		rs.close();
		return clubes;
	}
	
	@Override
	public String getDefaultSelect() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
