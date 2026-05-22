public class Damage extends MaterialThings
    {
    //Esta classe representa os objetos de dano, aqueles que podem "diminuir a vida" dos personagens.

    //Atributos do dano.

    //O Character que o criou.
    private Character creator;

    //Construtor da classe.
    public Damage(Character creator, int x, int y, int w, int h)
        {
        //Apenas herdando os atributos de posição e dimensão da classe MaterialThings.
        super(x, y, w, h);

        //Apenas atribuindo o criador do dano.
        this.creator = creator;
        }

    //Getters e setters para os atributos do dano.
    public Character getCreator()
        {
        return (creator);
        }
    }
