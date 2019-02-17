/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import controller.ControllerCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Turma;

/**
 *
 * @author emanu
 */
public class DaoTurma {
    private Connection con;
    public ArrayList<Turma> buscaTurmas(String comando, ArrayList<String> parametros){
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Turma> turmas = new ArrayList();
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                Turma turma = new Turma();
                turma.setId(rs.getInt("idTurma")); 
                turma.setCodigo(rs.getString("codigo"));
                turma.setSemestre(rs.getString("semestre"));
                turma.setModalidade(rs.getString("modalidade"));
                turma.setAno(rs.getString("ano"));
                turma.setTurno(rs.getString("turno"));
                ControllerCurso cc = new ControllerCurso();
                turma.setCurso(cc.bucsca(rs.getInt("idCurso")));
                turmas.add(turma);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar Turma: "+ e.getMessage());
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turmas;
    }
    
    public Turma busca(String comando, ArrayList<String> parametros) {  
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;    
        Turma turma = null;
	try {  
            stmt = con.prepareStatement(comando);  
            for(int i = 1; i<parametros.size() + 1; i++){
                stmt.setString(i, parametros.get(i-1));
            }
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                turma = new Turma();
                turma.setId(rs.getInt("idTurma"));
                turma.setAno(rs.getString("ano"));
                turma.setCodigo(rs.getString("codigo"));
                turma.setModalidade(rs.getString("modalidade"));
                turma.setSemestre(rs.getString("semestre"));
                turma.setTurno(rs.getString("turno"));
                ControllerCurso cc = new ControllerCurso();
                turma.setCurso(cc.bucsca(rs.getInt("idCurso")));
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao busca turma: "+e.getMessage()); 
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turma;
    }
}
