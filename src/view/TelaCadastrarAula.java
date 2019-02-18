/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAula;
import controller.ControllerDisciplina;
import controller.ControllerTurma;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Disciplina;
import model.Professor;
import model.Turma;

/**
 *
 * @author emanu
 */
public class TelaCadastrarAula extends javax.swing.JInternalFrame {
    private Professor professor;
    /**
     * Creates new form TelaCadastrarAula
     */
    public TelaCadastrarAula(Professor professor) {
        initComponents();
        this.professor = professor;
        
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.buscaTodos();
        cbCurso.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbCurso.addItem(turmas.get(i).getCurso().getNome());
        }
        
        ControllerDisciplina cd = new ControllerDisciplina();
        ArrayList<Disciplina> disciplinas = cd.buscaTodos(this.professor);
        cbDisciplinas.removeAllItems();
        for(int i = 0; i< disciplinas.size(); i++){
            cbDisciplinas.addItem(disciplinas.get(i).getNome());
          
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

        cbCurso = new javax.swing.JComboBox<>();
        btnCadastrarAula = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textConteudo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbDisciplinas = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        txtHorario = new javax.swing.JFormattedTextField();
        cbModalidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Aula");

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

        btnCadastrarAula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCadastrarAula.setText("Salvar");
        btnCadastrarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAulaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Disicplina:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Conteúdo:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Curso:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Data:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Horário:");

        cbDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desenvolvimento de Sistemas Web" }));
        cbDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDisciplinasMouseClicked(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##h##-##h##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Turno:");

        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(txtHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(cbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbModalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbTurno, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCodigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCadastrarAula)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbDisciplinas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
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
                .addComponent(btnCadastrarAula)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoActionPerformed

    private void btnCadastrarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAulaActionPerformed
        // TODO add your handling code here:
        String conteudo = textConteudo.getText();
        String data = txtData.getText();
        String horario = txtHorario.getText();
        
        String codigo = (String)cbCodigo.getSelectedItem();
        ControllerTurma ct = new ControllerTurma();
        Turma turma = ct.buscarPorCodigo(codigo);
        
        ControllerDisciplina cd = new ControllerDisciplina();
        Disciplina disciplina = cd.busca((String)cbDisciplinas.getSelectedItem());
        int idTurma = cbCurso.getSelectedIndex() + 1;
        ControllerAula ca = new ControllerAula();
        String mensagem;
        try {
            mensagem = ca.create(conteudo, data, horario, disciplina.getId(), turma.getId(), professor);
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastrarAula.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aula!");
        }
        
       
    }//GEN-LAST:event_btnCadastrarAulaActionPerformed

    private void cbDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDisciplinasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDisciplinasMouseClicked

    private void cbModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbModalidadeActionPerformed

    private void cbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoActionPerformed

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurnoActionPerformed

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCodigoActionPerformed

    private void cbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCursoItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem());
        
        cbModalidade.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbModalidade.addItem(turmas.get(i).getModalidade());
        }
    }//GEN-LAST:event_cbCursoItemStateChanged

    private void cbModalidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModalidadeItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem());
        
        cbAno.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbAno.addItem(turmas.get(i).getAno());
        }
    }//GEN-LAST:event_cbModalidadeItemStateChanged

    private void cbAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAnoItemStateChanged
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem(), (String)cbAno.getSelectedItem());
        
        cbTurno.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbTurno.addItem(turmas.get(i).getTurno());
        }
    }//GEN-LAST:event_cbAnoItemStateChanged

    private void cbTurnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTurnoItemStateChanged
        // TODO add your handling code here:
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.busca((String)cbCurso.getSelectedItem(), (String)cbModalidade.getSelectedItem(), (String)cbAno.getSelectedItem(), (String)cbTurno.getSelectedItem());
        
        cbCodigo.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbCodigo.addItem(turmas.get(i).getCodigo());
        }
    }//GEN-LAST:event_cbTurnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAula;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbDisciplinas;
    private javax.swing.JComboBox<String> cbModalidade;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textConteudo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorario;
    // End of variables declaration//GEN-END:variables
}
