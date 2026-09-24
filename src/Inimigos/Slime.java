package src.Inimigos;

import src.PersonagemQueBatalha;
import src.Dano;
import src.Heroi;
import src.Item;

public class Slime extends Inimigo
    {
    // Esta classe representa o inimigo Slime, que é um inimigo fraco e comum no jogo.

    // Construtor da classe.
    public Slime()
        {
        /*
        Ficha do Slime: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Slime
            Vida: 20
            Ataque: 4
            Defesa: 2
            Sorte: 1
        */
       
        // Chamando o construtor da superclasse (Inimigo) para configurar os atributos do Slime.
        super("Slime", 20, 4, 2, 1, new Saque[] {
            new Saque(Item.GELECA_DE_SLIME, 100.00f),
            new Saque(Item.POCAO_DE_CURA, 50.00f),

        });
        }

    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Slime ao herói, considerando os atributos de ataque e defesa.
        Dano dano = new Dano(this, 1.0, 1.0);
        int danoCausado = heroi.receberDano(dano);
        if (danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
            {
            // O dano foi causado com sucesso.
            System.out.println("O Slime atacou o heroi e causou " + danoCausado + " de dano.");
            }
        else
            {
            // O dano foi desviado.
            System.out.println("O Slime atacou o heroi, mas ele desviou.");
            }
        }
    }