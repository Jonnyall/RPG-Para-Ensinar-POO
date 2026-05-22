public class Zombie extends Enemiy implements Updateble
    {
    //Esta classe representa os zumbis, um tipo de personagem do jogo.

    //Atributos do zumbi.

    //Variaveis de estado do zumbi.
    private boolean isPursuing; //Indica se o zumbi está perseguindo o personagem (Hero) ou não.
    private int isBiteing; //Indica se o zumbi está performando a mordida no personagem (Hero) ou não. (É um momento no qual ele nao pode andar).

    static private int BITE_DURATION = 30; //Tempo que a mordida dura, em "frames". (meio segundo, se o jogo rodar a 60 fps).

    //Qual direção o zumbi está se movendo (0 = parado, 1 = para cima, 2 = para baixo, 3 = para esquerda, 4 = para direita).
    private int direction;


    //Construtor da classe.
    public Zombie(int _x, int _y)
        {
        //Exceto pelo ponto de origem, todos os atributos do zumbi são fixos, ou seja, são os mesmos para todos os zumbis do jogo.
        super("Zombie", 50, 10, 5, _x, _y, 32, 32 /*, Zombie.png*/);
        }

    //Metodo para o zumbi perseguir o personagem (Hero).
    public void pursueHero(Hero hero)
        {
        //Aqui deve ser implementada a lógica para o zumbi perseguir o personagem (Hero), ou seja, se mover em direção ao personagem (Hero) quando ele estiver próximo o suficiente.
        }

    //Metodo para o zumbi atacar o personagem (Hero).
    public void attackHero(Hero hero)
        {
        //Aqui deve ser implementada a lógica para o zumbi atacar o personagem (Hero), ou seja, realizar a mordida no personagem (Hero) quando ele estiver próximo o suficiente.
        
        //Criando o objeto de dano da mordida!
        }

    //Metodo de atualização do zumbi, que é chamado a cada ciclo do jogo.
    public void update()
        {
        //Aqui deve ser implementada a lógica para atualizar o estado do zumbi a cada ciclo do jogo, ou seja, verificar se ele deve perseguir o personagem (Hero), se deve atacar o personagem (Hero), etc.
        
        //Primeiro, vamos perguntar se ele estar em modo de perseguir o personagem (Hero) ou não, para decidir o que ele deve fazer.
        if (isPursuing)
            {
            //Se ele estiver perseguindo o personagem (Hero), ele deve tentar se mover em direção ao personagem (Hero).
            //Então devemos perguntar se ele está performando a mordida ou não, para decidir se ele pode se mover ou não.
            if (!isBiteing)
                {
                //Se ele não estiver performando a mordida, ele pode se mover em direção ao personagem (Hero).
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
            //Se ele não estiver perseguindo o personagem (Hero), ele deve apenas ficar parado esperando o personagem Hero chegar perto o suficiente para ele começar a perseguir.
            }
        }
}
