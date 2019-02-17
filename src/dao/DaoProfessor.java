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
import controller.ControllerDepartamento;
import java.util.ArrayList;
import model.Departamento;
import model.Professor;

/**
 *
 * @author emanu
 */
public class DaoProfessor {
    private Connection con;
    
    public boolean insert(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Professor professor = null;
	try {  
            stmt = con.prepareStatement(comando); 
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            stmt.execute();
          
	} catch (SQLException e) {  
	    System.out.println(e.getMessage());  
	    return false;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }
    
    public Professor busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        Professor professor = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                professor = new Professor();
                professor.setId(rs.getInt("idProfessor"));
                professor.setNome(rs.getString("nome"));
                professor.setCPF(rs.getString("CPF"));
                professor.setGraduacao(rs.getString("graduacao"));
                ControllerDepartamento cd = new ControllerDepartamento();
                Departamento departamento = cd.busca(rs.getInt("idDepartamento"));
                professor.setDepartamento(departamento);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca professor: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return professor;
    }  
    
    public boolean update(String comando, ArrayList<String> parametros) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(comando);
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
	    return false;  
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }
    
    public boolean delete(String comando, ArrayList<String> parametros) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(comando);
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());  
	    return false;  
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }
}
