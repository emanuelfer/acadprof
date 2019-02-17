/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Professor;

/**
 *
 * @author emanu
 */
public class DaoAdministrador {
    private Connection con;
    
    public Administrador buscar(String comando, ArrayList<String> parametros) {  
        this.con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        Administrador administrador = null;
	try {  
            stmt = con.prepareStatement(comando);
            for(int i = 1; i<parametros.size()+1 ; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            rs = stmt.executeQuery();
                   
            while(rs.next()) {  
                administrador = new Administrador();
                administrador.setId(rs.getInt("id")); 
                administrador.setNome(rs.getString("nome")); 
                administrador.setCPF(rs.getString("CPF"));
	    }  
          
	} catch (SQLException e) {  
	    System.out.println(e.getMessage());  
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return administrador;
    }
}
