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
public class Turma {
    private int id;
    private String codigo;
    private String modalidade;
    private String semestre;
    private String turno;
    private String ano;
    private Curso curso;

    public Turma() {
    }

    public Turma(int id, String codigo, String modalidade, String semestre, String turno, String ano, Curso curso) {
        this.id = id;
        this.codigo = codigo;
        this.modalidade = modalidade;
        this.semestre = semestre;
        this.turno = turno;
        this.ano = ano;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
    

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return this.curso.getNome()+" - "+ this.getAno() +" - "+ this.getTurno() + " - " + this.getCodigo();
    }
    
    
}
