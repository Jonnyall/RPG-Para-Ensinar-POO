package src;
public abstract class PersonagemQueBatalha extends Personagem
    {
    // Esta classe representa os personagens que podem lutar no jogo (herói e os monstros). Ela possui atributos como, além de nome, vida, ataque, defesa e sorte. Além de métodos para atacar outro personagem e receber dano.

    // Algumas constantes.
    public static final int PQB_DANO_DESVIADO = -1; // Constante para indicar que o dano foi desviado.

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

    // Métodos getters.

    // -- ATENÇÃO: ESSES MÉTODOS PODEM MUDAR; FALAR COM A PROFESSORA DEPOIS. --

    public int obterVida()
        {
        return (this.vida);
        }

    public int obterAtaque()
        {
        return (this.ataque);
        }

    public int obterDefesa()
        {
        return (this.defesa);
        }

    public int obterSorte()
        {
        return (this.sorte);
        }

    // Métodos da classe.

    // Método para o personagem receber danos.
    public int receberDano(Dano _damage)
        {
        // Calculando a chance de acerto do dano.
        boolean _acertou = _damage.calcularChanceDeAcerto(this.sorte);

        // Se acertou, calcula o dano e diminui a vida do personagem.
        if (_acertou)   
            {
            // Calculando o dano que o objeto dano vai causar.
            int dano = _damage.calcularDano(this.defesa);

            // Diminuindo a vida do personagem.
            this.vida -= dano;

            // Retornando o valor do dano causado.
            return (dano);
            }

        // Retornando à constante PQB_DANO_DESVIADO para indicar que o dano não acertou.
        return (PQB_DANO_DESVIADO);
        }
    
    // Método para o personagem se/ou ser curado.
    public void curar(int _cura)
        {
        // Aqui fica a logica para curar o personagem, aumentando sua vida.
        }

    // Métodos para multiplicar o ataque.
    public void multiplicarAtaque(double multiplicador)
        {
        this.ataque *= multiplicador;
        }
    
    // Métodos para multiplicar a defesa.
    public void multiplicarDefesa(double multiplicador)
        {
        this.defesa *= multiplicador;
        }

    // Métodos para multiplicar a sorte.
    public void multiplicarSorte(double multiplicador)
        {
        this.sorte *= multiplicador;
        }
    }