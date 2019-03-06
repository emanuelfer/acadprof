/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAula;
import controller.ControllerAvaliacao;
import controller.ControllerCurso;
import controller.ControllerDisciplina;
import controller.ControllerTurma;
import gerenciartelas.GerenciadorDeTelas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aula;
import model.Avaliacao;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class TelaAcessarAvaliacoes extends javax.swing.JInternalFrame {
    private Professor professor;
    private TelaAvaliacao telaAvaliacao;
    
    private GerenciadorDeTelas gerenciadorDeTelas;
    /**
     * Creates new form TelaAcessarAvaliações
     */
    public TelaAcessarAvaliacoes(Professor professor, GerenciadorDeTelas gerenciadorDeTelas) {
        initComponents();
        this.gerenciadorDeTelas = gerenciadorDeTelas;
        
        this.professor = professor;
        
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.buscaTodos();
        cbCurso.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbCurso.addItem(turmas.get(i).getCurso().getNome());
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
        cbModalidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox<>();
        cbCurso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAula = new javax.swing.JTable();
        btnBuscarAvaliacao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarAula = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Avaliações");

        tableAvaliacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Turma", "Disciplina", "Conteúdo", "Data", "Nota", "Parecer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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

        cbModalidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModalidadeItemStateChanged(evt);
            }
        });
        cbModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModalidadeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Modalidade:");

        cbAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAnoItemStateChanged(evt);
            }
        });
        cbAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Ano");

        cbTurno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTurnoItemStateChanged(evt);
            }
        });
        cbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnoActionPerformed(evt);
            }
        });

        cbCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCursoItemStateChanged(evt);
            }
        });
        cbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCursoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Curso:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Turno:");

        cbCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCodigoItemStateChanged(evt);
            }
        });
        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Código:");

        tableAula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Turma", "Disciplina", "Conteúdo", "Data", "Horário", "Semestre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAulaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAula);
        if (tableAula.getColumnModel().getColumnCount() > 0) {
            tableAula.getColumnModel().getColumn(0).setMinWidth(0);
            tableAula.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableAula.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnBuscarAvaliacao.setText("Buscar");
        btnBuscarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAvaliacaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Aula:");

        btnBuscarAula.setText("Buscar Aula");
        btnBuscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbTurno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbAno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbModalidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBuscarAula))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarAvaliacao))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarAvaliacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarAula)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbModalidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModalidadeItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem());

        cbAno.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbAno.addItem(turmas.get(i).getAno());
        }
    }//GEN-LAST:event_cbModalidadeItemStateChanged

    private void cbModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbModalidadeActionPerformed

    private void cbAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAnoItemStateChanged
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem(), (String)cbAno.getSelectedItem());

        cbTurno.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbTurno.addItem(turmas.get(i).getTurno());
        }
    }//GEN-LAST:event_cbAnoItemStateChanged

    private void cbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoActionPerformed

    private void cbTurnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTurnoItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem(), (String)cbAno.getSelectedItem(), (String)cbTurno.getSelectedItem());

        cbCodigo.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbCodigo.addItem(turmas.get(i).getCodigo());
        }
    }//GEN-LAST:event_cbTurnoItemStateChanged

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurnoActionPerformed

    private void cbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCursoItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem());

        cbModalidade.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbModalidade.addItem(turmas.get(i).getModalidade());
        }
    }//GEN-LAST:event_cbCursoItemStateChanged

    private void cbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoActionPerformed

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCodigoActionPerformed

    private void tableAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAulaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableAulaMouseClicked

    private void btnBuscarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAvaliacaoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabelaAvaliacao = (DefaultTableModel)tableAvaliacao.getModel();
        tabelaAvaliacao.setNumRows(0);
        if(tableAula.getSelectedRow() != -1){
            int row = tableAula.getSelectedRow();
            String codigo = (String)cbCodigo.getSelectedItem();
            int idAula = Integer.parseInt(tableAula.getValueAt(row, 0).toString());
            ControllerAula ca = new ControllerAula();
            Aula aula = ca.busca(idAula);
            ControllerAvaliacao controllerAvaliacao = new ControllerAvaliacao();
            ArrayList<Avaliacao> avaliacoes = controllerAvaliacao.busca(this.professor, codigo, aula);

            if(avaliacoes.size() ==0){
                JOptionPane.showMessageDialog(null, "Nenhuma avaliação encontrada!");
            }else{
                for(Avaliacao avaliacao : avaliacoes){
                    Object[] dados = {aula.getTurma().toString(), aula.getDisciplina().toString(),aula.getConteudo(), avaliacao.getData(), avaliacao.getNota(), avaliacao.getParecer()};
                    tabelaAvaliacao.addRow(dados);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma aula foi selecionada!");
        }
    }//GEN-LAST:event_btnBuscarAvaliacaoActionPerformed

    private void cbCodigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCodigoItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbCodigoItemStateChanged

    private void btnBuscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAulaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ta = (DefaultTableModel)tableAula.getModel();
        ta.setNumRows(0);
        String codigoTurma = (String)cbCodigo.getSelectedItem();
        ControllerAula ca = new ControllerAula();
        ArrayList<Aula> aulas = null;
        if(!codigoTurma.isEmpty())
           aulas = ca.buscaTodos(this.professor, codigoTurma);

        if(aulas.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
        }else{
            for(Aula aula : aulas) {

                Object[] dados = {aula.getId(),aula.getTurma().toString(), aula.getDisciplina(), aula.getConteudo(), aula.getData(), aula.getHora(), aula.getSemestre()};
                ta.addRow(dados);
            }
        }
    }//GEN-LAST:event_btnBuscarAulaActionPerformed

    private void tableAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAvaliacaoMouseClicked
        // TODO add your handling code here:
        int row = tableAvaliacao.getSelectedRow();
        
        String turma = tableAvaliacao.getValueAt(row, 0).toString();
        String disciplina = (String)tableAvaliacao.getValueAt(row, 1);
        String conteudo = (String)tableAvaliacao.getValueAt(row, 2);
        String data = tableAvaliacao.getValueAt(row, 3).toString();
        String nota = tableAvaliacao.getValueAt(row, 4).toString();
        String parecer = (String)tableAvaliacao.getValueAt(row, 5);

        telaAvaliacao = new TelaAvaliacao(turma, disciplina, conteudo, data, nota, parecer);
        this.gerenciadorDeTelas.abrirJanelas(telaAvaliacao);
    }//GEN-LAST:event_tableAvaliacaoMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAula;
    private javax.swing.JButton btnBuscarAvaliacao;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbModalidade;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableAula;
    private javax.swing.JTable tableAvaliacao;
    // End of variables declaration//GEN-END:variables
}
