/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAula;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Aluno;
import model.Aula;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class ControllerAula {
    
    public String create(String conteudo, String data,String horario,int idDisciplina,int idTurma, Professor professor) throws ParseException{   
        if(conteudo.isEmpty() || data.isEmpty() || horario.isEmpty()){
            return "Preencha todos os campos!";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date d = formatter.parse(data);
        if(new Date().before(d)){
            return "Data inválida !";
        }
        try{
           String[] h = horario.split("-");
           int inicioH = Integer.parseInt(h[0].split("h")[0]);
           int inicioM = Integer.parseInt(h[0].split("h")[1]);
           int finalH = Integer.parseInt(h[1].split("h")[0]);
           int finalM = Integer.parseInt(h[1].split("h")[1]);
            System.out.println(inicioH);
            System.out.println(finalH);
           if((inicioH < 0 || inicioH > 24) || (finalH < 0 || finalH > 24)){
               return "Horário inválido";
           }
           if((inicioM < 0 || inicioM >= 60) || (finalM < 0 || finalM >= 60)){
               return "Horário inválido";
           }
           if(inicioH > finalH){
               return "Erro: horário de início maior que o de finalização !!!!";
           }
           
        }catch(Exception e){
            return "Valores inválidos no campo Horário! Digite somente números";
        }
        
        ControllerTurma ct = new ControllerTurma();;;
        Turma turma = ct.busca(idTurma);
        String comando = "INSERT INTO aula (horario, data, semestre, conteudo, idDisciplina, idTurma, idProfessor) VALUES(?,?,?,?,?,?,?)";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(horario);
        parametros.add(data);
        parametros.add(turma.getSemestre());
        parametros.add(conteudo);
        parametros.add(Integer.toString(idDisciplina));
        parametros.add(Integer.toString(idTurma));
        parametros.add(Integer.toString(professor.getId()));
        DaoAula da = new DaoAula();
        da.create(comando, parametros);
        return "Aula cadastrada!";
    }
    
    public ArrayList<Aula> buscaTodos(){
       DaoAula da = new DaoAula();
       String comando = "SELECT * FROM aula";
       ArrayList<Aula> aulas = da.buscaAulas(comando,new ArrayList<String>());
       return aulas;
    }
    
    public ArrayList<Aula> buscaTodos(Aluno aluno, int idDisciplina){
       DaoAula da = new DaoAula();
       String comando = "SELECT * FROM aula, aluno where aluno.idTurma = ? and aluno.idTurma = aula.idTurma and aula.idDisciplina = ? group by aula.idAula";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(Integer.toString(aluno.getTurma().getId()));
       parametros.add(Integer.toString(idDisciplina));
       ArrayList<Aula> aulas = da.buscaAulas(comando, parametros);
       return aulas;
    }
    
    public ArrayList<Aula> buscaTodos(Professor professor, String codigo){
       DaoAula da = new DaoAula();
       ControllerTurma ct = new ControllerTurma();
       Turma turma = ct.buscarPorCodigo(codigo);
       String comando = "SELECT * FROM aula, aluno, professor where aluno.idTurma = ? and aluno.idTurma = aula.idTurma and aula.idProfessor = ? group by aula.idAula";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(Integer.toString(turma.getId()));
       parametros.add(Integer.toString(professor.getId()));
       ArrayList<Aula> aulas = da.buscaAulas(comando, parametros);
        
       return aulas;
    }
    
    public Aula busca(int id){
        DaoAula da = new DaoAula();
        String comando = "SELECT * FROM aula WHERE idAula = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return da.busca(comando, parametros);
    }
    
    
}
