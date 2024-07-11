class Higiene extends Produto {
    @Override
    public float gerarPrecoDeVenda() {
        return (super.getPrecoCompra() + super.getPrecoCompra() * 30 / 100);
    }

    @Override
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(30);
    }
    
    @Override
    public String buscarRemedioPorNome(String nome) {
        return null; // Método não aplicável para produtos de Higiene
    }
}