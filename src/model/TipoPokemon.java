package model;

import java.util.List;

public enum TipoPokemon {
    FOGO("FOGO", List.of("PLANTA"), List.of("AGUA", "TERRA")),
    AGUA("AGUA", List.of("FOGO", "TERRA"), List.of("PLANTA", "ELETRICO")),
    PLANTA("PLANTA", List.of("AGUA", "TERRA"), List.of("FOGO", "VOADOR")),
    TERRA("TERRA", List.of("ELETRICO", "FOGO"), List.of("PLANTA", "AGUA")),
    ELETRICO("ELETRICO", List.of("AGUA", "VOADOR"), List.of("TERRA")),
    VOADOR("VOADOR", List.of("PLANTA"), List.of("ELETRICO"));

    private final String nomeFormatado;
    private final List<String> vantagens; // Dano x2
    private final List<String> fraquezas;


    TipoPokemon(String nomeFormatado, List<String> vantagens, List<String> fraquezas) {
        this.nomeFormatado = nomeFormatado;
        this.vantagens = vantagens;
        this.fraquezas = fraquezas;
    }
    public boolean temVantagemContra(TipoPokemon defensor){
        return vantagens.contains(defensor.name());
    }
    public boolean temFraquezaContra(TipoPokemon atacante) {
        return fraquezas.contains(atacante.name());
    }
}
