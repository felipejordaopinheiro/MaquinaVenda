/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerProduto;
import Controller.ControllerDinheiro;
import java.util.*;
import Model.Produto;
import Model.Dinheiro;
/**
 *
 * @author FelipeJordao
 */
public class User extends javax.swing.JFrame {
    
    List<Produto> produtos = new ArrayList();
    List<Dinheiro> dinheiros = new ArrayList();
    ControllerProduto cProduto = new ControllerProduto();
    ControllerDinheiro cDinheiro = new ControllerDinheiro();
    
    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        
        fnInicializaDados();
    }
    
    public void fnInicializaDados(){
       
        /* for(Produto p:cProduto.read()) */
        produtos = cProduto.read();
        cProduto.blockVencido();
        
        if(produtos.size() >= 1)
            if(verificaqtd(produtos.get(0).getQtd_atual()) && produtos.get(0).isBloqueado()== 0)
                txtproduto1.setText(produtos.get(0).getNome() + " - R$" + produtos.get(0).getPreco());
            else
                txtproduto1.setText("Sem produto");
        else
            txtproduto1.setText("Sem produto");
        
        if(produtos.size() >= 2)
            if(verificaqtd(produtos.get(1).getQtd_atual())&& produtos.get(1).isBloqueado()== 0)
                txtproduto2.setText(produtos.get(1).getNome() + " - R$" + produtos.get(1).getPreco());
            else
                txtproduto2.setText("Sem produto");
        else
            txtproduto2.setText("Sem produto");
        
        if(produtos.size() >= 3)
            if(verificaqtd(produtos.get(2).getQtd_atual())&& produtos.get(2).isBloqueado()== 0)
                txtproduto3.setText(produtos.get(2).getNome() + " - R$" + produtos.get(2).getPreco());
            else
                txtproduto3.setText("Sem produto");
        else
            txtproduto3.setText("Sem produto");
        
        if(produtos.size() >= 4){
            if(verificaqtd(produtos.get(3).getQtd_atual())&& produtos.get(3).isBloqueado()== 0)
                txtproduto4.setText(produtos.get(3).getNome() + " - R$" + produtos.get(3).getPreco());
            else
                txtproduto4.setText("Sem produto");
        }else
            txtproduto4.setText("Sem produto");
            
        dinheiros = cDinheiro.read();
       
        //txtMensagem.setText("Display de Mensagem");
    }
    
    public boolean verificaqtd(int qtd){
        
        if(qtd > 0)
            return true;
        
        return false;
    }
    
    public boolean somaTroco(List<Double> listTroco){
            String msgtroco = "";
            boolean blntroco = false;
            double troco = 0.0;
            
            if(listTroco.get(0) != -1.0){
                
                while(!listTroco.isEmpty()){
                    msgtroco = msgtroco + "  "+listTroco.get(listTroco.size()-1);
                    troco = troco + listTroco.remove(listTroco.size()-1);
                }
            
                msgtroco = msgtroco + " = " + troco;
            
                txtTroco.setText(msgtroco);
                blntroco = true;
            }
            
         return blntroco;
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAlimento1 = new javax.swing.JButton();
        txtproduto1 = new javax.swing.JLabel();
        btnAlimento2 = new javax.swing.JButton();
        txtproduto2 = new javax.swing.JLabel();
        btnAlimento3 = new javax.swing.JButton();
        txtproduto3 = new javax.swing.JLabel();
        btnAlimento4 = new javax.swing.JButton();
        txtproduto4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        txtTroco = new javax.swing.JTextField();
        btn05 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));

        btnAlimento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn.png"))); // NOI18N
        btnAlimento1.setBorder(null);
        btnAlimento1.setContentAreaFilled(false);
        btnAlimento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimento1ActionPerformed(evt);
            }
        });

        txtproduto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtproduto1.setText("Goibada");

        btnAlimento2.setBackground(new java.awt.Color(255, 255, 255));
        btnAlimento2.setForeground(new java.awt.Color(255, 255, 255));
        btnAlimento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn.png"))); // NOI18N
        btnAlimento2.setBorder(null);
        btnAlimento2.setContentAreaFilled(false);
        btnAlimento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimento2ActionPerformed(evt);
            }
        });

        txtproduto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtproduto2.setText("Chocolate");

        btnAlimento3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn.png"))); // NOI18N
        btnAlimento3.setBorder(null);
        btnAlimento3.setContentAreaFilled(false);
        btnAlimento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimento3ActionPerformed(evt);
            }
        });

        txtproduto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtproduto3.setText("Croissant");

        btnAlimento4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn.png"))); // NOI18N
        btnAlimento4.setBorder(null);
        btnAlimento4.setContentAreaFilled(false);
        btnAlimento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimento4ActionPerformed(evt);
            }
        });

        txtproduto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtproduto4.setText("biscoito");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnAlimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtproduto3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtproduto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnAlimento2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtproduto4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnAlimento3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlimento4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproduto2)
                    .addComponent(txtproduto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlimento2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnAlimento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproduto3)
                    .addComponent(txtproduto4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlimento3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlimento4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setText("Inserir");

        jLabel2.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setText("0.0");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel7.setText("Troco   R$");

        txtMensagem.setBackground(new java.awt.Color(204, 204, 204));
        txtMensagem.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        txtMensagem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMensagem.setText("Display de Mensagem");
        txtMensagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTroco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTroco.setText("0.0");

        btn05.setText("0.5");
        btn05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn05ActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn10.setText("10");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTroco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMensagem)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn05)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn10)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn05)
                            .addComponent(btn1)
                            .addComponent(btn5)
                            .addComponent(btn10))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Maquina de Alimentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
     
    }//GEN-LAST:event_formWindowActivated

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnAlimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimento1ActionPerformed
        // TODO add your handling code here:
        List<Double> troco = new ArrayList<>();
        int Status = 0;
        Status = cDinheiro.compra(Double.parseDouble(txtTotal.getText()),produtos.get(0));
            
        if(Status == 1)
            txtMensagem.setText("Quantidade esgotada");
        if(Status == 2)
            txtMensagem.setText("Dinheiro insuficiente");
            
        if(Status == 0){
            troco = cDinheiro.calculaTroco(Double.parseDouble(txtTotal.getText()),produtos.get(0).getPreco(), dinheiros);
            if(somaTroco(troco)){
                txtMensagem.setText("Produto comprado.");
            }else{
                    txtMensagem.setText("Troco insuficiente");
                    txtTroco.setText(produtos.get(0).getPreco() + "");
            }        
        }
            
        txtTotal.setText("0.0");
        fnInicializaDados();
            
    }//GEN-LAST:event_btnAlimento1ActionPerformed

    private void btnAlimento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimento2ActionPerformed
        List<Double> troco = new ArrayList<>();
        int Status = 0;
        Status = cDinheiro.compra(Double.parseDouble(txtTotal.getText()),produtos.get(1));
            
        if(Status == 1)
            txtMensagem.setText("Quantidade esgotada");
        if(Status == 2)
            txtMensagem.setText("Dinheiro insuficiente");
            
        if(Status == 0){
            troco = cDinheiro.calculaTroco(Double.parseDouble(txtTotal.getText()),produtos.get(1).getPreco(), dinheiros);
            if(somaTroco(troco)){
                txtMensagem.setText("Produto comprado.");
            }else{
                    txtMensagem.setText("Troco insuficiente");
                    txtTroco.setText(produtos.get(1).getPreco() + "");
            }        
        }
            
        txtTotal.setText("0.0");
        fnInicializaDados();
        
    }//GEN-LAST:event_btnAlimento2ActionPerformed

    private void btnAlimento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimento3ActionPerformed
        List<Double> troco = new ArrayList<>();
        int Status = 0;
        Status = cDinheiro.compra(Double.parseDouble(txtTotal.getText()),produtos.get(2));
            
        if(Status == 1)
            txtMensagem.setText("Quantidade esgotada");
        if(Status == 2)
            txtMensagem.setText("Dinheiro insuficiente");
            
        if(Status == 0){
            troco = cDinheiro.calculaTroco(Double.parseDouble(txtTotal.getText()),produtos.get(2).getPreco(), dinheiros);
            if(somaTroco(troco)){
                txtMensagem.setText("Produto comprado.");
            }else{
                    txtMensagem.setText("Troco insuficiente");
                    txtTroco.setText(produtos.get(2).getPreco() + "");
            }        
        }
            
        txtTotal.setText("0.0");
        fnInicializaDados();
        
    }//GEN-LAST:event_btnAlimento3ActionPerformed

    private void btnAlimento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimento4ActionPerformed
        List<Double> troco = new ArrayList<>();
        int Status = 0;
        Status = cDinheiro.compra(Double.parseDouble(txtTotal.getText()),produtos.get(3));
            
        if(Status == 1)
            txtMensagem.setText("Quantidade esgotada");
        if(Status == 2)
            txtMensagem.setText("Dinheiro insuficiente");
            
        if(Status == 0){
            troco = cDinheiro.calculaTroco(Double.parseDouble(txtTotal.getText()),produtos.get(3).getPreco(), dinheiros);
            if(somaTroco(troco)){
                txtMensagem.setText("Produto comprado.");
            }else{
                    txtMensagem.setText("Troco insuficiente");
                    txtTroco.setText(produtos.get(3).getPreco() + "");
            }        
        }
            
        txtTotal.setText("0.0");
        fnInicializaDados();
        
    }//GEN-LAST:event_btnAlimento4ActionPerformed

    private void btn05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn05ActionPerformed
        // TODO add your handling code here:
        txtTotal.setText(String.valueOf(Double.parseDouble(txtTotal.getText()) + 0.5));
    }//GEN-LAST:event_btn05ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        txtTotal.setText(String.valueOf(Double.parseDouble(txtTotal.getText()) + 1));
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        txtTotal.setText(String.valueOf(Double.parseDouble(txtTotal.getText()) + 5));
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
        txtTotal.setText(String.valueOf(Double.parseDouble(txtTotal.getText()) + 10));
    }//GEN-LAST:event_btn10ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn05;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btnAlimento1;
    private javax.swing.JButton btnAlimento2;
    private javax.swing.JButton btnAlimento3;
    private javax.swing.JButton btnAlimento4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JLabel txtproduto1;
    private javax.swing.JLabel txtproduto2;
    private javax.swing.JLabel txtproduto3;
    private javax.swing.JLabel txtproduto4;
    // End of variables declaration//GEN-END:variables
}
