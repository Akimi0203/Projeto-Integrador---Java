import jxl.read.biff.BiffException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bot {
    private String nome = "Marinette";
    private String senha = "akimexx";
    private String descricao = "Bot criado para auxiliar os usuarios"+
                                " para pesquisar informações do ecommerce";

    private String enderecoExcel = "H:/FPOO/ProjetoIntegrador.xls";

    LerEscreverExcel teste = new LerEscreverExcel(enderecoExcel);

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void botOpcoes() {
        System.out.println("Oi, eu sou a "+this.nome);
        System.out.println("Eu sou o "+this.descricao);
        System.out.println("Olá, bem-vindo ao Marinatta Espetaria e Rotisseria :), \n" +
                " Como está sua fome hoje?, Eu sou um robô em fase de desenvolvimento \n" +
                "e posso te ajudar a fazer seu pedido. Aqui estão as opções aonde posso\n" +
                " ajudar você!");
        System.out.println("1 - Você gostaria de ver o cardapio?");
        System.out.println("2 - Gostaria de saber o que compõe cada prato?");
        System.out.println("3 - Quer saber quantas pessoas pode consumir esse prato delicioso com você?");
        System.out.println("4 - Vamos para o fechamento, quer saber o valor do seu prato?");
        System.out.println("5 - Ver todos os dados de um usuario cadastrado");
        System.out.println("6 - Mostar senha");
        System.out.println("Digite a opcao desejada:");
    }

    public void executarBot(int opcao) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        teste.lerExcel();

        switch (opcao) {
            case 1:
                System.out.println("Cardápio:");
                for (int x = 0; x <= teste.getAs1().length - 1; x++) {
                    System.out.println(Arrays.asList(teste.getAs1()).get(x));
                }
                break;
            case 2:
                System.out.println("Descrição dos produtos:");
                for (int x = 0; x <= teste.getAs3().length - 1; x++) {
                    System.out.println(Arrays.asList(teste.getAs3()).get(x));
                }
                break;
            case 3:
                System.out.println("Qntd dos Pratos:");
                for (int x = 0; x <= teste.getAs4().length - 1; x++) {
                    System.out.println(Arrays.asList(teste.getAs4()).get(x));
                }
                break;
            case 4:
                System.out.println("Valor dos Pratos:");
                for (int x = 0; x <= teste.getAs5().length - 1; x++) {
                    System.out.println(Arrays.asList(teste.getAs5()).get(x));
                }
                break;
            case 5:
                boolean flag = false;
                System.out.println("Digite o código do Prato:");
                String codigo = sc.next();
                String[] codigos = teste.getAs1();
                String[] nomes = teste.getAs2();
                String[] telefones = teste.getAs3();
                String[] emails = teste.getAs4();
                String[] datas = teste.getAs5();
                for (int x = 0; x < Arrays.asList(codigos).size(); x++) {
                    if(Arrays.asList(codigos).get(x).equals(codigo)){
                        System.out.println("Todos os dados de um usuario cadastrado");
                        System.out.println("Código: "+ Arrays.asList(codigos).get(x));
                        System.out.println("Nome do Prato: "+Arrays.asList(nomes).get(x));
                        System.out.println("Descrição: "+Arrays.asList(telefones).get(x));
                        System.out.println("Porção do Prato: "+Arrays.asList(emails).get(x));
                        System.out.println("Preço: "+Arrays.asList(datas).get(x));
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("Usuario não encontrado!");
                }
                break;
            case 6:
                System.out.println("A senha é "+this.senha);
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        System.out.println("Desejar escolher outra opcao?S ou N");

    }
}
