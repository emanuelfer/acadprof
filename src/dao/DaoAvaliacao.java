/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerAluno;
import controller.ControllerAula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Aula;
import model.Avaliacao;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class DaoAvaliacao {
    private Connection con;
    
    public boolean avaliar(String comando, ArrayList<String> parametros){
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
    
    public Avaliacao busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;  
        Avaliacao avaliacao = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("idAvaliacao"));
                avaliacao.setNota(rs.getDouble("nota"));
                avaliacao.setParecer(rs.getString("parecer"));
                avaliacao.setData(rs.getString("data"));
                
                ControllerAula ca = new ControllerAula();
                Aula aula = ca.busca(rs.getInt("aula.idAula"));
                avaliacao.setAula(aula);  
                ControllerAluno controllerAluno = new ControllerAluno();
                Aluno aluno = controllerAluno.bucsca(rs.getInt("aluno.idAluno"));
                avaliacao.setAluno(aluno);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca avaliação: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacao;
    }  
    
    public ArrayList<Avaliacao> buscaAvaliacoes(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;  
        ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                Avaliacao avaliacao = avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("avaliacao.idAvaliacao"));
                avaliacao.setNota(rs.getDouble("avaliacao.nota"));
                avaliacao.setParecer(rs.getString("avaliacao.parecer"));
                avaliacao.setData(rs.getString("avaliacao.data"));
                ControllerAula ca = new ControllerAula();
                Aula aula = ca.busca(rs.getInt("aula.idAula"));
                avaliacao.setAula(aula);  
                
                ControllerAluno contrellerAluno = new ControllerAluno();
                Aluno aluno = contrellerAluno.bucsca(rs.getInt("idAluno"));
                
                avaliacao.setAluno(aluno);
                
                avaliacoes.add(avaliacao);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca avaliação: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacoes;
    }
    
}
