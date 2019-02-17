/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAluno;
import java.util.ArrayList;
import model.Aluno;
import model.Turma;

/**
 *
 * @author emanu
 */
public class ControllerAluno {
    public Aluno loginAluno(String matricula, String senha){
        DaoAluno da = new DaoAluno();
        String comando = "select * from aluno where senha = md5(?) and matricula = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(senha);
        parametros.add(matricula);
        Aluno aluno = da.busca(comando, parametros);
        return aluno;
    }
    
    public String salvar(String nome, String CPF, String matricula, int idTurma ){
        if(nome.isEmpty() || CPF.isEmpty() || matricula.isEmpty()){
            return "Preencha todos os campos!";
        }
        ControllerTurma ct = new ControllerTurma();
        Turma turma = ct.busca(idTurma);
        
        String comando = "INSERT INTO aluno (nome, CPF, matricula, idTurma, senha) VALUES(?,?,?,?,md5(?))";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(nome);
        parametros.add(CPF);
        parametros.add(matricula);
        parametros.add(Integer.toString(idTurma));
        parametros.add(nome);
        DaoAluno da = new DaoAluno();
        da.create(comando, parametros);
        return "Aluno cadastrado!";
    }
    
    public Aluno bucsca(int id){
        DaoAluno da = new DaoAluno();
        String comando = "SELECT * FROM aluno where idAluno = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(id));
        return da.busca(comando, parametros);
    }
    public Aluno busca(String matricula){
        if(matricula.isEmpty()){
            return null;
        }
        
        DaoAluno da = new DaoAluno();
        String comando = "select * from aluno where matricula = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(matricula);
        return da.busca(comando, parametros);
    }
    
    public String alterar(String nome, String CPF, String matricula, int idTurma, int idAluno){  
        if(nome.isEmpty() || CPF.isEmpty() || matricula.isEmpty()){
            return "Preencha todos os campos!";
        }
        
        DaoAluno da = new DaoAluno();
        String comando = "update aluno set nome = ?, CPF = ?, matricula = ?, idTurma = ? where idAluno = ? ";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(nome);
        parametros.add(CPF);
        parametros.add(matricula);
        parametros.add(Integer.toString(idTurma));
        parametros.add(Integer.toString(idAluno));
        if(da.update(comando,parametros)){
            return "Aluno alterado com sucesso!";
        }else{
            return "Erro ao alterar aluno!";
        }
    } 
    
    public String deletar(Aluno aluno){
        String result = "Aluno "+aluno.getNome()+" deletado com sucesso !";
        String comando = "DELETE FROM aluno WHERE matricula = ?";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(aluno.getMatricula());
        if(new DaoAluno().delete(comando, parametros)){
            return result;
        }
        result = "Não foi possível realizar deleção devido a erros registrados no log";
        return result;
    }
    
    public String alterarSenha(String senhaAtual, String senhaNova, Aluno aluno){
        if(senhaAtual.isEmpty() || senhaNova.isEmpty()){
            return "Preencha todos os campos!";
        }
        
        if(senhaNova.length() <5){
            return "A nova senha deve possuir no mínimo 5 caracteres!";
        }
        ArrayList<String> parametros = new ArrayList<String>();
        
        String comando = "select * from aluno where idAluno = ? and senha = md5(?)";
        parametros.add(Integer.toString(aluno.getId()));
        parametros.add(senhaAtual);
        
        DaoAluno da = new DaoAluno();
        Aluno a = da.busca(comando, parametros);
        if(a == null){
            return "Senha atual inválida!";
        }
        
        parametros.clear();
        comando = "UPDATE aluno set senha = md5(?) where idAluno = ?";
        parametros.add(senhaNova);
        parametros.add(Integer.toString(aluno.getId()));
              
        if(da.update(comando, parametros)){
            return "Sucesso ao alterar senha!";
        }else{
            return "Erro ao alterar senha!";
        }
    }
}
