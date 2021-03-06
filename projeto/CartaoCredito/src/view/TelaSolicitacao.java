package view;

import controller.ClienteController;
import controller.PreClienteController;
import controller.SpcController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCliente;
import model.ModelPreCliente;
import model.ModelSpc;


public class TelaSolicitacao extends javax.swing.JFrame {
    ModelPreCliente modelPreCliente = new ModelPreCliente();
    ModelCliente modelCliente = new ModelCliente();
    ArrayList<ModelPreCliente> listaPreCliente = new ArrayList<>();
    ModelSpc modelSpc = new ModelSpc();
   
    /**
     * Creates new form TelaSolicitacao
     */
    public TelaSolicitacao() {
        initComponents();
        this.bloquearBotoes();
        this.carregarPreCliente();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSolicitacoes = new javax.swing.JTable();
        jButtonAprovar = new javax.swing.JButton();
        jButtonRecusar = new javax.swing.JButton();
        jButtonConsultarSPC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitações de cartões");
        setResizable(false);

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Nome", "CPF", "Salário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSolicitacoes);
        if (jTableSolicitacoes.getColumnModel().getColumnCount() > 0) {
            jTableSolicitacoes.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jButtonAprovar.setText("Aprovar");
        jButtonAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAprovarActionPerformed(evt);
            }
        });

        jButtonRecusar.setText("Recusar");
        jButtonRecusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecusarActionPerformed(evt);
            }
        });

        jButtonConsultarSPC.setText("Consultar SPC");
        jButtonConsultarSPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarSPCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonRecusar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAprovar))
                            .addComponent(jButtonConsultarSPC, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonConsultarSPC)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAprovar)
                    .addComponent(jButtonRecusar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.jTableSolicitacoes.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(model);
        this.jTableSolicitacoes.setRowSorter(classificador);
        String texto = jTextFieldPesquisa.getText();
        classificador.setRowFilter(RowFilter.regexFilter(texto,1));
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonConsultarSPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarSPCActionPerformed
     int linha = jTableSolicitacoes.getSelectedRow();
        if(linha<0){
            JOptionPane.showMessageDialog(this,"Selecione uma pessoa na tabela, antes de clicar em excluir!","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            String nome = (String)jTableSolicitacoes.getValueAt(linha,1);
            try {
            modelSpc = SpcController.consultarSpcPeloNome(nome);
            if(modelSpc==null){
                JOptionPane.showMessageDialog(null, "Essa pessoa não está na lista do SPC");
                this.desbloquearBotoes();
            }else{
                JOptionPane.showMessageDialog(null, "Essa pessoa está com o nome na lista do SPC!");
                this.desbloquearBotoaoExcluir();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaCartao.class.getName()).log(Level.SEVERE, null, ex);
       }
        carregarPreCliente();    
        
        }
    }//GEN-LAST:event_jButtonConsultarSPCActionPerformed

    private void jButtonRecusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecusarActionPerformed
     int linha = jTableSolicitacoes.getSelectedRow();
     int codigo = 0;
        if(linha<0){
            JOptionPane.showMessageDialog(this,"Selecione uma pessoa na tabela, antes de clicar em recusar","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            String nome = (String)jTableSolicitacoes.getValueAt(linha,1);
            int opcao= JOptionPane.showConfirmDialog(this,"Tem certeza que deseja recusar a pessoa: "+nome,"Atenção",JOptionPane.YES_NO_OPTION);
            if(opcao==JOptionPane.OK_OPTION){
                codigo = (Integer) jTableSolicitacoes.getValueAt(linha,0);
                try {
                    PreClienteController.excluirPreCliente(codigo);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       }
        carregarPreCliente();
    }//GEN-LAST:event_jButtonRecusarActionPerformed

    private void jButtonAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAprovarActionPerformed
        int linha = jTableSolicitacoes.getSelectedRow();
        int codigo=0;
        codigo = (Integer) jTableSolicitacoes.getValueAt(linha,0);
        try {
            modelPreCliente = PreClienteController.consultarPreCliente(codigo);
            modelCliente.setCpf(modelPreCliente.getCpf());
            modelCliente.setDataNascimento(modelPreCliente.getDataNascimento());
            modelCliente.setEndereco(modelPreCliente.getEndereco());
            modelCliente.setNome(modelPreCliente.getNome());
            modelCliente.setProfissao(modelPreCliente.getProfissao());
            modelCliente.setRg(modelPreCliente.getRg());
            modelCliente.setSalario(modelPreCliente.getSalario());
            modelCliente.setTelefone(modelPreCliente.getTelefone());
        } catch (SQLException ex) {
            Logger.getLogger(TelaSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           try {
               if(ClienteController.inserirCliente(modelCliente)==true){
                   JOptionPane.showMessageDialog(this,"Cliente cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                   PreClienteController.excluirPreCliente(codigo);
                   this.carregarPreCliente();
                   int resposta=JOptionPane.showConfirmDialog(null, "Deseja cadastrar um dependente?","Confirmação",JOptionPane.YES_NO_OPTION);
                   if(resposta==JOptionPane.YES_OPTION){
                       new TelaDependente().setVisible(true);
                   }
                   
               }else{
                   JOptionPane.showMessageDialog(this,"Erro ao cadastar cliente!","ERRO",JOptionPane.ERROR_MESSAGE);
               }  } catch (SQLException ex) {
               Logger.getLogger(TelaSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
           }
      
    }//GEN-LAST:event_jButtonAprovarActionPerformed
    
private void bloquearBotoes(){
    jButtonAprovar.setEnabled(false);
    jButtonRecusar.setEnabled(false);
}
private void desbloquearBotoes(){
    jButtonAprovar.setEnabled(true);
    jButtonRecusar.setEnabled(true);
}
private void desbloquearBotoaoExcluir(){
    jButtonRecusar.setEnabled(true);
}
    private void carregarPreCliente(){
        try {
            listaPreCliente=PreClienteController.listarPreCliente();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) jTableSolicitacoes.getModel();
        //número de linhas que a tabela começa
        model.setNumRows(0);
        
        //a variável cont recebe o tamanho da lista
        int cont = listaPreCliente.size();
        //inserir clientes na tabela
        for(int c =0; c<cont;c++){
            model.addRow(new Object[]{
                listaPreCliente.get(c).getIdPreCliente(),
                listaPreCliente.get(c).getNome(),
                listaPreCliente.get(c).getCpf(),
                listaPreCliente.get(c).getSalario(),

            });
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSolicitacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSolicitacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSolicitacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSolicitacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSolicitacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAprovar;
    private javax.swing.JButton jButtonConsultarSPC;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRecusar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSolicitacoes;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
