/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAdministrador;
import dao.DaoProfessor;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Administrador;
import model.Professor;

/**
 *
 * @author emanu
 */
public class ControllerProfessor {
    
    public Professor loginProfessor(String CPF, String senha) {
        DaoProfessor dp = new DaoProfessor();
        String comando = "SELECT * FROM professor where CPF = ? && senha = md5(?)";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(CPF);
        parametros.add(senha);
        Professor professor = dp.busca(comando, parametros);
        return professor;
    }
    
    public Professor busca(int id){
        DaoProfessor dp = new DaoProfessor();
        String comando = "SELECT * FROM professor WHERE idProfessor = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return dp.busca(comando, parametros);
    }
    
    public Professor busca(String CPF){
        if(CPF.isEmpty()){
            return null;
        }
        DaoProfessor dp = new DaoProfessor();
        String comando = "SELECT * FROM professor WHERE CPF = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(CPF);
        return dp.busca(comando, parametros);
    }
    
    public String salvar(String[] dados){
       boolean hasError = false;
       String nome = dados[0];
       String cpf = dados[1];
       String graduacao = dados[2];
       String departamento = dados[3];
       String errors = "";
       String result = "Inserção realizada com sucesso !!";
       String failure = "Não foi possível realizar o cadastro devido a erros registrados no log";
       
       if(nome.isEmpty()){
           hasError = true;
           errors = errors+"<b>Campo nome não pode ficar vazio</b><br>";
       } 
       
       if(cpf.isEmpty()){
           hasError = true;
           errors = errors+"<b>Campo cpf não pode ficar vazio</b><br>";
       }
       
       if(cpf.length()>11)
           return "O CPF deve conter apenas 11 dígitos!";
           
       for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
               return "Digete apenas números para o CPF";
            }
            
         }
       
       if(hasError){
           result = "<html><p>Erro:</p>"+errors+"</html>";
           return result;
       }
       
       Professor p = new Professor();
       ControllerDepartamento cp = new ControllerDepartamento();
       p.setNome(nome);
       p.setCPF(cpf);
       p.setDepartamento(cp.busca(departamento));
       p.setGraduacao(graduacao);
      
       DaoProfessor d = new DaoProfessor();
       String comando = "INSERT INTO `acadprofe`.`professor` (`nome`, `CPF`, `graduacao`, `idDepartamento`, `senha`) VALUES (?, ?, ?, ?, md5(?))";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(nome);
       parametros.add(cpf);
       parametros.add(graduacao);
       parametros.add(Integer.toString(p.getDepartamento().getId()));
       parametros.add(nome);
       if(d.insert(comando, parametros)){
           return result;
       }
       result = failure;
       return result;
    }
    
    public String atualizarProfessor(String[] dados){
       boolean hasError = false;
       String nome = dados[0];
       String cpf = dados[1];
       String graduacao = dados[2];
       String departamento = dados[3];
       int id = Integer.parseInt(dados[4]);
       String errors = "";
       String result = "Alteração realizada com sucesso !!";
       String failure = "Não foi possível realizar a alteração devido a erros registrados no log";
       
       if(nome.isEmpty()){
           hasError = true;
           errors = errors+"<b>Campo nome não pode ficar vazio</b><br>";
       } 
       
       if(cpf.isEmpty()){
           hasError = true;
           errors = errors+"<b>Campo cpf não pode ficar vazio</b><br>";
       }
       
       if(hasError){
           result = "<html><p>Erro:</p>"+errors+"</html>";
           return result;
       }
       
       Professor p = new Professor();
       ControllerDepartamento cd = new ControllerDepartamento();
       p.setNome(nome);
       p.setCPF(cpf);
       p.setDepartamento(cd.busca(departamento));
       p.setGraduacao(graduacao);
       p.setId(id);
      
       DaoProfessor d = new DaoProfessor();
       String comando = "UPDATE professor SET nome = ?, CPF =  ?, graduacao = ?, idDepartamento = ? WHERE idProfessor = ?";
       ArrayList<String> parametros = new ArrayList<String>();
       parametros.add(p.getNome());
       parametros.add(p.getCPF());
       parametros.add(p.getGraduacao());
       parametros.add(Integer.toString(p.getDepartamento().getId()));
       parametros.add(Integer.toString(p.getId()));
       if(d.update(comando, parametros)){
           return result;
       }
       result = failure;
       return result;
    }
    
    public String deletar(Professor professor){
        String result = "Professor "+professor.getNome()+" deletado com sucesso !";
        String comando = "DELETE FROM professor WHERE CPF = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(professor.getCPF());
        if(new DaoProfessor().delete(comando, parametros)){
            return result;
        }
        result = "Não foi possível realizar deleção devido a erros registrados no log";
        return result;
    }
    
    public String alterarSenha(String senhaAtual, String senhaNova, Professor professor){
        if(senhaAtual.isEmpty() || senhaNova.isEmpty()){
            return "Preencha todos os campos!";
        }
        
        if(senhaNova.length() <5){
            return "A nova senha deve possuir no mínimo 5 caracteres!";
        }
        ArrayList<String> parametros = new ArrayList<String>();
        
        String comando = "select * from professor where idProfessor = ? and senha = md5(?)";
        parametros.add(Integer.toString(professor.getId()));
        parametros.add(senhaAtual);
        
        DaoProfessor dp = new DaoProfessor();
        Professor prof = dp.busca(comando, parametros);
        if(prof == null){
            return "Senha atual inválida!";
        }
        
        parametros.clear();
        comando = "UPDATE professor set senha = md5(?) where idProfessor = ?";
        parametros.add(senhaNova);
        parametros.add(Integer.toString(professor.getId()));
              
        if(dp.update(comando, parametros)){
            return "Sucesso ao alterar senha!";
        }else{
            return "Erro ao alterar senha!";
        }
    }
}
