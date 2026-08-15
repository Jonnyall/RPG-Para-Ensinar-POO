public class Zumbi extends Inimigo
    {
    //Esta classe representa os zumbis, um tipo de inimigo  do jogo.

    // Construtor da classe.
    public Zumbi()
        {
        /*
        Ficha do zumbi: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Zumbi
            Vida: 50
            Ataque: 10
            Defesa: 5
            Sorte: 0

            Itens que o zumbi pode dropar ao ser derrotado:
                - Carne Podre (chance de 50%)
        */
    
        super("Zumbi", 50, 10, 5, 0, new Saque[] {new Saque(Item.CARNE_PODRE, 50.00f)});
        }

    // Implementação do método de atacar o personagem (Hero), que deve ser implementado por todas as classes filhas de Inimigo.
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Primeiro se instancia um objeto da classe Dano.
        Dano _dano = new Dano(this, 1.0, 1.0);

        // Agora o objeto dano vai interagir com o heroi.
        int _danoCausado = heroi.receberDano(_dano);
        if (_danoCausado != PQB_DANO_DESVIADO)
            {
            // O dano foi causado com sucesso.
            System.out.println("O zumbi mordeu o heroi e causou " + _danoCausado + " de dano.");
            }
        else
            {
            // O dano foi desviado.
            System.out.println("O zumbi mordeu o heroi, mas ele desviou.");
            }

        // A instancia dano é descartada, pois já cumpriu seu papel de interagir com o heroi.
        _dano = null;
        }
    }

