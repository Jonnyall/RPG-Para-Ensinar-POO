public class Dano extends EntidadeFisica
    {
    //Esta classe representa os objetos de dano, aqueles que podem "diminuir a vida" dos personagens.

    //Atributos do dano.

    //O Character que o criou.
    private Personagem criador;

    //Construtor da classe.
    public Dano(Personagem criador, int x, int y, int w, int h)
        {
        //Apenas herdando os atributos de posição e dimensão da classe MaterialThings.
        super(x, y, w, h);

        //Apenas atribuindo o criador do dano.
        this.criador = criador;
        }

    //Getters e setters para os atributos do dano.
    public Personagem obterPersonagemCriador()
        {
        return (this.criador);
        }
    }
