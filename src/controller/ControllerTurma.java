/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.DaoCurso;
import dao.DaoTurma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Turma;

/**
 *
 * @author emanu
 */
public class ControllerTurma {
    
    public ArrayList<Turma> buscaTodos(){
       DaoTurma dt = new DaoTurma();
       String comando = "SELECT * FROM turma group by idCurso";
       
       ArrayList<Turma> turmas = dt.buscaTurmas(comando, new ArrayList<String>());
       return turmas;
    }
    
    public Turma busca(int id){
        DaoTurma dt = new DaoTurma();
        String comando = "SELECT * FROM turma WHERE idTurma = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return dt.busca(comando, parametros);
    }
    
    public ArrayList<Turma> busca(String curso){
        DaoTurma dt = new DaoTurma();
        Turma turma = new Turma();
        String comando = "SELECT * FROM turma, curso where turma.idCurso = curso.idCurso and curso.nome = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(curso);
        return dt.buscaTurmas(comando, parametros);
    }
    
    public ArrayList<Turma> busca(String curso, String modalidade){
        DaoTurma dt = new DaoTurma();
        String comando = "SELECT * FROM turma, curso where turma.idCurso = curso.idCurso and curso.nome = ? and turma.modalidade = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(curso);
        parametros.add(modalidade);
        return dt.buscaTurmas(comando, parametros);
    }
    
    public ArrayList<Turma> busca(String curso, String modalidade, String ano){
        DaoTurma dt = new DaoTurma();
        String comando = "SELECT * FROM turma, curso where turma.idCurso = curso.idCurso and curso.nome = ? and turma.modalidade = ? and ano = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(curso);
        parametros.add(modalidade);
        parametros.add(ano);
        return dt.buscaTurmas(comando, parametros);
    }
    
    public ArrayList<Turma> busca(String curso, String modalidade, String ano, String turno){
        DaoTurma dt = new DaoTurma();
        Turma turma = new Turma();
        String comando = "SELECT * FROM turma, curso where turma.idCurso = curso.idCurso and curso.nome = ? and turma.modalidade = ? and ano = ? and turno = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(curso);
        parametros.add(modalidade);
        parametros.add(ano);
        parametros.add(turno);
        return dt.buscaTurmas(comando, parametros);
    }
    
    public Turma buscarPorCodigo(String codigo){
        DaoTurma dt = new DaoTurma();
        String comando = "SELECT * FROM turma WHERE codigo = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(codigo);
        return dt.busca(comando, parametros);
    }
}
