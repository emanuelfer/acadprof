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
public class Avaliacao {
    private int id;
    private double nota;
    private String parecer;
    private String data;
    private Aluno aluno;
    private Aula aula;

    public Avaliacao() {
    }

    
    
    public Avaliacao(int id, double nota, String parecer, String data, Aluno aluno, Aula aula) {
        this.id = id;
        this.nota = nota;
        this.parecer = parecer;
        this.data = data;
        this.aluno = aluno;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    
}
