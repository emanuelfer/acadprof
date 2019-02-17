/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerProfessor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Departamento;
import model.Professor;


/**
 *
 * @author emanu
 */
public class DaoDepartamento {
    private Connection con;
    public Departamento busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;   
        Departamento departamento = null;
	try {  
            stmt = con.prepareStatement(comando); 
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNome(rs.getString("nome"));
                departamento.setSigla(rs.getString("sigla"));
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca departamento: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return departamento;
    }  
    
     public ArrayList<Departamento> buscaDepartamentos(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Departamento> result = new ArrayList<Departamento>();
        Departamento departamento = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNome(rs.getString("nome"));
                departamento.setSigla(rs.getString("sigla"));
                ControllerProfessor cp = new ControllerProfessor();
                departamento.setCoordenador(cp.busca(rs.getInt("idCoordenador")));
                result.add(departamento);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar curso: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    } 
}
