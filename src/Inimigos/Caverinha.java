package src.Inimigos;

import src.Dano;
import src.Heroi;
import src.Item;
import src.PersonagemQueBatalha;

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
        super("Caverinha", 30, 5, 2, 10, new Saque[] {new Saque(Item.FLECHA, 30.00f)});
        }

    // Implementação do método de atacar o personagem (Heroi).
    @Override
    public void atacarHeroi(Heroi heroi)
        {
        // Aqui poderia ser implementada a lógica de ataque do Caverinha ao herói, considerando os atributos de ataque e defesa.

        // O inimigo Caverinha irá alternar entre atacar com sua adaga velha e atirar flechas.
        // 60% de chance de atacar com a adaga velha e 40% de chance de atirar flechas.
        int chance_de_ataque = (int) (Math.random() *100);

        // Declarando a instancia da classe Dano fora do if, para que ela possa ser usada em ambos os casos.
        Dano _dano;

        if (chance_de_ataque < 60)
            {
            // O Caverinha escolheu atacar com sua adaga velha.
            _dano = new Dano(this, 1.0, 1.0);
            int _danoCausado = heroi.receberDano(_dano);
            if (_danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
                {
                // O dano foi causado com sucesso.
                System.out.println("O Caverinha atacou o heroi com sua adaga velha e causou " + _danoCausado + " de dano.");
                }
            else
                {
                // O dano foi desviado.
                System.out.println("O Caverinha atacou o heroi com sua adaga velha, mas ele desviou.");
                }
            }
        else
            {
            // O Caverinha escolheu atirar flechas.
            _dano = new Dano(this, 1.5, 0.80); // Ataque mais forte e menos preciso.
            int _danoCausado = heroi.receberDano(_dano);
            if (_danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
                {
                // O dano foi causado com sucesso.
                System.out.println("O Caverinha atirou uma flecha no heroi e causou " + _danoCausado + " de dano.");
                }
            else
                {
                // O dano foi desviado.
                System.out.println("O Caverinha atirou uma flecha no heroi, mas ele desviou.");
                }
            }
        
        // A instancia dano é descartada, pois já cumpriu seu papel de interagir com o heroi.
        _dano = null;
        }
    }