package model;

public class ItemBase {

    protected String nome;
    protected int quantidade;
    protected double precoBase;

    public ItemBase(String nome, int quantidade, double precoBase) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
