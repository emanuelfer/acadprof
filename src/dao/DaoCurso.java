/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerDepartamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Curso;

/**
 *
 * @author emanu
 */
public class DaoCurso {
    private Connection con;
    
    public Curso busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        Curso curso = new Curso();
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                curso.setId(rs.getInt("idCurso"));
                curso.setNome(rs.getString("nome"));
                curso.setSigla(rs.getString("sigla"));
                ControllerDepartamento cd = new ControllerDepartamento();
                curso.setDepartamento(cd.busca(rs.getInt("idDepartamento")));
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca curso: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return curso;
    }  
}
