import javax.swing.JOptionPane;


public class ControleDaFarmacia {
    public static void main(String[] args){
        Produto[] produto = new Produto[15];
        int opcao, contador = 0;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    if (contador == produto.length)
                        JOptionPane.showMessageDialog(null, 
                        "Vetor completamente preenchido");
                    else
                        contador = cadastrarProduto(produto, contador);
                    break;
                case 2:
                    if (contador == 0)
                        JOptionPane.showMessageDialog(null, 
                    "Nenhum produto cadastrado");
                    else
                        mostrarMaisCaro(produto, contador);
                    break;
                case 3:
                    if (contador == 0)
                        JOptionPane.showMessageDialog(null, 
                    "Nenhum produto cadastrado");  
                    else
                        mostrarProdutosEmEstoque(produto, contador);
                    break;    
                case 4: 
                    if (contador == 0)
                        JOptionPane.showMessageDialog(null, 
                    "Nenhum produto cadastrado");  
                    else
                        alterarDadosDeUmProduto(produto, contador);
                    break;
                case 5:
                    if (contador == 0)
                        JOptionPane.showMessageDialog(null, 
                    "Nenhum produto cadastrado");
                    else
                        buscarRemedioPorNome(produto, contador);
                    break;
            }
        } while (opcao != 6);
    }

    
    public static int menu() {
        String mensagem = "1 - Cadastrar produto\n";
        mensagem += "2 - Mostrar detalhes do produto mais caro\n";
        mensagem += "3 - Mostrar produtos em estoque\n";
        mensagem += "4 - Alterar dados de produto\n";
        mensagem += "5 - Buscar remédio por nome\n";
        mensagem += "6 - Finalizar programa";
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    
    public static int cadastrarProduto(Produto[] p, int c) {
        int tipo;
        do {
            tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "1 - para cadastrar Remédio ou 2 - para cadastrar produtos de Higiene"));
        } while (tipo != 1 && tipo != 2);

        if (tipo == 1) {
            Remedio auxiliar = new Remedio();
            auxiliar.setCodigo(c + 1);
            auxiliar.setDescricao(JOptionPane.showInputDialog(
                "Digite a descrição do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog(
                "Digite o preço de compra"
            )));
            auxiliar.definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Preço de Venda = " + auxiliar.gerarPrecoDeVenda());
            p[c] = auxiliar;
        }

        if (tipo == 2) {
            Higiene auxiliar = new Higiene();
            auxiliar.setCodigo(c + 1);
            auxiliar.setDescricao(JOptionPane.showInputDialog(
                "Digite a descrição do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog(
                "Digite o preço de compra"
            )));
            auxiliar.definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Preço de Venda = " + auxiliar.gerarPrecoDeVenda());
            p[c] = auxiliar;
        }
        c++;
        return c;
    }
        
    
    public static void alterarDadosDeUmProduto(Produto[] p, int c) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
            "Digite o código do produto a ter seus dados alterados"));
        if (codigo < 1 || codigo - 1 >= c) 
            JOptionPane.showMessageDialog(null, "Produto Inexistente!");
        else {
            p[codigo-1].setDescricao(JOptionPane.showInputDialog(
                "Digite a nova descrição"));
            p[codigo-1].setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog(
                "Digite o novo preço de compra")));
            p[codigo-1].definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Novo lucro = "+p[codigo-1].gerarPrecoDeVenda());
        }
    }

    
    public static void mostrarProdutosEmEstoque(Produto[] p, int c) {
        String msg = "";
        for (int cont = 0; cont < c; cont++) {
            msg += "\nCódigo: " + p[cont].getCodigo();
            msg += "\nDescrição: " + p[cont].getDescricao();
            msg += "\nPreço de compra: " + p[cont].getPrecoCompra();
            msg += "\n% lucro: " + p[cont].getPercentualDeLucro();
            msg += "\nPreço de venda: " + p[cont].gerarPrecoDeVenda();
            JOptionPane.showMessageDialog(null, msg);
            msg = "";
        }
    }

    
    public static void mostrarMaisCaro(Produto[] p, int c) {
        float maiorPreco = p[0].getPrecoCompra();
        int indiceDoMaior = 0;
        String msg = "";
        for (int cont = 1; cont < c; cont++) {
            if (p[cont].getPrecoCompra() > maiorPreco) {
                maiorPreco = p[cont].getPrecoCompra();
                indiceDoMaior = cont;
            }
        }
        msg += "Código: " + p[indiceDoMaior].getCodigo();
        msg += "\nDescrição: " + p[indiceDoMaior].getDescricao();
        msg += "\nPreço de compra: " + p[indiceDoMaior].getPrecoCompra();
        msg += "\n% lucro: " + p[indiceDoMaior].getPercentualDeLucro();
        msg += "\nPreço de venda: " + p[indiceDoMaior].gerarPrecoDeVenda();
        JOptionPane.showMessageDialog(null, msg);
    }

    
    public static void buscarRemedioPorNome(Produto[] produtos, int contador) {
        String nome = JOptionPane.showInputDialog("Digite o nome do remédio");
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (produtos[i] instanceof Remedio) {
                String resultado = ((Remedio) produtos[i]).buscarRemedioPorNome(nome);
                if (resultado != null) {
                    JOptionPane.showMessageDialog(null, resultado);
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Remédio não encontrado");
        }
    }
    public static void gerarRelatorioDetalhado(Produto[] produtos, int contador) {
        StringBuilder relatorio = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            relatorio.append("\nCódigo: ").append(produtos[i].getCodigo());
            relatorio.append("\nDescrição: ").append(produtos[i].getDescricao());
            relatorio.append("\nPreço de compra: ").append(produtos[i].getPrecoCompra());
            relatorio.append("\n% Lucro: ").append(produtos[i].getPercentualDeLucro());
            relatorio.append("\nPreço de venda: ").append(produtos[i].gerarPrecoDeVenda());
            if (produtos[i] instanceof Remedio) {
                relatorio.append("\nTipo: Remédio");
            } else if (produtos[i] instanceof Higiene) {
                relatorio.append("\nTipo: Higiene");
            }
        }
        JOptionPane.showMessageDialog(null, relatorio.toString(), "Relatório Detalhado", JOptionPane.INFORMATION_MESSAGE);
    }
}








