/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAluno;
import controller.ControllerCurso;
import controller.ControllerTurma;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;
import model.Turma;

/**
 *
 * @author emanu
 */
public class TelaAlterarAluno extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAlterarAluno
     */
    public TelaAlterarAluno() {
        initComponents();
        preenchecbCurso();
        this.pnAlterar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMatriculaPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        pnAlterar = new javax.swing.JPanel();
        cbAno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cbTurno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox<>();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        cbCodigo = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbModalidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Digite a matrícula do aluno:");

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Ano:");

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("CPF:");

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

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Matrícula:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Turno:");

        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Código:");

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

        javax.swing.GroupLayout pnAlterarLayout = new javax.swing.GroupLayout(pnAlterar);
        pnAlterar.setLayout(pnAlterarLayout);
        pnAlterarLayout.setHorizontalGroup(
            pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAlterarLayout.createSequentialGroup()
                        .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnAlterarLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAlterar)
                                .addGroup(pnAlterarLayout.createSequentialGroup()
                                    .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnAlterarLayout.createSequentialGroup()
                                            .addComponent(txtCPF)
                                            .addGap(118, 118, 118))))))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(pnAlterarLayout.createSequentialGroup()
                        .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbModalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCodigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(150, 150, 150))))
        );
        pnAlterarLayout.setVerticalGroup(
            pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlterarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnAlterar)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtMatriculaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatriculaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(pnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void preenchecbCurso(){
        ControllerTurma ct = new ControllerTurma();
        ArrayList<Turma> turmas = ct.buscaTodos();
        cbCurso.removeAllItems();
        for(int i = 0; i< turmas.size(); i++){
            cbCurso.addItem(turmas.get(i).getCurso().getNome());
        }
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        ControllerAluno control = new ControllerAluno();
        Aluno p = control.busca(this.txtMatriculaPesquisa.getText());
        if(p == null){
            JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            return;
        }
       
        this.idAluno = p.getId();
        this.txtNome.setText(p.getNome());
        this.txtCPF.setText(p.getCPF());
        this.txtMatricula.setText(p.getMatricula());
        
        Turma t = p.getTurma();
        Curso c = t.getCurso();
        this.cbCurso.setSelectedItem(c.getNome());
        this.cbAno.setSelectedItem(t.getAno());
        this.cbModalidade.setSelectedItem(t.getModalidade());
        this.cbTurno.setSelectedItem(t.getTurno());
        this.pnAlterar.setVisible(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

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

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String CPF = txtCPF.getText();
        String matricula = txtMatricula.getText();

        String codigo = (String)cbCodigo.getSelectedItem();
        ControllerTurma ct = new ControllerTurma();
        Turma turma = ct.buscarPorCodigo(codigo);

        ControllerAluno ca = new ControllerAluno();
        String mensagem = ca.alterar(nome, CPF, matricula, turma.getId(), this.idAluno);
        JOptionPane.showMessageDialog(null, mensagem);
    }//GEN-LAST:event_btnAlterarActionPerformed

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

    int idAluno;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbModalidade;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnAlterar;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMatriculaPesquisa;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}