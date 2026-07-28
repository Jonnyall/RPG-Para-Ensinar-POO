public class Zumbi extends Inimigo implements Updateble
    {
    //Esta classe representa os zumbis, um tipo de personagem do jogo.

    //Atributos do zumbi.

    //Variaveis e constantes de estado do zumbi.
    private static int estado; //Indica o estado atual do zumbi (parado, perseguindo, atacando, etc).

    private static final int ESTADO_PARADO = 0; //Indica que o zumbi está parado.
    private static final int ESTADO_PERSEGUINDO = 1; //Indica que o zumbi está perseguindo o personagem Herói).
    private static final int ESTADO_MORDENDO = 2; //Indica que o zumbi está atacando Herói.


    static private final int DURACAO_MORDIDA = 30; //Tempo que a mordida dura, em "frames". (meio segundo, se o jogo rodar a 60 fps).
    private int tempoRestanteMordida; //Tempo restante da mordida, em "frames". (meio segundo, se o jogo rodar a 60 fps).


    //Qual direção o zumbi está se movendo (0 = parado, 1 = para cima, 2 = para baixo, 3 = para esquerda, 4 = para direita).
    private int direction;


    //Construtor da classe.
    public Zumbi(int _x, int _y)
        {
        //Exceto pelo ponto de origem, todos os atributos do zumbi são fixos, ou seja, são os mesmos para todos os zumbis do jogo.
        super("Zumbi", 50, 10, 5, _x, _y, 32, 32 /*, Zombie.png*/);
        }

    //Metodo para o zumbi perseguir o personagem (Herói).
    public void perseguirHero(Heroi heroi)
        {
        //Aqui deve ser implementada a lógica para o zumbi perseguir o personagem (Herói), ou seja, se mover em direção ao personagem (Herói) quando ele estiver próximo o suficiente.
        }

    //Metodo para o zumbi atacar o personagem (Herói).
    public void atacarHero(Heroi heroi)
        {
        //Aqui deve ser implementada a lógica para o zumbi atacar o personagem (Herói), ou seja, realizar a mordida no personagem (Herói) quando ele estiver próximo o suficiente.
        
        //Criando o objeto de dano da mordida!
        }

    //Metodo de atualização do zumbi, que é chamado a cada ciclo do jogo.
    public void update()
        {
        //Aqui deve ser implementada a lógica para atualizar o estado do zumbi a cada ciclo do jogo, ou seja, verificar se ele deve perseguir o personagem (Herói), se deve atacar o personagem (Herói), etc. 
        //Ou seja, a maquina de estados do zumbi.
        /* 
        //Primeiro, vamos perguntar se ele estar em modo de perseguir o personagem (Herói) ou não, para decidir o que ele deve fazer.
        if (isPursuing)
            {
            //Se ele estiver perseguindo o personagem (Herói), ele deve tentar se mover em direção ao personagem (Herói).
            //Então devemos perguntar se ele está performando a mordida ou não, para decidir se ele pode se mover ou não.
            if (!isBiteing)
                {
                //Se ele não estiver performando a mordida, ele pode se mover em direção ao personagem (Herói).
                pursueHero(hero);
                }
            else
                {
                //Se ele estiver performando a mordida, ele não pode se mover, então devemos apenas diminuir o tempo restante da mordida.
                isBiteing--;
                }
            }
        else
            { 
            //Se ele não estiver perseguindo o personagem (Herói), ele deve apenas ficar parado esperando o personagem Herói chegar perto o suficiente para ele começar a perseguir.
            }
        */

        switch (estado)
            {
            case ESTADO_PARADO:
                //Se ele não estiver perseguindo o personagem (Herói), ele deve apenas ficar parado esperando o personagem Herói chegar perto o suficiente para ele começar a perseguir.
            break;
        
            case ESTADO_PERSEGUINDO:
                //Se ele estiver perseguindo o personagem (Herói), ele deve tentar se mover em direção ao personagem (Herói).
                perseguirHero(heroi); //Variavel global 
            break;

            case ESTADO_MORDENDO:
                if (tempoRestanteMordida > 0)
                    {
                    //Se ele estiver performando a mordida, ele não pode se mover, então devemos apenas diminuir o tempo restante da mordida.
                    tempoRestanteMordida--;
                    }
                else
                    {
                    //Se o tempo da mordida acabou, ele deve voltar para o estado de perseguir o personagem (Herói).
                    estado = ESTADO_PERSEGUINDO;
                    }
            break;
            }
        }
}
