/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosbd;

import DAL.Conectabd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**

/**
 *
 * @author Lucas
 */
public class InterDelete extends javax.swing.JInternalFrame {

    Connection conecta = null;
    PreparedStatement pst;
    ResultSet rs;
    
    public InterDelete(String nome, String senha) throws SQLException, ClassNotFoundException {
        initComponents();
        
        if (conecta != null){
            conecta.close();
        }
        
            conecta = Conectabd.Conectabd(nome, senha);
        
    }
    
    public void DeletaBanda(){
        String sql = "delete from Banda where nome = ?";
        
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, NomeBanda.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Banda Removida Com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(InterDelete.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro!");
        }
    }
    
    public void DeletaArtista(){
        String sql = "delete from Artista where nome = ?";
        
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, NomeArtista.getText());
            
            pst.execute();
            
             JOptionPane.showMessageDialog(null,"Artista Removido Com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(InterDelete.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro!");
        }
            
    }
    
    public void RemoveArtistaBanda(){
        String sql = "delete from toca_em where artista = ? and banda = (select cod from banda where nome = ?)";
        
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, ABArtista.getText());
            pst.setString(2, ABBanda.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Artista Removido da Banda Com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(InterDelete.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro!");
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

        jLabel1 = new javax.swing.JLabel();
        NomeBanda = new javax.swing.JTextField();
        DeletaBanda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        NomeArtista = new javax.swing.JTextField();
        DeletaArtista = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ABArtista = new javax.swing.JTextField();
        ABBanda = new javax.swing.JTextField();
        DeletaAB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 15)); // NOI18N
        jLabel1.setText("Digite o nome da banda para deletar:");

        NomeBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeBandaActionPerformed(evt);
            }
        });

        DeletaBanda.setText("Deletar");
        DeletaBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletaBandaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 15)); // NOI18N
        jLabel2.setText("Digite o nome do artista para deletar:");

        DeletaArtista.setText("Deletar");
        DeletaArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletaArtistaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 15)); // NOI18N
        jLabel3.setText("Remover um artista de uma banda:");

        ABArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABArtistaActionPerformed(evt);
            }
        });

        ABBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABBandaActionPerformed(evt);
            }
        });

        DeletaAB.setText("Deletar");
        DeletaAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletaABActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome do Artista:");

        jLabel5.setText("Nome da Banda:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rock-in-rio.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomeBanda, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeletaBanda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DeletaArtista, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ABArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ABBanda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(DeletaAB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeletaBanda))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NomeArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeletaArtista))
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ABArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DeletaAB)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeBandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeBandaActionPerformed

    private void DeletaBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletaBandaActionPerformed
            DeletaBanda();
    }//GEN-LAST:event_DeletaBandaActionPerformed

    private void ABBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABBandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ABBandaActionPerformed

    private void ABArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ABArtistaActionPerformed

    private void DeletaABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletaABActionPerformed
          RemoveArtistaBanda();
    }//GEN-LAST:event_DeletaABActionPerformed

    private void DeletaArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletaArtistaActionPerformed
        DeletaArtista();
    }//GEN-LAST:event_DeletaArtistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ABArtista;
    private javax.swing.JTextField ABBanda;
    private javax.swing.JButton DeletaAB;
    private javax.swing.JButton DeletaArtista;
    private javax.swing.JButton DeletaBanda;
    private javax.swing.JTextField NomeArtista;
    private javax.swing.JTextField NomeBanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
