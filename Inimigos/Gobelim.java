public class Gobelim extends Inimigo
    {
    // Esta classe representa o inimigo Gobelim, que é um inimigo fraco e comum no jogo.

    // Construtor da classe.
    public Gobelim()
        {
        /*
        Ficha do Gobelim: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Gobelim
            Vida: 40
            Ataque: 7
            Defesa: 3
            Sorte: 8

            Itens que o Gobelim pode dropar ao ser derrotado:
                - Bomba (chance de 20%)
                - Flecha (chance de 5%)
        */
       
        // Chamando o construtor da superclasse (Inimigo) para configurar os atributos do Gobelim.
        super("Gobelim", 40, 7, 3, 8, new Saque[] {new Saque(Item.BOMBA, 0.20f), new Saque(Item.FLECHA, 5.00f)});
        }

    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Gobelim ao herói, considerando os atributos de ataque e defesa.

        // O inimigo Gobelim irá atacar com uma pequena faca.
        Dano _dano = new Dano(this, 1.2, 1.0); // Ataque mais forte e preciso.
        int _danoCausado = heroi.receberDano(_dano);
        if (_danoCausado != PQB_DANO_DESVIADO)
            {
            // O dano foi causado com sucesso.
            System.out.println("O Gobelim atacou o heroi com sua pequena faca e causou " + _danoCausado + " de dano.");
            }
        else
            {
            // O dano foi desviado.
            System.out.println("O Gobelim atacou o heroi com sua pequena faca, mas ele desviou.");
            }
        }
    }