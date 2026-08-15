public class Slime extends Inimigo
    {
    // Esta classe representa o inimigo Slime, que é um inimigo fraco e comum no jogo.

    // Construtor da classe.
    public Slime()
        {
        /*
        Ficha do Slime: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Slime
            Vida: 50
            Ataque: 5
            Defesa: 2
            Sorte: 10
        */
       
        // Chamando o construtor da superclasse (Inimigo) para configurar os atributos do Slime.
        super("Slime", 50, 5, 2, 10, new Saque[] {});
        }

    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Slime ao herói, considerando os atributos de ataque e defesa.
        }
    }