package controle;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
 

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

public class ControleRelatorios2 {
	

		public void gerarRelatorio() {
			JOptionPane.showMessageDialog(null, "iniciando geração de relatório.");
			try {
				WritableWorkbook planilha = Workbook.createWorkbook(new File(
						"relatorio.xls"));
				// Adicionando o nome da aba
				WritableSheet aba = planilha.createSheet("ListaAlunos", 0);
	 
				// Cabeçalhos
				String cabecalho[] = new String[5];
				cabecalho[0] = "ID";
				cabecalho[1] = "Nome";
				cabecalho[2] = "Telefone";
				cabecalho[3] = "E-mail";
				cabecalho[4] = "Data Cadastro";
	 
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
	 
				for (int linha = 1; linha < 10; linha++) { // Número da linha
					Random numeroAleatorio = new Random();
	 
					Number number = new Number(0, linha,
							numeroAleatorio.nextInt(2000));
					aba.addCell(number);
	 
					Label label = new Label(1, linha, "Jose da Silva");
					aba.addCell(label);
	 
					label = new Label(2, linha, "2230-6625");
					aba.addCell(label);
	 
					label = new Label(3, linha, "josesilva@feltex.com.br");
					aba.addCell(label);
	 
					Date data = Calendar.getInstance().getTime();
					DateFormat customDateFormat = new DateFormat(
							"dd MMM yyyy hh:mm:ss");
					WritableCellFormat dateFormat = new WritableCellFormat(
							customDateFormat);
					DateTime dateCell = new DateTime(4, linha, data, dateFormat);
					aba.addCell(dateCell);
				}
	 
				planilha.write();
				// Fecha o arquivo
				planilha.close();
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "fim da geração de relatório.");
		}
	}


