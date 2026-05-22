public abstract class Character extends MaterialThings
    {
    //Esta classe é a classe designada para os personagens do jogo, sejam eles jogadores ou NPCs ou até monstros.

    //Atributos do personagem.
    
    //A vida do personagem.
    private int HP;

    //O quanto o personagem pode fazer de dano, ou seja, o seu ataque.
    private int ATK;

    //A defesa do personagem, usada para amenizar o dano recebido.
    private int DEF;

    //O nome do personagem, apenas para identificação.
    private String name;

    //
    //private Sprite sprite;//

    //Construtor da classe.
    public Character(String name, int HP, int ATK, int DEF, int x, int y, int w, int h /*, Sprite sprite*/)
        {
        //Dando a posição inicial do personagem.
        super(x, y, w, h);

        //Apenas atribuindo os atributos do personagem.
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;

        //Apenas atribuindo o sprite do personagem.
        //this.sprite = sprite;
        }

    //Getters e setters para os atributos do personagem.
    public String getName()
        {
        return (name);
        }

    public int getHealth()
        {
        return (HP);
        }

    public int getStrength()
        {
        return (ATK);
        }

    public int getDefense()
        {
        return (DEF);
        }


    //Metodo para o personagem receber danos.
    public void receberDano(Damage damage)
        {
        //Calculando o dano recebido, levando em consideração a defesa do personagem.
        double _d = damage.getCreator().getStrength();
        _d = (_d*_d) / (this.DEF + _d +0.0001); //Apenas para evitar divisão por zero, caso a defesa seja zero.

        //Arredondando o dano recebido para o inteiro mais próximo.
        int _dint = (int) Math.round(_d);

        //Diminuindo a vida do personagem pelo dano recebido.
        this.HP -= _dint;

        //Verificando se o personagem morreu.
        if (this.HP <= 0)
            {
            this.Die();
            }
        }


    //Metodo para "matar" o personagem.
    public void Die()
        {
        //
        }

}
