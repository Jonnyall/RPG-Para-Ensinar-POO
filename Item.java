
public enum Item
    {
    //Nome String do item, Sprite Assossiado.
    ITM_OVO("Ovo", "ovo.png"),
    ITM_CENOURA("Cenoura", "cenoura.png"),
    ITM_FLECHA("Flecha", "flecha.png"),
    ITM_DENTEDEVAMPIRO("Dente de Vampiro", "dente_de_vampiro.png");
    
    //Atributos do item.
    private final String nome;
    private final String sprite;

    //Construtor do item.
    private Item(String nome, String sprite)
        {
        this.nome = nome;
        this.sprite = sprite;
        }
    }


