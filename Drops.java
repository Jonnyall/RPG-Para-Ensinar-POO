public class Drops extends TodasAsCoisas
    {
    // Esta classe representa os drops que os inimigos podem soltar ao serem derrotados.

    // Atributos da classe.

    // O item que é dropado.
    private Item item;

    // A chance de dropar o item, em %.
    private boolean chance;

    // Construtor da classe.
    public Drops(Item item, boolean chance)
        {
        this.item = item;
        this.chance = chance;
        }
    }