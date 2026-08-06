public class Caverinha extends Inimigo
    {
    // Esta classe representa o inimigo Caverinha, que é um inimigo fraco e comum no jogo.

    // Construtor da classe.
    public Caverinha()
        {
        /*
        Ficha do Caverinha: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Caverinha
            Vida: 30
            Ataque: 5
            Defesa: 2
            Sorte: 10

            Itens que o Caverinha pode dropar ao ser derrotado:
                - Flecha (chance de 30%)
        */
       
        // Chamando o construtor da superclasse (Inimigo) para configurar os atributos do Caverinha.
        super("Caverinha", 30, 5, 2, 10, new Drops[]{new Drops(Item.FLECHA, 0.3)});
        }

    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Caverinha ao herói, considerando os atributos de ataque e defesa.

        // O inimigo Caverinha irá alternar entre atacar com sua adaga velha e atirar flechas.
        }
    }