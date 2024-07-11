import javax.swing.JOptionPane;

class Remedio extends Produto {
    @Override
    public float gerarPrecoDeVenda() {
        return (super.getPrecoCompra() + 
        super.getPrecoCompra() * super.getPercentualDeLucro() / 100);
    }

    @Override
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(Float.parseFloat(JOptionPane.showInputDialog(
        "Digite o percentual de lucro do produto")));
    }

    @Override
    public String buscarRemedioPorNome(String nome) {
        if (this.getDescricao().equalsIgnoreCase(nome)) {
            return "Nome: " + this.getDescricao() + "\nCódigo: " + this.getCodigo() +
                   "\nPreço de compra: " + this.getPrecoCompra() + 
                   "\n% Lucro: " + this.getPercentualDeLucro() + 
                   "\nPreço de venda: " + this.gerarPrecoDeVenda();
        }
        return null;
    }
}