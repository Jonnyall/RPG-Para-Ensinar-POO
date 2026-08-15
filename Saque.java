public class Saque extends TodasAsCoisas
    {
    // Esta classe representa os drops que os inimigos podem soltar ao serem derrotados.

    // Atributos da classe.

    // O item que é dropado.
    private Item item;

    // A chance de dropar o item, em %.
    private float chance;

    // Construtor da classe.
    public Saque(Item item, float chance)
        {
        this.item = item;
        this.chance = chance;
        }

    // Métodos da classe.

    // Método para sortear o drop do item, com base na chance de dropar.
    public Item sortearSaque()
        {
        // Gerando um número aleatório entre 0 e 100.
        int numero_aleatorio = (int) (Math.random() *100);
        
        // Verificando se o número aleatório é menor ou igual à chance de dropar.
        if (numero_aleatorio <= this.chance)
            {
            return (this.item); // O item será dropado.
            }
        else
            {
            return (null); // O item não será dropado.
            }
        }
    }