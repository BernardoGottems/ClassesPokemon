    package factory;

    import model.PokemonBase;
    import model.TipoPokemon;
    import java.util.Random;

    public class GeradorDePokemons {

        public static PokemonBase gerarPokemon(TipoPokemon tipoDesejado, int nivel) {

            String[] nomes = null;
            int[] hpBase = null;
            int[] atqBase = null;

            switch (tipoDesejado) {
                case FOGO:
                    nomes = new String[]{"Charmander", "Vulpix", "Growlithe"};
                    hpBase = new int[]{39, 38, 55};
                    atqBase = new int[]{52, 41, 70};
                    break;
                case AGUA:
                    nomes = new String[]{"Squirtle", "Psyduck", "Poliwag"};
                    hpBase = new int[]{44, 50, 40};
                    atqBase = new int[]{48, 52, 50};
                    break;
                case PLANTA:
                    nomes = new String[]{"Bulbasaur", "Oddish", "Bellsprout"};
                    hpBase = new int[]{45, 45, 50};
                    atqBase = new int[]{49, 50, 75};
                    break;
                case TERRA:
                    nomes = new String[]{"Sandshrew","Digglet","Cubone"};
                    hpBase = new int[]{50, 10, 50};
                    atqBase = new int[]{75, 50, 55 };
                    break;
                case ELETRICO:
                    nomes = new String[]{"Pikachu","Magnemite","Voltorb"};
                    hpBase = new int[]{35, 25, 40};
                    atqBase = new int[]{55, 35, 30};
                    break;
                case VOADOR:
                    nomes = new String[]{"Pidgey","Spearow","Zubat"};
                    hpBase = new int[]{40, 40, 40};
                    atqBase = new int[]{45, 60, 45};
                    break;
                default:
                    throw new IllegalArgumentException("Erro: O tipo " + tipoDesejado + " ainda não foi cadastrado na Fábrica!");
            }

            Random random = new Random();
            int indice = random.nextInt(nomes.length);

            return new PokemonBase(
                    nomes[indice],
                    nivel,
                    tipoDesejado,
                    hpBase[indice],
                    atqBase[indice]
            );
        }
    }