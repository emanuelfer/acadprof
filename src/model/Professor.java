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
public class Professor {
    private int id;
    private String nome;
    private String CPF;
    private String graduacao;
    private Departamento departamento;

    public Professor(int id, String nome, String CPF, String graduacao, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.graduacao = graduacao;
        this.departamento = departamento;
    }

    public Professor() {
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
