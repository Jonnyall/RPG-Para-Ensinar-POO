public abstract class Enemiy extends Character implements Updateble
    {
    //Esta classe representa os inimigos do jogo, aqueles que o personagem (Hero) principal deve enfrentar.

    //Construtor da classe.
    public Enemiy(String name, int HP, int ATK, int DEF, int x, int y, int w, int h /*, Sprite sprite*/)
        {
        //Apenas herdando os atributos do personagem.
        super(name, HP, ATK, DEF, x, y, w, h /*, sprite*/);
        }

    
    //Declaração do método de perseguir o personagem (Hero), que deve ser implementado por todas as classes filhas de Enemiy.
    public abstract void pursueHero(Hero hero);

    //Declaração do método de atacar o personagem (Hero), que deve ser implementado por todas as classes filhas de Enemiy.
    public abstract void attackHero(Hero hero);
    
    }
