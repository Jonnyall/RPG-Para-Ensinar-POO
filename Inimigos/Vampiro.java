public class Vampiro extends Inimigo
    {
    // Esta classe representa o inimigo Vampiro, que é um inimigo poderoso e raro no jogo.

    // Atributos do Vampiro.

    // O Vampiro pode se transformar em morcego, o que lhe permite ficar mais dificil de ser atingido (A sua sorte é aumentada durante esse estado).
    boolean forma_de_morsego = false;

    // Construtor da classe.
    public Vampiro()
        {
        /*
        Ficha do Vampiro: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Vampiro
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5

            Itens que o Vampiro pode dropar ao ser derrotado:
                - Dente de Vampiro (chance de 100%)
        */
       
        // Chamando o construtor da superclasse (Inimigo) para configurar os atributos do Vampiro.
        super("Vampiro", 100, 20, 10, 5, new Drops[]{new Drops(Item.DENTEDEVAMPIRO, 1.0)});
        }

    // Metodo do Vampiro.

    // O Vampiro pode se transformar em morcego, o que lhe permite ficar mais dificil de ser atingido (A sua sorte é aumentada durante esse estado).
    public void alternarEmFormaDeMorcego()
        {
        // Aqui poderia ser implementada a lógica para transformar o Vampiro em morcego, aumentando sua sorte e dificultando que ele seja atingido.
        }


    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Vampiro ao herói, considerando os atributos de ataque e defesa.
        }
    }