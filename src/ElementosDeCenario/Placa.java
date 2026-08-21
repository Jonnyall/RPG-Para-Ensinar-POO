package src.ElementosDeCenario;

import src.Heroi;

public class Placa extends ElementosCenario
    {
    // Esta classe representa uma placa de cenário, que pode conter informações ou instruções para o jogador.

    // Atributos da placa.

    // O texto que será exibido na placa.
    private String texto;

    // Construtor da classe.
    public Placa(String texto)
        {
        // Chamando o construtor da superclasse ElementoDeCenario para inicializar o nome e a descrição da placa.
        super("Placa", "Uma placa de madeira com informações ou instruções para o jogador.");
        
        // Inicializando o atributo texto da placa.
        this.texto = texto;
        }

    // Métodos da classe.

    // Método para exibir o texto da placa.
    public void exibirTexto()
        {
        System.out.println(this.texto);
        }


    // Método sobreescritor da interface Interagivel, que permite ao jogador interagir com a placa.
    @Override
    public void interagir(Heroi heroi)
        {
        // Exibindo o texto da placa quando o jogador interage com ela.
        this.exibirTexto();
        }
    }