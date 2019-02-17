/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerDisciplina;
import controller.ControllerProfessor;
import controller.ControllerTurma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Aula;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class DaoAula {
    private Connection con;
    
    public void create(String comando, ArrayList<String> parametros){
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
            JOptionPane.showMessageDialog(null, "Erro ao iserir aula: " + e.getMessage());
        } finally {  
            ConnectionFactory.closeConnection(con, stmt);  
        }  
    }
    
    public ArrayList<Aula> buscaAulas(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Aula> aulas = new ArrayList();
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                Aula aula = new Aula();
                aula.setId(rs.getInt("idAula"));
                aula.setConteudo(rs.getString("conteudo"));
                aula.setData(rs.getString("data"));
                aula.setHora(rs.getString("horario"));
                aula.setSemestre(rs.getString("semestre"));
                
                ControllerDisciplina cd = new ControllerDisciplina();
                Disciplina disciplina = cd.busca(rs.getInt("idDisciplina"));
                
                ControllerTurma ct = new ControllerTurma();
                Turma turma = ct.busca(rs.getInt("idTurma"));
                
                ControllerProfessor cp = new ControllerProfessor();
                Professor professor = cp.busca(rs.getInt("idProfessor"));
                
                aula.setDisciplina(disciplina);
                aula.setTurma(turma);
                aula.setProfessor(professor);
                aulas.add(aula);
     
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar aula: "+ e.getMessage());
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aulas;
    }
    
    public Aula busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        Aula aula = new Aula();
	try {  
            stmt = con.prepareStatement(comando);
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                aula.setId(rs.getInt("idAula"));
                aula.setConteudo(rs.getString("conteudo"));
                aula.setData(rs.getString("data"));
                aula.setHora(rs.getString("horario"));
                aula.setSemestre(rs.getString("semestre"));
                
                ControllerProfessor cp = new ControllerProfessor();
                Professor professor = cp.busca(rs.getInt("idProfessor"));
                
                ControllerDisciplina cd = new ControllerDisciplina();
                Disciplina disciplina = cd.busca(rs.getInt("idDisciplina"));
                
                ControllerTurma ct = new ControllerTurma();
                Turma turma = ct.busca(rs.getInt("idTurma"));
                
                aula.setDisciplina(disciplina);
                aula.setTurma(turma);
                aula.setProfessor(professor);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca aula: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aula;
    }  
}
