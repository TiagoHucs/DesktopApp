package visao;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import controle.ControleRelatorios;

public class TelaPrincipal extends javax.swing.JFrame {
    
    public TelaPrincipal() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.jpg"));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblLogotipo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadastroCorretor = new javax.swing.JMenuItem();
        jMenuCadastroClientes = new javax.swing.JMenuItem();
        jMenuCadastroProdutos = new javax.swing.JMenuItem();
        jMenuConsulta = new javax.swing.JMenu();
        jMenuRelat = new javax.swing.JMenu();
        jMenuRelatGerar = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuItemSobreNos = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuSairEncerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADM - Hucs Corretora de Seguros");
        setResizable(false);
        getContentPane().setLayout(null);

        lblLogotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/hucsCorretora.PNG"))); // NOI18N
        getContentPane().add(lblLogotipo);
        lblLogotipo.setBounds(360, 160, 410, 190);

        jMenuCadastro.setText("Cadastro");

        jMenuCadastroCorretor.setText("Corretor");


        jMenuCadastroClientes.setText("Clientes");
        jMenuCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jMenuCadastroProdutos.setText("Produtos");
        jMenuConsulta.setText("Consultas");


        jMenuRelat.setText("Relatorios");
        jMenuRelat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatActionPerformed(evt);
            }
        });

        jMenuRelatGerar.setText("Gerar Relatório");
        jMenuRelatGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        


        jMenuSobre.setText("Sobre");
        jMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSobreActionPerformed(evt);
            }
        });

        jMenuItemSobreNos.setText("Sobre nÃ³s");
        jMenuItemSobreNos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreNosActionPerformed(evt);
            }
        });
        

        

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });

        jMenuSairEncerrar.setText("Encerrar programa");
        jMenuSairEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        
        // MONTANDO O MENU
        jMenuBar.add(jMenuCadastro);
	        jMenuCadastro.add(jMenuCadastroCorretor);        
	        jMenuCadastro.add(jMenuCadastroClientes);
	        jMenuCadastro.add(jMenuCadastroProdutos);
        jMenuBar.add(jMenuConsulta);
        jMenuBar.add(jMenuRelat);
        	jMenuRelat.add(jMenuRelatGerar);
        jMenuBar.add(jMenuSobre);
        	jMenuSobre.add(jMenuItemSobreNos);
        jMenuBar.add(jMenuSair);
        	jMenuSair.add(jMenuSairEncerrar);
        setJMenuBar(jMenuBar);

        setSize(new java.awt.Dimension(1143, 610));
        setLocationRelativeTo(null);
    }

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaClientes tela = new TelaClientes();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSobreActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "TESTE");
    }//GEN-LAST:event_jMenuSobreActionPerformed

    private void jMenuItemSobreNosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreNosActionPerformed
        // TODO add your handling code here:
        jFrameBV tela = new jFrameBV();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemSobreNosActionPerformed

    private void jMenuRelatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatActionPerformed


    }//GEN-LAST:event_jMenuRelatActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //JFrameRelatorios tela = new JFrameRelatorios();
        //tela.setVisible(true);
        
    	ControleRelatorios conRet = new ControleRelatorios();
    	conRet.gerarRelatorio();

    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLogotipo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConsulta;
    private javax.swing.JMenuItem jMenuCadastroCorretor;
    private javax.swing.JMenuItem jMenuCadastroClientes;
    private javax.swing.JMenuItem jMenuCadastroProdutos;
    private javax.swing.JMenuItem jMenuSairEncerrar;
    private javax.swing.JMenuItem jMenuRelatGerar;
    private javax.swing.JMenuItem jMenuItemSobreNos;
    private javax.swing.JMenu jMenuRelat;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuSobre;
    // End of variables declaration//GEN-END:variables
}
