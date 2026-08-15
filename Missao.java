import java.util.HashMap;
import java.util.Map;

public enum Missao
    {
    // Criando as missões do jogo.

    // Missão coletar 10 ovos.
    COLETAR_OVOS(
        "Coletar Ovos",
        "Coletar 10 ovos para o fazendeiro.",
        new HashMap<Item, Integer>() {{ put(Item.OVO, 10); }},
        new Item[] {}
    );


    // Nome da missão.
    private final String nome;

    // Descrição da missão.
    private final String descricao;

    // Requisitos da missão.
    private final Map<Item, Integer> requisitos;

	// Recompensa da missão.
    private final Item[] recompensas;

    // Construtor da missão.
    private Missao(String nome, String descricao, Map<Item, Integer> requisitos, Item[] recompensas)
        {
        this.nome = nome;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.recompensas = recompensas;
        }
    }