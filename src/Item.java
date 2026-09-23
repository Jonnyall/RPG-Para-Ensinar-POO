package src;

public enum Item
    {
    // Nome String do item e a descrição do item.
    OVO("Ovo", "um ovo de galinha"),
    CENOURA("Cenoura", "uma cenoura fresca"),
    CARNE_PODRE("Carne Podre", "Se você comer isso, você vai ficar doente com toda certeza!"),
    POCAO_DE_CURA("Poção de Cura", "Use-a para recuperar sua vida."),
    FLECHA("Flecha", "Use-a para atacar inimigos a distância."),
    BOMBA("Bomba", "Use-a para atacar vários inimigos de uma vez só."),
    
    // Troféus de inimigos derrotados.
    GELECA_DE_SLIME("Geleca de Slime", "Uma gosma viscosa que antes pertencia ao corpo de um slime."),
    DENTEDEVAMPIRO("Dente de Vampiro", "Um troféu que simboliza a vitória sobre um inimigo poderoso."),
    
    // Chaves.
    CHAVE_PARA_OS_FUNDOS("Chave para os Fundos", "Uma chave que abre a porta para os fundos da taberna e ir para a floresta."),
    
    
    //Apenas finalizando a enumeração com um ponto e vírgula.
    ;
    
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


