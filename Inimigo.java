public abstract class Inimigo extends Personagem implements Updateble
    {
    //Esta classe representa os inimigos do jogo, aqueles que o personagem (Hero) principal deve enfrentar.

    //Construtor da classe.
    public Inimigo(String nome, int vida, int ataque, int defesa, int x, int y, int w, int h /*, Sprite sprite*/)
        {
        //Apenas herdando os atributos do personagem.
        super(nome, vida, ataque, defesa, x, y, w, h /*, sprite*/);
        }

    
    //Declaração do método de perseguir o personagem (Hero), que deve ser implementado por todas as classes filhas de Inimigo.
    public abstract void perseguirHero(Heroi hero);

    //Declaração do método de atacar o personagem (Hero), que deve ser implementado por todas as classes filhas de Inimigo.
    public abstract void atacarHero(Heroi hero);
    }
