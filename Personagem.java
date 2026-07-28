public abstract class Personagem extends EntidadeFisica
    {
    //Esta classe é a classe designada para os personagens do jogo, sejam eles jogadores ou NPCs ou até monstros.

    //Atributos do personagem.
    
    //A vida do personagem.
    //private int HP;
    private int vida;

    //O quanto o personagem pode fazer de dano, ou seja, o seu ataque.
    //private int ATK;
    private int ataque;

    //A defesa do personagem, usada para amenizar o dano recebido.
    //private int DEF;
    private int defesa;

    //O nome do personagem, apenas para identificação.
    private String nome;

    //private Sprite sprite;//

    //Construtor da classe.
    public Personagem(String nome, int vida, int ataque, int defesa, int x, int y, int w, int h /*, Sprite sprite*/)
        {
        //Dando a posição inicial do personagem.
        super(x, y, w, h);

        //Apenas atribuindo os atributos do personagem.
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;

        //Apenas atribuindo o sprite do personagem.
        //this.sprite = sprite;
        }
    /* 
    //Getters e setters para os atributos do personagem.
    public String objeterNome()
        {
        return (nome);
        }

    public int objeterVida()
        {
        return (vida);
        }

    public int objeterAtaque()
        {
        return (ataque);
        }

    public int objeterDefesa()
        {
        return (defesa);
        }
    */

    //Metodo para o personagem receber danos.
    public void receberDano(Dano _damage)
        {
        //Calculando o dano recebido, levando em consideração a defesa do personagem.
        double _d = _damage.obterPersonagemCriador().objeterAtaque(); //-> possível erro por falta de getStrength(). #ERRO AQUI#
        _d = (_d*_d) / (this.defesa + _d +0.0001); //Apenas para evitar divisão por zero, caso a defesa seja zero.

        //Arredondando o dano recebido para o inteiro mais próximo.
        int _dint = (int) Math.round(_d);

        //Diminuindo a vida do personagem pelo dano recebido.
        this.vida -= _dint;

        //Verificando se o personagem morreu.
        if (this.vida <= 0)
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
