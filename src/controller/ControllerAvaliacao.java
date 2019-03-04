/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAvaliacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Aula;
import model.Avaliacao;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class ControllerAvaliacao {
    
    public String avaliar(int idAula, double nota,String parecer,String disciplina,String conteudo,String horario,String semestre,Aluno aluno){
        if(parecer.isEmpty()){
            return "Preencha todos os campos!";
        }
        if(nota>10.0){
            return "A nota máxima é 10!";
        }
        if(parecer.length()>255){
            return "O número máximo de caracteres é 255!";
        }
            
        
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String comando = "INSERT INTO avaliacao (nota, parecer, data, idAluno, idAula) VALUES(?,?,?,?,?)";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Double.toString(nota));
        parametros.add(parecer);
        parametros.add(formatador.format(data));
        parametros.add(Integer.toString(aluno.getId()));
        parametros.add(Integer.toString(idAula));
        DaoAvaliacao da = new DaoAvaliacao();
        
        if(da.avaliar(comando, parametros))
            return "Aula avaliada!";
        else
            return "Erro ao avaliar aula!";
    }
    
    public Avaliacao busca(Aula aula, Aluno aluno){
        DaoAvaliacao da = new DaoAvaliacao();
        String comando = "SELECT * FROM avaliacao, aula, aluno where avaliacao.idAula = ? and avaliacao.idAluno = ? group by avaliacao.idAvaliacao";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(aula.getId()));
        parametros.add(Integer.toString(aluno.getId()));
        return da.busca(comando, parametros);
    }
    
    public ArrayList<Avaliacao> busca(Aula aula){
        DaoAvaliacao da = new DaoAvaliacao();
        String comando = "SELECT * FROM avaliacao, aula where avaliacao.idAula = ? group by avaliacao.idAvaliacao";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(aula.getId()));
        return da.buscaAvaliacoes(comando, parametros);
    }
    
    public ArrayList<Avaliacao> busca(Professor professor, String codigo, Aula aula){
        ControllerTurma ct = new ControllerTurma();
        Turma turma = ct.buscarPorCodigo(codigo);
       
        String comando = "SELECT * FROM avaliacao, aula where ? = aula.idProfessor and aula.idTurma = ? and aula.idAula = ? and avaliacao.idAula = aula.idAula";
        ArrayList<String> parametros = new ArrayList<String>();
        parametros.add(Integer.toString(professor.getId()));
        parametros.add(Integer.toString(aula.getTurma().getId()));
        parametros.add(Integer.toString(aula.getId()));
        DaoAvaliacao da = new DaoAvaliacao();
        return da.buscaAvaliacoes(comando, parametros);
    }
    
    public double calcularMedia(ArrayList<Avaliacao> avaliacoes){
        double media =0.0;
        double soma = 0;
        int cont = 0;
        for(Avaliacao avaliacao : avaliacoes){
            soma += avaliacao.getNota();

            cont++;
        }
        return soma/cont;
    }
}
