package visao;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import controle.ConexaoDB;

public class TelaLogin extends javax.swing.JFrame {
	
    // Variaveis
    private javax.swing.JButton btSair;
    private javax.swing.JButton btAcessar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblFundoLogo;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUsuario;
    // Variaveis

    public TelaLogin(){
	
    	setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.jpg"));
        iniciaComponentes();
        
    }

    public void iniciaBanco(){
    	ConexaoDB banco = new ConexaoDB();
		banco.iniciaServidor();
		
		//cria as tabelas se nao existirem
		banco.preparaTabelas();
    }
  
   
    @SuppressWarnings("unchecked")
    private void iniciaComponentes() {

        lblSenha = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        btSair = new javax.swing.JButton();
        btAcessar = new javax.swing.JButton();
        lblFundoLogo = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(120, 210, 60, 20);

        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(120, 170, 60, 20);

        tfUsuario.setText("usuario");
        getContentPane().add(tfUsuario);
        tfUsuario.setBounds(170, 170, 160, 30);

        tfSenha.setText("12345");
        getContentPane().add(tfSenha);
        tfSenha.setBounds(170, 210, 160, 30);

        btSair.setText("Sair");
        getContentPane().add(btSair);
        btSair.setBounds(270, 250, 51, 23);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acaoBtSair(evt);
            }
        });

        btAcessar.setText("Acessar");
        btAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acaoBtAcessar(evt);
            }
        });
        getContentPane().add(btAcessar);
        btAcessar.setBounds(170, 250, 90, 23);

        lblFundoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/hucsCorretora.PNG"))); // NOI18N
        getContentPane().add(lblFundoLogo);
        lblFundoLogo.setBounds(30, 30, 440, 100);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 490, 330);

        setSize(new java.awt.Dimension(477, 341));
        setLocationRelativeTo(null);
    }

    
    private void acaoBtAcessar(java.awt.event.ActionEvent evt) {
    	iniciaBanco();
        if((tfUsuario.getText().equals("usuario"))&&(tfSenha.getText().equals("12345"))){
        //if(tfUsuario.getText().equals("usuario")){    
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
            dispose();
        }else{
                JOptionPane.showMessageDialog(null, "Usuario ou senha invalido!");
        }
    }
    
   
    private void acaoBtSair(java.awt.event.ActionEvent evt) {
    	System.exit(0);
    }

    // CLASSE MAIN
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }


}
