package br.com.apistats.database;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Elvis
 */
@Component
public abstract class GenericDAO {
	
	@Autowired
	private ConexaoMySQL conexaoMySQL;
	
	public GenericDAO() {
		super();
	}

	public ResultSet executeResultSet (String sql, Object... params) throws SQLException {
    	
        PreparedStatement ps = conexaoMySQL.getPreparedStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            
            ps.setObject(i+1, params[i]);
            
        }
        
        return ps.executeQuery();

    }
    
    public int executeQuery (String sql, Object... params) throws SQLException {
    	
        PreparedStatement ps = conexaoMySQL.getPreparedStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            
            ps.setObject(i+1, params[i]);
            
        }
        
        int retorno = ps.executeUpdate();
        
        if (sql.startsWith("INSERT")) {
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	        	retorno = rs.getInt(1);
	        }
        }
        
        return retorno;
    }
    
    public void fechaConexao() throws SQLException {
    	conexaoMySQL.fechaConexao();
    }
    
    public abstract String getDefaultSelect();

}
