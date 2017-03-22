
package controle;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import controle.Util;

import javax.swing.JOptionPane;

import modelo.ModeloCliente;


public class ControleCliente {
    
    ConexaoDB conexao = new ConexaoDB();
    ModeloCliente modcli = new ModeloCliente();
    Util u = new Util();
    
    public void Salvar(ModeloCliente modcli) {
       conexao.conectar();
     
        try {
            PreparedStatement pst = conexao.con.prepareStatement("insert into tb_clientes(nome,cpf,telefone,email,apolice,vencimento) values(?,?,?,?,?,?);");
            pst.setString(1,modcli.getNome());
            pst.setString(2,modcli.getCpf());
            pst.setString(3,modcli.getTelefone());
            pst.setString(4,modcli.getEmail());
            pst.setString(5,modcli.getApolice());
            pst.setDate(6, u.stringToDateSql(modcli.getVencimento()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n"+ex.getMessage());
        }
       
       conexao.desconectar();
    }
    
    public void SalvarSemApolice(ModeloCliente modcli) {
        conexao.conectar();
      
         try {
             PreparedStatement pst = conexao.con.prepareStatement("insert into tb_clientes(nome,cpf,telefone,email) values(?,?,?,?);");
             pst.setString(1,modcli.getNome());
             pst.setString(2,modcli.getCpf());
             pst.setString(3,modcli.getTelefone());
             pst.setString(4,modcli.getEmail());
             pst.execute();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir:\n"+ex.getMessage());
         }
        
        conexao.desconectar();
     }
    
    public void Atualizar(ModeloCliente modcli,String nome) {
        conexao.conectar();
      
         try {
             PreparedStatement pst = conexao.con.prepareStatement("update tb_clientes set nome=?,cpf=?,telefone=?,email=?,apolice=?,vencimento=? where nome = '"+nome+"';");       
             pst.setString(1,modcli.getNome());
             pst.setString(2,modcli.getCpf());
             pst.setString(3,modcli.getTelefone());
             pst.setString(4,modcli.getEmail());
             pst.setString(5,modcli.getApolice());
             pst.setDate(6, u.stringToDateSql(modcli.getVencimento()));
             pst.execute();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir:\n"+ex.getMessage());
         }
        
        conexao.desconectar();
     }
    
}
