public enum Item
    {
    // Nome String do item e a descrição do item.
    OVO("Ovo", "um ovo de galinha"),
    CENOURA("Cenoura", "uma cenoura fresca"),
    CARNE_PODRE("Carne Podre", "Se você comer isso, você vai ficar doente com toda certeza!"),
    FLECHA("Flecha", "Use-a para atacar inimigos a distância."),
    BOMBA("Bomba", "Use-a para atacar vários inimigos de uma vez só."),
    DENTEDEVAMPIRO("Dente de Vampiro", "Um troféu que simboliza a vitória sobre um inimigo poderoso."),;
    
    // Atributos do item.
    private final String nome;
    private final String sprite;

    // Construtor do item.
    private Item(String nome, String sprite)
        {
        this.nome = nome;
        this.sprite = sprite;
        }
    }


