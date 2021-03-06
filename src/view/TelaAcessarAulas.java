/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAula;
import controller.ControllerAvaliacao;
import controller.ControllerDisciplina;
import gerenciartelas.GerenciadorDeTelas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Aula;
import model.Avaliacao;
import model.Disciplina;

/**
 *
 * @author emanu
 */
public class TelaAcessarAulas extends javax.swing.JInternalFrame {
    private TelaAvaliarAula telaAvaliarAula = null;
    
    private Aluno aluno;
    private GerenciadorDeTelas gerenciadorDeTelas;
    /**
     * Creates new form TelaAcessarAulas
     */
    public TelaAcessarAulas(Aluno aluno, GerenciadorDeTelas gerenciadorDeTelas) {
        initComponents();
        this.aluno = aluno;
        this.gerenciadorDeTelas = gerenciadorDeTelas;

        
        ControllerDisciplina cd = new ControllerDisciplina();
        ArrayList<Disciplina> disciplinas = cd.buscaTodos(this.aluno);
        cbDisciplinas.removeAllItems();
        for(int i = 0; i< disciplinas.size(); i++){
            cbDisciplinas.addItem(disciplinas.get(i).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAvaliacao = new javax.swing.JTable();
        cbDisciplinas = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Aulas ");

        tableAvaliacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Disciplina", "Conteúdo", "Professor", "Data", "Horário", "Semestre", "Nota", "Disponível"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAvaliacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAvaliacao);
        if (tableAvaliacao.getColumnModel().getColumnCount() > 0) {
            tableAvaliacao.getColumnModel().getColumn(0).setMinWidth(0);
            tableAvaliacao.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableAvaliacao.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        cbDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disciplina", "Item 2", "Item 3", "Item 4" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(cbDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        ControllerDisciplina cd = new ControllerDisciplina();
        Disciplina disciplina = cd.busca((String)cbDisciplinas.getSelectedItem());
        DefaultTableModel tableAula = (DefaultTableModel)tableAvaliacao.getModel();
        tableAula.setNumRows(0);
        
        ControllerAula ca = new ControllerAula();
        ArrayList<Aula> aulas = ca.buscaTodos(aluno, disciplina.getId());
        
        if(aulas.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
        }else{
            ControllerAvaliacao controllerAvaliacao = new ControllerAvaliacao(); 
            for(Aula aula : aulas) {
                Avaliacao avaliacao = controllerAvaliacao.busca(aula, this.aluno);

                if(avaliacao==null){    
                    
                    Object[] dados = {aula.getId(), aula.getDisciplina(), aula.getConteudo(), aula.getProfessor().getNome(), aula.getData(), aula.getHora(), aula.getSemestre(),null,"SIM"};
                    tableAula.addRow(dados);
                }else{
                    Object[] dados = {aula.getId(),aula.getDisciplina(), aula.getConteudo(), aula.getProfessor().getNome(), aula.getData(), aula.getHora(), aula.getSemestre(), avaliacao.getNota(), "NÃO"};
                    tableAula.addRow(dados);
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAvaliacaoMouseClicked
        // TODO add your handling code here:
        int row = tableAvaliacao.getSelectedRow();
        int idAula = Integer.parseInt(tableAvaliacao.getValueAt(row, 0).toString());
        
        if(tableAvaliacao.getValueAt(row, 7) == null){
            String disciplina = tableAvaliacao.getValueAt(row, 1).toString();
            String conteudo = (String)tableAvaliacao.getValueAt(row, 2);
            String professor = (String)tableAvaliacao.getValueAt(row, 3);
            String data = (String)tableAvaliacao.getValueAt(row, 4);
            String horario = (String)tableAvaliacao.getValueAt(row, 5);
            String semestre = (String)tableAvaliacao.getValueAt(row, 6);
            
            if(telaAvaliarAula == null){
                telaAvaliarAula = new TelaAvaliarAula(idAula, disciplina, conteudo, professor, data, horario, semestre, this.aluno, this);
                this.gerenciadorDeTelas.abrirJanelas(telaAvaliarAula);
            }else{
                this.gerenciadorDeTelas.abrirJanelas(telaAvaliarAula);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aula indisponível");
        }
    }//GEN-LAST:event_tableAvaliacaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbDisciplinas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAvaliacao;
    // End of variables declaration//GEN-END:variables
}
