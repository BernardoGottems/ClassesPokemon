package model;

public class Pocao extends ItemBase{

    private int pontosDeCura;

    public Pocao(String nome, int quantidade, double precoBase, int pontosDeCura) {
        super(nome, quantidade, precoBase);
        this.pontosDeCura = pontosDeCura;
    }

    public int getPontosDeCura() {
        return pontosDeCura;
    }
}

