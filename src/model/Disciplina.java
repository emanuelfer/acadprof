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
public class Disciplina {
    private int id;
    private String nome;
    private String sigla;
    private String ch;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, String sigla, String ch) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ch = ch;
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

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
