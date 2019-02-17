/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoDepartamento;
import java.util.ArrayList;
import model.Departamento;

/**
 *
 * @author emanu
 */
public class ControllerDepartamento {
    
    public Departamento busca(int id){
        DaoDepartamento dd = new DaoDepartamento();
        Departamento departamento = new Departamento();
        String comando = "SELECT * FROM departamento WHERE id = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return dd.busca(comando, parametros);
    }
    
    public Departamento busca(String nomeDepartameno){
        DaoDepartamento dd = new DaoDepartamento();
        String comando = "SELECT * FROM departamento WHERE nome like ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(nomeDepartameno);
        return dd.busca(comando, parametros);
    }
    
    public ArrayList<Departamento> buscaTodos(){
        DaoDepartamento dd = new DaoDepartamento();
        String comando = "SELECT * FROM departamento";
        return dd.buscaDepartamentos(comando, new ArrayList<String>());
        
    }
}
