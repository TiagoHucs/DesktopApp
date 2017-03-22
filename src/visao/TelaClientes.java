/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConexaoDB;
import controle.ControleCliente;
import controle.Util;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import modelo.ModeloCliente;
import modelo.ModeloTabela;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

        
public class TelaClientes extends javax.swing.JFrame {

    ModeloCliente modcli = new ModeloCliente();
    ConexaoDB conexao = new ConexaoDB();
    ControleCliente control = new ControleCliente();
    Util u = new Util();
    private JButton btnEditar;
    private JButton btnNovo;
    private JButton btnApagar;
    private JButton btnSalvar;
    private JLabel lblCpf;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private JFormattedTextField txtTel;
    private JLabel lblApolice;
    private JLabel lblPlaca;
    private JFormattedTextField txtVencimento;
    private JFormattedTextField txtPlaca;
    private JLabel lblVencimento;
    private JTextField txtApolice;
    private MaskFormatter DataMask;
    private MaskFormatter CpfMask;
    private MaskFormatter TelMask;
    private MaskFormatter PlacaMask;

    
    
    // AO ABRIR A TELA CLIENTES
    public TelaClientes() {
        initComponents();
        setTitle("Clientes");
        preencherTabela("select * from tb_clientes");
    }

    // INICIANDO OS COMPONENTES
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	// CRIANDO A MASCARAS DA DATA CPF E TELEFONE
    	try {
			DataMask = new MaskFormatter("##/##/####");
			CpfMask = new MaskFormatter("###.###.###-##");
			TelMask = new MaskFormatter("(##) # ####-####");
			PlacaMask = new MaskFormatter("UUU-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	// INSTANCIANDO OS OBJETOS 
        btnNovo = new JButton();
        btnEditar = new JButton();
        btnApagar = new JButton();
        btnSalvar = new JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        lblCpf = new JLabel();
        lblNome = new JLabel();
        lblEmail = new JLabel();
        lblTelefone = new JLabel();
        txtNome = new JTextField();
        txtCpf = new JFormattedTextField();
        txtTel = new JFormattedTextField();
        txtEmail = new JTextField();
        lblApolice = new JLabel();
        txtVencimento = new JFormattedTextField();
        txtApolice = new JTextField();
        lblVencimento = new JLabel();
        txtPlaca = new JFormattedTextField();
        lblPlaca = new JLabel();
        
        

        // SETANDO caracteristicas 
        btnSalvar.setText("Salvar");
        btnNovo.setText("Novo");
        btnEditar.setText("Editar");
        lblCpf.setText("CPF:");
        lblNome.setText("Nome:");
        lblEmail.setText("E-mail:");
        lblTelefone.setText("Telefone:");
        lblApolice.setText("Apolice:");
        lblVencimento.setText("Vencimento:");
        btnApagar.setText("Apagar");
        lblPlaca.setText("Placa:");
        txtNome.setDisabledTextColor(Color.BLACK);
        txtCpf.setDisabledTextColor(Color.BLACK);
        txtTel.setDisabledTextColor(Color.BLACK);
        txtEmail.setDisabledTextColor(Color.BLACK);
        txtApolice.setDisabledTextColor(Color.BLACK);
        txtVencimento.setDisabledTextColor(Color.BLACK);
        txtPlaca.setDisabledTextColor(Color.BLACK);

        desabilitarCampos();
        
        // SETANDO MASCARA DOS CAMPOS FORMATADOS
        txtVencimento.setFormatterFactory(new DefaultFormatterFactory(DataMask));
        txtCpf.setFormatterFactory(new DefaultFormatterFactory(CpfMask));
        txtTel.setFormatterFactory(new DefaultFormatterFactory(TelMask));
        txtPlaca.setFormatterFactory(new DefaultFormatterFactory(PlacaMask));
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        // LISTENERS
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnNovoActionPerformed(evt);
            }
        });
        
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        
        btnApagar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		btnApagarActionPerformed(evt);
        	}
        });
        
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        jScrollPane1.setViewportView(jTableClientes);
        
        
        



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        						.addComponent(lblCpf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblTelefone, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        					.addGap(4)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtEmail)
        						.addComponent(txtTel, Alignment.TRAILING)
        						.addComponent(txtCpf)
        						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblPlaca, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblVencimento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        						.addComponent(lblApolice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(txtApolice)
        							.addComponent(txtVencimento, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnNovo)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnEditar)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNovo)
        				.addComponent(btnSalvar)
        				.addComponent(btnEditar)
        				.addComponent(btnApagar))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblApolice, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtApolice, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblVencimento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtVencimento, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	if(!txtNome.getText().isEmpty()){
            modcli.setNome(txtNome.getText());
            modcli.setCpf(txtCpf.getText());
            modcli.setTelefone(txtTel.getText());
            modcli.setEmail(txtEmail.getText());
	            if(!txtApolice.getText().isEmpty()){
	            modcli.setApolice(txtApolice.getText());
	            modcli.setVencimento(txtVencimento.getText());
	            control.Salvar(modcli);
	            }else{
	            	control.SalvarSemApolice(modcli);
	            }
            limpaCampos();
            desabilitarCampos();
            preencherTabela("select * from tb_clientes");
            btnSalvar.setEnabled(false);
    	}else{
    		JOptionPane.showMessageDialog(txtNome, "Nome do Cliente não preenchido!");
    	}
    }

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {
    	desabilitarCampos();
        String nome_clicado = ""+jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        conexao.conectar();
        conexao.executaSql("select * from tb_clientes where nome = '"+nome_clicado+"';");
        try {
            conexao.rs.first();
            txtNome.setText((conexao.rs.getString("nome")));
            txtCpf.setText((conexao.rs.getString("cpf")));
            txtTel.setText((conexao.rs.getString("telefone")));
            txtEmail.setText((conexao.rs.getString("email")));
            txtApolice.setText((conexao.rs.getString("apolice")));
            String txtData;
            Date data = null;
            data = conexao.rs.getDate("vencimento");
            txtData = u.dateSqlToString(data);      
            txtVencimento.setText(txtData);
        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao buscar dados\n"+ex);
            }
        conexao.desconectar();
		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(true);
		btnApagar.setEnabled(true);
    }
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
    	limpaCampos();
    	habilitarCampos();
    	btnEditar.setEnabled(false);
    	btnApagar.setEnabled(false);
    	btnSalvar.setEnabled(true);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    	habilitarCampos();
    	btnSalvar.setEnabled(true);
    }
    
    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {
    	desabilitarCampos();
        String nome_clicado = ""+jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        conexao.conectar();

        int response = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o cliente "+nome_clicado+"?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
            	try {
	            	conexao.executaSql("delete from tb_clientes where nome = '"+nome_clicado+"';");
	            	preencherTabela("select * from tb_clientes;");
	            	limpaCampos();
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "erro ao deletar dados\n"+ex);
		            }
            } else if (response == JOptionPane.NO_OPTION) {
            } else if (response == JOptionPane.CLOSED_OPTION) {
            };
        
        
        		preencherTabela("select * from tb_clientes;");

        conexao.desconectar();
    }

    private void habilitarCampos() {
		txtNome.setEnabled(true);
		txtCpf.setEnabled(true);
		txtTel.setEnabled(true);
		txtEmail.setEnabled(true);
		txtApolice.setEnabled(true);
		txtVencimento.setEnabled(true);
		txtPlaca.setEnabled(true);

	}
    
    private void desabilitarCampos() {
		txtNome.setEnabled(false);
		txtCpf.setEnabled(false);
		txtTel.setEnabled(false);
		txtEmail.setEnabled(false);
		txtApolice.setEnabled(false);
		txtVencimento.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnApagar.setEnabled(false);
		txtPlaca.setEnabled(false);
	}
    
    private void limpaCampos(){
        txtNome.setText("");
        txtCpf.setText("");
        txtTel.setText("");
        txtEmail.setText("");
        txtApolice.setText("");
        txtVencimento.setText("");
    }
    
    public void preencherTabela(String sql){
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"nome","cpf","telefone","email"};
        conexao.conectar();
        conexao.executaSql(sql);
        
        try {
           conexao.rs.first();
           do{
             dados.add(new Object[]{conexao.rs.getString("nome"),
                                    conexao.rs.getString("cpf"),
                                    conexao.rs.getString("telefone"),
                                    conexao.rs.getString("email")});
            
           }while (conexao.rs.next()); 
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableClientes.setModel(modelo);
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(300);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conexao.desconectar();
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
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientes().setVisible(true);
            }
        });
    }
}
