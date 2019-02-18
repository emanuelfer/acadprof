/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerDepartamento;
import controller.ControllerTurma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;
import model.Turma;

/**
 *
 * @author emanu
 */
public class DaoAluno {
    private Connection con;
    
    public boolean create(String comando, ArrayList<String> parametros){
        this.con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            stmt.executeUpdate();
            
        } catch (SQLException e) {  
            return false;
        } finally {  
            ConnectionFactory.closeConnection(con, stmt);  
        }
        return true;
    }
    
    
    public Aluno busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        Aluno aluno = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                aluno.setId(rs.getInt("idAluno"));
                aluno.setCPF(rs.getString("CPF"));
                aluno.setMatricula(rs.getString("matricula"));
                
                ControllerTurma ct = new ControllerTurma();
                Turma turma = ct.busca(rs.getInt("idTurma"));
                aluno.setTurma(turma);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar aluno: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluno;
    }
    
    public boolean update(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
            stmt.executeUpdate();
            
        } catch (SQLException e) {  
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
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }
}
