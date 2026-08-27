package src.Inimigos;

import src.Dano;
import src.Heroi;
import src.Item;

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
        super("Vampiro", 100, 20, 10, 5, new Saque[] {new Saque(Item.DENTEDEVAMPIRO, 100.00f)});
        }

    // Metodo do Vampiro.

    // O Vampiro pode se transformar em morcego, o que lhe permite ficar mais dificil de ser atingido (A sua sorte é aumentada durante esse estado).
    public void alternarEmFormaDeMorcego()
        {
        // Aqui poderia ser implementada a lógica para transformar o Vampiro em morcego, aumentando sua sorte e dificultando que ele seja atingido.
        if (forma_de_morsego)
            {
            // Se o Vampiro já está em forma de morcego, ele volta à sua forma normal.
            forma_de_morsego = false;
            System.out.println("O Vampiro voltou à sua forma normal.");
            
            // Aqui poderia ser implementada a lógica para reduzir a sorte do Vampiro de volta ao normal.
            }
        else
            {
            // Se o Vampiro não está em forma de morcego, ele se transforma em morcego.
            forma_de_morsego = true;
            System.out.println("O Vampiro se transformou em morcego, aumentando sua sorte e dificultando que ele seja atingido.");
            
            // Aqui poderia ser implementada a lógica para aumentar a sorte do Vampiro enquanto ele estiver em forma de morcego.
            }
        }


    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Vampiro ao herói, considerando os atributos de ataque e defesa.

        // Primeiro se instancia um objeto da classe Dano.
        Dano _mordida = new Dano(this, 1.0, 1.0);

        // Agora o objeto dano vai interagir com o heroi.
        int danoCausado = heroi.receberDano(_mordida);
        if (danoCausado != PQB_DANO_DESVIADO)
            {
            // O dano foi causado com sucesso.
            System.out.println("O Vampiro mordeu o heroi e causou " + danoCausado + " de dano.");
            }
        else
            {
            // O dano foi desviado.
            System.out.println("O Vampiro mordeu o heroi, mas o heroi desviou.");
            }

        // A instancia dano é descartada, pois já cumpriu seu papel de interagir com o heroi.
        _mordida = null;
        }
    }