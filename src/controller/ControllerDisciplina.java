/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoDisciplina;
import java.util.ArrayList;
import model.Aluno;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author emanu
 */
public class ControllerDisciplina {
    
    public ArrayList<Disciplina> buscaTodos(){
       DaoDisciplina dc = new DaoDisciplina();
       String comando = "SELECT * FROM disciplina";
       ArrayList<Disciplina> disciplinas = dc.buscaDisciplinas(comando, new ArrayList<String>());
       return disciplinas;
    }
    
    public ArrayList<Disciplina> buscaTodos(Professor professor){
       DaoDisciplina dc = new DaoDisciplina();
       String comando = "select * from professor, disciplina where professor.idDepartamento = disciplina.idDepartamento and professor.idProfessor = ?";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(Integer.toString(professor.getId()));
       ArrayList<Disciplina> disciplinas = dc.buscaDisciplinas(comando, parametros);
       return disciplinas;
    }
    
    public ArrayList<Disciplina> buscaTodos(Aluno aluno){
       DaoDisciplina dc = new DaoDisciplina();
       String comando = "SELECT * FROM disciplina, aula, aluno where aula.idDisciplina = disciplina.idDisciplina and aluno.idTurma = aula.idTurma and aluno.idAluno = ? group by disciplina.idDisciplina";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(Integer.toString(aluno.getId()));
       ArrayList<Disciplina> disciplinas = dc.buscaDisciplinas(comando, parametros);
       return disciplinas;
    }
    
    public Disciplina busca(int id){
        DaoDisciplina dd = new DaoDisciplina();
        String comando = "SELECT * FROM disciplina WHERE idDisciplina = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return dd.busca(comando, parametros);
    }
    
    public Disciplina busca(String nome){
        DaoDisciplina dd = new DaoDisciplina();
        String comando = "SELECT * FROM disciplina WHERE nome = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(nome);
        return dd.busca(comando, parametros);
    }
}
