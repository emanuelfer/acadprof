/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import dao.DaoAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Administrador;

/**
 *
 * @author emanu
 */
public class ControllerAdministrador {
    public Administrador loginAdministrador(String CPF, String senha) throws SQLException{
        String comando = "SELECT * FROM administrador where CPF = ? && senha = md5(?)";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(CPF);
        parametros.add(senha);
        DaoAdministrador da = new DaoAdministrador();
        Administrador adm = da.buscar(comando , parametros);
        return adm;
    }
    
}
