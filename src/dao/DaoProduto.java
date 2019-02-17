/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author emanu
 */
public class DaoProduto {
    /*private Connection con;
    public ArrayList<Produto> buscaProdutos(String nome){
        con = ConnectionFactory.getConnection();
	ResultSet rs = null;
        PreparedStatement stmt = null;
        ArrayList<Produto> produtos = new ArrayList();
	try {  
            stmt = con.prepareStatement("SELEC * FROM produto WHERE nome LIKE %?%");  
            stmt.setString(1, nome);
	    rs = stmt.executeQuery();
            
            while(rs.next()) { 
                Produto produto = new Produto();
                produto.setId(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
	    }   
	} catch (SQLException e) {  
	           System.out.println("Erro ao buscar curso: "+ e.getMessage());
	    return null;  
	}finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }*/
}
