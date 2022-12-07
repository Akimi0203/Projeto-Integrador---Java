import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Number;

import java.io.File;
import java.util.ArrayList;

import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CriarPlanilha {

    private String enderecoExcel = "H:/FPOO/saida.xlsx";

    public CriarPlanilha(String excel){
        this.enderecoExcel = excel;
    }

    public void gerarPlanilha(){
        //System.out.println("Inicio");

        ArrayList<Object> lista = new ArrayList<Object>();

        Usuario usuario1 = new Usuario(
                "André Souza",
                "98441-4545",
                "usuario@user.com"
        );
        Usuario usuario2 = new Usuario(
                "Bernado Campos",
                "98554-2231",
                "usuario2@user.com"
        );
        Usuario usuario3 = new Usuario(
                "Caetano Veloso",
                "98551-7474",
                "usuario3@user.com"
        );

        lista.add(usuario1);
        lista.add(usuario2);
        lista.add(usuario3);

        try {
            WritableWorkbook planilha = Workbook.createWorkbook(new File(
                    getEnderecoExcel()));
            // Adicionando o nome da aba
            WritableSheet aba = planilha.createSheet("ListaAlunos", 0);

            // Cabeçalhos
            String cabecalho[] = new String[5];
            cabecalho[0] = "ID";
            cabecalho[1] = "NOME";
            cabecalho[2] = "TELEFONE";
            cabecalho[3] = "EMAIL";
            cabecalho[4] = "DATA DO CADASTRO";

            // Cor de fundo das celular
            Colour bckcolor = Colour.DARK_GREEN;
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setBackground(bckcolor);

            // Cor e tipo de fonte
            WritableFont fonte = new WritableFont(WritableFont.ARIAL);
            fonte.setColour(Colour.GOLD);
            cellFormat.setFont(fonte);

            // Write the Header to the Excel file
            for (int i = 0; i < cabecalho.length; i++) {
                Label label = new Label(i, 0, cabecalho[i]);
                aba.addCell(label);
                WritableCell cell = aba.getWritableCell(i, 0);
                cell.setCellFormat(cellFormat);
            }

            for (int linha = 0; linha < lista.size(); linha++) { // Número da linha

                Usuario usuario = (Usuario) lista.get(linha);

                jxl.write.Number number = new Number(0, linha, Double.parseDouble(usuario.getId()));

                aba.addCell(number);

                Label label = new Label(1, linha, usuario.getNome());
                aba.addCell(label);

                label = new Label(2, linha, usuario.getTelefone());
                aba.addCell(label);

                label = new Label(3, linha, usuario.getEmail());
                aba.addCell(label);

                DateFormat customDateFormat = new DateFormat(
                        "dd MMM yyyy hh:mm:ss");
                WritableCellFormat dateFormat = new WritableCellFormat(
                        customDateFormat);
                DateTime dateCell = new DateTime(4, linha, usuario.getDataCadastro(), dateFormat);

                aba.addCell(dateCell);
            }

            planilha.write();
            // Fecha o arquivo
            planilha.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fim");
    }

    public String getEnderecoExcel() {
        return enderecoExcel;
    }
}

