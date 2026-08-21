package src;

public enum Item
    {
    // Nome String do item e a descrição do item.
    OVO("Ovo", "um ovo de galinha"),
    CENOURA("Cenoura", "uma cenoura fresca"),
    CARNE_PODRE("Carne Podre", "Se você comer isso, você vai ficar doente com toda certeza!"),
    POCAO_DE_CURACAO("Poção de Cura", "Use-a para recuperar sua vida."),
    FLECHA("Flecha", "Use-a para atacar inimigos a distância."),
    BOMBA("Bomba", "Use-a para atacar vários inimigos de uma vez só."),
    DENTEDEVAMPIRO("Dente de Vampiro", "Um troféu que simboliza a vitória sobre um inimigo poderoso."),;
    
    // Atributos do item.
    private final String nome;
    private final String descricao;

    // Construtor do item.
    private Item(String nome, String descricao)
        {
        this.nome = nome;
        this.descricao = descricao;
        }

    // Métodos de obtenção (getters).
    public String obterNome()
        {
        return (nome);
        }

    public String obterDescricao()
        {
        return (descricao);
        }
    }


