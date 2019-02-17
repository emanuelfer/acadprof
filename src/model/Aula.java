/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author emanu
 */
public class Aula {
    private int id;
    private String semestre;
    private String data;
    private String hora;
    private Turma turma;
    private Disciplina disciplina;
    private Professor professor;
    private String conteudo;

    public Aula() {
    }

    public Aula(int id, String semestre, String data, String hora, Turma turma, Disciplina disciplina,Professor professor, String conteudo) {
        this.id = id;
        this.semestre = semestre;
        this.data = data;
        this.hora = hora;
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
