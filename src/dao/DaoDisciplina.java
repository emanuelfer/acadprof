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
import model.Aluno;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author emanu
 */
public class DaoDisciplina {
    private Connection con;
    public ArrayList<Disciplina> buscaDisciplinas(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Disciplina> disciplinas = new ArrayList();
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("disciplina.idDisciplina"));
                disciplina.setNome(rs.getString("disciplina.nome"));
                disciplina.setSigla(rs.getString("disciplina.sigla"));
                disciplinas.add(disciplina);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar curso: "+ e.getMessage());
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinas;
    }
    
    
    public Disciplina busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;     
        Disciplina disciplina = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                disciplina = new Disciplina();
                disciplina.setNome(rs.getString("disciplina.nome"));
                disciplina.setSigla(rs.getString("disciplina.sigla"));
                disciplina.setId(rs.getInt("disciplina.idDisciplina"));
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca disciplina aqui: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplina;
    }  
 
}
