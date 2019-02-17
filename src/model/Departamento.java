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
public class Departamento {
    private int id;
    private String nome;
    private String sigla;
    private Professor coordenador;

    public Departamento() {
    }

    public Departamento(int id, String nome, String sigla,  Professor coordenador) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.coordenador = coordenador;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }
    
    
}
