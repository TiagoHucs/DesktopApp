package controle;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
 


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ControleRelatorios {

    ConexaoDB conexao = new ConexaoDB();
    JFileChooser fileChoser;

		public void gerarRelatorio() {
			
			
			fileChoser = new JFileChooser(); 
			fileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChoser.setDialogTitle("Escolha o diretório de destino");
			fileChoser.showOpenDialog(null);
			File url = fileChoser.getCurrentDirectory();
			
			JOptionPane.showMessageDialog(null, "iniciando geração de relatório em "+url);

	        try {
	        	
				WritableWorkbook planilha = Workbook.createWorkbook(new File(
						"relatorio.xls"));
				// Adicionando o nome da aba
				WritableSheet aba = planilha.createSheet("ListaClientes", 0);
	 
				// Cabeçalhos
				String cabecalho[] = new String[6];
				cabecalho[0] = "Nome";
				cabecalho[1] = "CPF";
				cabecalho[2] = "Telefone";
				cabecalho[3] = "E-mail";
				cabecalho[4] = "Apolice";
				cabecalho[5] = "Vencimento";
				
				// Cor de fundo das celular
				Colour bckcolor = Colour.DARK_GREEN;
				WritableCellFormat cellFormat = new WritableCellFormat();
				cellFormat.setBackground(bckcolor);
	 
				// Cor e tipo de fonte
				WritableFont fonte = new WritableFont(WritableFont.ARIAL);
				fonte.setColour(Colour.GOLD);
				cellFormat.setFont(fonte);
	 
				// Escreva o cabeçalho no arquivo excel
				for (int i = 0; i < cabecalho.length; i++) {
					Label label = new Label(i, 0, cabecalho[i]);
					aba.addCell(label);
					WritableCell cell = aba.getWritableCell(i, 0);
					cell.setCellFormat(cellFormat);
				}
				
				// PEGANDO REGISTROS DO BANCO
				conexao.conectar();
				conexao.executaSql("select * from tb_clientes");
	            conexao.rs.first();

	            // Adicionando itens a planilha relatório
				for (int linha = 1; !conexao.rs.isAfterLast(); linha++) { 
 
					Label label = new Label(0, linha, conexao.rs.getString("nome"));
					aba.addCell(label);
					JOptionPane.showMessageDialog(null, "adicionando: "+conexao.rs.getString("nome"));
					
					label = new Label(1, linha, conexao.rs.getString("cpf"));
					aba.addCell(label);
	 
					label = new Label(2, linha, conexao.rs.getString("telefone"));
					aba.addCell(label);

					label = new Label(3, linha, conexao.rs.getString("email"));
					aba.addCell(label);

					label = new Label(4, linha, conexao.rs.getString("apolice"));
					aba.addCell(label);
					
					label = new Label(5, linha, conexao.rs.getString("vencimento"));
					aba.addCell(label);
					
					conexao.rs.next();

					/*// PARA ADICIONAR A DATA ATUAL
					Date data = Calendar.getInstance().getTime();
					DateFormat customDateFormat = new DateFormat(
							"dd MMM yyyy hh:mm:ss");
					WritableCellFormat dateFormat = new WritableCellFormat(
							customDateFormat);
					DateTime dateCell = new DateTime(4, linha, data, dateFormat);
					aba.addCell(dateCell);*/
				}
				
				//escreve arquivo excel
				planilha.write();
				// Fecha o arquivo
				planilha.close();
	           
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: "+ex);
	        }
	        conexao.desconectar();
			JOptionPane.showMessageDialog(null, "fim da geração de relatório.");
		}

		
}


