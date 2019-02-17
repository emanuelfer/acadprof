/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCurso;
import java.util.ArrayList;
import model.Curso;

/**
 *
 * @author emanu
 */
public class ControllerCurso {
    
    public Curso bucsca(int id){
        DaoCurso dc = new DaoCurso();
        String comando = "SELECT * FROM curso WHERE idCurso = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return dc.busca(comando, parametros);
    }
}
