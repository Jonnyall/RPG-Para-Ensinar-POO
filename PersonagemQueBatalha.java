public abstract class PersonagemQueBatalha extends Personagem
    {
    // Esta classe representa os personagens que podem lutar no jogo (herói e os monstros). Ela possui atributos como, além de nome, vida, ataque, defesa e sorte. Além de métodos para atacar outro personagem e receber dano.

    // Algumas constantes.
    private static final int PQB_DANO_DESVIADO = -1; // Constante para indicar que o dano foi desviado.

    // Atributos do personagem.
    
    // A vida do personagem.
    private int vida;

    // O quanto o personagem pode fazer de dano, ou seja, o seu poder de ataque.
    private int ataque;

    // A defesa do personagem, usada para amenizar o dano recebido.
    private int defesa;

    // A sorte do personagem, usada para determinar a chance de acerto de um ataque.
    private int sorte;


    // Construtor da classe.
    public PersonagemQueBatalha(String nome, int vida, int ataque, int defesa, int sorte)
        {
        // Atirbutos da classe pai.
        super(nome);
        
        // Atribuindo os atributos do personagem.
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.sorte = sorte;
        }

    // Método para o personagem receber danos.
    public int receberDano(Dano _damage)
        {
        // Calculando a chance de acerto do dano.
        boolean _acertou = _damage.calcularChanceDeAcerto(this.sorte);

        // Se acertou, calcula o dano e diminui a vida do personagem.
        if (_acertou)   
            {
            // Calculando o dano que o objeto dano vai causar.
            int _dano = _damage.calcularDano(this.defesa);

            // Diminuindo a vida do personagem.
            this.vida -= _dano;

            // Retornando o valor do dano causado.
            return (_dano);
            }

        // Retornando à constante PQB_DANO_DESVIADO para indicar que o dano não acertou.
        return (PQB_DANO_DESVIADO);
        }
    }