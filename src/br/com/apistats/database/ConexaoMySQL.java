package br.com.apistats.database;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Elvis
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ConexaoMySQL {

    private Connection conn = null;
    private Properties prop;

    public ConexaoMySQL() {        
        prop = new Properties();
    	Class<? extends ConexaoMySQL> cls = this.getClass();
        InputStream is = cls.getResourceAsStream("db.properties");
        try {
			prop.load(is);
		} catch (IOException e) {
			
		}	
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
    	if (conn == null || conn.isClosed() || !conn.isValid(0)) {
            abreConexao();
        }
        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    @PreDestroy
    public void fechaConexao() throws SQLException {
    	if (conn.getAutoCommit()) {
    		conn.close();
    	}
    }

    private void abreConexao() {
        try {
            Class.forName(getDriver());
            conn = DriverManager.getConnection(
            		getConnectionString(), 
            		getUser(),
            		getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void beginTransaction() throws SQLException {
    	if (conn == null || conn.isClosed() || !conn.isValid(0)) {
            abreConexao();
        }
    	conn.setAutoCommit(false);    	
    }
    
    public void commit() throws SQLException {
    	conn.commit();
    	conn.setAutoCommit(true);
    }
    
    public void rollback() throws SQLException {
    	if (!conn.getAutoCommit()) {
	    	conn.rollback();
	    	conn.setAutoCommit(true);
    	}
    }
    
    public String getDriver() {
    	return prop.getProperty("driver");
    }
    
    public String getConnectionString() {
    	return prop.getProperty("connectionstring");
    }
    
    public String getUser() {
    	return prop.getProperty("user");
    }
    
    public String getPassword() {
    	return prop.getProperty("password");
    }
}
